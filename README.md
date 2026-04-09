# CSD214 w26 Lecture 8 Starter App
- [Lecture 8...](https://docs.google.com/document/d/1DqL55GGoQbX6LO9NgkX5eCzmMfDRyoH_PEh4T4bo9QQ/edit?usp=sharing)

**1. The Vanishing Act: In Lab 5, we had to write logic for every repository. In Lab 6, we just wrote an interface. How does Spring replace the coding?**
Spring uses Dynamic Proxies and Reflection. When the interface extends JpaRepository, Spring Data JPA scans the method names (like findByPriceLessThan) and automatically generates the necessary SQL queries and implementation logic at runtime. This eliminates the need for manual boilerplate code like EntityManager calls or result-set mapping.
  
**2. The Power of Annotations: If you forgot @Service, what would happen?**
Spring’s Component Scanner would skip the class during the "Wiring Phase." When another class (like your CLI) tries to inject that service via its constructor, Spring will throw a NoSuchBeanDefinitionException because it doesn't recognize the class as a managed "Bean".

**3. Constructor Injection vs. New: Why is it better?**
It promotes Loose Coupling. Instead of a class being "hard-coded" to a specific implementation using new, it simply asks for an interface. This makes the code easier to test and allows Spring to manage the entire lifecycle and dependency graph of the application.

**4. Profiles vs. Lab 5 Menu: Why is the Profile approach better for real-world deployment?**
Profiles prevent accidental environment contamination. In Lab 5, I had to manually change code or menu options to switch databases. With Profiles, I can swap between dev (H2) and prod (MySQL) using external configuration files or command line arguments without touching the Java source code, which is the industry standard for CI/CD pipelines.

# 20 Questions

**1. What is the primary benefit of Inversion of Control (IoC)?**
B. The framework (Spring) manages the object lifecycle and dependencies instead of the developer.

**2. Which annotation is specifically used to mark a class as part of the "Business Logic" or "Service" layer?**
C. @Service

**3. What happens if you have two different classes implementing the same interface and try to inject that interface without further instruction?**
B. Spring throws an Ambiguous Bean exception unless you use @Qualifier.

**4. How does Spring Data JPA handle a method named findByPriceLessThan(double price) in a Repository interface?**
B. It parses the method name and generates the SQL query automatically.

**5. Which of the following is the most "generic" stereotype annotation for a Spring-managed component?**
C. @Component

**6. What is "Constructor Injection"?**
B. Defining dependencies in the constructor so Spring can provide them automatically.

**7. Which tool would you use to change the database configuration (e.g., from H2 to MySQL) without changing Java code?**
B. A Spring Profile.

**8. When extending JpaRepository<Book, Long>, what does the Long parameter represent?**
B. The data type of the Entity's Primary Key (@Id).

**9. What is the purpose of the @Transactional annotation?**
B. It ensures that if one database operation fails, the entire transaction is rolled back.

**10. What is a "Bean" in the Spring framework?**
B. An object that is instantiated, assembled, and managed by the Spring IoC container.

**11. Which annotation is used on the main class to enable auto-configuration and component scanning?**
B. @SpringBootApplication

**12. In a professional Spring Boot app using JPA, how many lines of manual SQL are typically required for basic CRUD operations?**
B. Zero (Configuration is done in properties/profiles).

**13. If you want a piece of code to run immediately after the Spring application context starts, which interface should you implement?**
B. CommandLineRunner

**14. What does the @Repository annotation signal to Spring?**
A. This class handles Data Access logic.

**15. What occurs if Class A requires Class B in its constructor, and Class B requires Class A?**
B. A "Circular Dependency" error occurs at startup.

**16. Which Maven dependency is required to use Spring Data JPA and Hibernate?**
B. spring-boot-starter-data-jpa

**17. How do you run a Spring Boot application with the "prod" profile active from the command line?**
A. mvn spring-boot:run -Dspring-boot.run.profiles=prod

**18. What is "Loose Coupling" in the context of Spring?**
B. You can change one part of the system (like the DB) without breaking other parts (like the UI).

**19. What does @GeneratedValue(strategy = GenerationType.IDENTITY) do?**
B. Tells the database to automatically increment the Primary Key ID.

**20. What is the name of the "engine" in Spring that holds all the beans and manages their relationships?**
B. The ApplicationContext (IoC Container).
