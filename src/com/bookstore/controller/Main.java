package com.bookstore.controller;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoImp1Jdbc;
import com.bookstore.dao.factory.DBConnectionFactory;
import com.bookstore.entities.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Connection connection=DBConnectionFactory.getConnection();
//if(connection!=null) {
//	System.out.println("done");
//}
		
		BookDao dao=new BookDaoImp1Jdbc();
		for(Book book:dao.getAllBooks()) {
			System.out.println(book);
		}
	}

}
