package com.web.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.BaseDao;



@org.springframework.stereotype.Repository
@Transactional(rollbackFor = Throwable.class, value = "transactionManager")
public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements
		BaseDao<T> {
	private final static String field_id = "id";
	protected Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
	public T findById(Serializable id) {
		Criteria criteria = getCurrentSession()
				.createCriteria(getDomainClass());
		criteria.add(Restrictions.eq(field_id, id));
		List<T> domainObjects = criteria.list();
		return domainObjects.isEmpty() ? null : domainObjects.get(0);
		
	}
	public List<T> findAll() {
		Criteria criteria = getCurrentSession()
				.createCriteria(getDomainClass());
		return criteria.list();
	}

	public List<T> findAllBy(Criteria criteria) {
		return criteria.list();
	}
	public List<T> findAllBy(String criteriaName, Object criteriaValue) {
		Criteria criteria = getCurrentSession()
				.createCriteria(getDomainClass());
		criteria.add(Restrictions.eq(criteriaName, criteriaValue));
		List<T> domainObjects = criteria.list();
		return domainObjects;
	}

	public void save(T object) {
		getCurrentSession().save(object);
	}

	public void update(T object) {
		getCurrentSession().update(object);
	}

	public void delete(T object) {
		getCurrentSession().delete(object);
	}

	public void evict(T object) {
		getCurrentSession().evict(object);
	}

	public void merge(T object) {
		getCurrentSession().merge(object);
	}

	public long getTotalCount() {
		Criteria criteria = getCurrentSession()
				.createCriteria(getDomainClass());
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.list().get(0);
	}

	public void persist(T object) {
		getCurrentSession().persist(object);
	}

	public abstract Class<T> getDomainClass();

}
