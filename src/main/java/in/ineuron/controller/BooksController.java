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

//import in.ineuron.utill.UUIDGenrator;
///BooksController/*
@WebServlet(urlPatterns = "/bookscontroller/*")
public class BooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IBooksService bookservice=null;
	RequestDispatcher requestDispatcher = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	bookservice=BooksServiceFactory.getBookService();

	if(request.getRequestURI().endsWith("addbook")){
		String Bookid=request.getParameter("bid");
		String authorName=request.getParameter("authorName");
		String title = request.getParameter("title");
		String catName = request.getParameter("catName");
		
	   String bookPrice = request.getParameter("bookPrice");
	   String  qty= request.getParameter("qty");
	   String edition=request.getParameter("edition");
		String description=request.getParameter("description");
	   Books books=new Books();
//		String id = UUIDGenrator.getUniqueId();
		books.setBookId(Bookid);
		books.setAuthorName(authorName);
		books.setTitle(title);
		books.setCatName(catName);
		books.setBookPrice(bookPrice);
		books.setQty(qty);
		books.setEdition(edition);
		books.setDescription(description);
		
		
	
	String addBook = bookservice.addBook(books);
		System.out.println(addBook);
		request.setAttribute("addBook", addBook);
		requestDispatcher = request.getRequestDispatcher("/booksinsertresponse.jsp");
		requestDispatcher.forward(request, response);

		
	}
		

if (request.getRequestURI().endsWith("searchbook")) {
	bookservice = BooksServiceFactory.getBookService();
	
	String bookId = request.getParameter("bid");
	

	List<Books> searchBook = bookservice.searchBook(bookId);

	request.setAttribute("searchBook", searchBook);
	requestDispatcher=request.getRequestDispatcher("../bookssearchresponse.jsp");
	requestDispatcher.forward(request, response);
}


if (request.getRequestURI().endsWith("deletebook")) {
	bookservice = BooksServiceFactory.getBookService();
	String bookId = request.getParameter("bid");

	String deleteBook = bookservice.deleteBook(bookId);

	request.setAttribute("deleteBook", deleteBook);
	requestDispatcher=request.getRequestDispatcher("../booksdeleteresponse.jsp");
	requestDispatcher.forward(request, response);
}

if (request.getRequestURI().endsWith("showsbooks")) {
	bookservice = BooksServiceFactory.getBookService();

	List<Books> allBooks = bookservice.getAllBooks();
	request.setAttribute("allBooks", allBooks);
	requestDispatcher=request.getRequestDispatcher("../showallbooks.jsp");
	requestDispatcher.forward(request, response);
}

if (request.getRequestURI().endsWith("searchbookforupdate")) {
	bookservice = BooksServiceFactory.getBookService();
	String bookId =request.getParameter("bid");

	List<Books> searchBook = bookservice.searchBook(bookId);
	
	request.setAttribute("searchBook", searchBook);
	requestDispatcher=request.getRequestDispatcher("../editbook.jsp");
	requestDispatcher.forward(request,response);	
	

}
if (request.getRequestURI().endsWith("updatebook")) {
	bookservice = BooksServiceFactory.getBookService();
		
	Books book = new Books();
	book.setBookId(request.getParameter("bid"));
	book.setAuthorName(request.getParameter("authorName"));
	book.setTitle(request.getParameter("title"));
	book.setCatName(request.getParameter("catName"));
		book.setBookPrice(request.getParameter("bookPrice"));
	book.setQty(request.getParameter("qty"));
	book.setEdition(request.getParameter("edition"));
	book.setDescription(request.getParameter("description"));

	String updateBook = bookservice.updateBook(book);
	request.setAttribute("updateBook", updateBook);
	requestDispatcher = request.getRequestDispatcher("../../booksupdateresponse.jsp");
	requestDispatcher.forward(request, response);


}
}




}
