package unisolicitacao.data.factory;

import unisolicitacao.data.generic.IRepository;
import unisolicitacao.data.generic.Repository;

public class RepositoryFactory<T>
{
	private static RepositoryFactory repositoryFactory;
	public RepositoryFactory()
	{
		
	}
	
	public static RepositoryFactory getInstance()
	{
		if(repositoryFactory == null)
			repositoryFactory = new RepositoryFactory();
		return repositoryFactory;
	}
	
	public IRepository<T> getRepository()
	{
		return new Repository<T>();
	}

}
