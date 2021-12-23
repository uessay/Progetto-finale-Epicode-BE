package it.epicode.be05.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T> {
	void create(T entity);

	T readById(long id);

	Page<T> readAll(Pageable pageable);

	void update(long id, T entity);

	void delete(long id);
}

