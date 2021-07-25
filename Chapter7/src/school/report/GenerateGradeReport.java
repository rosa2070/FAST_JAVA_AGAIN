package school.report;

import java.util.ArrayList;

import school.School;
import school.Student;
import school.Subject;

public class GenerateGradeReport {
	
	School school = School.getInstance();
	public static final String TITLE = "������ ���� \t\t\n";
	public static final String HEADER = "�̸�   |  �й�    |��������| ����     \n";
	public static final String LINE = "--------------------------------\n";
	private StringBuffer buffer = new StringBuffer();
	
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList();
		for ( Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		return buffer.toString();
	}
	
	public void makeHeader(Subject subject) {
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("/t" + subject.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE);
		
	}
	
	public void makeBody(Subject subject) {
		
		ArrayList<Student> studentList = subject.getStudentList();
		
		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			buffer.append(student.getStudentName());
			buffer.append(" | ");
			buffer.append(student.getStudentId());
			buffer.append(" | ");
			buffer.append(student.getMajorSubject().getSubjectName() + "\t");
			buffer.append(" | ");
			
			getScoreGrade(student, subject);
			buffer.append("\n");
			buffer.append(LINE);
		}
	}
	
	public void getScoreGrade(Student student, Subject subject) {
		
	}

}
