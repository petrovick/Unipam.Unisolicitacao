package unisolicitacao.web.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import unisolicitacao.application.factory.ApplicationFactory;
import unisolicitacao.application.interfaces.ISituacaoApplication;
import unisolicitacao.business.Situacao;

@ManagedBean
@RequestScoped
public class SituacaoController
{
	private ISituacaoApplication situacaoApplication = ApplicationFactory.getInstance().getSituacaoApplication();

	public List<Situacao> todos()
	{
		List<Situacao> ss = situacaoApplication.todos();
		for(Situacao s : ss)
			System.err.println("AAMASetor: " + s.getDescricao());
		return ss;
	}
	

}
