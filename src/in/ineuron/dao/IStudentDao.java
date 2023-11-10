package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao {

	String save(Student student);
	
	Student findById(int id);
	
	String update(int id, Student student);
	
	String delete(int id);
}
