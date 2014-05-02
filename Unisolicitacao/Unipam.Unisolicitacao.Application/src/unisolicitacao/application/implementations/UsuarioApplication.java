package unisolicitacao.application.implementations;

import java.util.Set;

import unisolicitacao.application.generic.GenericApplication;
import unisolicitacao.application.interfaces.IUsuarioApplication;
import unisolicitacao.business.Usuario;

public class UsuarioApplication extends GenericApplication<Usuario, Integer> implements IUsuarioApplication
{

	@Override
	public Set<String> salvarUsuario(Usuario usuario) {
		System.out.println("Prioridade no Application:" + usuario.getNome());
		if(usuario.getIdUsuario() != null)
			return super.alterar(usuario);
		else
			return super.inserir(usuario);
	}
}
