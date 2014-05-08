package unisolicitacao.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import unisolicitacao.business.Prioridade;

@FacesConverter(value = "prioridadeConverter", forClass = Prioridade.class)
public class PrioridadeConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
	{
		if(arg2 == null || arg2.isEmpty())
			return null;
		try
		{
			Short id = Short.parseShort(arg2);
			Prioridade pri = new Prioridade();
			pri.setIdPrioridade(id);
			return pri;
		}
		catch(Exception ex)
		{
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 == null || arg2.getClass() != Prioridade.class)
			return null;
		Prioridade pri = (Prioridade) arg2;
		if(pri.getIdPrioridade() == null)
			return null;
		System.out.println("Arg2:" + pri.getIdPrioridade());
		return pri.getIdPrioridade().toString();
	}
	
	

}
