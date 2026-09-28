\# Student Management System



A console application to manage student records, built with Java, JDBC and MySQL.



\## Features

\- Add, view, search (by ID), update and delete students

\- DAO pattern: model, interface and implementation are kept separate

\- All queries use `PreparedStatement`, which prevents SQL injection

\- Database credentials are kept in a private `config.properties` file, not in the code



\## Tech Stack

Java, JDBC, MySQL



\## Database

Run these two files in MySQL:

1\. `sql/schema.sql` creates the database and the `students` table

2\. `sql/seed\_data.sql` adds sample data



\## Setup

1\. Install Java (JDK) and MySQL

2\. Run the two SQL files above

3\. Create a `config.properties` file in the project root:



```

db.url=jdbc:mysql://localhost:3306/student\_db

db.user=root

db.password=YOUR\_PASSWORD

```



4\. Download the MySQL Connector/J jar and add it to your classpath

5\. Compile and run `main.java`



\## Planned Improvements

\- More tables: courses, departments, enrollments

\- Advanced SQL queries (joins, views, window functions)

\- Input validation and login with hashed passwords

\- Maven for dependency management

