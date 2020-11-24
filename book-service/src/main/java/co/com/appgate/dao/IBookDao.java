package co.com.appgate.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.appgate.entities.Book;

/**
 * @author Alejandro Echeverri Restrepo
 * 
 * date 22/11/2020
 *
 */
public interface IBookDao extends CrudRepository<Book, Long> {

}
