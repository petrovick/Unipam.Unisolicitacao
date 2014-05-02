package unisolicitacao.application.implementations;

import java.util.Set;

import unisolicitacao.application.generic.GenericApplication;
import unisolicitacao.application.interfaces.IPrioridadeApplication;
import unisolicitacao.business.Prioridade;

public class PrioridadeApplication extends GenericApplication<Prioridade, Short> implements IPrioridadeApplication
{

	@Override
	public Set<String> salvarPrioridade(Prioridade prioridade) {
		System.out.println("Prioridade no Application:" + prioridade.getDescricao());
		if(prioridade.getIdPrioridade() != null)
			return super.alterar(prioridade);
		else
			return super.inserir(prioridade);
	}
}
