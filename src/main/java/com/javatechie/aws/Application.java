package com.javatechie.aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/book")
public class Application {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public String saveBook(@RequestParam("name") String name, @RequestParam("price") String price) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(Double.parseDouble(price));
         bookRepository.save(book);
         return  "<html>Book saved <a href=\"javascript:history.back()\">Go Back</a></html>";
    }

    @GetMapping
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }


    @GetMapping("/{id}")
    public Book findBook(@PathVariable int id) throws Exception {
        Book book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not available"));
        return book;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
