package controller;

public class ProfesorController {
	
	private static ProfesorController instance = null;
	
	private ProfesorController() {}
	
	public ProfesorController getInstance()
	{
		if(instance == null)
			instance = new ProfesorController();
		return instance;
	}
}
