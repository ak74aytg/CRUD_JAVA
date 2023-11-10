package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.utils.jdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String save(Student student) {
		Connection connection = null;
		PreparedStatement ppst = null;
		int resultSet = 0;
		String query = "insert into students(`name`, `age`, `branch`) values(?,?,?)";
		String status = "";
		try {
			connection = jdbcUtil.getConnection();
			if(connection!=null) {
				ppst = connection.prepareStatement(query);
				ppst.setString(1, student.getName());
				ppst.setInt(2, student.getAge());
				ppst.setString(3, student.getBranch());
			}
			
			if(ppst!=null) {
				resultSet = ppst.executeUpdate();
			}
			if(resultSet==0) {
				status = "failure";
			}else {
				status = "success";
			}
		} catch (SQLException e) {
			status = "failure";
			e.printStackTrace();
		} catch (IOException e) {
			status = "failure";
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public Student findById(int id) {
		Connection connection = null;
		PreparedStatement ppst = null;
		ResultSet resultSet = null;
		Student student = null;
		String query = "select name, age, branch from students where id=?";
		try {
			connection = jdbcUtil.getConnection();
			if(connection!=null) {
				ppst = connection.prepareStatement(query);
				ppst.setInt(1, id);
			}
			
			if(ppst!=null) {
				resultSet = ppst.executeQuery();
			}
			if(resultSet.next()) {
				student = new Student();
				student.setName(resultSet.getString(1));
				student.setAge(resultSet.getInt(2));
				student.setBranch(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public String update(int id, Student student) {
		Connection connection = null;
		PreparedStatement ppst = null;
		int resultSet = 0;
		String query = "UPDATE students SET name=?, age=?, branch=? WHERE id=?";
		String status = "";
		try {
			connection = jdbcUtil.getConnection();
			if(connection!=null) {
				ppst = connection.prepareStatement(query);
				ppst.setString(1, student.getName());
				ppst.setInt(2, student.getAge());
				ppst.setString(3, student.getBranch());
				ppst.setInt(4, id);
			}
			
			if(ppst!=null) {
				resultSet = ppst.executeUpdate();
			}
			if(resultSet==0) {
				status = "failure";
			}else {
				status = "success";
			}
		} catch (SQLException e) {
			status = "failure";
			e.printStackTrace();
		} catch (IOException e) {
			status = "failure";
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public String delete(int id) {
		Connection connection = null;
		PreparedStatement ppst = null;
		int resultSet = -1;
		String query = "delete from students where id=?";
		String status="";
		try {
			connection = jdbcUtil.getConnection();
			if(connection!=null) {
				ppst = connection.prepareStatement(query);
				ppst.setInt(1, id);
			}
			
			if(ppst!=null) {
				resultSet = ppst.executeUpdate();
			}
			if(resultSet==0) {
				status = "failure";
			}else {
				status = "success";
			}
		} catch (SQLException e) {
			status = "failure";
			e.printStackTrace();
		} catch (IOException e) {
			status = "failure";
			e.printStackTrace();
		}
		
		return status;
	}

}
