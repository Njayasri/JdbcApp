package in.micro.persistance;

import in.micro.dto.Student;

public interface IStudentDao {
	
	public String addStudent(Integer sid, String sname, Integer sage) ;
	
	public String updateStudent(Student student) ;
	
	public Student searchStudent(Integer sid) ;
	
	public String deleteStudent(Integer sid) ;
		
	
	

}
