## Employee Management - Hibernate 📃

This application provides CRUD operations for employee management through a command-line interface. It uses Hibernate for database operations and MySQL as the backend database.

### Features

- Add new employees with name, salary, and email
- Retrieve employee information by ID
- Update existing employee details
- Delete employee records
- Console-based interactive menu system

### Technology Stack

- **Java 17**
- **Hibernate 7.2.2** (ORM Framework)
- **MySQL 8.0.33** (Database)
- **Maven** (Build Tool)
- **JUnit 5** (Testing)

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- MySQL Server 8.0 or higher
- Apache Maven 3.6 or higher
- An IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Database Setup

1. Install MySQL Server on your system
2. Create a database named `hibernatedb`:

   ```sql
   CREATE DATABASE hibernatedb;
   ```

3. Update the database credentials in `src/main/java/hibernate.cfg.xml` if needed:

   ```xml
   <property name="hibernate.connection.username">your_username</property>
   <property name="hibernate.connection.password">your_password</property>
   ```

### Installation and Running

1. Clone or download the project
2. Navigate to the project directory
3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn exec:java -Dexec.mainClass="com.kodnest.ems.App"
   ```

### Usage

Once the application starts, you'll see an interactive menu:

```
Welcome to Employee Management System
Press 1 -> AddEmployee
Press 2 -> GetEmployee
Press 3 -> DeleteEmployee
Press 4 -> UpdateEmployee
Press other -> Exit
```

- **Option 1**: Add a new employee (enter name, salary, and email)
- **Option 2**: View employee details by ID
- **Option 3**: Delete an employee by ID
- **Option 4**: Update employee information by ID

### Project Structure

```
ems/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/kodnest/ems/
│   │           ├── App.java          # Main application class
│   │           ├── Employee.java      # Entity class
│   │           └── hibernate.cfg.xml  # Hibernate configuration
│   └── test/
│       └── java/
│           └── com/kodnest/ems/
│               └── AppTest.java      # Test class
├── pom.xml                            # Maven configuration
└── README.md                          # This file
```

### Testing

Run the test suite using Maven:

```bash
mvn test
```

### Notes

- The application uses Hibernate's auto-configuration to create/update database schema
- SQL queries are logged to console for debugging (configured in hibernate.cfg.xml)
- The application uses IDENTITY strategy for auto-generating employee IDs
