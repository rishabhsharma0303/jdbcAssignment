package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoImp1Jdbc;
import com.bookstore.entities.Book;

public class BookServiceImp implements BookService{
private BookDao bookdao;
public BookServiceImp() {
	bookdao=new BookDaoImp1Jdbc();	
}
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookdao.getAllBooks();
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return bookdao.getBookById(id);
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookdao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		 bookdao.deleteBook(id);
		
	}

	@Override
	public void UpdateBook(int id, Book book) {
		// TODO Auto-generated method stub
		bookdao.UpdateBook(id, book);
		
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return bookdao.getBookByIsbn(isbn);
	}

}
