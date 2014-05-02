package unisolicitacao.application.interfaces;

import java.util.Set;

import unisolicitacao.application.generic.IGenericApplication;
import unisolicitacao.business.Prioridade;

public interface IPrioridadeApplication extends IGenericApplication<Prioridade, Short>
{
	public abstract Set<String> salvarPrioridade(Prioridade prioridade);

}
