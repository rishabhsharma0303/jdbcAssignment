package com.bookstore.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dao.factory.DBConnectionFactory;
import com.bookstore.entities.Book;
import com.bookstore.exception.DataAccessException;
import com.bookstore.exception.*;
public class BookDaoImp1Jdbc implements BookDao{
private Connection connection;

public BookDaoImp1Jdbc() {
	connection=DBConnectionFactory.getConnection();
}
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> books =new ArrayList<Book>();
		Book book=null;
		try {
			PreparedStatement pstmt=connection.prepareStatement("select * from books");
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()) {
			book=new Book(rs.getString("isbn"),rs.getString("title"),rs.getString("author"),rs.getDouble("price"),rs.getDate("Pubdate"));
	books.add(book);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		Book book=null;
		try {
			PreparedStatement pstmt=connection.prepareStatement("select * from books where id=?");
			pstmt.setInt(1, id);
			ResultSet rs=	pstmt.executeQuery();
		if(rs.next()) {
			book=new Book(rs.getString("isbn"),rs.getString("title"),rs.getString("author"),rs.getDouble("price"),rs.getDate("Pubdate"));
		}else {
			throw new ResourceNotFoundException("book with id is not found");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new DataAccessException(e.toString());
		}
		return book;
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
	try {
		
		String INSERT_BOOK_QUERY = "insert into books(isbn,title,author,price,pubdate) valuse(?,?,?,?,?)";
		PreparedStatement pstmt=connection.prepareStatement(INSERT_BOOK_QUERY,Statement.RETURN_GENERATED_KEYS);
	pstmt.setString(1,book.getIsbn());
	pstmt.setString(2,book.getTitle());
	pstmt.setString(3,book.getAuthor());
	pstmt.setDouble(4,book.getPrice());
	pstmt.setDate(5, new Date(book.getPubDate().getTime()));
	
		pstmt.executeUpdate();
	
	ResultSet rs=pstmt.getGeneratedKeys();
	if(rs.next()) {
		book.setId(rs.getInt(1));
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	throw new DataAccessException(e.toString());
	}
		return book;
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt=connection.prepareStatement("delete from books where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e.toString());
		}
		
		
		
	}

	@Override
	public void UpdateBook(int id, Book book) {

		// TODO Auto-generated method stub
	try {
		
		String UPDATE_BOOK_QUERY = "update books set price where id=?";
		PreparedStatement pstmt=connection.prepareStatement(UPDATE_BOOK_QUERY,Statement.RETURN_GENERATED_KEYS);
	pstmt.setInt(1, id);
	pstmt.setDouble(4, book.getPrice());
	
	
	
		pstmt.executeUpdate();
	
	ResultSet rs=pstmt.getGeneratedKeys();
	if(rs.next()) {
		book.setId(rs.getInt(1));
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	throw new DataAccessException(e.toString());
	}
		
	
		
	}

	
	    @Override
	    public Book getBookByIsbn(String isbn) {
	        Book book = null;
	        try {
	            PreparedStatement pstmt = connection.prepareStatement("select * from books where isbn=?");
	            pstmt.setString(2, isbn);

	 

	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                book = new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
	                        rs.getDouble("price"), rs.getDate("pubDate"));
	            } else {
	                throw new ResourceNotFoundException("book with isbn :=" + isbn + " is not found");
	            }
	        } catch (SQLException e) {
	            throw new DataAccessException(e.toString());
	        }
	        return book;
	    }

	 

	
	 




	}


