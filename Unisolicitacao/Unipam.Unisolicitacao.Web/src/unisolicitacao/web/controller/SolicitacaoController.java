package unisolicitacao.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
import unisolicitacao.application.implementations.AtendimentoApplication;
import unisolicitacao.application.interfaces.ISetorApplication;
import unisolicitacao.application.interfaces.ISistemaModuloApplication;
import unisolicitacao.application.interfaces.ISituacaoApplication;
import unisolicitacao.application.interfaces.ISolicitacaoApplication;
import unisolicitacao.application.interfaces.IUsuarioApplication;
import unisolicitacao.business.Anexo;
import unisolicitacao.business.Prioridade;
import unisolicitacao.business.Setor;
import unisolicitacao.business.SistemaModulo;
import unisolicitacao.business.Situacao;
import unisolicitacao.business.Solicitacao;
import unisolicitacao.business.Usuario;
@ManagedBean
@ViewScoped
public class SolicitacaoController implements Serializable
{
	private Solicitacao solicitacao;
	private Solicitacao solicitacaoSelecionada;
	private List<Solicitacao> solicitacoes;
	private Integer situacao;
	private ISolicitacaoApplication solicitacaoApplication = ApplicationFactory.getInstance().getSolicitacaoApplication();
	private ISituacaoApplication situacaoApplication = ApplicationFactory.getInstance().getSituacaoApplication();
	private IUsuarioApplication usuarioApplication = ApplicationFactory.getInstance().getUsuarioApplication();
	private ISistemaModuloApplication sistemaModuloApplication = ApplicationFactory.getInstance().getSistemaModuloApplication();
	private ISetorApplication setorApplication = ApplicationFactory.getInstance().getSetorApplication();
	
	public SolicitacaoController()
	{
		solicitacao = new Solicitacao();
		solicitacao.setAnexos(new ArrayList<Anexo>());
		solicitacao.setPrioridade(new Prioridade());
		solicitacao.setSetorByIdSetorDestino(new Setor());
		solicitacao.setSetorByIdSetorOrigem(new Setor());
		solicitacao.setSistemaModulo(new SistemaModulo());
		solicitacao.setSituacao(new Situacao());
		solicitacao.setUsuario(new Usuario());
	}
	public void salvar()
	{
		System.err.println("IDPrioridade: " + solicitacao.getPrioridade().getIdPrioridade());
		System.out.println("IdSetor Origem" + solicitacao.getSetorByIdSetorDestino());
		solicitacao.setSistemaModulo(sistemaModuloApplication.obter(123));
		solicitacao.setSituacao(situacaoApplication.obter((short)1));
		solicitacao.setSetorByIdSetorOrigem(setorApplication.obter(1));
		solicitacao.setUsuario(usuarioApplication.obter(1));
		solicitacao.setDataSolicitacao(new Date());
		
				
		System.out.println("Salvar solicitação");
		Set<String> erros = solicitacaoApplication.salvarSolicitacao(solicitacao);
		System.out.println("Solicitação não salva.");
		if(erros.isEmpty())
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitacao Salva com sucesso.", null));
			novo();
			atualizarTabela();
		}
		else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erros.iterator().next(), null));
	}
	
	public List<Solicitacao> acompanhar()
	{
		return solicitacaoApplication.todos("setorByIdSetorOrigem", "setorByIdSetorDestino", "anexos", "prioridade", "situacao");
	}
	
	public void novo()
	{
		this.solicitacao = new Solicitacao();
	}
	public List<Solicitacao> todosAvaliar()
	{
		return solicitacaoApplication.solicitacaoParaAvaliarOuPendente("setorByIdSetorOrigem", "setorByIdSetorDestino", "anexos", "prioridade", "situacao");
	}
	
	public List<Solicitacao> todos()
	{
		return solicitacaoApplication.todos();
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
	
	@PostConstruct
	public void inicializar()
	{
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id != null)
		{
			solicitacao = solicitacaoApplication.obter(Integer.parseInt(id), "setorByIdSetorOrigem", "setorByIdSetorDestino", "anexos", "prioridade", "situacao");
		}
	}
	
	public void detalhar()
	{
		try
		{
			FacesContext.getCurrentInstance().getExternalContext().redirect("detalhaSolicitacao.html?id=" + solicitacaoSelecionada.getIdSolicitacao());
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
//		return "detalhaSolicitacao.xhtml";
	}	
	public void gerarAtendimento(Solicitacao s)
	{
		s.setSituacao(situacaoApplication.obter((short)2));
		solicitacao = s;
		System.err.println("IdSituacao: " +s.getDescAssunto()+ " - "+ solicitacao.getSituacao().getIdSituacao());
	}
	
	public void recusarSolicitacao()
	{
		System.out.println("foi la ta.");
		/*
		solicitacao.setSituacao(situacaoApplication.obter((short)3));
		System.err.println("IdSituacao: " + solicitacao.getSituacao().getIdSituacao());
		solicitacaoApplication.alterar(solicitacao);
		System.out.println("Salvo!");
		
		System.out.println("External:" + FacesContext.getCurrentInstance().getExternalContext());
		
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		*/
	}
	
	public void salvarAtendimento()
	{
		System.out.println("teste");
	}
	public void editar()
	{
		solicitacao = solicitacaoSelecionada;
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
	public Solicitacao getSolicitacaoSelecionada()
	{
		return solicitacaoSelecionada;
	}
	public void setSolicitacaoSelecionada(Solicitacao solicitacaoSelecionada)
	{
		this.solicitacaoSelecionada = solicitacaoSelecionada;
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
	public Integer getSituacao() {
		return situacao;
	}
	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}
}
