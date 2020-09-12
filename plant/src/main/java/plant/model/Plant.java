package plant.model;

import java.time.LocalDate;
import java.util.Date;

public interface Plant {

		
		public void waterIt();
		public String getLightRecommendation();
		public boolean isThirsty();
		public String getType();
		public String getName();
		public LocalDate getNextWaterDate();
		public int getDaysUntilNextWater();
		public String record();
		public void setLastWaterDate(LocalDate lastWaterDate);
		public void setNextWaterDate(LocalDate nextWaterDate);
		public void setWaterRate(int waterRate);
		public void setThirsty(boolean isThirsty);
		public int getWaterRate();
	}

