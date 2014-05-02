package unisolicitacao.application.factory;

import unisolicitacao.application.implementations.PrioridadeApplication;
import unisolicitacao.application.implementations.SolicitacaoApplication;
import unisolicitacao.application.interfaces.IPrioridadeApplication;
import unisolicitacao.application.interfaces.ISolicitacaoApplication;
import unisolicitacao.business.Solicitacao;

public class ApplicationFactory
{
	private static ApplicationFactory applicationFactory;
	
	public static ApplicationFactory getInstance()
	{
		if(applicationFactory == null)
			applicationFactory = new ApplicationFactory();
		return applicationFactory;
	}
	
	public ISolicitacaoApplication getSituacaoApplication()
	{
		return new SolicitacaoApplication();
	}
	
	public IPrioridadeApplication getPrioridadeApplication()
	{
		return new PrioridadeApplication();
	}

}
