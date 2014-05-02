package unisolicitacao.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import unisolicitacao.business.Solicitacao;

@FacesConverter(value = "solicitacaoConverter")
public class SolicitacaoConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2 == null || arg2.isEmpty())
			return null;
		try
		{
			Integer id = Integer.parseInt(arg2);
			Solicitacao sol = new Solicitacao();
			sol.setIdSolicitacao(id);
			return sol;
		}
		catch(Exception ex)
		{
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 == null || arg2.getClass() != Solicitacao.class)
			return null;
		Solicitacao sol = (Solicitacao) arg2;
		return sol.getIdSolicitacao().toString();
	}
	
	

}
