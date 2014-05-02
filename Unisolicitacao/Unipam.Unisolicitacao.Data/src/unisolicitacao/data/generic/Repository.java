package unisolicitacao.data.generic;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import unisolicitacao.data.util.HibernateUtil;

public class Repository<T> implements IRepository<T>
{
	public void save (T entity)
	{
		Session session = getSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void update(T entity)
	{
		Session session = getSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(T entity)
	{
		Session session = getSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<T> find(DetachedCriteria criteria)
	{
		Session session = getSession();
		List<T> list = criteria.getExecutableCriteria(session).list();
		session.close();
		return list;
	}
	
	public T single(DetachedCriteria criteria)
	{
		Session session = getSession();
		T entity = (T) criteria.getExecutableCriteria(session).uniqueResult();
		session.close();
		return entity;
	}
	
	public Session getSession()
	{
		return HibernateUtil.getSession();
	}
	

}
