package guru.springframework.services;

import java.util.List;

public interface CRUDservice<T> {
	
	List<?> listAll();
	
	T getById(Integer id);
	
	T saveOrUpdate(T domainObject);

	void delete(Integer id);
}
