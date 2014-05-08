package unisolicitacao.web.controller;

import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import unisolicitacao.application.factory.ApplicationFactory;
import unisolicitacao.application.interfaces.IPrioridadeApplication;
import unisolicitacao.business.Prioridade;
import unisolicitacao.business.Setor;


@ManagedBean
@RequestScoped
public class PrioridadeController
{
	private Prioridade prioridade;
	private List<Prioridade> prioridades;
	private Prioridade prioridadeSelecionada;
	
	private IPrioridadeApplication prioridadeApplication = ApplicationFactory.getInstance().getPrioridadeApplication();
	
	public void salvar()
	{
		Set<String> erros = prioridadeApplication.salvarPrioridade(prioridade);
		
		
		System.out.println("Prioridade:" + prioridade.getDescricao());
		
		if(erros.isEmpty())
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Prioridade salvo com sucesso.", null));
			novo();
			atualizarTabela();
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, erros.iterator().next(), null));
		}
	}
	
	
	public void editar()
	{
		prioridade = prioridadeSelecionada;
	}
	
	
	public void novo()
	{
		this.setPrioridade(new Prioridade());
	}
	
	public void excluir()
	{
		System.err.println("\n\n\n\n\nIdPrioridade: " + prioridadeSelecionada.getIdPrioridade() + "\n\n\n");
		String erro = prioridadeApplication.excluir(prioridadeSelecionada.getIdPrioridade());
		if(erro == null)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Prioridade excluida com sucesso.", null));
			novo();
			atualizarTabela();
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		}
	}
	
	public List<Prioridade> todos()
	{
		List<Prioridade> ss = prioridadeApplication.todos();
		for(Prioridade s : ss)
			System.err.println("IdPrioridade:" + s.getIdPrioridade() + "AAMAPrioridade: " + s.getDescricao());
		return ss;
	}

	public Prioridade getPrioridadeNewIfNull()
	{
		if(prioridade == null)
			this.prioridade = new Prioridade();
		return prioridade;
		
	}
	
	public List<Prioridade> getPrioridades()
	{
		if(this.prioridades == null)
			atualizarTabela();
		return prioridades;
	}
	
	public void setPrioridades(List<Prioridade> prioridades)
	{
		this.prioridades = prioridades;
	}
	
	public void atualizarTabela()
	{
		prioridades = prioridadeApplication.todos();
	}
	
	public Prioridade getPrioridade()
	{
		if(this.prioridade == null)
			prioridade = new Prioridade();
		return prioridade;
	}
	
	public void setPrioridade(Prioridade prioridade)
	{
		this.prioridade = prioridade;
	}
	
	public void setPrioridadeSelecionada(Prioridade prioridadeSelecionada)
	{
		this.prioridadeSelecionada = prioridadeSelecionada;
	}
	
	public Prioridade getPrioridadeSelecionada()
	{
		return prioridadeSelecionada;
	}
}
