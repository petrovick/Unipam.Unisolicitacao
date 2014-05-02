package unisolicitacao.web.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import unisolicitacao.application.factory.ApplicationFactory;
import unisolicitacao.application.interfaces.ISetorApplication;
import unisolicitacao.application.interfaces.ISolicitacaoApplication;
import unisolicitacao.business.Setor;
import unisolicitacao.business.SistemaModulo;

@ManagedBean
@RequestScoped
public class SetorController
{
	private ISetorApplication setorApplication = ApplicationFactory.getInstance().getSetorApplication();
	private ISolicitacaoApplication solicitacaoApplication = ApplicationFactory.getInstance().getSituacaoApplication();
	private List<Setor> setores;
	private Setor setor;
	
	public List<Setor> todos()
	{
		List<Setor> ss = setorApplication.todos();
		for(Setor s : ss)
			System.err.println("AAMASetor: " + s.getNomeSetor());
		return ss;
	}
	
	public void setSetor(Setor setor)
	{
		this.setor = setor;
	}
	
	public Setor getSetor()
	{
		if(this.setor == null)
			setor = new Setor();
		return setor;
	}
	
	public List<Setor> getSetores()
	{
		return this.setores;
	}
	
	public void setSetores(List<Setor> setores)
	{
		this.setores = setores;
	}
	
	
	
	

}
