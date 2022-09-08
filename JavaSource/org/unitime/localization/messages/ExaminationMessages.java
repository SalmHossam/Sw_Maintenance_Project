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
package org.unitime.localization.messages;

/**
 * @author Tomas Muller
 */
public interface ExaminationMessages extends Messages {
	
	@DefaultMessage("Filter")
	String filter();

	@DefaultMessage("Normal")
	String seatingNormal();

	@DefaultMessage("Exam")
	String seatingExam();

	@DefaultMessage("Final")
	String typeFinal();
	
	@DefaultMessage("Midterm")
	String typeMidterm();
	
	@DefaultMessage("{0} Examinations")
	String tableExaminations(String type);
	
	@DefaultMessage("Classes / Courses")
	String colExamOwner();
	
	@DefaultMessage("Length")
	String colExamLength();
	
	@DefaultMessage("Seating\nType")
	String colExamSeatingType();
	
	@DefaultMessage("Size")
	String colExamSize();
	
	@DefaultMessage("Max\nRooms")
	String colExamMaxRooms();
	
	@DefaultMessage("Instructor")
	String colExamInstructor();
	
	@DefaultMessage("Period\nPreferences")
	String colExamPeriodPrefs();
	
	@DefaultMessage("Room\nPreferences")
	String colExamRoomPrefs();
	
	@DefaultMessage("Distribution\nPreferences")
	String colExamDistributionPrefs();
	
	@DefaultMessage("Assigned\nPeriod")
	String colExamAssignedPeriod();
	
	@DefaultMessage("Assigned\nRoom")
	String colExamAssignedRoom();
	
	@DefaultMessage("Subject")
	String colExamOwnerSubject();
	
	@DefaultMessage("Course<br>Number")
	String colExamOwnerCourseNumber();
	
	@DefaultMessage("Config<br>Subpart")
	String colExamOwnerConfigSubpart();
	
	@DefaultMessage("Class<br>Number")
	String colExamOwnerClassNumber();
	
	@DefaultMessage("N/A")
	String examOwnerNotApplicable();
	
	@DefaultMessage("Object")
	String colExamOwnerObject();
	
	@DefaultMessage("Type")
	String colExamOwnerType();
	
	@DefaultMessage("Title")
	String colExamOwnerTitle();
	
	@DefaultMessage("Manager")
	String colExamOwnerManager();
	
	@DefaultMessage("Students")
	String colExamOwnerStudents();
	
	@DefaultMessage("Limit")
	String colExamOwnerLimit();
	
	@DefaultMessage("Assignment")
	String colExamOwnerAssignment();
	
	@DefaultMessage("Class")
	String examTypeClass();
	
	@DefaultMessage("Configuration")
	String examTypeConfig();
	
	@DefaultMessage("Offering")
	String examTypeOffering();
	
	@DefaultMessage("Course")
	String examTypeCourse();
	
	@DefaultMessage("-- Configurations --")
	String sctOwnerTypeConfigurations();
	
	@DefaultMessage("-- Subparts --")
	String sctOwnerTypeSubparts();

	@DefaultMessage("No examination matching the above criteria was found.")
	String errorNoMatchingExam();
	
	@DefaultMessage("Maximal Number of Rooms cannot be negative.")
	String errorNegativeMaxNbrRooms();
	
	@DefaultMessage("Length must be above zero.")
	String errorZeroExamLength();
	
	@DefaultMessage("Size must be a number.")
	String errorExamSizeNotNumber();
	
	@DefaultMessage("Print Offset must be a number")
	String errorExamPrintOffsetNotNumber();
	
	@DefaultMessage("One instructor is listed two or more times.")
	String errorDuplicateExamInstructors();
	
	@DefaultMessage("At least one class/course has to be specified.")
	String errorNoExamOwners();
	
	@DefaultMessage("Add Examination")
	String buttonAddExamination();
	
	@DefaultMessage("Export PDF")
	String buttonExportPDF();
	
	@DefaultMessage("Export CSV")
	String buttonExportCSV();
	
	@DefaultMessage("Search")
	String buttonSearch();
	
	@DefaultMessage("Edit")
	String actionExamEdit();
	
	@DefaultMessage("Edit Examination (Alt + E)")
	String titleExamEdit();
	
	@DefaultMessage("E")
	String accessExamEdit();
	
	@DefaultMessage("Clone")
	String actionExamClone();
	
	@DefaultMessage("Clone Examination (Alt + C)")
	String titleExamClone();
	
	@DefaultMessage("C")
	String accessExamClone();
	
	@DefaultMessage("Add Distribution Preference")
	String actionExamAddDistributionPref();
	
	@DefaultMessage("Add Distribution Preference (Alt + A)")
	String titleExamAddDistributionPref();
	
	@DefaultMessage("A")
	String accessExamAddDistributionPref();
	
	@DefaultMessage("Assign")
	String actionExamAssign();
	
	@DefaultMessage("Open Examination Assignment Dialog (Alt + X)")
	String titleExamAssign();
	
	@DefaultMessage("X")
	String accessExamAssign();
	
	@DefaultMessage("Previous")
	String actionExamPrevious();
	
	@DefaultMessage("Previous Examination (Alt + P)")
	String titleExamPrevious();
	
	@DefaultMessage("P")
	String accessExamPrevious();
	
	@DefaultMessage("Next")
	String actionExamNext();
	
	@DefaultMessage("Next Examination (Alt + N)")
	String titleExamNext();
	
	@DefaultMessage("N")
	String accessExamNext();
	
	@DefaultMessage("Back")
	String actionExamBack();
	
	@DefaultMessage("Return to %% (Alt + B)")
	String titleExamBack();
	
	@DefaultMessage("B")
	String accessExamBack();
	
	@DefaultMessage("Delete")
	String actionExamDelete();
	
	@DefaultMessage("Delete Examination (Alt + D)")
	String titleExamDelete();
	
