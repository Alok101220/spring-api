package com.firstspring.myapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstspring.myapp.model.Book;
import com.firstspring.myapp.services.BookService;

@RestController
@RequestMapping("/api/v1/")
public class BookController {
    @Autowired
    private BookService bookService; 
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> list=this.bookService.getAllBooks(); 
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book b= bookService.getBookById(id);
        if(b==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }

    @PostMapping("/books")
    public Book addNewBook(@RequestBody Book b){
         Book book=bookService.addBook(b);
            return book;
    }

    @DeleteMapping("/books/{bid}")
    public void deleteBook(@PathVariable("bid") int bid){
       
            this.bookService.deleteBook(bid);
        
    }

    @PutMapping("/books/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable("id") int id){
        
            this.bookService.updateBook(book,id);
    }
}
