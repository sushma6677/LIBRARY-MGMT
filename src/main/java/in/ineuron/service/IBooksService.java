package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Books;

public interface IBooksService {
	public String addBook(Books book);

	public String deleteBook(String bookId);

	public String updateBook(Books book);

	public List<Books> searchBook(String bookId);

	public List<Books> getAllBooks();
}
