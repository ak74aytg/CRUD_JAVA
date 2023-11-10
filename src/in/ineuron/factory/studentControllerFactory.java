package in.ineuron.factory;

import in.ineuron.controller.IStudentController;
import in.ineuron.controller.StudentControllerImpl;

public class studentControllerFactory {

	private studentControllerFactory() {}
	
	static IStudentController stdController = null;
	
	public static IStudentController getStudentController() {
		if(stdController == null) {
			stdController = new StudentControllerImpl();
		}
		return stdController;
	}
}
