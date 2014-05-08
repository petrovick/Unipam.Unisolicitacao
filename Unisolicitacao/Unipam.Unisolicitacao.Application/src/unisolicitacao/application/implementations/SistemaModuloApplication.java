package unisolicitacao.application.implementations;

import java.util.Set;

import unisolicitacao.application.generic.GenericApplication;
import unisolicitacao.application.interfaces.ISistemaModuloApplication;
import unisolicitacao.business.SistemaModulo;

public class SistemaModuloApplication extends GenericApplication<SistemaModulo, Integer> implements ISistemaModuloApplication
{
	@Override
	public Set<String> salvarSistemaModulo(SistemaModulo sistemaModulo) {
		if(sistemaModulo.getIdSistema() == null || sistemaModulo.getIdSistema() == 0)
			return super.inserir(sistemaModulo);
		else
			return super.alterar(sistemaModulo);
	}

}
