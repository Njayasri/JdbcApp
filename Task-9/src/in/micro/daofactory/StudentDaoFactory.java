package in.micro.daofactory;

import in.micro.persistance.IStudentDao;
import in.micro.persistance.StudentDaoImpl;

public class StudentDaoFactory {
	
	private StudentDaoFactory() {
		
	}
	
	public static IStudentDao  studentDao = null;
	
	public static IStudentDao  getStudentDao() {
		if(studentDao == null) {
			studentDao = new StudentDaoImpl();
			
		}
		return studentDao;
		
	}

}
