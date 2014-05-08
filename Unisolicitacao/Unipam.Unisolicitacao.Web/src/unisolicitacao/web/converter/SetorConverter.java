package unisolicitacao.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import unisolicitacao.business.Setor;
import unisolicitacao.business.Solicitacao;
@FacesConverter(value = "setorConverter", forClass = Setor.class)
public class SetorConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2 == null || arg2.isEmpty())
			return null;
		try
		{
			Integer id = Integer.parseInt(arg2);
			Setor sol = new Setor();
			sol.setIdSetor(id);
			return sol;
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 == null || arg2.getClass() != Setor.class)
			return null;
		
		Setor sol = (Setor) arg2;
		if(sol.getIdSetor() == null)
			return null;
		return sol.getIdSetor().toString();
	}
}