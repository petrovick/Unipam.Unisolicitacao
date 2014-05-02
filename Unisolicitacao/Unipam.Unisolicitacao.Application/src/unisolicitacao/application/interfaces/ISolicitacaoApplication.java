package unisolicitacao.application.interfaces;

import java.util.List;
import java.util.Set;

import unisolicitacao.application.generic.IGenericApplication;
import unisolicitacao.business.Solicitacao;

public interface ISolicitacaoApplication extends IGenericApplication<Solicitacao, Integer>
{
	public abstract Set<String> salvarSolicitacao(Solicitacao solicitacao);
	public List<Solicitacao> listarPorSolicitacao(Integer numeroSolicitacao,String... joins);
}
