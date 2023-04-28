
package in.ineuron.dao;

import java.util.List;

import in.ineuron.model.Books;

public interface IBooksDao {
	public String addBook(Books book);

	public String deleteBook(String bookId);

	public String updateBook(Books book);

	public List<Books> searchBook(String bookId, String authorName);

	public List<Books> getAllBooks();
}
