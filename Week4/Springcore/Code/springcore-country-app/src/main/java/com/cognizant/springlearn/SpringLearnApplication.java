package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		// Invoke the displayCountry method after Spring Boot has started (optional, for simplicity)
		// Or you can call it directly as a static method if you prefer not to wait for Spring Boot context
		// For this exercise, calling it directly from main() without full Spring Boot context is simpler.
		displayCountry();
	}

	// Method to display country details from Spring XML configuration
	public static void displayCountry() {
		LOGGER.debug("Starting displayCountry()");

		// SME Detailing: ApplicationContext, ClassPathXmlApplicationContext
		// ApplicationContext: This is Spring's advanced IoC container. It provides
		//                      configuration information to the Spring application.
		//                      It handles the instantiation, configuration, and assembly of beans.
		// ClassPathXmlApplicationContext: This is a specific implementation of ApplicationContext
		//                                  that loads bean definitions from an XML file located
		//                                  in the classpath (like our country.xml in src/main/resources).
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		// SME Detailing: What exactly happens when context.getBean() is invoked
		// context.getBean("country", Country.class):
		// 1. The Spring container (context) looks for a bean with the ID "country".
		// 2. It finds the <bean> definition for "country" in country.xml.
		// 3. It sees that the class for this bean is "com.cognizant.springlearn.Country".
		// 4. It instantiates an object of com.cognizant.springlearn.Country.
		//    (At this point, the Country class's no-arg constructor will be called,
		//     and you'll see "Inside Country Constructor." in the logs).
		// 5. It then looks for <property> tags within that bean definition.
		// 6. For each <property> tag (e.g., name="code", value="IN"), it calls the
		//    corresponding setter method (e.g., setCode("IN")) on the newly created
		//    Country object.
		//    (You'll see "Inside Country setCode() method..." and "Inside Country setName() method..." logs).
		// 7. Finally, it returns the fully initialized and configured Country object.
		Country country = (Country) context.getBean("country", Country.class); // Casting is good practice

		// Using the toString() method to log the country details
		LOGGER.debug("Country : {}", country.toString());

		// It's good practice to close the context for non-web applications to release resources
		((ClassPathXmlApplicationContext) context).close();

		LOGGER.debug("Ending displayCountry()");
	}
}