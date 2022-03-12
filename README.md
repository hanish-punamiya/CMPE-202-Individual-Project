# Individual-project-hanish-punamiya
### Hanish Ravindra Punamiya 
### 015271971


## Build the project

- Navigate into the src folder (./src) present in the root folder of the project
- run the command "javac IndividualProject.java"
- ![Building the project](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/build.PNG?raw=true)

### Things to note before running the project

- The cards, output and error output files need to be closed before running the program.
- The Cards.csv file is getting updated with every new card from input that was not present in it before.
- Please make sure that the Dataset, Input and Card files in the CSV format are present inside the src folder (./src).
- ![File placement in project](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/files.PNG?raw=true)


- #### Please update the config.properties file with the correct values.
    - The config.properties file is present inside the Config package (./src/Config).
    - Please put in the names of the Dataset, Input and Card files here under DATASET_FILE, INPUT_FILE and CARDS_FILE parameters respectively.
    - Please update the cap on category quantities for Essential, Luxury and Misc items under ESSENTIALS_QUANTITY, LUXURY_QUANTITY and MISCELLANEOUS_QUANTITY parameters respectively.
    - The output and error output file names can be changed as well under OUTPUT_FILE and ERROR_FILE respectively.
    - ###### The config file
    ![config file](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/Config.PNG?raw=true)


## Run the project

- Navigate into the src (./src) folder present in the root folder of the project
- After building the project, run the command "java IndividualProject"

## UML Class Diagram
![Individual Project UML Class Diagram](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/UML%20Class%20Diagrams/Individual%20Project.png?raw=true)

## Design Patterns Used

I have used 3 design patterns in my project.

### Strategy Pattern

- The strategy design pattern defines a set of encapsulated algorithms that can be swapped to carry out a specific behavoiur.
- In my project I have defined an Interface called LoadItems which has one method called getItems.
- There are three classes that implement this method, namely, LoadInventory, LoadCart and LoadCards.
- Each of these classes has the GetItems method which is overriden and performs a specific function related to the class.
- In essence each class serves to extract data for similar structered objects but performs different actions related to the object.
#### UML Class Diagram
![Strategy Pattern UML Class Diagram](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/UML%20Class%20Diagrams/Strategy.png?raw=true)

### Command Pattern
- The command pattern is a behavioral design pattern in which an object is used to encapsulate all information needed to perform an action or trigger an event at a later time.
- This information includes the method name, the object that owns the method and values for the method.
- In my project I have defined an Interface called LoadItems which has one method called getItems.
- There are three classes that implement this method, namely, LoadInventory, LoadCart and LoadCards.
- I am sending the above classes as arguments based on functionality to my methods.
- They are being accepted as interface LoadItems paramter in method, which is calling the getItems() function of the interface.
- This enables me to call the getItems() functions of any of the classes, that I passed as arguments, that implements this interface.
#### UML Class Diagram
![Command Pattern UML Class Diagram](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/UML%20Class%20Diagrams/Command.png?raw=true)

### Singleton Pattern
- The singleton pattern is a software design pattern that restricts the instantiation of a class to one "single" instance.
- This is useful when exactly one object is needed to coordinate actions across the system.
- In my project, I have used the singleton design pattern in my Config class in the Config package.
- I have used singleton here because it allows me to use one instance of the config class to access variable values instead of createing multiple instances and passing it around.
#### UML Class Diagram
![Singleton Pattern UML Class Diagram](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/UML%20Class%20Diagrams/Singleton.png?raw=true)

## Test Cases

### Test Case 1

#### Running the application
![Running the application for Input 1](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/Input1.PNG?raw=true)

#### Output CSV
![Output for Input 1](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/output1.PNG?raw=true)

#### Cards data structure
![Cards data structure for Input 1](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/Input1-card-dataset.PNG?raw=true)

#### Cards CSV
![Cards.CSV for Input 1](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/output1-cards.PNG?raw=true)

#### Error (error.txt)
No error.txt file was generated as there was no error (incorrect inputs)

### Test Case 2

#### Running the application
![Running the application for Input 2](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/Input2.PNG?raw=true)

#### Output CSV
No output.csv file was generated as there was an error (incorrect quantities).

#### Cards data structure
No cards data structure to show as there was an error (incorrect quantities).

#### Cards CSV
Cards.csv file was not updated as there was an error (incorrect quantities).

#### Error (error.txt)
![Running the application for Input 2](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/output2-error.PNG?raw=true)

### Test Case 3

#### Running the application
![Running the application for Input 3](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/Input3.PNG?raw=true)

#### Output CSV
![Output for Input 3](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/Output3.PNG?raw=true)

#### Cards data structure
![Cards data structure for Input 3](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/Output3-card-dataset.PNG?raw=true)

#### Cards CSV
![Cards.CSV for Input 3](https://github.com/gopinathsjsu/individual-project-hanish-punamiya/blob/main/Screenshots/output3-cards.PNG?raw=true)

#### Error (error.txt)
No error.txt file was generated as there was no error (incorrect inputs)