	@DefaultMessage("D")
	String accessExamDelete();
	
	@DefaultMessage("Update")
	String actionExamUpdate();
	
	@DefaultMessage("Update Examination (Alt + U)")
	String titleExamUpdate();
	
	@DefaultMessage("U")
	String accessExamUpdate();
	
	@DefaultMessage("Save")
	String actionExamSave();
	
	@DefaultMessage("Save Examination (Alt + S)")
	String titleExamSave();
	
	@DefaultMessage("S")
	String accessExamSave();
	
	@DefaultMessage("Back")
	String actionBatckToDetail();
	
	@DefaultMessage("Do not make any change. Return to Detail Screen (ALT+B)")
	String titleBatckToDetail();
	
	@DefaultMessage("B")
	String accessBatckToDetail();
	
	@DefaultMessage("Course numbers can be specified using wildcard (*). E.g. 2*")
	String titleCourseNumberSuggestBox();
	
	@DefaultMessage("{0} Exams ({1})")
	String backExams(String type, String subjectOrCourse);
	
	@DefaultMessage("{0} ({1})")
	String backExaminationReports(String report, String subject);
	
	@DefaultMessage("Exam ({0})")
	String backExam(String name);
	
	@DefaultMessage("Clear Exam Preferences")
	String actionClearExamPreferences();
	
	@DefaultMessage("C")
	String accessClearExamPreferences();
	
	@DefaultMessage("Delete all Examination Preferences (Alt+C)")
	String titleClearExamPreferences();
	
	@DefaultMessage("Add Instructor")
	String actionAddInstructor();
	
	@DefaultMessage("I")
	String accessAddInstructor();
	
	@DefaultMessage("Add Instructor (Alt+I)")
	String titleAddInstructor();
	
	@DefaultMessage("Add Object")
	String actionAddObject();
	
	@DefaultMessage("O")
	String accessAddObject();
	
	@DefaultMessage("Add Class/Config/Course/Offering (Alt+O)")
	String titleAddObject();
	
	@DefaultMessage("Delete")
	String actionDeleteInstructor();
	
	@DefaultMessage("Delete Instructor")
	String titleDeleteInstructor();
	
	@DefaultMessage("Delete")
	String actionDeleteObject();
	
	@DefaultMessage("Delete Class/Config/Course/Offering")
	String titleDeleteObject();
	
	@DefaultMessage("Type:")
	String propExamType();
	
	@DefaultMessage("Subject:")
	String propExamSubject();
	
	@DefaultMessage("Course Number:")
	String propExamCourseNumber();
	
	@DefaultMessage("Name:")
	String propExamName();
	
	@DefaultMessage("Length:")
	String propExamLength();
	
	@DefaultMessage("Seating Type:")
	String propExamSeatingType();
	
	@DefaultMessage("Maximum Number of Rooms:")
	String propExamMaxRooms();
	
	@DefaultMessage("Size:")
	String propExamSize();
	
	@DefaultMessage("Print Offset:")
	String propExamPrintOffset();
	
	@DefaultMessage("Examination Period:")
	String propExamAssignedPeriod();
	
	@DefaultMessage("Room:")
	String propExamAssignedRoom();
	
	@DefaultMessage("Rooms:")
	String propExamAssignedRooms();
	
	@DefaultMessage("Violated Distributions:")
	String propExamViolatedDistConstraints();
	
	@DefaultMessage("Student Conflicts:")
	String propExamStudentConflicts();
	
	@DefaultMessage("Instructor Conflicts:")
	String propExamInstructorConflicts();
	
	@DefaultMessage("minutes")
	String offsetUnitMinutes();
	
	@DefaultMessage("Instructors:")
	String propExamInstructors();
	
	@DefaultMessage("Average Period:")
	String propExamAvgPeriod();
	
	@DefaultMessage("Notes")
	String sectExamNotes();
	
	@DefaultMessage("Student Accommodations:")
	String propExamStudentAccommodations();
	
	@DefaultMessage("Classes / Courses")
	String sectExamOwners();
	
	@DefaultMessage("No relation defined for this exam.")
	String warnNoExamOwners();
	
	@DefaultMessage("Assignment")
	String sectExamAssignment();
	
	@DefaultMessage("Preferences")
	String sectExamPreferences();
	
	@DefaultMessage("Examination id not provided.")
	String errorNoExamId();
	
	@DefaultMessage("Exam ({0})")
	String backToExam(String name);
	
	@DefaultMessage("Examination Assignment")
	String dialogExamAssign();
	
	@DefaultMessage("(in minutes, only used for reports)")
	String noteExamPrintOffset();
	
	@DefaultMessage("The examination will be deleted. Continue?")
	String confirmExamDelete();
	
	@DefaultMessage("There are the following errors:")
	String formValidationErrors();
	
	@DefaultMessage("Select a distribution type.")
	String errorSelectDistributionType();
	
	@DefaultMessage("Select a preference level.")
	String errorSelectPreferenceLevel();
	
	@DefaultMessage("Cancel")
	String actionCancel();
	
	@DefaultMessage("Update")
	String actionUpdateDistributionPreference();
	
	@DefaultMessage("Save")
	String actionSaveNewDistributionPreference();

	@DefaultMessage("Delete")
	String actionDeleteDistributionPreference();
	
	@DefaultMessage("Back")
	String actionBackDistributionPreference();
	
	@DefaultMessage("Add Distribution Preference")
	String actionAddDistributionPreference();
	
	@DefaultMessage("Add Examination")
	String actionAddExamToDistribution();

	@DefaultMessage("Search")
	String actionSearchDistributionPreferences();

	@DefaultMessage("Export PDF")
	String actionExportPdf();

	@DefaultMessage("Export CSV")
	String actionExportCsv();
	
	@DefaultMessage("Delete")
	String actionDelete();
	
	@DefaultMessage("Update Distribution Preference (Alt+{0})")
	String titleUpdateDistributionPreference(String accessKey);

