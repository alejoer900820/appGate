package co.com.appgate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.appgate.dao.IBookDao;
import co.com.appgate.dto.BookDTO;
import co.com.appgate.entities.Book;
import co.com.appgate.interfaces.IBookService;
import co.com.appgate.util.ConvertidorDTOEntityUtil;
import co.com.appgate.util.EnumMessages;

import org.apache.log4j.Logger;

/**
 * @author Alejandro Echeverri Restrepo
 * 
 * @date 22/11/2020
 *
 */
@Service
public class BookService implements IBookService {

	private ConvertidorDTOEntityUtil convertidorDTOEntityUtil = new ConvertidorDTOEntityUtil();
	private final static Logger log = Logger.getLogger(BookService.class);
	
	@Autowired
	private IBookDao bookDao;

	/**
	 * Return list of Books 
	 */
	@Override
	public List<BookDTO> getBook() throws Exception {

		log.info("[INICIO][BookService][getBook]");
		List<BookDTO> books = new ArrayList<BookDTO>();
		books = convertidorDTOEntityUtil.convertToDto((List<Book>) bookDao.findAll());

		return books;

	}

	/**
	 * Create a new book
	 */
	@Override
	public BookDTO createBook(BookDTO bookDTO) throws Exception {
		
		Book book = null;
		log.info("[INICIO][BookService][createBook]");
		book = bookDao.save(convertidorDTOEntityUtil.convertToEntity(bookDTO));
		if(book != null)
			return convertidorDTOEntityUtil.convertToDto(book);
		else
			return null;
	}

	/**
	 * Update a book
	 */
	@Override
	public BookDTO updateBook(BookDTO bookDTO) throws Exception {
		Book book = null;
		log.info("[INICIO][BookService][updateBook]");
		book = bookDao.save(convertidorDTOEntityUtil.convertToEntity(bookDTO));
		if(book != null)
			return convertidorDTOEntityUtil.convertToDto(book);
		else
			return null;
	}

	/**
	 * Delete a book
	 */
	@Override
	public void deleteBook(BookDTO bookDTO) throws Exception {
		log.info("[INICIO][BookService][deleteBook]");
		bookDao.delete(convertidorDTOEntityUtil.convertToEntity(bookDTO));
	}

	/**
	 * find a book by Id
	 */
	@Override
	public BookDTO findBookById(Long idBook) throws Exception {
		Optional<Book> book = null;
		log.info("[INICIO][BookService][findBookById]");
		book = bookDao.findById(idBook);
		if(book.isPresent())
			return convertidorDTOEntityUtil.convertToDto(book.get());
		else
			return null;
	}

}
