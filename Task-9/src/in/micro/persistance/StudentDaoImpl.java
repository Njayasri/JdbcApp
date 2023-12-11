package in.micro.persistance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.micro.dto.Student;
import in.mirco.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;


	@Override
	public String addStudent(Integer sid, String sname, Integer sage) {
		
		String sql = "insert into student (`sid`, `sname`, `sage`) values(?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				
				pstmt = connection.prepareStatement(sql);
			}
			
			if (pstmt != null) {

				pstmt.setInt(1, sid);
				pstmt.setString(2, sname);
				pstmt.setInt(3, sage);

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}


			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return "failure";
	}

	
	
	@Override
	public Student searchStudent(Integer sid) {
		
		Student student = null;
		
		String Selectsql = "select sid, sname,sage from student where sid = ? ";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				
				pstmt = connection.prepareStatement(Selectsql);
			}
			
			if (pstmt != null) {

				pstmt.setInt(1, sid);		
			}
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				if (resultSet.next()) {
					student = new Student();
					
					// copy resultSet data to student object
					student.setSid(resultSet.getInt(1));
					student.setSname(resultSet.getString(2));
					student.setSage(resultSet.getInt(3));				
					return student;
				}

			}



			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}


	@Override
	public String deleteStudent(Integer sid) {
		String deleteSql = "delete from student where sid =?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				
				pstmt = connection.prepareStatement(deleteSql);
			}
			
			if (pstmt != null) {

				pstmt.setInt(1, sid);
				

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}else {
					return "not found";
				}
			}


			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return "failure";
	
		
	}
	
	
	
	
	@Override
	public String updateStudent(Student student) {
		String updateSql = "update  student set sname=?,sage=? where sid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				
				pstmt = connection.prepareStatement(updateSql);
			}
			
			if (pstmt != null) {

				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setInt(3, student.getSid());

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}


			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return "failure";
	}

	


}
