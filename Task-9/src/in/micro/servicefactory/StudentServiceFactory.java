package in.micro.servicefactory;

import in.micro.dto.Student;
import in.micro.service.IStudentService;
import in.micro.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	
	 private StudentServiceFactory() {
		
	}
	 
	public  static IStudentService studentService = null;
	
	
	 
	public static IStudentService getStudentService() {
		
		//singleton pattern code
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}

		

}
