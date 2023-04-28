package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.model.Books;

import in.ineuron.service.IBooksService;

import in.ineuron.servicefactory.BooksServiceFactory;

import in.ineuron.utill.UUIDGenrator;


@WebServlet("/BooksController/*")
public class BooksController extends HttpServlet{
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doRegisterBooks(request, response);
}

private void doRegisterBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	IBooksService bookservice=BooksServiceFactory.getBookService();

	if(request.getRequestURI().endsWith("addBooks")){
		
		String authorName=request.getParameter("authorName");
		String title = request.getParameter("title");
		String catName = request.getParameter("catName");
		String bookNo = request.getParameter("bookNo");
	   String bookPrice = request.getParameter("bookPrice");
	   String  qty= request.getParameter("qty");
		
	   Books books=new Books();
		String id = UUIDGenrator.getUniqueId();
		
		books.setAuthorName(authorName);
		books.setTitle(title);
		books.setCatName(catName);
		books.setBookNo(bookNo);
		books.setBookPrice(bookPrice);
		books.setQty(qty);
		String status = bookservice.addBook(books);
		
		RequestDispatcher rd = null;
		
		if(status.equals("success")) {
			System.out.println("sucess-------------");
			request.setAttribute("status", "success");
			rd = request.getRequestDispatcher("../Books.jsp");
			rd.forward(request, response);
			//response.sendRedirect("../registration.jsp");
		}else {
			System.out.println("failure-------------");
			request.setAttribute("status", "failure");
			rd = request.getRequestDispatcher("../Books.jsp");
			rd.forward(request, response);
			
			response.sendRedirect("../Books.jsp");
		}
		
	}
		

if (request.getRequestURI().endsWith("searchbook")) {
	bookservice = BooksServiceFactory.getBookService();
	
	String bookId = request.getParameter("bookId");
	String authorName=request.getParameter("authorName");
	RequestDispatcher rd1=null;
	List<Books> searchBook = bookservice.searchBook(bookId, authorName);

	request.setAttribute("searchBook", searchBook);
	rd1=request.getRequestDispatcher("../bookssearchresponse.jsp");
	rd1.forward(request, response);
}


if (request.getRequestURI().endsWith("deletebook")) {
	bookservice = BooksServiceFactory.getBookService();
	String bookId = request.getParameter("bookId");

	String deleteBook = bookservice.deleteBook(bookId);
	RequestDispatcher rd2=null;
	request.setAttribute("deleteBook", deleteBook);
	rd2=request.getRequestDispatcher("../booksdeleteresponse.jsp");
	rd2.forward(request, response);
}

if (request.getRequestURI().endsWith("showbooks.jsp")) {
	bookservice = BooksServiceFactory.getBookService();
	RequestDispatcher rd3=null;
	List<Books> allBooks = bookservice.getAllBooks();
	request.setAttribute("allBooks", allBooks);
	rd3=request.getRequestDispatcher("../showallbooks.jsp");
	rd3.forward(request, response);
}

if (request.getRequestURI().endsWith("searchbookforupdate")) {
	bookservice = BooksServiceFactory.getBookService();
	String bookId =request.getParameter("bookId");

	List<Books> searchBook = bookservice.searchBook(bookId,"");
	RequestDispatcher rd4=null;
	request.setAttribute("searchBook", searchBook);
	rd4=request.getRequestDispatcher("../editbook.jsp");
	rd4.forward(request, response);
}
if (request.getRequestURI().endsWith("updatebook")) {
	bookservice = BooksServiceFactory.getBookService();
		
	Books book = new Books();
	book.setBookId(request.getParameter("bookId"));
	book.setAuthorName(request.getParameter("authorName"));
	book.setTitle(request.getParameter("title"));
	book.setCatName(request.getParameter("catName"));
	book.setBookNo(request.getParameter("bookNo"));
	book.setBookPrice(request.getParameter("bookPrice"));
	book.setQty(request.getParameter("qty"));
	RequestDispatcher rd5=null;
	String updateBook = bookservice.updateBook(book);
	request.setAttribute("updateBook", updateBook);
	rd5 = request.getRequestDispatcher("../../booksupdateresponse.jsp");
	rd5.forward(request, response);


}
}




}
