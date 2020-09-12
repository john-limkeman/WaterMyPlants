# WaterMyPlants
Application to track when your plants next need to be watered. This is my first independent Java project, and therefore reflects an understanding of basics, but predates
my understanding of APIs and databases. Because of this, it relies on File I/O to maintain a database in a text file.

recallData() - This application utilizes a scanner to generate the plant collection as it was when the previous session ended.
It then uses LocalDate.now() to determine how long it has been since each plant was last watered. 

'Add plant' allows the user to instantiate a new plant according to which type they select. Each plant class contains the specific information 
for taking care of that specific type of plant.

'View Garden Report' in the main CLI allows the user to know if a plant is thirsty, or how soon each plant should watered next.

'Record Watering' allows the user to update a plant's history to reflect a recent watering. 
The plant will become thirsty again when the days past this watering exceeds the water rate of that plant type.

'Remove Plant' permanently removes a plant from the collection.

'Save and Exit' closes the terminates the program and causes plant-log.txt to be overwritten with the current state of the plant collection.
