package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {

	String save(Student student);
	
	Student findById(int id);
	
	String update(int id, Student student);
	
	String delete(int id);
}
