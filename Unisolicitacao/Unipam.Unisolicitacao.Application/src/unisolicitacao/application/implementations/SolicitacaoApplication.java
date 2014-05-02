package unisolicitacao.application.implementations;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;

import unipam.utils.database.CriteriaInclude;
import unisolicitacao.application.generic.GenericApplication;
import unisolicitacao.application.interfaces.ISolicitacaoApplication;
import unisolicitacao.business.Solicitacao;

public class SolicitacaoApplication extends GenericApplication<Solicitacao, Integer> implements ISolicitacaoApplication
{
	
	
	@Override
	public Set<String> salvarSolicitacao(Solicitacao solicitacao) {
		if(solicitacao.getIdSolicitacao() == null || solicitacao.getIdSolicitacao() == 0)
		{
			return super.inserir(solicitacao);
		}
		else
		{
			return super.alterar(solicitacao);
		}
	}

	@Override
	public List<Solicitacao> listarPorSolicitacao(Integer numeroSolicitacao, String... joins) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Solicitacao.class);
		criteria.add(Restrictions.eq("idSolicitacao", numeroSolicitacao));
		CriteriaInclude.include(criteria, joins);
		return repository.find(criteria);		
	}
	 
}
