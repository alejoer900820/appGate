package co.com.appgate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.appgate.dto.BookDTO;
import co.com.appgate.service.BookService;

/**
 * @author Alejandro Echeverri Restrepo
 * 
 * @date 22/11/2020
 *
 * this class contains all test of services
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/Data.sql")
@AutoConfigureTestDatabase
class TestValidApplicationTests {

	String pattern = "dd/MM/yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	
	public static final Long ID = 2L;	
	private static final String TITLE = "Doce cuentos peregrinos";
	private static final String GENRE = "Realismo mágico";
	private static final String AUTHOR = "Gabriel Gracía Marquez";
	private static final Double TOTAL_PRICE = 32000.5;
	private static final String PUBLISHER = "Norma";
	
	public static final Long ID_2 = 3L;	
	private static final String TITLE_2 = "The black cat";
	private static final String GENRE_2 = "Terror";
	private static final String AUTHOR_2 = "Edgar Allan Poe";
	private static final Double TOTAL_PRICE_2 = 30000.4;
	private static final String PUBLISHER_2 = "Norma";
	
	private static final Double TOTAL_PRICE_3 = 50000.0;
	
	@Autowired
	BookService bookService;
	
	@Test
	void testGetBook() {
		try {
			assertNotNull(bookService.getBook());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void testGetBookSize() {
		try {
			assertNotEquals(1,bookService.getBook().size());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void testCreateBook() {

		BookDTO bookDto = new BookDTO();

		try {

			bookDto.setId(ID);
			bookDto.setTitle(TITLE);
			bookDto.setGenre(GENRE);
			bookDto.setAuthor(AUTHOR);
			bookDto.setTotalprice(TOTAL_PRICE);
			bookDto.setPublisher(PUBLISHER);
			bookDto.setFecha(simpleDateFormat.parse("12/08/1990"));

			assertNotNull(bookService.createBook(bookDto));	

			bookDto.setId(ID_2);
			bookDto.setTitle(TITLE_2);
			bookDto.setGenre(GENRE_2);
			bookDto.setAuthor(AUTHOR_2);
			bookDto.setTotalprice(TOTAL_PRICE_2);
			bookDto.setPublisher(PUBLISHER_2);
			bookDto.setFecha(simpleDateFormat.parse("13/10/2000"));

			assertNotNull(bookService.createBook(bookDto));	

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	void testUpdateBook() {
		BookDTO bookDto = new BookDTO();

		try {
			bookDto.setId(ID);
			bookDto.setTitle(TITLE);
			bookDto.setGenre(GENRE);
			bookDto.setAuthor(AUTHOR);
			bookDto.setTotalprice(TOTAL_PRICE_3);
			bookDto.setPublisher(PUBLISHER);
			bookDto.setFecha(simpleDateFormat.parse("12/08/1955"));

			assertNotNull(bookService.updateBook(bookDto));	

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testFindBookById() {
		try {
			assertEquals(AUTHOR_2,bookService.findBookById(ID_2).getAuthor());	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testFindBookByIdNull() {
		try {
			assertNull(bookService.findBookById(ID_2));	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testDeleteBookBy() {
		try {
			BookDTO bookDTO = new BookDTO();
			bookDTO = bookService.findBookById(ID_2);
			bookService.deleteBook(bookDTO);
			
			assertEquals(5,bookService.getBook().size());	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
