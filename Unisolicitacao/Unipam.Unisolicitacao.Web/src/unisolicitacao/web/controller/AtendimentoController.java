package unisolicitacao.web.controller;

import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import unisolicitacao.application.factory.ApplicationFactory;
import unisolicitacao.application.interfaces.IAtendimentoApplication;
import unisolicitacao.business.Atendimento;
import unisolicitacao.business.Solicitacao;
import unisolicitacao.business.Usuario;

@ManagedBean
@RequestScoped
public class AtendimentoController
{
	private Atendimento atendimento;
	private List<Atendimento> atendimentos;
	private Atendimento atendimentoSelecionado;
	
	private Solicitacao idSolicitacao;
	
	private IAtendimentoApplication atendimentoApplication = ApplicationFactory.getInstance().getAtendimentoApplication();
	
	/*
	public AtendimentoController()
	{
		atendimento.setSolicitacao(new Solicitacao());
		atendimento.setUsuario(new Usuario());
	}
	*/
	public void salvar()
	{
		Set<String> erros = atendimentoApplication.salvarAtendimento(atendimento);
		System.out.println("Data Início Atendimento:" + atendimento.getDataInicioAtendimento());
		if(erros.isEmpty())
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atendimento salvo ocm sucesso.", null));
			novo();
			atualizarTabela();
		}
		else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erros.iterator().next(), null));
	}
	
	public String imprime()
	{
		System.out.println("sssss: " + atendimento.getSolicitacao());
		return "index.xhtml";
	}
	
	public void editar()
	{
		atendimento = atendimentoSelecionado;
	}
	
	public void novo()
	{
		this.setAtendimento(new Atendimento());
	}
	
	public void excluir()
	{
		System.err.println("\n\n\n\n\n\nIdAtendimento " + atendimentoSelecionado.getIdAtendimento() + "\n\n\n");
		String erro = atendimentoApplication.excluir(atendimentoSelecionado.getIdAtendimento());
		if(erro == null)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atendimento excluido com sucesso.", null));
			novo();
			atualizarTabela();
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		}
	}
	
	public List<Atendimento> todos()
	{
		List<Atendimento> at = atendimentoApplication.todos();
		for(Atendimento s : at)
			System.out.println("AtendimentoID:" + s.getIdAtendimento());
		return at;
	}
	
	public void atualizarTabela()
	{
		atendimentos = atendimentoApplication.todos();
	}

	public Atendimento getAtendimento() {
		if(this.atendimento == null)
			atendimento = new Atendimento();
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento getAtendimentoSelecionado() {
		return atendimentoSelecionado;
	}

	public void setAtendimentoSelecionado(Atendimento atendimentoSelecionado) {
		this.atendimentoSelecionado = atendimentoSelecionado;
	}

	public Solicitacao  getIdSolicitacao() {
		System.out.println("Get o IdSolicitacao");
		return idSolicitacao;
	}

	public void setIdSolicitacao(Solicitacao  idSolicitacao) {
		System.out.println("Set o IdSolicitacao:" + idSolicitacao);
		this.idSolicitacao = idSolicitacao;
	}
	
	
	
}
