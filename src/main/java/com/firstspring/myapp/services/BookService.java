package com.firstspring.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firstspring.myapp.dao.BookRepository;
import com.firstspring.myapp.model.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list= new ArrayList<>();
    
    // static{
    //     list.add(new Book(2,"Python","GFG"));
    //     list.add(new Book(1,"java","Striver"));
    //     list.add(new Book(3,"Data Structure","Alok"));
    // }

    public List<Book> getAllBooks(){
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;
    }
    public Book getBookById(int id){
        Book book=null;
        try{
            // book=list.stream().filter(e->e.getId()==id).findFirst().get();
            return this.bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }
    public Book addBook(Book book){
        Book result=bookRepository.save(book);
        return result;
    }

    public void deleteBook(int bid){
        // list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    public void updateBook(Book book, int id){
        // list=list.stream().map(b->{
        //     if(b.getId()==id){
        //         b.setAuthor(book.getAuthor());
        //         b.setTitle(book.getTitle());
        //     }
        //     return b;
        // }).collect(Collectors.toList());
            book.setId(id);
            bookRepository.save(book);
    }
}