	@DefaultMessage("Save New Distribution Preference (Alt+{0})")
	String titleSaveNewDistributionPreference(String accessKey);
	
	@DefaultMessage("Delete Distribution Preference (Alt+{0})")
	String titleDeleteDistributionPreference(String accessKey);
	
	@DefaultMessage("Return to %% (Alt+{0})")
	String titleBackDistributionPreference(String accessKey);	
	
	@DefaultMessage("Add Examination (Alt+{0})")
	String titleAddExamToDistribution(String accessKey);
	
	@DefaultMessage("Move Up")
	String titleMoveUp();
	
	@DefaultMessage("Move Down")
	String titleMoveDown();
	
	@DefaultMessage("Search Distribution Preferences (Alt+{0})")
	String titleSearchDistributionPreferences(String accessKey);
	
	@DefaultMessage("Export PDF (Alt+{0})")
	String titleExportPdf(String accessKey);

	@DefaultMessage("Export CSV (Alt+{0})")
	String titleExportCsv(String accessKey);
	
	@DefaultMessage("Add Distribution Preference (Alt+{0})")
	String titleAddDistributionPreference(String accessKey);
	
	@DefaultMessage("U")
	String accessUpdateDistributionPreference();

	@DefaultMessage("S")
	String accessSaveNewDistributionPreference();
	
	@DefaultMessage("D")
	String accessDeleteDistributionPreference();
	
	@DefaultMessage("B")
	String accessBackDistributionPreference();
	
	@DefaultMessage("A")
	String accessAddExamToDistribution();
	
	@DefaultMessage("S")
	String accessSearchDistributionPreferences();
	
	@DefaultMessage("P")
	String accessExportPdf();
	
	@DefaultMessage("C")
	String accessExportCsv();
	
	@DefaultMessage("A")
	String accessAddDistributionPreference();
	
	@DefaultMessage("Do you really want to delete this distribution preference?")
	String confirmDeleteDistributionPreference();
	
	@DefaultMessage("Add Examination Distribution Preference")
	String sectionAddDistributionPreference();
	
	@DefaultMessage("Edit Examination  Distribution Preference")
	String sectionEditDistributionPreference();
	
	@DefaultMessage("{0} Examinations in Distribution")
	String sectionExaminationsInDistribution(String examType);
	
	@DefaultMessage("{0} Examination Distribution Preferences")
	String sectionDistributionPreferences(String examType);

	@DefaultMessage("Distribution Type:")
	String propertyDistributionType();
	
	@DefaultMessage("Preference:")
	String propertyDistributionPreference();
	
	@DefaultMessage("Course numbers can be specified using wildcard (*). E.g. 2*")
	String tooltipCourseNumber();
	
	@DefaultMessage("Show classes/courses:")
	String filterShowClassesCourses();
	
	@DefaultMessage("Examination Problem:")
	String filterExaminationProblem();
	
	@DefaultMessage("Report:")
	String filterReport();
	
	@DefaultMessage("Filter:")
	String filterTextFilter();
	
	@DefaultMessage("Hint: use comma for conjunctions, semicolon for disjunctions, e.g., 'a,b;c means (a and b) or c'.")
	String titleTextFilter();
	
	@DefaultMessage("Subject Areas:")
	String filterSubjectAreas();
	
	@DefaultMessage("Apply")
	String buttonApply();
	
	@DefaultMessage("A")
	String accessApply();
	
	@DefaultMessage("Apply (Alt + A)")
	String titleApply();
	
	@DefaultMessage("Refresh")
	String buttonRefresh();
	
	@DefaultMessage("R")
	String accessRefresh();
	
	@DefaultMessage("Refresh (Alt + R)")
	String titleRefresh();
	
	@DefaultMessage("No exams matching the above criteria found.")
	String errorNoExamsFound();
	
	@DefaultMessage("Class / Course")
	String colOwner();
	
	@DefaultMessage("Examination")
	String colExamination();
	
	@DefaultMessage("Enrollment")
	String colEnrollment();
	
	@DefaultMessage("Seating\nType")
	String colSeatingType();
	
	@DefaultMessage("Date")
	String colDate();
	
	@DefaultMessage("Time")
	String colTime();
	
	@DefaultMessage("Room")
	String colRoom();
	
	@DefaultMessage("Name")
	String colStudentOrInstructorName();
	
	@DefaultMessage("Name")
	String colName();
	
	@DefaultMessage("Student Id")
	String colStudentId();
	
	@DefaultMessage("Instructor Id")
	String colInstructorId();
	
	@DefaultMessage("Instructor")
	String colInstructor();
	
	@DefaultMessage("Capacity")
	String colRoomCapacity();
	
	@DefaultMessage("Exam Capacity")
	String colExamCapacity();
	
	@DefaultMessage("Instructor\nConflicts")
	String colInstructorConflicts();
	
	@DefaultMessage("Student\nConflicts")
	String colStudentConflicts();
	
	@DefaultMessage("Classes / Courses")
	String colOwners();
	
	@DefaultMessage("Examinations")
	String colExaminations();
	
	@DefaultMessage("Total Enrollment")
	String colTotalEnrollment();
	
	@DefaultMessage("with {0}+ students")
	String withNOrMoreStudents(int n);
	
	@DefaultMessage("Totals")
	String colTotals();
	
	@DefaultMessage("Average\nDistance")
	String colAverageDistance();
	
	@DefaultMessage("1st")
	String col1stExam();
	
	@DefaultMessage("2nd")
	String col2ndExam();
	
	@DefaultMessage("3rd")
	String col3rdExam();
	
	@DefaultMessage("{0}th")
	String colNthExam(int n);
	
	@DefaultMessage("Preference")
	String colPreference();
	
	@DefaultMessage("Distribution")
	String colDistribution();
	
	@DefaultMessage("Students with\nNo Exam")
	String colStudentsWithNoExam();
	
	@DefaultMessage("Students with\nOne Exam")
	String colStudentsWithOneExam();
	
