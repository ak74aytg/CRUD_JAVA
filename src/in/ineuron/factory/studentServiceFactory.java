package in.ineuron.factory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

public class studentServiceFactory {
private studentServiceFactory() {}
	
	static IStudentService stdService = null;
	
	public static IStudentService getStudentService() {
		if(stdService == null) {
			stdService = new StudentServiceImpl();
		}
		return stdService;
	}
}
