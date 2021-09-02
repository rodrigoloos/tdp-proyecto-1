package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	int lu=117858;
            	String ln="Loos";
            	String fn="Rodrigo";
            	String mail="rodrigoloos@outlook.es";
            	String gitH="https://github.com/rodrigoloos";
            	String ph="/images/yo.png";
            	
            	Student alumno= new Student(lu, ln, fn, mail, gitH, ph);
            	SimplePresentationScreen guiP = new SimplePresentationScreen(alumno);
            	
            	
            }
        });
    }
}