package co.com.appgate;

import java.util.List;

import co.com.appgate.dto.BookDTO;

/**
 * @author Alejandro Echeverri Restrepo
 * 
 * 
 * It's the service'response
 * 
 * @date 22/11/2020
 *
 */
public class BookResponse {

	private List<BookDTO> books;
	private String message;
	
	public List<BookDTO> getBooks() {
		return books;
	}
	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
