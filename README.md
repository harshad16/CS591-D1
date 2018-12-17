[![GradeIn Applciation](https://img.shields.io/badge/GradeIn-v1.0-green.svg)](src/)
[![Java](https://img.shields.io/badge/Java-8-red.svg)](https://www.oracle.com/technetwork/java/javase/documentation/index.html)

# GradeIn    
![GradeIn](src/misc/logo.png)  
Grading Application for helping the Professor in evaluation and keeping track of students grades.  
The Application was developed as a part of final project for the Course: CS591-D1 Object Oriented Design with Java,Fall 2018, Computer Science Department, Boston University 

## How to Run

### Requirement  
* Java 8 should be installed.  
* MySQL should be installed, with `root` user's password set as `password`.  
    * For Custom `root` user, please change the required details in [src/service/Utilities.java](src/service/Utilities.java).  

> *RUN* `GradeIn.jar` (Its Executable)

or Run [src/Main.Java](src/Main.Java) to execute the GradeIn Application.  


## Getting Started  

### Prerequisites    
* Install Java 8 JDK/JRE, if not already. [Java 8](https://www.java.com/en/download/)
* Install MySQL Database with `root` user password set as `password`, if not already. [MySQL](https://www.mysql.com/downloads/)
    * For Custom 'root' user, please change the required details in '[src/service/Utilities.java](src/service/Utilities.java)'.
* Preferred: Install Eclipse, if not already. [Eclipse](https://www.eclipse.org/downloads/)
    * Install packages - Windows Builder and Java Swings in Eclipse using (Help -> Install New Software) Option.
* Open the Project in Eclipse.
* Add following Jar files to the Project using (Right Click on Project -> Build Path -> Add External Jars) Option.
    * MySQL JDBC connection Jar:
        - mysql-connector-java-8.0.13.jar
    * JFreeChart connection Jar:
        - jfreechart-1.0.19.jar
        - jcommon-1.0.23.jar
        - jfreesvg-2.0.jar
        - orsoncharts-1.4-eval-nofx.jar
        - orsonpdf-1.6-eval.jar
        - jfreechart-1.0.19-experimental.jar
        - jfreechart-1.0.19-demo.jar
    * Opencsv Jar:
        -  opencsv-4.3.2.jar  
* Project is now setup.
* Run 'src/Main.Java' to execute the GradeIn Application.
* Happy Coding! 

### Description  

The Application is developed using Java 8 and MySQL. The architecture followed is the Data Access Object Model.  
There are four main packages:  
* DAO Package: Abstract Responsible for executing MySQL CRUD statements.
* Service Package: Responsible for establishing connection with JDBC and passing information along DAO package.
* Entity Package: Responsible for the Business Object entities.
* GUI Package: Responsible for all the UI's, developed using Java swings.  

Using the above packages the application is built.  

Starter MySQL Script: [Schema Scripts](Schema_scripts.sql)
Future Works: [ToDo](TODO.md)


## Built With  
* [Java 8](https://www.oracle.com/technetwork/java/javase/documentation/index.html) - Java
* [MySQL](https://www.mysql.com/) - MySQL
* [Eclipse Window Builder](https://www.eclipse.org/windowbuilder/) - Eclipse Window Builder 
* [Java Swings](https://docs.oracle.com/javase/tutorial/uiswing/index.html)  - Java Swings for Developing GUI in Java
* [JFreeChart](http://www.jfree.org/jfreechart/) - JFreeChart is a Java chart library used for Visualization.
* [Opencsv](http://opencsv.sourceforge.net/) - Opencsv is an CSV (comma-separated values) parser library for Java.

## Authors  
* **Arezoo Sadeghi** - [Arezoo](https://github.com/asadeg02)
* **Peixin Li** - [Iris](https://github.com/Irislpx)
* **Harshad Reddy Nalla** - [Harshad](https://github.com/harshad16)

See also the list of contributors who participated in this project.

## Acknowledgments  
* **Professor Christine Papadakis-Kanaris**
* **CS591-D1 Course At Boston University**
