

package plant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import plant.model.Cactus;
import plant.model.Fern;
import plant.model.Foliage;
import plant.model.Herb;
import plant.model.Orchid;
import plant.model.Palm;
import plant.model.Plant;
import plant.model.Succulent;
import plant.model.Vegetable;

public class PlantApp {
	private static final String[] MAIN_MENU = {"Add Plant", "View Garden Report", "Record Watering", "Remove Plant", "Save and Exit"};
	private static final String[] NEW_PLANT_MENU = {"Cactus", "Succulent", "Fern", "Palm", "Foliage", "Orchid", "Herb", "Vegetable"};
	private static final String[] PLANT_LIGHT_MENU = {"Full Sun (6+ hours)", "Part Sun (2-4 hours)", "Mostly Shade", "Full Shade"};
	private static File file = new File("plant-log.txt");
	
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		Garden garden = new Garden();
		Menu menu = new Menu(System.in, System.out);
		recallData(garden, file);
		run(scanner, garden, menu);
	}
	
	public static void recallData(Garden garden, File file) throws IOException {
		if (!file.exists()){
			file.createNewFile();
		}
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			String rawPlant = reader.nextLine();
			garden.addFullPlant(rawPlant);
		}
		
	}
	
	public static void recordData(Garden garden, File file) throws IOException {
		new PrintWriter(file).close();
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))){
			
			List<Plant> currentGarden = garden.listGarden();
			for (Plant plant: currentGarden) {
				writer.print(plant.record() + "\n");
			}
		}
	}
	
	private static void run(Scanner scanner, Garden garden, Menu menu) throws IOException {
		System.out.println("                                             _          ");
		System.out.println("     __                                    (..))                ");
		System.out.println("    || \\   ||   ___           _||_        (:():))             ");
		System.out.println("    ||_//  || //  ||  ||//\\    ||          (''))           ");
		System.out.println("    ||     ||  \\__||  ||  ||   ||           ||           ");
		System.out.println("                          _            <>~~~||~~~<>           ");
		System.out.println("           ||            //\\    __          ||            ");
		System.out.println("           ||     \\  // -||-   //_\\         ||               ");
		System.out.println("           ||___   \\//   ||    ||__       __||__                  ");
		System.out.println("                   //                     \\    //               ");
		System.out.println("                  //                       \\__//             ");
		
		while (true) {
			Object choice = menu.getMenuChoice(MAIN_MENU);
			
		if (choice.equals("Add Plant")) {
			System.out.println("What kind of plant are you adding?");
			Object newPlantType = menu.getMenuChoice(NEW_PLANT_MENU);
			
			System.out.println("What would you like to name your plant?");
			String plantName = scanner.nextLine();
			
			System.out.println("How much sun will it get?");
			Object newPlantLight = menu.getMenuChoice(PLANT_LIGHT_MENU);
			
			Plant newPlant = createNewPlant(newPlantType, plantName, garden);
			if (!newPlant.getLightRecommendation().equals(newPlantLight)) {
				System.out.println("Warning: this plant prefers " + newPlant.getLightRecommendation() + ". Consider moving plant to new location.");
			}

		}
		
		else if (choice.equals("View Garden Report")) {
			System.out.println(garden.report());
			
		}
		else if (choice.equals("Record Watering")) {
			System.out.println("What plant would you like to water?");
			List <Plant> gardenList = garden.listGarden();
			Plant[] gardenArray =  gardenList.toArray(new Plant[gardenList.size()]);
			menu.displayPlants(gardenArray);
			Plant plantToWater = (Plant) menu.getPlantChoice(gardenArray);
			garden.waterPlant(plantToWater);
			
			
		} else if (choice.equals("Remove Plant")) {
			System.out.println("What plant would you like to remove?");
			List <Plant> gardenList = garden.listGarden();
			Plant[] gardenArray =  gardenList.toArray(new Plant[gardenList.size()]);
			menu.displayPlants(gardenArray);
			Plant plantToRemove = (Plant) menu.getPlantChoice(gardenArray);
			garden.removePlant(plantToRemove);
		}
		
	
		else if (choice.equals("Save and Exit")) {
			recordData(garden, file);
			System.exit(0);
		}
		
		
		}
	}

	public static Plant createNewPlant(Object type, String name, Garden garden){
		Plant newPlant = null;
		
		if (type.equals("Cactus")) {
			newPlant = new Cactus(name);
		} if (type.equals("Succulent")) {
			newPlant = new Succulent(name);
		}if (type.equals("Palm")) {
			newPlant = new Palm(name);
		}if (type.equals("Fern")) {
			newPlant = new Fern(name);
		}if (type.equals("Foliage")) {
			newPlant = new Foliage(name);
		}if (type.equals("Orchid")) {
			newPlant = new Orchid(name);
		}if (type.equals("Herb")) {
			newPlant = new Herb(name);
		}if (type.equals("Vegetable")) {
			newPlant = new Vegetable(name);
		}
		garden.addPlant(newPlant);
		return newPlant;
	}
}
		
		