	@DefaultMessage("Students with\nTwo Exams")
	String colStudentsWithTwoExams();
	
	@DefaultMessage("Students with\nThree Exams")
	String colStudentsWithThreeExams();
	
	@DefaultMessage("Students with\nFour or More Exams")
	String colStudentsWithFourOrMoreExams();
	
	@DefaultMessage("Student\nBack-To-Back Exams")
	String colStudentBTBExams();
	
	@DefaultMessage("Student Distance\nBack-To-Back Exams")
	String colStudentDistanceBTBExams();
	
	@DefaultMessage("Type")
	String colType();
	
	@DefaultMessage("Distance")
	String colDistance();
	
	@DefaultMessage("Class")
	String typeClass();
	
	@DefaultMessage("Event")
	String typeEvent();
	
	@DefaultMessage("Direct")
	String conflictDirect();
	
	@DefaultMessage("Student N/A")
	String conflictStudentNotAvailable();
	
	@DefaultMessage("Direct [%]")
	String colDirectPercent();
	
	@DefaultMessage("Back-To-Back")
	String conflictBackToBack();
	
	@DefaultMessage("Back-To-Back [%]")
	String colBackToBackPercent();
	
	@DefaultMessage("Distance [m]")
	String colDistanceMeters();
	
	@DefaultMessage(">2 A Day")
	String conflictMoreThanTwoADay();
	
	@DefaultMessage(">2 A Day [%]")
	String colMoreThanTwoADayPercent();
	
	@DefaultMessage("Value")
	String colValue();
	
	@DefaultMessage("Number of exams")
	String propNumberOfExams();
	
	@DefaultMessage("Classes")
	String typeClasses();
	
	@DefaultMessage("Configs")
	String typeConfigs();
	
	@DefaultMessage("Courses")
	String typeCourses();
	
	@DefaultMessage("Offerings")
	String typeOfferings();
	
	@DefaultMessage("{0} with an exam")
	String propOwnersWithAnExam(String type);
	
	@DefaultMessage("Students enrolled in classes")
	String propStudentsEnrolledInClasses();
	
	@DefaultMessage("Students having an exam")
	String propStudentsHavingAnExam();
	
	@DefaultMessage("Student exam enrollments")
	String propStudentExamEnrollments();
	
	@DefaultMessage("Registered instructors")
	String propRegisteredInstructors();
	
	@DefaultMessage("Instructors having an exam")
	String propInstructorsHavingAnExam();
	
	@DefaultMessage("Instructor exam enrollments")
	String propInstructorExamEnrollments();
	
	@DefaultMessage("Direct student conflicts")
	String propDirectStudentConflicts();
	
	@DefaultMessage("Conflict with other exam")
	String propConflictWithOtherExam();
	
	@DefaultMessage("Student not available")
	String propStudentNotAvailable();
	
	@DefaultMessage("More than 2 exams a day student conflicts")
	String propStudentMoreThanTwoExamsADayConflicts();
	
	@DefaultMessage("Back-to-back student conflicts")
	String propStudentBackToBackConflicts();
	
	@DefaultMessage("Distance back-to-back student conflicts")
	String propStudentDistanceBackToBackConflicts();
	
	@DefaultMessage("Direct instructor conflicts")
	String propDirectInstructorConflicts();
	
	@DefaultMessage("Instructor not available")
	String propInstructorNotAvailable();
	
	@DefaultMessage("More than 2 exams a day instructor conflicts")
	String propInstructorMoreThanTwoExamsADayConflicts();
	
	@DefaultMessage("Back-to-back instructor conflicts")
	String propInstructorBackToBackConflicts();
	
	@DefaultMessage("Distance back-to-back instructor conflicts")
	String propInstructorDistanceBackToBackConflicts();

	@DefaultMessage("Exam Assignment Report")
	String reportExamAssignmentReport();

	@DefaultMessage("Room Assignment Report")
	String reportRoomAssignmentReport();

	@DefaultMessage("Statistics")
	String reportStatistics();

	@DefaultMessage("Period Usage")
	String reportPeriodUsage();

	@DefaultMessage("Number of Exams A Day")
	String reportNrExamsADay();

	@DefaultMessage("Room Splits")
	String reportRoomSplits();

	@DefaultMessage("Violated Distribution Constraints")
	String reportViolatedDistributions();

	@DefaultMessage("Direct Student Conflicts")
	String reportDirectStudentConflicts();

	@DefaultMessage("More Than 2 Exams A Day Student Conflicts")
	String reportMore2ADayStudentConflicts();

	@DefaultMessage("Back-To-Back Student Conflicts")
	String reportBackToBackStudentConflicts();

	@DefaultMessage("Individual Student Conflicts")
	String reportIndividualStudentConflicts();

	@DefaultMessage("Individual Direct Student Conflicts")
	String reportIndividualDirectStudentConflicts();

	@DefaultMessage("Individual Back-To-Back Student Conflicts")
	String reportIndividualBackToBackStudentConflicts();

	@DefaultMessage("Individual More Than 2 Exams A Day Student Conflicts")
	String reportIndividualMore2ADayStudentConflicts();

	@DefaultMessage("Direct Instructor Conflicts")
	String reportDirectInstructorConflicts();

	@DefaultMessage("More Than 2 Exams A Day Instructor Conflicts")
	String reportMore2ADayInstructorConflicts();

	@DefaultMessage("Back-To-Back Instructor Conflicts")
	String reportBackToBackInstructorConflicts();

	@DefaultMessage("Individual Instructor Conflicts")
	String reportIndividualInstructorConflicts();

	@DefaultMessage("Individual Direct Instructor Conflicts")
	String reportIndividualDirectInstructorConflicts();

	@DefaultMessage("Individual Back-To-Back Instructor Conflicts")
	String reportIndividualBackToBackInstructorConflicts();

