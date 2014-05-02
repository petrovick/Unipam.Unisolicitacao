package unisolicitacao.data.generic;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IRepository<T>
{
	void save(T entity);
	void update(T entity);
	void delete(T entity);
	
	//Pesquisa 0 a N Objetos
	List<T> find(DetachedCriteria criteria);
	T single(DetachedCriteria criteria);

}
