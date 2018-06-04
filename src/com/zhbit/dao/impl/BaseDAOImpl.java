package com.zhbit.dao.impl;

import com.zhbit.entity.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zhbit.dao.BaseDAO;

import java.io.Serializable;
import java.util.List;

@Repository("baseDAO")
@SuppressWarnings("all")
public class BaseDAOImpl<T> implements BaseDAO<T> {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * ����
	 * @param o
	 * @return
	 */
	public Serializable save(T o) {
		return this.getCurrentSession().save(o);
	}

	/**
	 * ɾ��
	 * @param o
	 */
	public void delete(T o) {
		this.getCurrentSession().delete(o);
	}

	/**
	 * ����
	 * @param o
	 */
	public void update(T o) {
		this.getCurrentSession().update(o);
	}

	/**
	 * ����&����
	 * @param o
	 */
	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
	}

	/**
	 * ��hql���Ĳ�ѯ
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql) {
		return this.getCurrentSession().createQuery(hql).list();
	}

	/**
	 * ��sql&�����Ĳ�ѯ
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	/**
	 * ��sql&����(����)�Ĳ�ѯ
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	/**
	 * ��sql&�����Ĳ�ѯ&�����Ϸ�ҳ
	 * @param hql
	 * @param param
	 * @param pageBean
	 * @return
	 */
	public List<T> find(String hql, Object[] param, PageBean pageBean) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult(pageBean.getStart()).setMaxResults(pageBean.getPageSize()).list();
	}

	/**
	 * ��sql&����(����)�Ĳ�ѯ&�����Ϸ�ҳ
	 * @param hql
	 * @param param
	 * @param pageBean
	 * @return
	 */
	public List<T> find(String hql, List<Object> param, PageBean pageBean) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult(pageBean.getStart()).setMaxResults(pageBean.getPageSize()).list();
	}

	/**
	 * ��ȡһ����¼
	 * @param c
	 * @param id
	 * @return
	 */
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	/**
	 * ��ȡһ����¼����
	 * @param hql
	 * @param param
	 * @return
	 */
	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	/**
	 * ��ȡ�ܵļ�¼��
	 * @param hql
	 * @return
	 */
	public Long count(String hql) {
		return  (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
	}

	public Long count(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	/**
	 *  ��ȡ�ܵļ�¼��������
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	/**
	 * ִ��hql���
	 * @param hql
	 * @return
	 */
	public Integer executeHql(String hql) {
		return this.getCurrentSession().createQuery(hql).executeUpdate();
	}

	public Integer executeHql(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	/**
	 * ִ�д�������hql���
	 * @param hql
	 * @param param
	 * @return
	 */
	public Integer executeHql(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}

	/**
	 * �ϲ�
	 * @param o
	 */
	public void merge(T o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().merge(o);
	}

	/**
	 * ʵ��sql���
	 * @param sql
	 * @return
	 */
	public Integer executeSql(String sql) {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

}
