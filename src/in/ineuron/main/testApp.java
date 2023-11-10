package in.ineuron.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import in.ineuron.controller.IStudentController;
import in.ineuron.dto.Student;
import in.ineuron.factory.studentControllerFactory;

public class testApp {
	public static void main(String args[]) {
		String name = "";
		Integer age = -1;
		String branch = "";
		Integer id = -1;
		Student student=null;
		String message="";
		
		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("1::[INSERT]");
			System.out.println("2::[FIND]");
			System.out.println("3::[UPDATE]");
			System.out.println("4::[DELETE]");
			System.out.println("5::[EXIT]");
			System.out.println("Your Options :: [1,2,3,4,5]");
	
			try {
				IStudentController stdController  = studentControllerFactory.getStudentController();
				Integer option = Integer.parseInt(br.readLine());
				
				switch(option) {
				case 1:
					System.out.print("Enter name:: ");
					name = br.readLine();
					System.out.print("Enter age:: ");
					age = Integer.parseInt(br.readLine());
					System.out.print("Enter branch:: ");
					branch = br.readLine();
					student = new Student();
					student.setName(name);
					student.setAge(age);
					student.setBranch(branch);
					message = stdController.save(student);
					if(message.equalsIgnoreCase("success")) {
						System.out.println("DATA ADDED SUCCESSFULLY");
					}else if(message.equalsIgnoreCase("failure")) {
						System.out.println("DATA INSERTION FAILED");
					}else {
						System.out.println("SOME ERROR OCCURED");
					}
					System.out.println();
					break;
					
					
				case 2:
					System.out.print("Enter id:: ");
					id = Integer.parseInt(br.readLine());
					student = stdController.findById(id);
					if(student!=null) {
						System.out.println(student.toString());						
					}else {
						System.out.println("NO RECORD FOUND!\n");
					}
					break;
					
					
				case 3:
					System.out.print("Enter id:: ");
					id = Integer.parseInt(br.readLine());
					student = stdController.findById(id);
					if(student==null) {
						System.out.println("NO RECORD FOUND!\n");					
					}else {
						String oldName = student.getName();
						int oldAge = student.getAge();
						String oldBranch = student.getBranch();
						System.out.print("name ["+oldName+"] ::");
						name = br.readLine();
						if(name.equals("") || name==null) {
							name = oldName;
						}
						System.out.print("age ["+oldAge+"] ::");
						String newAge = br.readLine();
						if(newAge.equals("") || newAge==null) {
							age = oldAge;
						}else {
							age = Integer.parseInt(newAge);
						}
						System.out.print("branch ["+oldBranch+"] ::");
						branch = br.readLine();
						if(branch.equals("") || branch==null) {
							branch = oldBranch;
						}
						student.setAge(age);
						student.setBranch(branch);
						student.setName(name);
						message = stdController.update(id, student);
						if(message.equalsIgnoreCase("success")) {
							System.out.println("DATA ADDED SUCCESSFULLY");
						}else if(message.equalsIgnoreCase("failure")) {
							System.out.println("DATA INSERTION FAILED");
						}else {
							System.out.println("SOME ERROR OCCURED");
						}
						System.out.println();
					}

					break;
					
				case 4:
					System.out.print("Enter id:: ");
					id = Integer.parseInt(br.readLine());
					message = stdController.delete(id);
					if(message.equalsIgnoreCase("success")) {
						System.out.println("DATA DELETED SUCCESSFULLY");
					}else if(message.equalsIgnoreCase("failure")) {
						System.out.println("DATA DELETION FAILED");
					}else {
						System.out.println("SOME ERROR OCCURED");
					}
					System.out.println();
					break;
					
					
				case 5:
					System.out.println("THANK YOU FOR USING OUR APPLICATION!\n");
					System.exit(0);
					break;
					
					
				default:
					System.out.println("PLEASE ENTER A VALID RESPONSE!\n");
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
