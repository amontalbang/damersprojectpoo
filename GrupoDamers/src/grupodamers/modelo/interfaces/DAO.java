package grupodamers.modelo.interfaces;

import java.util.ArrayList;

public interface DAO<T> {
	
	void add(T t) throws Exception;
	void delete(T t) throws Exception;
	T get(String id) throws Exception;
	ArrayList<T> getAll() throws Exception;
	
}
