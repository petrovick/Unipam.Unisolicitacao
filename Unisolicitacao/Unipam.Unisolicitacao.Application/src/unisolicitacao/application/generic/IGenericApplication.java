package unisolicitacao.application.generic;

import java.util.List;
import java.util.Set;

public interface IGenericApplication<T, K>
{
	public abstract Set<String> inserir(T entity);
	
	public abstract Set<String> alterar(T entity);
	
	public abstract String excluir(K id);
	
	public abstract T obter(K id, String... joins);
	
	public abstract List<T> todos(String... joins);
}