	@DefaultMessage("Individual More Than 2 Exams A Day Instructor Conflicts")
	String reportIndividualMore2ADayInstructorConflicts();

	@DefaultMessage("Individual Student Schedule")
	String reportIndividualStudentSchedule();

	@DefaultMessage("Individual Instructor Schedule")
	String reportIndividualInstructorSchedule();
	
	@DefaultMessage("Best")
	String changeBest();
	
	@DefaultMessage("Initial")
	String changeInitial();
	
	@DefaultMessage("Saved")
	String changeSaved();
	
	@DefaultMessage("Examination Assignment Changes")
	String sectExaminationAssingmentChanges();
	
	@DefaultMessage("Period")
	String colPeriod();
	
	@DefaultMessage("Students")
	String colStudents();
	
	@DefaultMessage("not-assigned")
	String notAssigned();
	
	@DefaultMessage("ERROR: {0}")
	String error(String message);
	
	@DefaultMessage("d:")
	String prefixDistanceConclict();
	
	@DefaultMessage("Exam Changes")
	String backExaminationAssignmentChanges();
	
	@DefaultMessage("Reversed mode:")
	String filterReverseMode();
	
	@DefaultMessage("(current &rarr; compared solution)")
	String hintReversedMode();
	
	@DefaultMessage("Compare with:")
	String filterCompareWith();
	
	@DefaultMessage("No examination timetable is loaded into the solver.")
	String messageNoSolver();
	
	@DefaultMessage("No subject area selected.")
	String messageNoSubject();
	
	@DefaultMessage("Solutions are identical.")
	String messageNoChanges();
	
	@DefaultMessage("There are no assignment changes between exams of {0} subject area.")
	String messageNoChangesInSubject(String subject);
	
	@DefaultMessage("Violated\nDistributions")
	String colViolatedDistributions();
	
	@DefaultMessage("Assigned Exams")
	String backAssignedExaminations();
	
	@DefaultMessage("All examinations are not assigned.")
	String messageAllExamsAreNotAssinged();
	
	@DefaultMessage("There are no examinations of {0} subject area, or none of them is assigned.")
	String messageAllExamsOfASubjectAreNotAssinged(String subject);
	
	@DefaultMessage("Not-assigned Examinations")
	String sectionNotAssingedExaminations();

	@DefaultMessage("Assigned Examinations")
	String sectAssignedExaminations();
	
	@DefaultMessage("Not-assigned Exams")
	String backNotAssignedExaminations();
	
	@DefaultMessage("All examinations are assigned.")
	String messageAllExamsAreAssinged();
	
	@DefaultMessage("There are no examinations of {0} subject area, or all of them are assigned.")
	String messageAllExamsOfASubjectAreAssinged(String subject);
	
	@DefaultMessage("<b>Exam Type</b> is required.")
	String errorExamTypeIsRequired();
	
	@DefaultMessage("Room Availability")
	String sectRoomAvailability();
	
	@DefaultMessage("Examination\nCapacity")
	String colExaminationCapacity();

	@DefaultMessage("Event")
	String colEvent();
	
	@DefaultMessage("Event Type")
	String colEventType();
	
	@DefaultMessage("Start Time")
	String colStartTime();
	
	@DefaultMessage("End Time")
	String colEndTime();
	
	@DefaultMessage("WARN: No examination periods.")
	String warnNoExaminationPeriods();
	
	@DefaultMessage("Examination Comparison")
	String sectExaminationComparison();
	
	@DefaultMessage("Examination\nDate")
	String colExaminationDate();
	
	@DefaultMessage("Examination\nTime")
	String colExaminationTime();
	
	@DefaultMessage("Event\nDate")
	String colEventDate();
	
	@DefaultMessage("Event\nTime")
	String colEventTime();
	
	@DefaultMessage("Room Filter:")
	String filterRoomFilter();
	
	@DefaultMessage("Display Examinations:")
	String filterDisplayExaminations();
	
	@DefaultMessage("Compare Examinations:")
	String filterCompareExaminations();
	
	@DefaultMessage("Last Update:")
	String propLastUpdate();
	
	@DefaultMessage("Examination problem not selected.")
	String messageNoExaminationProblemSelected();
	
	@DefaultMessage("Nothing to display.")
	String messageNothingToDisplay();
	
	@DefaultMessage("Examination PDF reports are generated from the current solution (in-memory solution taken from the solver).")
	String warnExamPdfReportsUsingSolution();
	
	@DefaultMessage("Examination PDF reports are generated from the saved solution (solver assignments are ignored).")
	String warnEamPdfReportsUsingSaved();
	
	@DefaultMessage("Reports in progress")
	String sectReportsInProgress();
	
	@DefaultMessage("Name")
	String colTaskName();
	
	@DefaultMessage("Status")
	String colTaskStatus();
	
	@DefaultMessage("Progress")
	String colTaskProgress();
	
	@DefaultMessage("Owner")
	String colTaskOwner();
	
	@DefaultMessage("Session")
	String colTaskSession();
	
	@DefaultMessage("Created")
	String colTaskCreated();
	
	@DefaultMessage("Started")
	String colTaskStarted();
	
	@DefaultMessage("Finished")
	String colTaskFinished();
	
	@DefaultMessage("Output")
	String colTaskOutput();
	
	@DefaultMessage("Do you really want to remove this report?")
	String questionDeleteReportInProgress();
	
	@DefaultMessage("PDF (Letter)")
	String formatPdfLetter();
	
	@DefaultMessage("PDF (Ledger)")
	String formatPdfLedger();

	@DefaultMessage("Text")
	String formatText();
	
	@DefaultMessage("CSV")
	String formatCSV();
	
	@DefaultMessage("PDF (New)")
	String formatPdfNew();
	
	@DefaultMessage("XLS")
	String formatXLS();

	@DefaultMessage("Schedule by Course")
	String reportScheduleByCourseReport();

	@DefaultMessage("Student Conflicts")
	String reportConflictsByCourseAndStudentReport();

