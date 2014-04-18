package com.fn.fornow.common.orm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import com.fn.fornow.common.bean.Page;
import com.fn.fornow.common.orm.PropertyFilter;
import com.fn.fornow.common.orm.entity.BaseEntity;

/**
 * @author Simon Lv
 * @since 2012-5-29
 */
public interface BaseDao<T extends BaseEntity> {

	T get(Serializable id);
	
	void insert(Object entity);

	void save(T entity);

	void merge(T entity);

	void update(T entity);

	void saveOrUpdate(T entity);

	void delete(T entity);

	void delete(Serializable id);
	
	void evict(Object... entities);

	void clear();

	List<T> findAll();

	List<T> findDatas(String propertyName, Object value);

	List<T> findPage(Page page);

	List<T> findPage(Object object, Page page);

	List<T> findDatas(String propertyName, Object value, Page page);

	List<T> findPage(DetachedCriteria detachedCriteria, Page page);

	List<T> findPage(final Page page, final List<PropertyFilter> filters);
	
	Long count(String propertyName, Object value);

	long countCriteriaResult(final Criteria criteria);

	DetachedCriteria createDetachedCriteria();

	DetachedCriteria createDetachedCriteria(String alias);

}