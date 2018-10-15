# toDoAppSpringBoot
To Do Spring Boot Web Application with basic Feature like login, View, Add, Delete tasks to do
Summary
To Do Application is a web-based (Spring MVC) application built on a spring boot
framework which uses in memory data base h2 to store User details, authorization, To Do Item details, categories, Last update, Description and other details of an item. User can add, update, delete and mark done/undone his/her to do tasks. User will be able to see its tasks after he/she re logins the application.

Technology Used
•	JAVA 1.8
•	Framework – Spring Boot V1.5 (Spring MVC as Design Pattern)
•	Web service – REST
•	ORM – JPA Hibernate for DB operations
•	Database – In Memory DB H2
•	Development Tool – Eclipse IDE 
•	Server – Tomcat 8.5.34
•	Build Tool - Maven 3.2.2


Use Cases

1.	Login
User can login with his/her credentials stored in database already using SQL script “data.sql” under USERS table.

 
2.	Logout
User can logout from his/her session and move back to login page. He/She should see all his/her items status as it is.

3.	Add ToDo Item
User can add ToDo tasks in to his/her list and can also give category of each tasks.

 

4.	Delete ToDo Item
User can delete ToDo tasks by clicking on Delete button provided for each task in a table.

5.	Mark Item to Complete
User can mark particular item to complete if that task is done.

6.	Mark Item to Pending again
User can again mark the same completed item to pending list.

7.	Filter To do Item list
User has additional facility to filter the tasks list as per its status i: e User can view pending task only or all completed tasks.

8.	Update description & Date
User can see when a particular task was updated and its update description.

 
How to Run this Application

1.	Right click on project and run as java application.Server will start and application will be deployed using embeded tomcat.
2. Go to brpwser and hit http://localhost:8080/anikeshToDo-1.0/
3. Login using below credentials

4.	We have default user stored in a in Memory database H2 (Loaded during application start using data.sql script)
Username: anikesh
password: pwd123

5.	After successful login, you can verify all use cases like adding, updating, deleting, changing status of a ToDo items.
a.	Click on Add Items button, on Popup add items and category of a to-do task.
b.	Using Delete button one can delete the item.
c.	Mark any item as completed using Mark Complete button.
d.	Mark again to Pending using Mark pending button.
e.	Read last update date, time and description of an item.
6.	Clicking on Log out Button on Top Left, one can re login and check all to items and their status persist or not.
7.	One can check H2 in memory database entries using its console which is enabled through application.
 	Access the database using URL: http://localhost:8080/anikeshToDo-1.0/h2
         Username: sa
	Password: 
          URL- jdbc:h2:file:~/toDodb