	@DefaultMessage("Instuctor Conflicts")
	String reportConflictsByCourseAndInstructorReport();

	@DefaultMessage("Schedule by Period")
	String reportScheduleByPeriodReport();

	@DefaultMessage("Schedule by Period (Exams)")
	String reportExamScheduleByPeriodReport();

	@DefaultMessage("Schedule by Room")
	String reportScheduleByRoomReport();

	@DefaultMessage("Period Chart")
	String reportPeriodChartReport();

	@DefaultMessage("Period Chart (Exams)")
	String reportExamPeriodChartReport();

	@DefaultMessage("Verification")
	String reportExamVerificationReport();

	@DefaultMessage("Abbreviated Schedule")
	String reportAbbvScheduleByCourseReport();

	@DefaultMessage("Abbreviated Schedule (Exams)")
	String reportAbbvExamScheduleByCourseReport();

	@DefaultMessage("Individual Instructor Schedule")
	String reportInstructorExamReport();

	@DefaultMessage("Individual Student Schedule")
	String reportStudentExamReport();
	
	@DefaultMessage("Examination Report")
	String emailSubjectExaminationReport();
	
	@DefaultMessage("Loading exams...")
	String statusLoadingExams();
	
	@DefaultMessage("Errors")
	String sectErrors();
	
	@DefaultMessage("No report selected.")
	String errorNoReportSelected();
	
	@DefaultMessage("No subject area selected.")
	String errorNoSubjectAreaSelected();
	
	@DefaultMessage("<b>{0}</b> is not a valid date.")
	String errorNotValidDate(String date);
	
	@DefaultMessage("Generate")
	String actionGenerateReport();
	
	@DefaultMessage("G")
	String accessGenerateReport();
	
	@DefaultMessage("Generate Report (Alt+G)")
	String titleGenerateReport();
	
	@DefaultMessage("Refresh")
	String actionRegreshLog();
	
	@DefaultMessage("R")
	String accessRegreshLog();
	
	@DefaultMessage("Refresh Log (Alt+R)")
	String titleRegreshLog();
	
	@DefaultMessage("Log of {0}")
	String sectLogOfTask(String task);
	
	@DefaultMessage("Input Data")
	String sectInputData();
	
	@DefaultMessage("All Subject Areas (on one report)")
	String checkReportAllSubjectAreas();
	
	@DefaultMessage("Report")
	String sectReport();
	
	@DefaultMessage("Parameters")
	String sectParameters();
	
	@DefaultMessage("All Reports:")
	String propAllReports();
	
	@DefaultMessage("Display Instructional Type")
	String checkDisplayInstructionalType();
	
	@DefaultMessage("Skip Exams with No Enrollment")
	String checkSkipExamsWithNoEnrollment();
	
	@DefaultMessage("Use Room Display Names")
	String checkUseRoomDisplayNames();
	
	@DefaultMessage("Conflicts Reports:")
	String propConflictReports();
	
	@DefaultMessage("Display Direct Conflicts")
	String checkDisplayDirectConflicts();
	
	@DefaultMessage("Display More Than 2 Exams A Day Conflicts")
	String checkDisplayMoreThan2ExamsADayConflicts();
	
	@DefaultMessage("Display Back-To-Back Conflicts")
	String checkDisplayBackToBackConflicts();
	
	@DefaultMessage("Reports with Rooms:")
	String propReportsWithRooms();
	
	@DefaultMessage("Display Rooms")
	String checkDisplayRooms();
	
	@DefaultMessage("No Room:")
	String propNoRoomLabel();
	
	@DefaultMessage("Period Chart:")
	String propPeriodChartReport();
	
	@DefaultMessage("Display Totals")
	String checkDisplayTotals();
	
	@DefaultMessage("Limit:")
	String propExamLimit();
	
	@DefaultMessage("Room Codes:")
	String propRoomCodes();
	
	@DefaultMessage("Compact Size <i>(no section information)</i>")
	String checkReportCompactSize();
	
	@DefaultMessage("Verification Report:")
	String propVerificationReport();
	
	@DefaultMessage("Display Limits &amp; Enrollments")
	String checkDisplayLimitsAndEnrollments();
	
	@DefaultMessage("Display Class Schedule Notes")
	String checkDisplayClassScheduleNotes();
	
	@DefaultMessage("Individual Reports:")
	String propIndividualReports();
	
	@DefaultMessage("Include Class Schedule")
	String checkIncludeClassSchedule();
	
	@DefaultMessage("Date:")
	String propReportStartDate();
	
	@DefaultMessage("(Only email instructors/students that have a change in their schedule since this date, email all when empty)")
	String hintReportStartDate();
	
	@DefaultMessage("Output")
	String sectOutput();
	
	@DefaultMessage("Format:")
	String propReportFormat();
	
	@DefaultMessage("Delivery:")
	String propReportDelivery();
	
	@DefaultMessage("Email")
	String checkReportDeliveryEmail();
	
	@DefaultMessage("Address:")
	String propEmailAddress();
	
	@DefaultMessage("All Involved Department Schedule Managers")
	String checkAllInvolvedDepartmentScheduleManagers();
	
	@DefaultMessage("Send Individual Instructor Schedule Reports to All Involved Instructors")
	String checkSendIndividualInstructorReportsToInstructors();
	
	@DefaultMessage("Send Individual Student Schedule Reports to All Involved Students")
	String checkSendIndividualStudentReportsToStudents();
	
	@DefaultMessage("CC:")
	String propEmailCC();
	
	@DefaultMessage("BCC:")
	String propEmailBCC();
	
	@DefaultMessage("Subject:")
	String propEmailSubject();
	
	@DefaultMessage("Message:")
	String propEmailMessage();
	
	@DefaultMessage("Fetching exams...")
	String statusFetchingExams();
	
	@DefaultMessage("Fetching related objects (class)...")
	String statusFetchingRelatedClasses();
	
