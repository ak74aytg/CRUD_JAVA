package in.ineuron.dto;

public class Student {
	

	private String name;
	private int age;
	private String branch;
	
	
	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public String getBranch() {
		return branch;
	}

	

	public void setName(String name) {
		this.name = name;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
	public void setBranch(String branch) {
		this.branch = branch;
	}



	@Override
	public String toString() {
		return "Student \n[\n\tname=" + name + ",\n\tage=" + age + ",\n\tbranch=" + branch + "\n]\n\n";
	}
}
