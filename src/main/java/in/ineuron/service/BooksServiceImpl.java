package in.ineuron.service;

import java.util.List;

import in.ineuron.dao.IBooksDao;
import in.ineuron.daofactory.BooksDaoFactory;
import in.ineuron.model.Books;

public class BooksServiceImpl implements IBooksService{

	IBooksDao booksDao = BooksDaoFactory.getBooksDao();
	@Override
	public String addBook(Books book) {
		return booksDao.addBook(book);
	}

	@Override
	public String deleteBook(String bookId) {
		// TODO Auto-generated method stub
		return booksDao.deleteBook(bookId);
	}

	@Override
	public String updateBook(Books book) {
		// TODO Auto-generated method stub
		return booksDao.updateBook(book);
	}

	@Override
	public List<Books> searchBook(String bookId) {
		// TODO Auto-generated method stub
		return booksDao.searchBook(bookId);
	}

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return booksDao.getAllBooks();
	}

}


	