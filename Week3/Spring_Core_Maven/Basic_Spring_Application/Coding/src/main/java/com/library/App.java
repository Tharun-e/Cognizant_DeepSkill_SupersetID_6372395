package com.library;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import com.library.service.BookService;
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.displayBooks();
        context.close(); 
    }
}
