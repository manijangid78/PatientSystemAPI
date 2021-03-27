# PatientSystemAPI

The system is developed with SpringBoot Framework that helps to easily build applications. 

Many Manven Dependecies are used that helps to manage the whole application like spring-web, spring-jpa, mysql-driver, h2, hibernate-validator, gson etc. These all depedencies are helpful to design the applciation. 

## Task 1. Add new patient without authentication
Using this end-point, can add new patient detials in the database. 
![Add Image](https://github.com/manijangid78/PatientSystemAPI/blob/master/src/main/resources/static/Images/Task1.PNG "Add New Patient")

## Task 2. Authenticate Patient<br/>
Using this end-point, patient should have to create jwt token for fruther process so, this endpoint helps to authenticate and provide a jwt token
![Add Image](https://github.com/manijangid78/PatientSystemAPI/blob/master/src/main/resources/static/Images/Task2.PNG "Add New Patient")

## Task 3. Update old patient <br/>
Using this end-point, can be updated details of the patient.
![Add Image](https://github.com/manijangid78/PatientSystemAPI/blob/master/src/main/resources/static/Images/Task3-Header.PNG "Add New Patient")
![Add Image](https://github.com/manijangid78/PatientSystemAPI/blob/master/src/main/resources/static/Images/Task3-Main.PNG "Add New Patient")

## Task 4. Delete patient<br/>
Using this end-point, patient detials can be removed. During this end point have to enter jwt token in the header otherwise **403 Forbiden** message will be shown. 
![Delete Image](https://github.com/manijangid78/PatientSystemAPI/blob/master/src/main/resources/static/Images/Delete.PNG "Title")

## Task 5. Get all patient by email in acending order<br/>
Using this end-point, all patient detials can be retirived from the database in the acending order. In the header must have to enter jwt token.  
![Delete Image](https://github.com/manijangid78/PatientSystemAPI/blob/master/src/main/resources/static/Images/findAll.PNG "Title")

## Task 6. Book appointment of patient<br/>
Using this end-point, patient can book an appoinment. In the header must have to enter jwt token. 
![Delete Image](https://github.com/manijangid78/PatientSystemAPI/blob/master/src/main/resources/static/Images/bookappointment.PNG "Title")

## Task 7. Get all appointment<br/>
Using this end-point, all appoinment detials can be retirived from the database in the acending order. In the header must have to enter jwt token. 
![Delete Image](https://github.com/manijangid78/PatientSystemAPI/blob/master/src/main/resources/static/Images/allApoinment.PNG "Title")

## Collection Link used in postman: 
        https://www.getpostman.com/collections/c4d449923cf1923916d4
