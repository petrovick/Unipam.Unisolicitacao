package unisolicitacao.application.implementations;

import java.util.Set;

import unisolicitacao.application.generic.GenericApplication;
import unisolicitacao.application.interfaces.IAtendimentoApplication;
import unisolicitacao.business.Atendimento;

public class AtendimentoApplication extends GenericApplication<Atendimento, Integer> implements IAtendimentoApplication
{
	public Set<String> salvarAtendimento(Atendimento atendimento)
	{
		System.out.println("IDAtendimento no Application:" + atendimento.getIdAtendimento());
		if(atendimento.getIdAtendimento() != null)
			return super.alterar(atendimento);
		else
			return super.inserir(atendimento);
	}

}
