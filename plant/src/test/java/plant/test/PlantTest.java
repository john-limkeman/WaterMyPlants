package plant.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import plant.Garden;
import plant.PlantApp;
import plant.model.Plant;

public class PlantTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	public void createNewPlantTest() throws IOException {
		PlantApp plantApp = new PlantApp();
		Garden garden = new Garden();
		Object type = "Cactus";
		String name = "testCac";
		
		@SuppressWarnings("static-access")
		Plant plantTest = plantApp.createNewPlant(type, name, garden);
		
		Assert.assertEquals(1, garden.listGarden().size());
		Assert.assertEquals("Cactus", plantTest.getType());
		Assert.assertEquals("testCac", plantTest.getName());
		
		Object type2 = "Fern";
		String name2 = "testFern";
		
		
		Plant plantTest2 = plantApp.createNewPlant(type2, name2, garden);
		
		Assert.assertEquals(2, garden.listGarden().size());
		Assert.assertEquals("Fern", plantTest2.getType());
		Assert.assertEquals("testFern", plantTest2.getName());
		
	}

	@SuppressWarnings("static-access")
	@Test
	public void recallDataTest() throws IOException {
		PlantApp plantApp2 = new PlantApp();
		Garden testG = new Garden();
		File file = new File("testlog.txt");
		
		plantApp2.recallData(testG, file);
		System.out.println(testG.listGarden());
		Assert.assertEquals(1, testG.listGarden().size());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void recordDataTest() throws IOException {
		PlantApp plantApp = new PlantApp();
		Garden garden = new Garden();
		File file = new File("testlog.txt");
		garden.addFullPlant("Fern,Ferny,false,2020-09-08,2020-09-01,7");
		plantApp.recordData(garden, file);
		String result = "";
		
		
		Scanner reader = new Scanner(file);
		while (reader.hasNext()) {
			result = reader.nextLine();
		}
		
		Assert.assertEquals("Fern,Ferny,true,2020-09-08,2020-09-01,7", result);
	}
	
	@Test
	public void gardenReportTest() {
		PlantApp plantApp = new PlantApp();
		Garden garden = new Garden();
		garden.addFullPlant("Fern,Ferny,false,2020-09-08,2020-09-01,7");
		String actual = garden.report();
		String expected = "Fern Ferny is thirsty!\r";
		
		Assert.assertEquals(expected, actual);
		
		Plant testPlant = null;
		for(Plant plant: garden.listGarden()) {
			testPlant = plant;
		}
		garden.waterPlant(testPlant);
		
		String actual2 = garden.report();
		String expected2 = "Fern Ferny will need water in 7 days\r";
	}
	
	@Test
	public void gardenRemoveTest() {
		PlantApp plantApp = new PlantApp();
		Garden garden = new Garden();
		garden.addFullPlant("Fern,Ferny,false,2020-09-08,2020-09-01,7");
		Plant testPlant = null;
		for(Plant plant: garden.listGarden()) {
			testPlant = plant;
		}
		garden.removePlant(testPlant);
		
		String actual = garden.report();
		String expected = "";
		Assert.assertEquals(expected, actual);
	}

}
