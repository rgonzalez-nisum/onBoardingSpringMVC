package com.nisum.onboarding.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
	
	public void save(T newInstance);
	
	public void update(T transientObject);
	
	public void delete(T persistentObject);
	
	public void deleteById(ID id);
	
	public List<T> findAll();
	
	public T findById(ID id);

}
