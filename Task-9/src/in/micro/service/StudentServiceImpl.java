package in.micro.service;

import in.micro.daofactory.StudentDaoFactory;
import in.micro.dto.Student;
import in.micro.persistance.IStudentDao;

public class StudentServiceImpl implements IStudentService {
	
	private IStudentDao stdDao; 
	
	public String addStudent(Integer sid, String sname, Integer sage) {
		
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(sid, sname, sage);
	}
	
	public Student searchStudent(Integer sid) {
			
			stdDao = StudentDaoFactory.getStudentDao();
			return stdDao.searchStudent(sid);
		}



	public String updateStudent(Student student) {
		
		stdDao = StudentDaoFactory.getStudentDao();
	
		return stdDao.updateStudent(student);
	}


	
	public String deleteStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
	
		return stdDao.deleteStudent(sid);
	}

	

}
