package co.com.appgate.interfaces;

import java.util.List;

import co.com.appgate.dto.BookDTO;


/**
 * @author Alejandro Echeverri Restrepo
 * 
 * date 22/11/2020
 *
 */
public interface IBookService {

	public List<BookDTO> getBook() throws Exception;
	
	public BookDTO createBook(BookDTO bookDTO) throws Exception;
	
	public BookDTO updateBook(BookDTO bookDTO) throws Exception;
	
	public void deleteBook(BookDTO bookDTO) throws Exception;
	
	public BookDTO findBookById (Long idBook) throws Exception;
	
}
