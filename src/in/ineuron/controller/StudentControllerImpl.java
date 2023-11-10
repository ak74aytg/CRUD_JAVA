package in.ineuron.controller;

import in.ineuron.dto.Student;
import in.ineuron.factory.studentServiceFactory;
import in.ineuron.service.IStudentService;

public class StudentControllerImpl implements IStudentController {
	private static IStudentService stdService = studentServiceFactory.getStudentService();

	@Override
	public String save(Student student) {
		return stdService.save(student);
	}

	@Override
	public Student findById(int id) {
		return stdService.findById(id);
	}

	@Override
	public String update(int id, Student student) {
		return stdService.update(id, student);
	}

	@Override
	public String delete(int id) {
		return stdService.delete(id);
	}

}
