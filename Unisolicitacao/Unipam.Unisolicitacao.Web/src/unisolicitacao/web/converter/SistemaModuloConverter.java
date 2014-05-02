package unisolicitacao.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import unisolicitacao.business.SistemaModulo;

@FacesConverter(value = "SistemaModuloConverter")
public class SistemaModuloConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2 == null || arg2.isEmpty())
			return null;
		try
		{
			Integer id = Integer.parseInt(arg2);
			SistemaModulo sis = new SistemaModulo();
			sis.setIdSistema(id);
			return sis;
		}
		catch(Exception ex)
		{
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 == null || arg2.getClass() != SistemaModulo.class)
			return null;
		SistemaModulo sis = (SistemaModulo) arg2;
		return sis.getIdSistema().toString();
	}
}
