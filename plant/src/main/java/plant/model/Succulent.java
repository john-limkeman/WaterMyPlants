package plant.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Succulent implements Plant{
	private String type = "Succulent";
	private String name;
	private boolean isThirsty;
	private int daysUntilNextWater;
	private int waterRate = 60;
	private LocalDate nextWaterDate = LocalDate.now();
	private LocalDate lastWaterDate = LocalDate.now().minusDays(waterRate);
	

	public Succulent(String plantName) {
		this.name = plantName; 
		this.isThirsty = true;
	}
	
	public String record() {
		String record = getType() + "," + getName() + "," + isThirsty() + "," + getNextWaterDate() + ","
				 + getLastWaterDate() + "," + getWaterRate();
		return record;
	}
	
	public void waterIt() {
		setThirsty(false);
		setLastWaterDate(LocalDate.now());
		setNextWaterDate(LocalDate.now().plusDays(waterRate));
		
	}
	
	
	
	@Override 
	public String toString() {
		return getType() + " " + getName();
	}


	public int getDaysUntilNextWater() {
		int daysRemaining = 0;
		if (LocalDate.now().compareTo(getNextWaterDate()) > 0 || LocalDate.now().compareTo(getNextWaterDate()) == 0) {
			return daysRemaining;
		} else {
			daysRemaining = (int) ChronoUnit.DAYS.between(LocalDate.now(), getNextWaterDate());
		}
		this.daysUntilNextWater = daysRemaining;
		return daysUntilNextWater;
	}

	public boolean isThirsty() {
		
		if (getDaysUntilNextWater() == 0) {
			setThirsty(true);
		}
		return isThirsty;
	}
	public LocalDate getLastWaterDate() {
		return lastWaterDate;
	}
	
	public void setLastWaterDate(LocalDate lastWaterDate) {
		this.lastWaterDate = lastWaterDate;
	}

	public void setNextWaterDate(LocalDate nextWaterDate) {
		this.nextWaterDate = nextWaterDate;
	}

	public LocalDate getNextWaterDate() {
		return this.nextWaterDate;
	}

	public int getWaterRate() {
		return waterRate;
	}

	public void setWaterRate(int waterRate) {
		this.waterRate = waterRate;
	}
	public String getLightRecommendation() {
		return "Part Sun (2-4 hours)";
	}
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public void setThirsty(boolean isThirsty) {
		this.isThirsty = isThirsty;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
}
