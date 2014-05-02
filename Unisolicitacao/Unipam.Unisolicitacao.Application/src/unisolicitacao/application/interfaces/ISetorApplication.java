package unisolicitacao.application.interfaces;

import java.util.Set;

import unisolicitacao.application.generic.IGenericApplication;
import unisolicitacao.business.Prioridade;
import unisolicitacao.business.Setor;

public interface ISetorApplication extends IGenericApplication<Setor, Integer>
{
	public abstract Set<String> salvarSetor(Setor setor);
}
