package com.nisum.onboarding.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.GenericDao;

@SuppressWarnings("unchecked")
@Transactional
public abstract class HibernateDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> persistentClass;

	public HibernateDaoImpl() {
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		persistentClass = (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T newInstance) {
		getSession().save(newInstance);
	}

	@Override
	public void update(T transientObject) {
		getSession().update(transientObject);
	}

	@Override
	public void delete(T persistentObject) {
		getSession().delete(persistentObject);
	}
	
	@Override
	public void deleteById(ID id) {
		T persistentObject = (T) getSession().load(persistentClass, id);
		getSession().delete(persistentObject);
	}

	@Override
	@Transactional(readOnly = true)
	public T findById(ID id) {
		return (T) getSession().get(persistentClass, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		String namedQuery = persistentClass.getSimpleName() + ".findAll";
		return (List<T>) getSession().getNamedQuery(namedQuery).list();
	}

}
