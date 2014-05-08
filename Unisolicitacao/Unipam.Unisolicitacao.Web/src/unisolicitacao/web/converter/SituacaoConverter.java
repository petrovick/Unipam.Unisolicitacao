package unisolicitacao.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import unisolicitacao.business.Situacao;
@FacesConverter(value = "situacaoConverter", forClass = Situacao.class)
public class SituacaoConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2 == null || arg2.isEmpty())
			return null;
		try
		{
			Short id = Short.parseShort(arg2);
			Situacao sol = new Situacao();
			sol.setIdSituacao(id);
			return sol;
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 == null || arg2.getClass() != Situacao.class)
			return null;
		
		Situacao sit = (Situacao) arg2;
		if(sit.getIdSituacao() == null)
			return null;
		return sit.getIdSituacao().toString();
	}
}
