package co.com.appgate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.appgate.BookResponse;
import co.com.appgate.dto.BookDTO;
import co.com.appgate.interfaces.IBookService;
import co.com.appgate.util.EnumMessages;
import io.swagger.annotations.ApiOperation;

/**
 * @author Alejandro Echeverri Restrepo
 * 
 * @date 22/11/2020
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="bookrest")
@RestController
public class BookRest {

	@Autowired
	private IBookService bookService;

	private BookResponse bookResponse;

	public BookRest () {

		bookResponse = new BookResponse();

	}

	/**
	 * Service to get all books
	 * 
	 * @return list of books
	 */
	@GetMapping(value="books")
	@ApiOperation(value = "Service to get all books", notes = "get all books")
	public ResponseEntity<?> getBook() {

		List<BookDTO> books = new ArrayList<BookDTO>();

		try {
			books = bookService.getBook();

			if (books != null) {

				bookResponse.setBooks(books);
				bookResponse.setMessage(EnumMessages.OK.getName());

				return ResponseEntity.status(HttpStatus.OK).body(bookResponse);

			} else {

				bookResponse.setBooks(books);
				bookResponse.setMessage(EnumMessages.ERROR.getName());

				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);

			}

		} catch (Exception e) {
			e.printStackTrace();
			bookResponse.setMessage(EnumMessages.ERROR.getName());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);		
		}

	}

	/**
	 * Service to get a book by Id
	 * 
	 * @param idBook
	 * @return book
	 */
	@GetMapping(value="booksById")
	@ApiOperation(value = "Service to get book by Id", notes = "get book by Id")
	public ResponseEntity<?> getBookById(@RequestParam Long idBook) {

		List<BookDTO> books = new ArrayList<BookDTO>();
		BookDTO bookDTOAux = new BookDTO();

		try {
			bookDTOAux = bookService.findBookById(idBook);

			if (bookDTOAux != null) {
				books.add(bookDTOAux);
				bookResponse.setBooks(books);
				bookResponse.setMessage(EnumMessages.OK.getName());

				return ResponseEntity.status(HttpStatus.OK).body(bookResponse);

			} else {
				books.add(bookDTOAux);
				bookResponse.setBooks(books);
				bookResponse.setMessage(EnumMessages.ERROR.getName());

				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);

			}
		} catch (Exception e) {
			e.printStackTrace();
			bookResponse.setMessage(EnumMessages.ERROR.getName());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);		
		}

	}

	/**
	 * Service to create a book
	 * 
	 * @param bookDTO
	 * @return book
	 */
	@PostMapping(value="create")
	@ApiOperation(value = "Service to create books", notes = "create books")
	public ResponseEntity<?> createBook(@RequestBody BookDTO bookDTO) {

		List<BookDTO> books = new ArrayList<BookDTO>();
		BookDTO bookDTOAux = new BookDTO();

		try {
			bookDTOAux = bookService.createBook(bookDTO);

			if (bookDTOAux != null) {

				books.add(bookDTOAux);
				bookResponse.setBooks(books);
				bookResponse.setMessage(EnumMessages.OK.getName());

				return ResponseEntity.status(HttpStatus.OK).body(bookResponse);

			} else {
				books.add(bookDTOAux);
				bookResponse.setBooks(books);
				bookResponse.setMessage(EnumMessages.ERROR.getName());

				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);

			}
		} catch (Exception e) {
			e.printStackTrace();
			bookResponse.setMessage(EnumMessages.ERROR.getName());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);		
		}
	}

	/**
	 * service to delete a book by id
	 * 
	 * @param idBook
	 * @return
	 */
	@GetMapping(value="delete")
	@ApiOperation(value = "Service to delete books", notes = "delete books")
	public ResponseEntity<?> deleteBook(@RequestParam Long idBook) {

		BookDTO bookDTOAux = new BookDTO();

		try {
			if(idBook != null) {

				bookDTOAux = bookService.findBookById(idBook);
				boolean delete = false;

				if(bookDTOAux != null) {

					bookService.deleteBook(bookDTOAux);
					delete =true;

					if (delete) {
						bookResponse.setMessage(EnumMessages.OK.getName());
						return ResponseEntity.status(HttpStatus.OK).body(bookResponse);
					} else {
						bookResponse.setMessage(EnumMessages.ERROR.getName());
						return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);
					}
				} else {
					bookResponse.setMessage(EnumMessages.ERROR.getName());
					return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);
				}

			} else {
				bookResponse.setMessage(EnumMessages.ERROR.getName());
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			bookResponse.setMessage(EnumMessages.ERROR.getName());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);		
		}
	}

	/**
	 * service to update a book
	 * 
	 * @param bookDTO
	 * @return
	 */
	@PostMapping(value="update")
	@ApiOperation(value = "Service to update books", notes = "update books")
	public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO) {

		List<BookDTO> books = new ArrayList<BookDTO>();
		BookDTO bookDTOAux = new BookDTO();

		try {
			bookDTOAux = bookService.updateBook(bookDTO);

			if (bookDTOAux != null) {

				books.add(bookDTOAux);
				bookResponse.setBooks(books);
				bookResponse.setMessage(EnumMessages.OK.getName());

				return ResponseEntity.status(HttpStatus.OK).body(bookResponse);

			} else {
				books.add(bookDTOAux);
				bookResponse.setBooks(books);
				bookResponse.setMessage(EnumMessages.ERROR.getName());

				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);

			}
		} catch (Exception e) {
			e.printStackTrace();
			bookResponse.setMessage(EnumMessages.ERROR.getName());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookResponse);		
		}

	}

}
