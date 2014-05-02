package unisolicitacao.application.interfaces;

import java.util.Set;

import unisolicitacao.application.generic.IGenericApplication;
import unisolicitacao.business.SistemaModulo;
import unisolicitacao.business.Solicitacao;

public interface ISistemaModuloApplication extends IGenericApplication<SistemaModulo, Integer>
{
	public abstract Set<String> salvarSistemaModulo(SistemaModulo sistemaModulo);
}
