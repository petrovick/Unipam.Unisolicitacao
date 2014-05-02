package unisolicitacao.application.implementations;

import java.util.Set;

import unisolicitacao.application.generic.GenericApplication;
import unisolicitacao.application.interfaces.ISetorApplication;
import unisolicitacao.business.Setor;

public class SetorApplication extends GenericApplication<Setor, Integer> implements ISetorApplication
{
	@Override
	public Set<String> salvarSetor(Setor setor) {
		if(setor.getIdSetor() == null || setor.getIdSetor() == 0)
		{
			return super.inserir(setor);
		}
		else
		{
			return super.alterar(setor);
		}
	}
	
}
