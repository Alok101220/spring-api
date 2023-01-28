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
    public ResponseEntity<Book> addNewBook(@RequestBody Book b){
         Book book= null;
         try {
            book=bookService.addBook(book);
            return ResponseEntity.of(Optional.of(book));
         } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
    }

    @DeleteMapping("/books/{bid}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bid") int bid){
        try {
            this.bookService.deleteBook(bid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Void> updateBook(@RequestBody Book book, @PathVariable("id") int id){
        try{
            this.bookService.updateBook(book,id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
