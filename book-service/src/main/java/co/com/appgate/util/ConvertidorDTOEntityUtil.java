package co.com.appgate.util;

import java.util.ArrayList;
import java.util.List;
import co.com.appgate.dto.BookDTO;
import co.com.appgate.entities.Book;

/**
 * @author Alejandro Echeverri
 * 
 * @date 22/11/2020
 *
 */
public class ConvertidorDTOEntityUtil {

	/**
	 * Convert DTO to Entity
	 * 
	 * @param book Entity
	 * @return DTO
	 */
	public BookDTO convertToDto(Book book) {
		BookDTO bookDto = new BookDTO();
		
		if(book != null) {
			bookDto.setId(book.getId());
			bookDto.setTitle(book.getTitle());
			bookDto.setAuthor(book.getGenre());
			bookDto.setTotalprice(book.getTotalprice());
			bookDto.setPublisher(book.getPublisher());
			bookDto.setFecha(book.getFecha());
		}

		return bookDto;
	}
	
	/**
	 * convert list of entities to DTOs
	 * 
	 * @param books list of books
	 * @return list of DTOs
	 */
	public List<BookDTO> convertToDto(List<Book> books) {
		
		List<BookDTO> booksAux = new ArrayList<BookDTO>();
		BookDTO bookDto = new BookDTO();
		
		for (Book book : books) {
			bookDto = convertToDto(book);
			booksAux.add(bookDto);
		}
	    return booksAux;
	}
	
	/**
	 * Convert DTO to Entity
	 * 
	 * @param bookDto 
	 * @return  Entity
	 */
	public Book convertToEntity(BookDTO bookDto) {
		Book book = new Book();
		
		if(book != null) {
			book.setId(bookDto.getId());
			book.setTitle(bookDto.getTitle());
			book.setAuthor(bookDto.getGenre());
			book.setTotalprice(bookDto.getTotalprice());
			book.setPublisher(bookDto.getPublisher());
			book.setFecha(bookDto.getFecha());
		}

		return book;
	}
	
}
