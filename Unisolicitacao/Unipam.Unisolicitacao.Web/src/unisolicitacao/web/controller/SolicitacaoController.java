package unisolicitacao.web.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;

import unisolicitacao.application.factory.ApplicationFactory;
import unisolicitacao.application.interfaces.ISolicitacaoApplication;
import unisolicitacao.business.Solicitacao;
@ManagedBean
@RequestScoped
public class SolicitacaoController
{
	private Solicitacao solicitacao;
	private List<Solicitacao> solicitacoes;

	private ISolicitacaoApplication solicitacaoApplication = ApplicationFactory.getInstance().getSituacaoApplication();
	
	
	public void salvar()
	{
		System.out.println("Salvar solicitação");
		Set<String> erros = solicitacaoApplication.salvarSolicitacao(solicitacao);
		if(erros.isEmpty())
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitacao Salva com sucesso.", null));
			novo();
			atualizarTabela();
		}
		else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erros.iterator().next(), null));
	}
	
	public void novo()
	{
		this.solicitacao = new Solicitacao();
	}
	
	public void excluir()
	{
		String erro = solicitacaoApplication.excluir(solicitacao.getIdSolicitacao());
		if(erro == null)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitacao Excluida com sucesso.", null));
			novo();
			atualizarTabela();
		}
	}
	
	public void atualizarTabela()
	{
		solicitacoes = solicitacaoApplication.todos();
	}
	
	public Solicitacao getSolicitacao()
	{
		if(this.solicitacao == null)
			solicitacao = new Solicitacao();
		return solicitacao;
	}
	
	public void setSolicitacao(Solicitacao solicitacao)
	{
		this.solicitacao = solicitacao;
	}
	
	
	public List<Solicitacao> getSolicitacoes()
	{
		if(this.solicitacoes == null)
			atualizarTabela();
		return solicitacoes;
	}
	
	public void setSolicitacoes(List<Solicitacao> solicitacoes)
	{
		this.solicitacoes = solicitacoes;
	}
}
