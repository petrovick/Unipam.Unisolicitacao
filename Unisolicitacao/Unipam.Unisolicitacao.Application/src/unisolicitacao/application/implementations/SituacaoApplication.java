package unisolicitacao.application.implementations;

import java.util.Set;

import unisolicitacao.application.generic.GenericApplication;
import unisolicitacao.application.interfaces.ISituacaoApplication;
import unisolicitacao.business.Situacao;

public class SituacaoApplication extends GenericApplication<Situacao, Short> implements ISituacaoApplication
{

	@Override
	public Set<String> salvarSituacao(Situacao situacao) {
		System.out.println("Prioridade no Application:" + situacao.getDescricao());
		if(situacao.getIdSituacao() != null)
			return super.alterar(situacao);
		else
			return super.inserir(situacao);
	}
}
