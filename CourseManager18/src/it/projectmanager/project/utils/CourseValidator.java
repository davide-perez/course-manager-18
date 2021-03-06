package it.projectmanager.project.utils;
import it.projectmanager.project.controller.CourseController;
import javafx.scene.control.TextField;


public class CourseValidator {
	
	private CourseController c;
	
	
	public CourseValidator(CourseController controller) {
		this.c = controller;
	}
	
	
	public boolean isValid() {
		return checkName() && checkYear() && checkProfessor() && 
			   checkMark() && checkCredits() && checkField() &&
			   checkFolder() && checkProject();
	}
	
	//Name can be any sequence of alphanumerics and space chars, of minimum length 1 and max length 50.
	public boolean checkName() {
		TextField txt = c.getName();
		boolean res = txt.getText().matches("^[a-zA-Z0-9\\+\\, ]{1,50}$");
		if(!res) {
			c.highlight(txt, "red");
		}
		return res;
	}
	
	
	public boolean checkYear() {
		int year = -1;
		TextField txt = c.getYear();
		boolean res = false;
		try {
			year = Integer.parseInt(txt.getText());
			res = year > 0 && year < 3;
			if(!res)
				c.highlight(txt, "red");
			
		}
		catch(NumberFormatException e) {
			c.highlight(txt, "red");
			return false;
		}
		return res;
	}
	
	
	public boolean checkProfessor() {
		TextField txt = c.getProfessor();
		boolean res = txt.getText().matches("^[a-zA-Z0-9 ]{1,40}$");
		if(!res)
			c.highlight(txt, "red");
		return res;
	}
	
	
	public boolean checkMark() {
		TextField txt = c.getMark();
		int mark = -1;
		boolean res = false;
		try {
			mark = Integer.parseInt(txt.getText());
			res = mark >= 0 && mark <= 31;
		}
		catch(NumberFormatException e) {
			c.highlight(txt, "red");
			return false;
		}
		return res;
	}
	
	
	public boolean checkCredits() {
		TextField txt = c.getCredits();
		int creds = -1;
		boolean res = false;
		try {
			creds = Integer.parseInt(c.getCredits().getText());
			res = creds >=2 && creds <= 12;
			if(!res)
				c.highlight(txt, "red");
		}
		catch(NumberFormatException e) {
			c.highlight(txt, "red");
			return false;
		}
		return res;
	}
	
	//TODO
	//has to be selected in a predefined set of CS disciplines, to define
	public boolean checkField() {
		return true;
	}
	
	//TODO
	//also requires another approach. Since it is a path, maybe a file selector would be more useful
	//and in this case the check would have no sense (unless it is a check that tests for permissions).f
	public boolean checkFolder() {
		return true;
	}
	
	//TODO
	public boolean checkProject() {
		return true;
	}
	
	
	
	

}
