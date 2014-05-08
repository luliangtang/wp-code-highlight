package com.web.dao;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
/**
 * 
 * 
 *
 * @param <T>
 */
public interface BaseDao<T> {
	T findById(Serializable id);
	List<T> findAll();
	List<T> findAllBy(Criteria criteria);
	List<T> findAllBy(String criteriaName, Object criteriaValue);
	void save(T object);
	void update(T object);
	void delete(T object);
	void merge(T object);
	long getTotalCount();
	void evict(T object);
}
