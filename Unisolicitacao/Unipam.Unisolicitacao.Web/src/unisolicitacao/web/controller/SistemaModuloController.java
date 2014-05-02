package unisolicitacao.web.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import unisolicitacao.application.factory.ApplicationFactory;
import unisolicitacao.application.interfaces.ISistemaModuloApplication;
import unisolicitacao.business.Prioridade;
import unisolicitacao.business.SistemaModulo;

@ManagedBean
@RequestScoped
public class SistemaModuloController
{
	private ISistemaModuloApplication sistemaModuloApplication = ApplicationFactory.getInstance().getSistemaModuloApplication();
	
	private List<SistemaModulo> sistemaModulos;
	private SistemaModulo sistemaModulo;
	
	
	public List<SistemaModulo> todos()
	{
		return sistemaModuloApplication.todos();
	}
	
	
	public List<SistemaModulo> getSistemaModulos() {
		return sistemaModulos;
	}
	public void setSistemaModulos(List<SistemaModulo> sistemaModulos) {
		this.sistemaModulos = sistemaModulos;
	}
	public SistemaModulo getSistemaModulo()
	{
		if(this.sistemaModulo == null)
			sistemaModulo = new SistemaModulo();
		return sistemaModulo;
	}
	public void setSistemaModulo(SistemaModulo sistemaModulo) {
		this.sistemaModulo = sistemaModulo;
	}
	
	
	

}
