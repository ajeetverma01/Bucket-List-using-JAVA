# 🎯 Bucket List – A Command-Line Goal Tracker

**Bucket List** is a **Command-Line User Interface (CUI) application** built using **Java, JDBC, and SQL**, designed to help users efficiently manage their goals and aspirations. The project is integrated with **XAMPP** for MySQL database management and uses **MySQL Connector/J** for seamless communication between Java and MySQL.

## 🚀 Features
- ✅ **User Account System** – Users can create an account and log in.
- ✅ **Add New Goals** – Insert new items into your bucket list.
- ✅ **Update Goals** – Modify existing goals to reflect progress.
- ✅ **Delete Goals** – Remove completed or unwanted goals.
- ✅ **View Goals** – Retrieve and display all bucket list items.
- ✅ **Persistent Storage** – Uses MySQL for long-term data management.

## 🛠️ Technologies Used
- **Java** – Core programming language for application logic.
- **JDBC** – Java Database Connectivity for SQL interaction.
- **MySQL (XAMPP)** – Database management system.
- **MySQL Connector/J** – JDBC driver for MySQL communication.

## 📌 Setup Instructions

### 1️⃣ Install Required Software
- **[XAMPP](https://www.apachefriends.org/download.html)** (for MySQL database)
- **[MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)** (JDBC driver for MySQL)

### 2️⃣ Clone This Repository
```sh
git clone https://github.com/ajeetverma01/Bucket-List-using-JAVA.git
cd Bucket-List-using-JAVA
```

### 3️⃣ Set Up the Database

1. Start **XAMPP** and enable **MySQL**.
2. Open **phpMyAdmin** and create a new database:
   ```sql
   CREATE DATABASE bucket_list_db;
   ```
3. Ensure the database includes **user** and **task** tables for authentication and goal tracking:
   ```sql
   CREATE TABLE user (
       id INT PRIMARY KEY,
       name VARCHAR(50) UNIQUE NOT NULL,
       password VARCHAR(255) NOT NULL
   );

   CREATE TABLE task (
       id INT PRIMARY KEY,
       taskIndex INT,
       name varchar(50) NOT NULL,
       about varchar(200),
       status varchar(30)
   );
   ```

### 4️⃣ Configure Database Connection
Update the MySQL connection details in your Java file:
```java
String url = "jdbc:mysql://localhost:3306/bucket_list";
String user = "root"; // Change if needed
String password = ""; // Change if your MySQL has a password
```

### 5️⃣ Run the Application in IntelliJ IDEA

1. Open IntelliJ IDEA.

2. Click File → Open and select the project folder.

3. Ensure the MySQL Connector/J is added to the project dependencies.

4. Locate the main.java file.

5. Click the Run button or execute:
```
main.java
```