	@DefaultMessage("Fetching related objects (config)...")
	String statusFetchingRelatedConfigs();
	
	@DefaultMessage("Fetching related objects (course)...")
	String statusFetchingRelatedCourses();
	
	@DefaultMessage("Fetching related objects (offering)...")
	String statusFetchingRelatedOfferings();
	
	@DefaultMessage("Loading students (class)...")
	String statusLoadingStudentsFromClasses();

	@DefaultMessage("Loading students (config)...")
	String statusLoadingStudentsFromConfigs();
	
	@DefaultMessage("Loading students (course)...")
	String statusLoadingStudentsFromCourses();
	
	@DefaultMessage("Loading students (offering)...")
	String statusLoadingStudentsFromOfferings();
	
	@DefaultMessage("Generating {0}...")
	String statusGeneratingReport(String report);
	
	@DefaultMessage("Writing {0}...")
	String statusWritingReport(String report);
	
	@DefaultMessage("({0} exams)")
	String hintNbrExams(int exams);
	
	@DefaultMessage("No report generated.")
	String warnNoReportGenerated();
	
	@DefaultMessage("Sending email(s)...")
	String statusSendingEmails();
	
	@DefaultMessage("No manager associated with subject area {0} ({1}).")
	String warnNoManagerForSubject(String subject, String dept);
	
	@DefaultMessage("Manager {0} has no email address.")
	String warnManagerHasNoEmail(String name);
	
	@DefaultMessage("Nothing to send.")
	String warnNothingToSend();
	
	@DefaultMessage("Sending email to {0} ({1})...")
	String infoSendingEmail(String name, String email);
	
	@DefaultMessage("For an up-to-date examination report, please visit {0}")
	String emailForUpToDateReportVisit(String url);
	
	@DefaultMessage("This email was automatically generated by UniTime {0} (Univesity Timetabling Application, http://www.unitime.org).")
	String emailFooter(String version);
	
	@DefaultMessage("Including {0} ({1})")
	String infoIncluding(String name, String email);
	
	@DefaultMessage("Attaching {0}")
	String infoAttaching(String file);
	
	@DefaultMessage("Email sent.")
	String infoEmailSent();
	
	@DefaultMessage("Unable to send email: {0}")
	String errorUnableToSendEmail(String error);
	
	@DefaultMessage("Emailing instructors...")
	String statusEmailingInstructors();
	
	@DefaultMessage("Unable to email {0} -- instructor has no email address.")
	String errorUnableToSentInstructorNoEmail(String name);
	
	@DefaultMessage("An email was sent to {0}.")
	String infoEmailSentTo(String name);
	
	@DefaultMessage("Unable to send email {0} -- {1}.")
	String errorUnableToSendEmailTo(String name, String error);
	
	@DefaultMessage("Emails sent.")
	String infoEmailsSent();
	
	@DefaultMessage("Emailing students...")
	String statusEmailingStudents();
	
	@DefaultMessage("Unable to email {0} -- student has no email address.")
	String errorUnableToSentStudentNoEmail(String name);
	
	@DefaultMessage("Nothing generated.")
	String errorNoReportGenerated();
	
	@DefaultMessage("All done.")
	String statusAllDone();
	
	@DefaultMessage("  Sorting sections...")
	String statusSortingSections();
	
	@DefaultMessage("  Sorting exams...")
	String statusSortingExams();
	
	@DefaultMessage("  Printing report...")
	String statusPrintingReport();
	
	@DefaultMessage("  Loading students ...")
	String statusLoadingStudents();
	
	@DefaultMessage("  Loading courses ...")
	String statusLoadingCourses();
	
	@DefaultMessage("  Loading class events...")
	String statusLoadingClassEvents();
	
	@DefaultMessage("  Loading course limits ...")
	String statusLoadingCourseLimits();
	
	@DefaultMessage("  Loading class limits ...")
	String statusLoadingClassLimits();
	
	@DefaultMessage("  Loading locations...")
	String statusLoadingLocations();
	
	@DefaultMessage("  Printing individual instructor reports...")
	String statusPrintingIndividualInstructorReports();
	
	@DefaultMessage("  Printing individual student reports...")
	String statusPrintingIndividualStudentReports();
	
	@DefaultMessage("  Computing room table...")
	String statusComputingRoomTable();

	@DefaultMessage("Process failed.")
	String errorTaskFailed();
	
	@DefaultMessage("EXAMINATIONS")
	String legacyReportExaminations();
	
	@DefaultMessage("{0} EXAMINATIONS")
	String legacyReportExaminationsOfType(String type);
	
	@DefaultMessage("SCHEDULE BY COURSE")
	String legacyReportScheduleByCourse();
	
	@DefaultMessage("CONFLICTS BY COURSE AND INSTRUCTOR")
	String legacyReportConflictsByCourseAndInstructor();
	
	@DefaultMessage("CONFLICTS BY COURSE AND STUDENT")
	String legacyReportConflictsByCourseAndStudent();
	
	@DefaultMessage("PERIOD ASSIGNMENT")
	String legacyReportPeriodAssignment();
	
	@DefaultMessage("SCHEDULE BY PERIOD")
	String legacyReportScheduleByPeriod();
	
	@DefaultMessage("SCHEDULE BY ROOM")
	String legacyReportScheduleByRoom();
	
	@DefaultMessage("EXAMINATION VERIFICATION REPORT")
	String legacyReportExaminationVerificationReport();
	
	@DefaultMessage("INSTRUCTOR EXAMINATION SCHEDULE")
	String legactReportInstructorExaminationSchedule();
	
	@DefaultMessage("STUDENT EXAMINATION SCHEDULE")
	String legactReportStudentExaminationSchedule();
	
	@DefaultMessage("ALL")
	String lrALL();
	
	@DefaultMessage("w/")
	String lrWith();
	
	@DefaultMessage("Subject")
	String lrSubject();
	
	@DefaultMessage("Course")
	String lrCourse();
	
