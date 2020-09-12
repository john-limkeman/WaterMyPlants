package plant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import plant.model.Cactus;
import plant.model.Fern;
import plant.model.Foliage;
import plant.model.Herb;
import plant.model.Orchid;
import plant.model.Palm;
import plant.model.Plant;
import plant.model.Succulent;
import plant.model.Vegetable;

public class Garden {


List<Plant> myGarden = new ArrayList<Plant>();

public void addPlant(Plant plant) {

	myGarden.add(plant);
}
public String report() {
	String report = "";
	for (Plant plant: myGarden) { 
		if (plant.isThirsty()){
			report += plant.getType() + " " + plant.getName() + " is thirsty!\r"  ;
		} else {
			report += plant.getType() + " " + plant.getName() + " will need water in " + plant.getDaysUntilNextWater() + " days\r";
		}
	}
		return report;
	}

public List<Plant> listGarden() {
	return myGarden;
}

public void waterPlant(Plant chosen) {
	
	System.out.println("checking if watered [BEFORE]...");
	
	for (Plant p : myGarden) {
		System.out.println(p.getName() + " " + p.isThirsty());
	}
	
	for (Plant plant: myGarden) {
		if (plant == chosen) {
			plant.waterIt();
			break;
		}
	}
	
}

public void removePlant(Plant plant) {
	myGarden.remove(plant);
	
}

public void addFullPlant(String rawPlant) {
	String[] properties = rawPlant.split(",");
	if (properties[0].equals("Cactus")) {
		Plant newPlant = new Cactus (properties[1]);
		mapPlant(properties, newPlant);
		
		myGarden.add(newPlant);
	} else if (properties[0].equals("Succulent")) {
		//
		Plant newPlant = new Succulent (properties[1]);
		mapPlant(properties, newPlant);
		
		myGarden.add(newPlant);
	}else if (properties[0].equals("Fern")) {
		Plant newPlant = new Fern (properties[1]);
		mapPlant(properties, newPlant);
		
		myGarden.add(newPlant);
	}else if (properties[0].equals("Palm")) {
		Plant newPlant = new Palm (properties[1]);
		mapPlant(properties, newPlant);
		
		myGarden.add(newPlant);
	}else if (properties[0].equals("Foliage")) {
		Plant newPlant = new Foliage (properties[1]);
		mapPlant(properties, newPlant);
		
		myGarden.add(newPlant);
	}else if (properties[0].equals("Orchid")) {
		Plant newPlant = new Orchid (properties[1]);
		mapPlant(properties, newPlant);
		
		myGarden.add(newPlant);
	}else if (properties[0].equals("Herb")) {
		Plant newPlant = new Herb (properties[1]);
		mapPlant(properties, newPlant);
		
		myGarden.add(newPlant);
	}else if (properties[0].equals("Vegetable")) {
		Plant newPlant = new Vegetable (properties[1]);
		mapPlant(properties, newPlant);
		
		myGarden.add(newPlant);
	}
}
private void mapPlant(String[] properties, Plant newPlant) {
	newPlant.setThirsty(Boolean.valueOf(properties[2]));
	newPlant.setNextWaterDate(LocalDate.parse(properties[3]));
	newPlant.setLastWaterDate(LocalDate.parse(properties[4]));
	newPlant.setWaterRate(Integer.parseInt(properties[5]));
}
}
