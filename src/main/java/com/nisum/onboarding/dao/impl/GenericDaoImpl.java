package com.nisum.onboarding.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.GenericDao;

@SuppressWarnings("unchecked")
@Transactional
public abstract class GenericDaoImpl<T, ID extends Serializable> extends HibernateDaoSupport
		implements GenericDao<T, ID> {

	private Class<T> persistentClass;

	public GenericDaoImpl() {
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		persistentClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public void save(T newInstance) {
		getHibernateTemplate().save(newInstance);
	}

	@Override
	public void update(T transientObject) {
		getHibernateTemplate().update(transientObject);
	}

	@Override
	public void delete(T persistentObject) {
		getHibernateTemplate().delete(persistentObject);
	}
	
	@Override
	public void deleteById(ID id) {
		T persistentObject = getHibernateTemplate().load(persistentClass, id);
		delete(persistentObject);
	}

	@Override
	@Transactional(readOnly = true)
	public T findById(ID id) {
		return getHibernateTemplate().get(persistentClass, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return (List<T>) getHibernateTemplate().findByNamedQuery(
				persistentClass.getSimpleName() + ".findAll");
	}

}
