package in.ineuron.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.model.Books;
import in.ineuron.utill.JdbcUtil;

public class BooksDaoImpl implements IBooksDao{
	private Connection connection = null;
	private PreparedStatement prepareStatement = null;
	private ResultSet resultSet = null;
	@Override
	public String addBook(Books book) {
		String status = "failure";
		String insertBookQuery = "insert into books (book_id,author_name,title,cat_name,book_no,price_no,qty)values(?,?,?,?,?,?,?)";
		try {
			try {
				connection = JdbcUtil.getJdbcConnection();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			if (connection != null) {
				prepareStatement = connection.prepareStatement(insertBookQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setString(1, book.getBookId());
				prepareStatement.setString(2, book.getAuthorName());
				prepareStatement.setString(3, book.getTitle());
				prepareStatement.setString(4, book.getCatName());
				prepareStatement.setString(5, book.getBookNo());
				prepareStatement.setString(6, book.getBookPrice());
				prepareStatement.setString(7, book.getQty());

				int rowAffected = prepareStatement.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				} else {
					return "failure";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConnection(connection);
		}

		return status;
	}
	

	@Override
	public String deleteBook( String bookId)  {
		String status = "failure";
		String deleteBookQuery = "delete from books where book_id=?";
		try {
			try {
				connection = JdbcUtil.getJdbcConnection();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			if (connection != null) {
				prepareStatement = connection.prepareStatement(deleteBookQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setString(1, bookId);
				int rowAffected = prepareStatement.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				} else {
					return "failure";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConnection(connection);
		}


		return status;
	}

	@Override
	public String updateBook(Books book) {
		
		String status="failure";
		try {
			connection = JdbcUtil.getJdbcConnection();
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {

			if (connection != null) {
				String sqlUpdateQuery = "update books set author_name=?,title=?,cat_name=?,book_no=?,price_no=?,qty=?where book_id=?";
				prepareStatement=connection.prepareStatement(sqlUpdateQuery);
			}
			if(prepareStatement!=null) {
				prepareStatement.setString(1, book.getAuthorName());
				prepareStatement.setString(2, book.getTitle());
				prepareStatement.setString(3, book.getCatName());
				prepareStatement.setString(4, book.getBookNo());
				prepareStatement.setString(5, book.getBookPrice());
				prepareStatement.setString(6, book.getQty());
				prepareStatement.setString(7, book.getBookId());
				
				int rowAffected = prepareStatement.executeUpdate();
				
				if(rowAffected==1) {
					status="success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConnection(connection);
		}

		return status;
	}
	

	@Override
	public List<Books> searchBook(String bookId, String authorName) {
		List<Books> list = null;
		String selectBookSearchQuery = "select book_id,author_name,title,cat_name,book_no,book_price,qty from books where book_id=? or author_name=?";
		try {
			try {
				connection = JdbcUtil.getJdbcConnection();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (connection != null) {
				prepareStatement = connection.prepareStatement(selectBookSearchQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setString(1, bookId);
				prepareStatement.setString(2, authorName);
				
				resultSet = prepareStatement.executeQuery();
			}
			if (resultSet != null) {
				Books books = null;
				list=new ArrayList<>();
				while (resultSet.next()) {
					books = new Books();
					books.setBookId(resultSet.getString(1));
					books.setAuthorName(resultSet.getString(2));
					books.setTitle(resultSet.getString(3));
					books.setCatName(resultSet.getString(4));
					books.setBookNo(resultSet.getString(5));
					books.setBookPrice(resultSet.getString(6));
					books.setQty(resultSet.getString(7));
					list.add(books);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConnection(connection);
		}


		return list;
	}


	@Override
	public List<Books> getAllBooks() {
		List<Books> list = new ArrayList<>();
		String selectBookSearchQuery = "select book_id,author_name,title,cat_name,book_no,book_price,qty from books";
		try {
			try {
				connection = JdbcUtil.getJdbcConnection();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			if (connection != null) {
				prepareStatement = connection.prepareStatement(selectBookSearchQuery);
			}
			if (prepareStatement != null) {

				resultSet = prepareStatement.executeQuery();
			}
			if (resultSet != null) {
				Books books = null;
				while (resultSet.next()) {
					books = new Books();
					books.setBookId(resultSet.getString(1));
					books.setAuthorName(resultSet.getString(2));
					books.setTitle(resultSet.getString(3));
					books.setCatName(resultSet.getString(4));
					books.setBookNo(resultSet.getString(5));
					books.setBookPrice(resultSet.getString(6));
					books.setQty(resultSet.getString(7));
					list.add(books);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConnection(connection);
		}

		return list;
	}
	

}