	@DefaultMessage("ExtID")
	String lrExtID();
	
	@DefaultMessage("Section")
	String lrSection();
	
	@DefaultMessage("Date")
	String lrDate();
	
	@DefaultMessage("Time")
	String lrTime();
	
	@DefaultMessage("Type")
	String lrType();
	
	@DefaultMessage("Bldg")
	String lrBldg();
	
	@DefaultMessage("Room")
	String lrRoom();
	
	@DefaultMessage("ExtnID")
	String lrExtnID();
	
	@DefaultMessage("Name")
	String lrName();
	
	@DefaultMessage("DIRECT")
	String lrDIRECT();
	
	@DefaultMessage("CLASS")
	String lrCLASS();
	
	@DefaultMessage("EVENT")
	String lrEVENT();
	
	@DefaultMessage(">2-DAY")
	String lrMore2DAY();
	
	@DefaultMessage("BTB")
	String lrBTB();
	
	@DefaultMessage("N/A")
	String lrNA();
	
	@DefaultMessage("limit={0}")
	String lrLimit(int limit);
	
	@DefaultMessage("Start Time")
	String lrStartTime();
	
	@DefaultMessage("Exam")
	String lrExam();
	
	@DefaultMessage("Enrl")
	String lrEnrl();
	
	@DefaultMessage("Totals")
	String lrTotals();
	
	@DefaultMessage("Total Student Exams")
	String lrTotalStudentExams();
	
	@DefaultMessage("Date And Time")
	String lrDateAndTime();
	
	@DefaultMessage("Meeting Times")
	String lrMeetingTimes();
	
	@DefaultMessage("Cap")
	String lrCap();
	
	@DefaultMessage("ExCap")
	String lrExCap();
	
	@DefaultMessage("** NO EXAM **")
	String lrNoExam();
		
	@DefaultMessage("Not organized instructional type")
	String lrNotOrganizedIType();
	
	@DefaultMessage("Class not organized")
	String lrClassNotOrganized();
	
	@DefaultMessage("Class not full-term")
	String lrClassNotFullTerm();
	
	@DefaultMessage("Meets with")
	String lrMeetsWith();
	
	@DefaultMessage("Exam not assigned")
	String lrExamNotAssigned();
	
	@DefaultMessage("Section exam")
	String lrSectionExam();
	
	@DefaultMessage("yes")
	String lrYes();
	
	@DefaultMessage("no")
	String lrNo();
	
	@DefaultMessage("m/w")
	String lrMW();
	
	@DefaultMessage("Title")
	String lrTitle();
	
	@DefaultMessage("Alt")
	String lrAlt();
	
	@DefaultMessage("Len")
	String lrLen1();
	
	@DefaultMessage("gth")
	String lrLen2();
	
	@DefaultMessage("Seat")
	String lrSeat();
	
	@DefaultMessage("Date & Time")
	String lrDateAmpTime();
	
	@DefaultMessage("InsType")
	String lrInsType();
	
	@DefaultMessage("Sections")
	String lrSections();
	
	@DefaultMessage("Exam with")
	String lrExamWith();
	
	@DefaultMessage("Limit")
	String lrLimit();
	
	@DefaultMessage("Enrollmt")
	String lrEnrollmt();
	
	@DefaultMessage("Course Exam")
	String lrCourseExam();
	
	@DefaultMessage("MM/dd")
	String lrDateFormat();
	
	@DefaultMessage("EEE, MM/dd/yyyy hh:mmaa")
	String lrLastChangeDateFormat();
	
	@DefaultMessage("Instructor:")
	String lrPropInstructor();
	
	@DefaultMessage("Name:")
	String lrPropStudent();
	
	@DefaultMessage("Email:")
	String lrPropEmail();
	
	@DefaultMessage("Last Change:")
	String lrPropLastChange();
	
	@DefaultMessage("ExtnId")
	String lrExtnId();
	
	@DefaultMessage("Dates")
	String lrDates();
	
	@DefaultMessage("Share")
	String lrShare();
	
	@DefaultMessage("Chk")
	String lrChk();
	
	@DefaultMessage("ARRANGED HOURS")
	String lrArrangedHours();
	
	@DefaultMessage("CROSS-LIST")
	String lrCrossList();
	
	@DefaultMessage("Capacity")
	String lrCapacity();
	
	@DefaultMessage("Period")
	String lrPeriod();
	
	@DefaultMessage("Instructor")
	String lrInstructor();
	
	@DefaultMessage("~ ~ ~ ~ ~ CLASS SCHEDULE ~ ~ ~ ~ ~")
	String lrSectClassSchedule();
	
	@DefaultMessage("~ ~ ~ ~ ~ EXAMINATION SCHEDULE ~ ~ ~ ~ ~")
	String lrSectExaminationSchedule();
	
	@DefaultMessage("~ ~ ~ ~ ~ INSTRUCTOR CONFLICTS ~ ~ ~ ~ ~")
	String lrSectInstructorConflicts();
	
	@DefaultMessage("{0}  INSTRUCTOR CONFLICTS")
	String lrInstructorConflicts(String name);
	
	@DefaultMessage("~ ~ ~ ~ ~ STUDENT CONFLICTS ~ ~ ~ ~ ~")
	String lrSectStudentConflicts();
	
	@DefaultMessage("{0}  STUDENT CONFLICTS")
	String lrStudentConflicts(String name);
	
	@DefaultMessage("~ ~ ~ ~ ~ EXAMINATION CONFLICTS AND/OR BACK-TO-BACK EXAMINATIONS ~ ~ ~ ~ ~")
	String lrExaminationConflicts();
	
	@DefaultMessage("{0}  EXAMINATION CONFLICTS")
	String lrExaminationConflicts(String name);
	
	@DefaultMessage("No change found for {0}")
	String logNoChangesFoundFor(String name);
	
	@DefaultMessage("Generating file for {0}")
	String logGeneratingFileFor(String name);
}