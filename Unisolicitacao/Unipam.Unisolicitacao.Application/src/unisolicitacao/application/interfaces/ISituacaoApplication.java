package unisolicitacao.application.interfaces;

import java.util.Set;

import unisolicitacao.application.generic.IGenericApplication;
import unisolicitacao.business.Situacao;


public interface ISituacaoApplication extends IGenericApplication<Situacao, Short>
{
	public abstract Set<String> salvarSituacao(Situacao usuario);
}
