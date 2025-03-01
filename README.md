# 🎯 Bucket List – A Command-Line Goal Tracker

**Bucket List** is a **Command-Line User Interface (CUI) application** built using **Java, JDBC, and SQL**, designed to help users efficiently manage their goals and aspirations. The project is integrated with **XAMPP** for MySQL database management and uses **MySQL Connector/J** for seamless communication between Java and MySQL.

## 🚀 Features
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

### 4️⃣ Configure Database Connection
Update the MySQL connection details in your Java file:
```java
String url = "jdbc:mysql://localhost:3306/bucket_list";
String user = "root"; // Change if needed
String password = ""; // Change if your MySQL has a password
```



