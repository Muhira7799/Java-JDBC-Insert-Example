# Java JDBC Insert Example

A small Java program that connects to a MySQL database and inserts one row into a `students` table using JDBC.

## What It Demonstrates

- Loading the MySQL JDBC driver
- Opening a connection with `DriverManager.getConnection()`
- Running an `INSERT` statement with `Statement.executeUpdate()`
- Reading the number of affected rows that `executeUpdate()` returns

```java
String insertQuery =
    "INSERT INTO students(id, name, district, country) " +
    "VALUES (20, 'Mnique', 'Rwamagana', 'Rwanda')";

int rows = st.executeUpdate(insertQuery);
System.out.println(rows + " row inserted");
```

## Requirements

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) (JDBC driver)

## Database Setup

The program expects a database named `unilak` with a `students` table containing the columns `id`, `name`, `district`, and `country`:

```sql
CREATE DATABASE unilak;
USE unilak;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    district VARCHAR(50),
    country VARCHAR(50)
);
```

## Configuration

The connection settings are at the top of `main`:

```java
final String url = "jdbc:mysql://localhost:3306/unilak";
final String username = "root";
final String password = "";
```

Change them to match your MySQL setup.

## Getting Started

### Compile

```bash
javac Jdbc.java
```

### Run

Include the MySQL Connector/J jar on the classpath (replace the jar name with your version):

```bash
# Windows
java -cp ".;mysql-connector-j-8.x.x.jar" Jdbc

# Linux / macOS
java -cp ".:mysql-connector-j-8.x.x.jar" Jdbc
```

## Output

```
1 row inserted
```

## Notes

- The insert uses a fixed `id` of `20`. If `id` is a primary key, running the program a second time fails with a duplicate entry error.
- `main` declares `throws Exception`, so any database error stops the program with a stack trace.
- The `Statement` is not closed. Only the connection is closed.
- `Class.forName("com.mysql.cj.jdbc.Driver")` is optional with modern JDBC drivers, which register themselves automatically.

## Project Structure

```
.
├── Jdbc.java
└── README.md
```

## Possible Improvements

- Use `PreparedStatement` with placeholders instead of building the SQL as text
- Use try-with-resources so the connection and statement close automatically
- Read the values from the user with `Scanner` instead of hardcoding them
- Store the database credentials in a config file or environment variables
