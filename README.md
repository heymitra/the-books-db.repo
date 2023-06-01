# the-books-db.repo

This is a simple JDBC-based project for saving authors and their published books info.

The directory structure of this project is as below: <br>
(p stands for the package, C for class, and I for interface) <br>


<pre>
&nbsp;src
&nbsp;   |____main
&nbsp;       |____java
&nbsp;           |____org.example
&nbsp;               |_____(p) entity:     (C)Table(s)
&nbsp;               |_____(p) repository: (I)TableRepository(s) + (C)TableRepositoryImpl(s)
&nbsp;               |_____(p) service:    (I)TableService(s) + (C)TableServiceImpl(s)
&nbsp;               |_____(p) config:     (C)DataBaseConfig + (C)DataConnector
&nbsp;               |_____(p) util:       (C)ApplicationContext + (C)Constant
&nbsp;               |_____(p) sql:        console
&nbsp;               |_____(p) ui:         (C)Menu
&nbsp;               |_____(C) App         (contains psvm)
</pre>





## Directory Structure

- **src**
  - **main**
    - **java**
      - **org.example**
        - **entity**
          - Table: maps the SQL data in a form known by Java. Contains fields of the table as private variables, constructor(s), and getter/setter methods.
        - **repository**
          - TableRepository: contains all methods which may be applied to data (save, delete, etc.).
          - TableRepositoryImpl: implements the methods of TableRepository.
        - **service**
          - TableService: contains the same methods as TableRepository. Implements those methods by validating and then calling TableRepository. (TableRepository should not be called directly from ui. It is suggested to call Service, and it will call the considered method from the repository after validating.)
        - **config**
          - DatabaseConfig: contains a method named `getCreateConnection` that returns an object of `Connection`. Inside this method, the Connection is made using the `getConnection` method of the `DriverManager` class.
          - DatabaseConnector: acts as an intermediary between the Connection made in DataConnector and other parts of the program where we need to create this connection. It checks whether the connection is already made before returning it or creates a new connection if it is null.
        - **util**
          - For utility classes that provide common functionalities across the JDBC project.

