package unisolicitacao.application.implementations;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import unipam.utils.database.CriteriaInclude;
import unisolicitacao.application.generic.GenericApplication;
import unisolicitacao.application.interfaces.IAtendimentoApplication;
import unisolicitacao.business.Atendimento;
import unisolicitacao.business.Solicitacao;

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

	@Override
	public List<Atendimento> listarAtendimentoPorSolictacao(Integer solicitacao,String... joins)
	{
		DetachedCriteria criteria = DetachedCriteria.forClass(Atendimento.class);
		criteria.add(Restrictions.eq("solicitacao.idSolicitacao", solicitacao));
		CriteriaInclude.include(criteria, joins);
		return repository.find(criteria);		
	}
	
}
