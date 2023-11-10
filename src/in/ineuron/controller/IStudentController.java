package in.ineuron.controller;

import in.ineuron.dto.Student;

public interface IStudentController {
	
	String save(Student student);
	
	Student findById(int id);
	
	String update(int id, Student student);
	
	String delete(int id);
}
