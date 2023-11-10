package in.ineuron.factory;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudentDaoImpl;

public class studentDaoFactory {

	private studentDaoFactory() {}
	
	static IStudentDao stdDao = null;
	
	public static IStudentDao getStudentDao() {
		if(stdDao == null) {
			stdDao = new StudentDaoImpl();
		}
		return stdDao;
	}
}
