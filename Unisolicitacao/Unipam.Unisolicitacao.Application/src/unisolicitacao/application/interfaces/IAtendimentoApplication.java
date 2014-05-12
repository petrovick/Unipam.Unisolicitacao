package unisolicitacao.application.interfaces;

import java.util.List;
import java.util.Set;

import unisolicitacao.application.generic.IGenericApplication;
import unisolicitacao.business.Atendimento;

public interface IAtendimentoApplication extends IGenericApplication<Atendimento, Integer>
{
	public abstract Set<String> salvarAtendimento(Atendimento atendimento);
	public List<Atendimento> listarAtendimentoPorSolictacao(Integer solicitacao,String... joins);
}
