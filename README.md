# student-management-system
Notes:
CRUD-funktionalitet implementerades (Create, Read, Update, Delete) - Done;  
Data om en student ska kunna hämtas med efternamn som parameter i URL:en - Done;  
När en ny student ska läggas till, är alla fält obligatoriska utom telefonnummer - Done;  
Skapade en egen exception;   
Inga 500 - Internal Server Error uppstår;  

URLs:

localhost:8080/lab/api/v1/student/new : to create a new student account;	

localhost:8080/lab/api/v1/student/{id}: (GET or DELETE)To get /delete the student with a spesific id;

localhost:8080/lab/api/v1/student/getall: To get the list of all students;

localhost:8080/lab/api/v1/student/getbyname/{lastname}: To get the students with a spesific sirname;

localhost:8080/lab/api/v1/student/update: To update the info. of the student with a given id;
