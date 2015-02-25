package com.nisum.onboarding.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dto.SerializableDto;

@SuppressWarnings("unchecked")
@Transactional
public abstract class AbstractHibernateDao<DTO extends SerializableDto, ID extends Serializable> implements
		GenericDao<DTO, ID> {

	private final Class<?> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;

	public AbstractHibernateDao(Class<?> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(DTO newInstance) {
		getSession().save(dtoToPersistent(newInstance));
	}

	@Override
	public void update(DTO transientObject) {
		getSession().update(dtoToPersistent(transientObject));
	}

	@Override
	public void delete(DTO persistentObject) {
		getSession().delete(dtoToPersistent(persistentObject));
	}

	@Override
	public void deleteById(ID id) {
		Object persistentObject = getSession().load(persistentClass, id);
		getSession().delete(persistentObject);
	}

	@Override
	@Transactional(readOnly = true)
	public DTO findById(ID id) {
		Object persistent = getSession().get(persistentClass, id); 
		return persistentToDto((Serializable) persistent);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DTO> findAll() {
		String namedQuery = getEntityName() + ".findAll";
		List<Serializable> results = getSession().getNamedQuery(namedQuery).list();
		return persistentsToDtos(results);
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected String getEntityName() {
		return persistentClass.getAnnotation(Entity.class).name();
	}

	protected abstract Serializable dtoToPersistent(DTO dto);

	protected abstract DTO persistentToDto(Serializable persistent);

	protected List<DTO> persistentsToDtos(List<Serializable> persistents) {
		List<DTO> dtos = new ArrayList<DTO>(persistents.size());
		
		for (Serializable persistent : persistents) {
			dtos.add(persistentToDto(persistent));
		}
		
		return dtos;
	}

}
