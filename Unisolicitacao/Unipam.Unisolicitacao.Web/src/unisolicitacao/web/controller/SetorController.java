package unisolicitacao.web.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import unisolicitacao.business.Setor;

@ManagedBean
@RequestScoped
public class SetorController
{
	private List<Setor> setores;
	private Setor setor;
	
	public void setSetor(Setor setor)
	{
		this.setor = setor;
	}
	
	public Setor getSetor()
	{
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
