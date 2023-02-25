# Chapter 1 – Advanced Class Design

- [X] Proper use of visibility modifiers
- [ ] Polymorphic class structure with use of parent classes and interfaces
- [ ] Use of overloaded methods and/or constructors
- [X] Use of overridden methods and/or constructors
   - [X] Including override of .toString() in at least one scenario
- [X] Proper use of the Static keyword
- [X] Proper use of the final keyword
- [ ] Use of nested classes
- [ ] Use of enumerations (enums)
- [X] Proper use of @Override notation

# Chapter 2 – Design Patterns

- [ ] Use of lambda expressions in at least five scenarios
- [ ] Valid example of encapsulation in at least two scenarios
- [X] Use of the Singleton pattern
- [ ] Use of the Immutable Object pattern
- [ ] Valid object comparison in at least one scenario

# Chapter 3 - Generics

- [ ] Appropriate use of a Generic Class
   - [ ] Use of an Upper-bounded, lower-bounded, or unbounded wildcard when using the generic class)
- [X] Use of an Array List
- [ ] Use of a TreeSet or TreeMap
- [ ] Use of the Comparator or Comparable interface
- [X] Valid example of a foreach statement

# Chapter 4 – Functional Programming

- [ ] Use of a variables in lambda expression
- [ ] Use of at least two of the built-in functional interfaces (page 173)
- [ ] Creation and use of a custom functional interface
- [ ] Use of the optional type
- [ ] Use of the stream pipeline and console
   - [ ] If you are building a GUI onto your application, consider implementing a debugging console for developer-only
      information

# Chapter 5 – Dates, Strings, and Localization

- [X] Use of dates and times in your application
   - [X] Consider logging output to a database/flat file
- [ ] Implementation of a custom calendar in your application
   - [ ] Consider special things/displays occurring on Holidays or different seasons
- [ ] Proper use of String localization
   - [ ] Use of a resource bundle
- [ ] At least one date calculation

# Chapter 6 – Exceptions and Assertions

- [X] Proper use of Try-Catch blocks
- [X] Use of catch, multi-catch, and finally clauses
  - This requirement was met under the SimpleDBReadTest.
- [ ] Use and creation of a custom exception
- [ ] Proper disposal of resources (try-with resources block)
- [X] Use of assertions
  - Implemented in the JUnit tests.

# Chapter 8 – IO

- [X] Demonstration of reading/writing data from the console
   - [ ] If you are implementing a GUI, consider a Developer only console
- [X] Demonstration of the FileReader and FileWriter clases
   - [X] Consider logging output or errors to a file

# Chapter 9 – NIO

- [X] Manipulation of an existing file on local machine (read in values, write to values)
  - Implemented using SQLite.
- [ ] Creation and deletion of a file stored locally

# Chapter 10 – JDBC

- [ ] Implementation of a database with basic CRUD operations (Create, Read, Update, Delete)
  - [ ] CREATE
  - [X] READ
  - [ ] UPDATE
  - [ ] DELETE
- [X] Proper opening and closure of a Database resource
  - Implemented using SQLite.
- [ ] Inclusion of prepared statements if user input is used on SQL statements

# Additional Requirements

- [X] Appropriate of code comments (single line)
- [X] Appropriate use of JavaDoc comments for all classes, methods, interface, enumerations, and similar
   objects
   - [X] JavaDoc should be generated before submission
     - Doxygen used instead of JavaDoc.
- [X] Appropriate use of JavaBeans (chapter 2, page 69)
    - [X] All properties should be privates
      - Except for the collections in the Game singleton class, all objects should be properly encapsulated.
    - [X] Getter for non-boolean properties begins with a get
    - [X] Getters for Boolean properties begins with Is or Get
    - [X] Setter methods begin with set
    - [X] Correct use of Camel Casing

# Optional Extra Credit

Note: Extra Credit is only graded when at least 95% of all other requirements are met

- [ ] Use of the builder pattern (potential 10 points)
- [ ] Use of concurrent processes (chapter 7) (potential 25 points)
- [ ] Use of a GUI framework (potential 25 points)
- [X] Use of a Database other than derby (potential 25 points)
  - We used SQLite in our project.
- [ ] Hosting your database on a network or hardware device (potential 25 points)

If your team has other interests that you believe is worth extra credit, please reach out for approval!