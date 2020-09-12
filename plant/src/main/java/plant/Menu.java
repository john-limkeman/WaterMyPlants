package plant;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import plant.model.Plant;

public class Menu {
	private PrintWriter out;
	private Scanner in;
	
	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}
	
	private void displayMenu(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int menuNum = i + 1;
			out.println(menuNum + ". " + options[i]);
		}
		out.println("\nWhat would you like to do?");
		out.flush();
	}
	
	private Object userChoose(Object[] options) {
		Object choice = null;
		String input = in.nextLine();
		try {
			int selection = Integer.valueOf(input);
			if (selection > 0 && selection <= options.length) {
				choice = options[selection - 1];
			}
		}catch (NumberFormatException e) {
			
		}
		if (choice == null) {
			out.println("\n <<< " + input + " is not a valid option>>>\n");
		}
		return choice;
	}
	
	public Object getMenuChoice(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenu(options);
			choice = userChoose(options);
		}
		return choice;
	}
	
	public void displayPlants(Plant[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int menuNum = i + 1;
			out.println(menuNum + ". " + options[i]);
		}
		out.flush();
	}
	public Plant getPlantChoice(Plant[] options) {
		Plant choice = null;
		while (choice == null) {
			choice = (Plant) userChoose(options);
		}
		return choice;
	}
}
