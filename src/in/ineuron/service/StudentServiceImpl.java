package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.Student;
import in.ineuron.factory.studentDaoFactory;

public class StudentServiceImpl implements IStudentService {
	private static IStudentDao stdDao = studentDaoFactory.getStudentDao();

	@Override
	public String save(Student student) {
		return stdDao.save(student);
	}

	@Override
	public Student findById(int id) {
		return stdDao.findById(id);
	}

	@Override
	public String update(int id, Student student) {
		return stdDao.update(id, student);
	}

	@Override
	public String delete(int id) {
		return stdDao.delete(id);
	}

}
