package unisolicitacao.application.factory;

import unisolicitacao.application.implementations.PrioridadeApplication;
import unisolicitacao.application.implementations.SetorApplication;
import unisolicitacao.application.implementations.SistemaModuloApplication;
import unisolicitacao.application.implementations.SituacaoApplication;
import unisolicitacao.application.implementations.SolicitacaoApplication;
import unisolicitacao.application.implementations.UsuarioApplication;
import unisolicitacao.application.interfaces.IPrioridadeApplication;
import unisolicitacao.application.interfaces.ISetorApplication;
import unisolicitacao.application.interfaces.ISistemaModuloApplication;
import unisolicitacao.application.interfaces.ISituacaoApplication;
import unisolicitacao.application.interfaces.ISolicitacaoApplication;
import unisolicitacao.application.interfaces.IUsuarioApplication;
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
	
	public ISolicitacaoApplication getSolicitacaoApplication()
	{
		return new SolicitacaoApplication();
	}
	
	public IPrioridadeApplication getPrioridadeApplication()
	{
		return new PrioridadeApplication();
	}
	
	public ISetorApplication getSetorApplication()
	{
		return new SetorApplication();
	}
	
	public ISistemaModuloApplication getSistemaModuloApplication()
	{
		return new SistemaModuloApplication();
	}
	
	public ISituacaoApplication getSituacaoApplication()
	{
		return new SituacaoApplication();
	}
	
	public IUsuarioApplication getUsuarioApplication()
	{
		return new UsuarioApplication();
	}
}
