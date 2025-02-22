/* 
  * Licensed to The Apereo Foundation under one or more contributor license 
  * agreements. See the NOTICE file distributed with this work for 
  * additional information regarding copyright ownership. 
  * 
  * The Apereo Foundation licenses this file to you under the Apache License, 
  * Version 2.0 (the "License"); you may not use this file except in 
  * compliance with the License. You may obtain a copy of the License at: 
  * 
  * http://www.apache.org/licenses/LICENSE-2.0 
  * 
  * Unless required by applicable law or agreed to in writing, software 
  * distributed under the License is distributed on an "AS IS" BASIS, 
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
  * 
  * See the License for the specific language governing permissions and 
  * limitations under the License. 
  *  
 */ 
 package org.unitime.commons.ant; 
  
 import java.io.File; 
 import java.io.FileWriter; 
 import java.io.IOException; 
 import java.io.PrintWriter; 
 import java.io.StringWriter; 
 import java.util.Hashtable; 
 import java.util.Iterator; 
 import java.util.TreeSet; 
 import java.util.Vector; 
  
 import org.apache.tools.ant.BuildException; 
 import org.apache.tools.ant.Project; 
 import org.apache.tools.ant.Task; 
 import org.dom4j.Document; 
 import org.dom4j.DocumentException; 
 import org.dom4j.Element; 
 import org.dom4j.io.SAXReader; 
 import org.xml.sax.EntityResolver; 
 import org.xml.sax.InputSource; 
  
 /** 
  * Creates base model from UniTime3 .hbm.xml files. 
  * @author Tomas Muller 
  * 
  */ 
 public class CreateBaseModelFromXml extends Task { 
         private Hashtable<String, String> iParent = new Hashtable<String, String>(); 
         private Hashtable<String, String[]> iIds = new Hashtable<String, String[]>(); 
         private Hashtable<String, TreeSet<String>> iClassProperties = new Hashtable<String, TreeSet<String>>(); 
          
         private SAXReader iSAXReader = null; 
         private String iSource = null; 
         private String iConfig = "hibernate.cfg.xml"; 
          
         public CreateBaseModelFromXml() throws DocumentException { 
                 iSAXReader = new SAXReader(); 
                 iSAXReader.setEntityResolver(iEntityResolver); 
         } 
          
         private EntityResolver iEntityResolver = new EntityResolver() { 
             public InputSource resolveEntity(String publicId, String systemId) { 
                 if (publicId.equals("-//Hibernate/Hibernate Mapping DTD 3.0//EN")) { 
                         return new InputSource(getClass().getClassLoader().getResourceAsStream("org/hibernate/hibernate-mapping-3.0.dtd")); 
                 } else if (publicId.equals("-//Hibernate/Hibernate Configuration DTD 3.0//EN")) { 
                         return new InputSource(getClass().getClassLoader().getResourceAsStream("org/hibernate/hibernate-configuration-3.0.dtd")); 
                 } 
                 return null; 
             } 
         }; 
          
         public void setSource(String source) { 
                 iSource = source; 
         } 
          
         public void setConfig(String config) { 
                 iConfig = config; 
         } 
          
         protected Document read(String resource) throws IOException, DocumentException { 
                 if (iSource == null) { 
                         return iSAXReader.read(getClass().getClassLoader().getResourceAsStream(resource)); 
                 } else { 
                         return iSAXReader.read(new File(iSource + File.separator + resource)); 
                 } 
         } 
          
         @SuppressWarnings("unchecked") 
         public void convert() throws IOException, DocumentException { 
                 info("Config: " + (iSource == null ? getClass().getClassLoader().getResource(iConfig) : iSource + File.separator + iConfig)); 
                 File workDir = null; 
                 if (iSource == null) { 
                         workDir = new File(getClass().getClassLoader().getResource(iConfig).getFile()); 
                         while (workDir.getParentFile() != null && !"WebContent".equals(workDir.getName())) 
                                 workDir = workDir.getParentFile(); 
                         workDir = new File(workDir.getParentFile(), "JavaSource"); 
                         workDir.mkdirs(); 
                 } else { 
                         workDir = new File(iSource); 
                 } 
                 info("Working directory: " + workDir); 
                 info("Reading hibernate.cfg.xml ..."); 
                 Document document = read(iConfig); 
                 Element root = document.getRootElement(); 
                 Element sessionFactoryElement = root.element("session-factory"); 
                 for (Iterator<Element> i = sessionFactoryElement.elementIterator("mapping"); i.hasNext(); ) { 
                         Element m = i.next(); 
                         String resource = m.attributeValue("resource"); 
                         if (resource == null) continue; 
                         info("Pre-processing " + resource + " ..."); 
                         Document resDoc = read(resource); 
                         Element resRoot = resDoc.getRootElement(); 
                         String pkg = resRoot.attributeValue("package"); 
                         for (Iterator<Element> j = resRoot.elementIterator("class");j.hasNext(); ) { 
                                 Element classEl = j.next(); 
                                 preprocess(classEl, null, pkg); 
                         } 
                 } 
                 for (Iterator<Element> i = sessionFactoryElement.elementIterator("mapping"); i.hasNext(); ) { 
                         Element m = i.next(); 
                         String resource = m.attributeValue("resource"); 
                         if (resource == null) continue; 
                         info("Processing " + resource + " ..."); 
                         Document resDoc = read(resource); 
                         Element resRoot = resDoc.getRootElement(); 
                         String pkg = resRoot.attributeValue("package"); 
                         for (Iterator<Element> j = resRoot.elementIterator("class");j.hasNext(); ) { 
                                 Element classEl = j.next(); 
                                 importClass(classEl, pkg, workDir, null, null, null, null); 
                         } 
                 } 
                 info("All done."); 
         } 
          
         @SuppressWarnings("unchecked") 
         private void preprocess(Element classEl, String ext, String pkg) throws IOException { 
                 String className = fixType(classEl.attributeValue("name"), pkg); 
                 if (className.indexOf('.') >= 0) className = className.substring(className.lastIndexOf('.')+1); 
                 if (ext!=null) iParent.put(className, ext); 
                 Element idEl = classEl.element("id"); 
                 if (idEl!=null) { 
                         String type = fixType(idEl.attributeValue("type"), pkg); 
                         String name = fixName(idEl.attributeValue("name")); 
                         iIds.put(className, new String[] {type, name}); 
                 } 
                 for (Iterator<Element> i=classEl.elementIterator("union-subclass");i.hasNext();) { 
                         preprocess(i.next(), className, pkg); 
                 } 
                 for (Iterator<Element> i=classEl.elementIterator("subclass");i.hasNext();) { 
                         preprocess(i.next(), className, pkg); 
                 } 
         }          
         private String fixType(String type, String pkg) { 
                 if (type == null) return null; 
                 if (type.startsWith("java.lang.")) return type.substring("java.lang.".length()); 
                 if ("byte[]".equals(type)) return type; 
                 if (type.indexOf('.')<0) type = type.substring(0,1).toUpperCase() + type.substring(1); 
                 if ("Boolean".equals(type)) return type; 
                 if ("Long".equals(type)) return type; 
                 if ("Integer".equals(type)) return type; 
                 if ("String".equals(type)) return type; 
                 if ("Float".equals(type)) return type; 
                 if ("Double".equals(type)) return type; 
                 if (type.equals("java.sql.Date")) return "java.util.Date"; 
                 if (type.equalsIgnoreCase("java.sql.TimeStamp")) return "java.util.Date"; 
                 if (type.endsWith(".XmlBlobType")) return "org.dom4j.Document"; 
                 if (type.endsWith(".XmlClobType")) return "org.dom4j.Document"; 
                 if (type.startsWith("java.")) return type; 
                 if (type.indexOf('.') < 0) type = pkg+"."+type; 
                 return type; 
         } 
          
         private String fixName(String name) { 
                 if (name == null) return null; 
                 return name.substring(0,1).toUpperCase() + name.substring(1); 
         } 
         private File fileFromPackage(File outputFolder, String pkg) { 
                 File ret = new File(outputFolder, pkg.replace('.', File.separatorChar)); 
                 ret.mkdirs(); 
                 return ret; 
         } 
          
         private void license(PrintWriter pw) { 
                 pw.println("/*"); 
                 pw.println(" * Licensed to The Apereo Foundation under one or more contributor license"); 
                 pw.println(" * agreements. See the NOTICE file distributed with this work for"); 
                 pw.println(" * additional information regarding copyright ownership."); 
                 pw.println(" *"); 
                 pw.println(" * The Apereo Foundation licenses this file to you under the Apache License,"); 
                 pw.println(" * Version 2.0 (the \"License\"); you may not use this file except in"); 
                 pw.println(" * compliance with the License. You may obtain a copy of the License at:"); 
                 pw.println(" *"); 
                 pw.println(" * http://www.apache.org/licenses/LICENSE-2.0"); 
                 pw.println(" *"); 
                 pw.println(" * Unless required by applicable law or agreed to in writing, software"); 
                 pw.println(" * distributed under the License is distributed on an \"AS IS\" BASIS,"); 
                 pw.println(" * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied."); 
                 pw.println(" *"); 
                 pw.println(" * See the License for the specific language governing permissions and"); 
                 pw.println(" * limitations under the License."); 
                 pw.println(" * "); 
                 pw.println("*/"); 
         } 
  
         @SuppressWarnings("unchecked") 
         private void importClass(Element classEl, String pkg, File outputFolder, String ext, String idClass, String idName, String idType) throws IOException { 
                 String className = fixType(classEl.attributeValue("name"), pkg); 
                 @SuppressWarnings("unused") 
                 String table = classEl.attributeValue("table"); 
                 StringWriter attributes = new StringWriter(); 
                 PrintWriter pwa = new PrintWriter(attributes); 
                 StringWriter props = new StringWriter(); 
                 PrintWriter pwp = new PrintWriter(props); 
                 StringWriter body = new StringWriter(); 
                 PrintWriter pwb = new PrintWriter(body); 
                 TreeSet<String> imports = new TreeSet<String>(); 
                 if (className.indexOf('.') >= 0) { 
                         className = className.substring(className.lastIndexOf('.')+1); 
                 } 
                 info("  "+className+" ..."); 
                  
                 Vector<String[]> manyToOnes = new Vector<String[]>(); 
                 TreeSet<String> properties = new TreeSet<String>(); 
                 Vector<String[]> compositeId = new Vector<String[]>(); 
                 boolean hasProperty = false; 
                 for (Iterator<Element> i = classEl.elementIterator("id"); i.hasNext();) { 
                         Element el = i.next(); 
                         String type = fixType(el.attributeValue("type"), pkg); 
                         if (type.indexOf('.')>=0) { 
                                 imports.add(type); 
                                 type = type.substring(type.lastIndexOf('.')+1); 
                         } 
                         String name = fixName(el.attributeValue("name")); 
                         String column = el.attributeValue("column").toLowerCase(); 
                         String attribute = name.substring(0,1).toLowerCase()+name.substring(1); 
                         if ("default".equals(attribute)) attribute = "defaultValue"; 
                         idName = name; idType = type; 
                         pwa.println("        private "+type+" i"+name+";"); 
                         pwp.println("        public static String PROP_"+column.toUpperCase()+" = \""+name.substring(0, 1).toLowerCase()+name.substring(1)+"\";"); 
                         properties.add(name); 
                         pwb.println(); 
                         pwb.println("        public "+type+" get"+name+"() { return i"+name+"; }"); 
                         pwb.println("        public void set"+name+"("+type+" "+attribute+") { i"+name+" = "+attribute+"; }"); 
                         hasProperty = true; 
                 } 
                 for (Iterator<Element> i = classEl.elementIterator("composite-id"); i.hasNext();) { 
                         Element cidEl = i.next(); 
                         for (Iterator<Element> j = cidEl.elementIterator("key-many-to-one"); j.hasNext();) { 
                                 Element el = j.next(); 
                                 String type = fixType(el.attributeValue("class"), pkg); 
                                 if (type.indexOf('.')>=0) { 
                                         imports.add(type); 
                                         type = type.substring(type.lastIndexOf('.')+1); 
                                 } 
                                 String name = fixName(el.attributeValue("name")); 
                                 // String column = el.attributeValue("column").toLowerCase(); 
                                 String attribute = name.substring(0,1).toLowerCase()+name.substring(1); 
                                 if ("default".equals(attribute)) attribute = "defaultValue"; 
                                 pwa.println("        private "+type+" i"+name+";"); 
                                 properties.add(name); 
                                 compositeId.add(new String[] {type, name}); 
                                 pwb.println(); 
                                 pwb.println("        public "+type+" get"+name+"() { return i"+name+"; }"); 
                                 pwb.println("        public void set"+name+"("+type+" "+attribute+") { i"+name+" = "+attribute+"; }"); 
                                 hasProperty = true; 
                         } 
                         for (Iterator<Element> j = cidEl.elementIterator("key-property"); j.hasNext();) { 
                                 Element el = j.next(); 
                                 String type = fixType(el.attributeValue("type"), pkg); 
                                 if (type.indexOf('.')>=0) { 
                                         imports.add(type); 
                                         type = type.substring(type.lastIndexOf('.')+1); 
                                 } 
                                 String name = fixName(el.attributeValue("name")); 
                                 String attribute = name.substring(0,1).toLowerCase()+name.substring(1); 
                                 if ("default".equals(attribute)) attribute = "defaultValue"; 
                                 compositeId.add(new String[] {type, name}); 
                                 pwa.println("        private "+type+" i"+name+";"); 
                                 properties.add(name); 
                                 pwb.println(); 
                                 pwb.println("        public "+type+" get"+name+"() { return i"+name+"; }"); 
                                 pwb.println("        public void set"+name+"("+type+" "+attribute+") { i"+name+" = "+attribute+"; }"); 
                                 hasProperty = true; 
                         } 
                 } 
                 for (Iterator<Element> i = classEl.elementIterator("property"); i.hasNext();) { 
                         Element el = i.next(); 
                         String type = fixType(el.attributeValue("type"), pkg); 
                         if (type.indexOf('.')>=0) { 
                                 imports.add(type); 
                                 type = type.substring(type.lastIndexOf('.')+1); 
                         } 
                         String name = fixName(el.attributeValue("name")); 
                         String column = el.attributeValue("column"); 
                         String formula = el.attributeValue("formula"); 
                         String attribute = name.substring(0,1).toLowerCase()+name.substring(1); 
                         if ("default".equals(attribute)) attribute = "defaultValue"; 
                         if (column!=null) { 
                                 pwa.println("        private "+type+" i"+name+";"); 
                                 properties.add(name); 
                                 pwb.println(); 
                                 pwp.println("        public static String PROP_"+column.toUpperCase()+" = \""+name.substring(0, 1).toLowerCase()+name.substring(1)+"\";"); 
                                 if (type.equals("Boolean")) 
                                         pwb.println("        public "+type+" is"+name+"() { return i"+name+"; }"); 
                                 pwb.println("        public "+type+" get"+name+"() { return i"+name+"; }"); 
                                 pwb.println("        public void set"+name+"("+type+" "+attribute+") { i"+name+" = "+attribute+"; }"); 
                         } else if (formula!=null) { 
                                 pwa.println("        private "+type+" i"+name+";"); 
                                 pwb.println(); 
                                 if (type.equals("Boolean")) 
                                         pwb.println("        public "+type+" is"+name+"() { return i"+name+"; }"); 
                                 pwb.println("        public "+type+" get"+name+"() { return i"+name+"; }"); 
                                 pwb.println("        public void set"+name+"("+type+" "+attribute+") { i"+name+" = "+attribute+"; }"); 
                         } else { 
                                 System.err.println("Unknown "+el.getName()+": "+el.asXML()); 
                         } 
                         hasProperty = true; 
                 } 
                 if (hasProperty) pwa.println(); 
                 for (Iterator<Element> i = classEl.elementIterator("many-to-one"); i.hasNext();) { 
                         Element el = i.next(); 
                         String type = fixType(el.attributeValue("class"), pkg); 
                         if (type.indexOf('.')>=0) { 
                                 imports.add(type); 
                                 type = type.substring(type.lastIndexOf('.')+1); 
                         } 
                         String name = fixName(el.attributeValue("name")); 
                         String column = el.attributeValue("column"); 
                         String formula = el.attributeValue("formula"); 
                         if (column!=null) { 
                                 pwa.println("        private "+type+" i"+name+";"); 
                                 properties.add(name); 
                                 pwb.println(); 
                                 manyToOnes.add(new String[] {type, name}); 
                                 pwb.println("        public "+type+" get"+name+"() { return i"+name+"; }"); 
                                 pwb.println("        public void set"+name+"("+type+" "+name.substring(0,1).toLowerCase()+name.substring(1)+") { i"+name+" = "+name.substring(0,1).toLowerCase()+name.substring(1)+"; }"); 
                         } else if (formula!=null) { 
                                 pwa.println("        private "+type+" i"+name+";"); 
                                 pwb.println(); 
                                 pwb.println("        public "+type+" get"+name+"() { return i"+name+"; }"); 
                                 pwb.println("        public void set"+name+"("+type+" "+name.substring(0,1).toLowerCase()+name.substring(1)+") { i"+name+" = "+name.substring(0,1).toLowerCase()+name.substring(1)+"; }"); 
                         } else { 
                                 System.err.println("Unknown "+el.getName()+": "+el.asXML()); 
                         } 
                 } 
                 for (Iterator<Element> i = classEl.elementIterator("set"); i.hasNext();) { 
                         Element el = i.next(); 
                         String type = null; 
                         String name = fixName(el.attributeValue("name")); 
                         // boolean lazy = "true".equals(el.attributeValue("lazy","false")); 
                         // boolean eager = "false".equals(el.attributeValue("lazy","true")); 
                         // String cascade = el.attributeValue("cascade"); 
                         pwb.println(); 
                         if (el.element("many-to-many")!=null) { 
                                 // String column = el.element("key").attributeValue("column").toLowerCase(); 
                                 // String icolumn = el.element("many-to-many").attributeValue("column").toLowerCase(); 
                                 // String m2mtable = el.attributeValue("table").toLowerCase(); 
                                 type = fixType(el.element("many-to-many").attributeValue("class"), pkg); 
                                 if (type.indexOf('.')>=0) { 
                                         imports.add(type); 
                                         type = type.substring(type.lastIndexOf('.')+1); 
                                 } 
                         } else if (el.element("one-to-many")!=null) { 
                                 // String column = el.element("key").attributeValue("column").toLowerCase(); 
                                 type = fixType(el.element("one-to-many").attributeValue("class"), pkg); 
                                 if (type.indexOf('.')>=0) { 
                                         imports.add(type); 
                                         type = type.substring(type.lastIndexOf('.')+1); 
                                 } 
                         } else if (el.element("element")!=null) { 
                                 type = fixType(el.element("element").attributeValue("type"), pkg); 
                                 if (type.indexOf('.')>=0) { 
                                         imports.add(type); 
                                         type = type.substring(type.lastIndexOf('.')+1); 
                                 } 
                         } else { 
                                 System.err.println("Unknown type of set"); 
                         } 
                         if (type.indexOf('.')>=0) imports.add(type); 
                         imports.add("java.util.Set"); 
                         imports.add("java.util.HashSet"); 
                         pwa.println("        private Set<"+type+"> i"+name+";"); 
                         pwb.println("        public Set<"+type+"> get"+name+"() { return i"+name+"; }"); 
                         pwb.println("        public void set"+name+"(Set<"+type+"> "+name.substring(0,1).toLowerCase()+name.substring(1)+") { i"+name+" = "+name.substring(0,1).toLowerCase()+name.substring(1)+"; }"); 
                         pwb.println("        public void addTo"+name.substring(0,1).toLowerCase()+name.substring(1)+"("+type+" "+type.substring(0, 1).toLowerCase()+type.substring(1)+") {"); 
                         pwb.println("                if (i"+name+" == null) i"+name+" = new HashSet<"+type+">();"); 
                         pwb.println("                i"+name+".add("+type.substring(0, 1).toLowerCase()+type.substring(1)+");"); 
                         pwb.println("        }"); 
                 } 
                 pwa.flush(); pwa.close(); 
                 pwb.flush(); pwb.close(); 
                 pwp.flush(); pwp.close(); 
                  
                 imports.add("java.io.Serializable"); 
                 boolean abs = "true".equals(classEl.attributeValue("abstract","false")); 
                 ext = fixType(ext, pkg); 
                 if (ext != null && ext.indexOf('.')>=0) { 
                         imports.add(ext); 
                         ext = ext.substring(ext.lastIndexOf('.')+1); 
                 } 
                 if (idName != null || !compositeId.isEmpty()) 
                         imports.add(fixType(classEl.attributeValue("name"), pkg)); 
                  
                 // Base class 
                 PrintWriter pw = new PrintWriter(new FileWriter(new File(fileFromPackage(outputFolder, pkg + ".base"), "Base" + className + ".java"))); 
                 license(pw); 
                 pw.println("package "+pkg+".base;"); 
                 pw.println(); 
                 String last = null; 
                 for (String imp: imports) { 
                         String top = imp.substring(0, imp.indexOf('.')); 
                         if (last!=null && !last.equals(top)) pw.println(); 
                         pw.println("import "+imp+";"); 
                         last = top; 
                 } 
                 pw.println(); 
                 pw.println("/**"); 
                 pw.println(" * Do not change this class. It has been automatically generated using ant create-model."); 
                 pw.println(" * @see org.unitime.commons.ant.CreateBaseModelFromXml"); 
                 pw.println(" */"); 
                 pw.println("public abstract class Base"+className+(ext==null?"":" extends "+ext)+" implements Serializable {"); 
                 pw.println("        private static final long serialVersionUID = 1L;"); 
                 pw.println(); 
                 pw.print(attributes.getBuffer()); 
                 pw.println(); 
                 pw.print(props.getBuffer()); 
                 pw.println(); 
                 pw.println("        public Base"+className+"() {"); 
                 pw.println("                initialize();"); 
                 pw.println("        }"); 
                 if (idName != null) { 
                         String x = idName.substring(0,1).toLowerCase()+idName.substring(1); 
                         pw.println(); 
                         pw.println("        public Base"+className+"("+idType+" "+x+") {"); 
                         pw.println("                set"+idName+"(" + x + ");"); 
                         pw.println("                initialize();"); 
                         pw.println("        }"); 
                 } 
                 pw.println(); 
                 pw.println("        protected void initialize() {}"); 
                 pw.print(body.getBuffer()); 
                 iClassProperties.put(className, properties); 
                 if (ext!=null && iClassProperties.containsKey(ext)) { 
                         properties.addAll(iClassProperties.get(ext)); 
                 } 
                 if (idName!=null) { 
                         if (idClass==null) idClass = className; 
                         pw.println(); 
                         pw.println("        public boolean equals(Object o) {"); 
                         pw.println("                if (o == null || !(o instanceof "+className+")) return false;"); 
                         pw.println("                if (get"+idName+"() == null || (("+className+")o).get"+idName+"() == null) return false;"); 
                         pw.println("                return get"+idName+"().equals((("+className+")o).get"+idName+"());"); 
                         pw.println("        }"); 
                         pw.println(); 
                         pw.println("        public int hashCode() {"); 
                         pw.println("                if (get"+idName+"() == null) return super.hashCode();"); 
                         pw.println("                return get"+idName+"().hashCode();"); 
                         pw.println("        }"); 
                         pw.println(); 
                         pw.println("        public String toString() {"); 
                         if (properties.contains("Name")) 
                                 pw.println("                return \""+className+"[\"+get"+idName+"()+\" \"+getName()+\"]\";"); 
                         else if (properties.contains("Label")) 
                                 pw.println("                return \""+className+"[\"+get"+idName+"()+\" \"+getLabel()+\"]\";"); 
                         else 
                                 pw.println("                return \""+className+"[\"+get"+idName+"()+\"]\";"); 
                         pw.println("        }"); 
                 } else if (!compositeId.isEmpty()) { 
                         String x = className.substring(0,1).toLowerCase()+className.substring(1); 
                         pw.println(); 
                         pw.println("        public boolean equals(Object o) {"); 
                         pw.println("                if (o == null || !(o instanceof "+className+")) return false;"); 
                         pw.println("                "+className+" "+x+" = ("+className+")o;"); 
                         for (String[] typeName: compositeId) { 
                                 String name = typeName[1]; 
                                 pw.println("                if (get"+name+"() == null || "+x+".get"+name+"() == null || !get"+name+"().equals("+x+".get"+name+"())) return false;"); 
                         } 
                         pw.println("                return true;"); 
                         pw.println("        }"); 
                         pw.println(); 
                         pw.println("        public int hashCode() {"); 
                         String xor = "", isNull = ""; 
                         for (String[] typeName: compositeId) { 
                                 String name = typeName[1]; 
                                 if (!xor.isEmpty()) { xor += " ^ "; isNull += " || "; } 
                                 xor += "get"+name+"().hashCode()"; 
                                 isNull += "get"+name+"() == null"; 
                         } 
                         pw.println("                if ("+isNull+") return super.hashCode();"); 
                         pw.println("                return "+xor+";"); 
                         pw.println("        }"); 
                         pw.println(); 
                         pw.println("        public String toString() {"); 
                         String names = ""; 
                         for (String[] typeName: compositeId) { 
                                 String name = typeName[1]; 
                                 if (!names.isEmpty()) names += " + \", \" + "; 
                                 names += "get"+name+"()"; 
                         } 
                         pw.println("                return \""+className+"[\" + "+names+" + \"]\";"); 
                         pw.println("        }"); 
                 } 
                 pw.println(); 
                 pw.println("        public String toDebugString() {"); 
                 pw.println("                return \""+className+"[\" +"); 
                 for (String p: properties) 
                         pw.println("                        \"\\n        "+p+": \" + get"+p+"() +"); 
                 pw.println("                        \"]\";"); 
                 pw.println("        }"); 
                 pw.println("}"); 
                 pw.flush(); pw.close(); 
                 for (Iterator<Element> i=classEl.elementIterator("union-subclass");i.hasNext();) { 
                         importClass(i.next(), pkg, outputFolder, className, idClass, idName, idType); 
                 } 
                 for (Iterator<Element> i=classEl.elementIterator("subclass");i.hasNext();) { 
                         importClass(i.next(), pkg, outputFolder, className, idClass, idName, idType); 
                 } 
                  
                 // Main class 
                 File mainFile = new File(fileFromPackage(outputFolder, pkg), className + ".java"); 
                 if (!mainFile.exists()) { 
                         pw = new PrintWriter(new FileWriter(mainFile)); 
                         license(pw); 
                         pw.println("package "+pkg+";"); 
                         pw.println(); 
                         pw.println("import "+pkg+".base.Base"+className+";"); 
                         pw.println(); 
                         pw.println("public"+(abs?" abstract":"")+" class "+className+" extends Base"+className+" {"); 
                         pw.println(); 
                         pw.println("        public " + className + "() {"); 
                         pw.println("                super();"); 
                         pw.println("        }"); 
                         pw.println(); 
                         pw.println("}"); 
                         pw.flush(); pw.close(); 
                 } 
                  
                 // BASE DAO class 
                 pw = new PrintWriter(new FileWriter(new File(fileFromPackage(outputFolder, pkg + ".base"), "Base" + className + "DAO.java"))); 
                 license(pw); 
                 pw.println("package "+pkg+".base;"); 
                 pw.println(); 
                 if (idType == null) 
                         pw.println("import java.io.Serializable;"); 
                 if (!manyToOnes.isEmpty()) 
                         pw.println("import java.util.List;"); 
                 if (idType == null || !manyToOnes.isEmpty()) 
                         pw.println(); 
                 pw.println("import "+pkg+"."+className+";"); 
                 pw.println("import "+pkg+".dao._RootDAO;"); 
                 pw.println("import "+pkg+".dao."+className+"DAO;"); 
                 pw.println(); 
                 pw.println("/**"); 
                 pw.println(" * Do not change this class. It has been automatically generated using ant create-model."); 
                 pw.println(" * @see org.unitime.commons.ant.CreateBaseModelFromXml"); 
                 pw.println(" */"); 
                 pw.println("public abstract class Base"+className+"DAO"+" extends _RootDAO<"+className+","+(idType==null?"Serializable":idType)+"> {"); 
                 pw.println(); 
                 pw.println("        private static "+className+"DAO sInstance;"); 
                 pw.println(); 
                 pw.println("        public static "+className+"DAO getInstance() {"); 
                 pw.println("                if (sInstance == null) sInstance = new "+className+"DAO();"); 
                 pw.println("                return sInstance;"); 
                 pw.println("        }"); 
                 pw.println(); 
                 pw.println("        public Class<"+className+"> getReferenceClass() {"); 
                 pw.println("                return "+className+".class;"); 
                 pw.println("        }"); 
                 for (String[] attr: manyToOnes) { 
                         String type = attr[0]; 
                         String name = attr[1]; 
                         String x = name.substring(0,1).toLowerCase()+name.substring(1); 
                         String[] id = iIds.get(type); 
                         String iType = "Long"; 
                         String iName = "UniqueId"; 
                         if (id!=null) { 
                                 iType = id[0]; 
                                 iName = id[1]; 
                         } 
                         pw.println(); 
                         pw.println("        @SuppressWarnings(\"unchecked\")"); 
                         pw.println("        public List<"+className+"> findBy"+name+"(org.hibernate.Session hibSession, "+iType+" "+x+"Id) {"); 
                         pw.println("                return hibSession.createQuery(\"from "+className+" x where x."+x+"."+iName.substring(0,1).toLowerCase()+iName.substring(1)+" = :"+x+"Id\").set"+iType+"(\""+x+"Id\", "+x+"Id).list();"); 
                         pw.println("        }"); 
                 } 
  
                 pw.println("}"); 
                 pw.flush(); pw.close(); 
                  
                 // DAO class 
                 File daoFile = new File(fileFromPackage(outputFolder, pkg+".dao"), className + "DAO.java"); 
                 if (!daoFile.exists()) { 
                         pw = new PrintWriter(new FileWriter(daoFile)); 
                         license(pw); 
                         pw.println("package "+pkg+".dao;"); 
                         pw.println(); 
                         pw.println("import "+pkg+".base.Base"+className+"DAO;"); 
                         pw.println(); 
                         pw.println("public"+(abs?" abstract":"")+" class "+className+"DAO extends Base"+className+"DAO {"); 
                         pw.println(); 
                         pw.println("        public " + className + "DAO() {}"); 
                         pw.println(); 
                         pw.println("}"); 
                         pw.flush(); pw.close(); 
                 } 
         } 
          
         public void execute() throws BuildException { 
                 try { 
                         convert(); 
                 } catch (Exception e) { 
                         throw new BuildException(e); 
                 } 
         } 
          
         public void info(String message) { 
                 try { 
                         log(message); 
                 } catch (Exception e) { 
                         System.out.println(message); 
                 } 
         } 
          
         public void warn(String message) { 
                 try { 
                         log(message, Project.MSG_WARN); 
                 } catch (Exception e) { 
                         System.out.println(message); 
                 } 
         } 
  
         public static void main(String[] args) { 
                 try { 
                         new CreateBaseModelFromXml().convert(); 
                 } catch (Exception e) { 
                         e.printStackTrace(); 
                 } 
         } 
          
 }
