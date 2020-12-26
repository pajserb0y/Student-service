package controller;


public class StudentController {

	private static StudentController instance = null;

	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	

}
