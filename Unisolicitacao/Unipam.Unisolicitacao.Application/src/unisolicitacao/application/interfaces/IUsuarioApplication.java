package unisolicitacao.application.interfaces;

import java.util.Set;

import unisolicitacao.application.generic.IGenericApplication;
import unisolicitacao.business.Usuario;


public interface IUsuarioApplication extends IGenericApplication<Usuario, Integer>
{
	public abstract Set<String> salvarUsuario(Usuario usuario);
}
