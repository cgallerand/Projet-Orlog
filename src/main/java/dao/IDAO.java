package dao;

import java.util.List;

public interface IDAO <T,K> {	
	
	public T findById(K id);
	public List<T> findAll();
	public void insert(T d);
	public void update(T d);
	public T save(T object);
	public void delete(T d);
	
}
