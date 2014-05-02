package unisolicitacao.application.generic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.lang.reflect.ParameterizedType;

import javax.validation.ConstraintViolation;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import unisolicitacao.data.factory.RepositoryFactory;
import unisolicitacao.data.generic.IRepository;

public class GenericApplication<T, K> implements IGenericApplication<T, K>
{
	protected IRepository<T> repository;

	public GenericApplication()
	{
		this.repository = RepositoryFactory.getInstance().getRepository();
	}
	
	@Override
	public Set<String> inserir(T entity) {
		Set<String> erros = new HashSet<String>();
		try
		{
			repository.save(entity);
		}catch(javax.validation.ConstraintViolationException e)
		{
			for(javax.validation.ConstraintViolation<?> violation : e.getConstraintViolations())
				erros.add(violation.getMessage());
			e.printStackTrace();
		}catch(Exception ex)
		{
			erros.add("Ocorreu um erro ao inserir. " + ex.getMessage());
			ex.printStackTrace();
		}
		return erros;
	}

	@Override
	public Set<String> alterar(T entity) {
		Set<String> erros = new HashSet<String>();
		try
		{
			repository.update(entity);
		}catch(javax.validation.ConstraintViolationException e)
		{
			for(javax.validation.ConstraintViolation<?> violation : e.getConstraintViolations())
				erros.add(violation.getMessage());
		}catch(Exception ex)
		{
			erros.add("Ocorreu um erro ao alterar. " + ex.getMessage());
			ex.printStackTrace();
		}
		return erros;
	}

	@Override
	public String excluir(K id) {
		String erro = null;
		try
		{
			System.err.println("\n\n\nId no Generic Application: " + id + "\n\n\n");
			T entity = obter(id);
			repository.delete(entity);
		}
		catch(ConstraintViolationException ex)
		{
			erro = "Este registro não pode ser excluído. Ele faz referência em outro registro.";
			ex.printStackTrace();
		}catch(Exception ex)
		{
			erro = ex.getMessage();
			ex.printStackTrace();
		}
		return erro;
	}

	@Override
	public T obter(K id, String... joins) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getType()).add(Restrictions.idEq(id));
		if(joins != null)
			for(String join : joins)
				criteria.setFetchMode(join, FetchMode.JOIN);
		return repository.single(criteria);
	}

	@Override
	public List<T> todos(String... joins)
	{
		DetachedCriteria criteria = DetachedCriteria.forClass(getType());
		if(joins != null)
			for(String join : joins)
				criteria.setFetchMode(join, FetchMode.JOIN);
		return repository.find(criteria);
	}
	
	public Class<T> getType()
	{
		ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) thisType.getActualTypeArguments()[0];
	}
	

}
