package br.com.direfrog.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.validator.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.direfrog.entity.ArchetypeBenefit;
import br.com.direfrog.service.ArchetypeBenefitService;

@Component
public class ArchetypeBenefitConverter implements Converter{

	@Autowired
	ArchetypeBenefitService service;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try{
			return service.findById(Integer.parseInt(id));
		}catch (Exception e) {
			e.getStackTrace();
			return null;
		}	
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object archetypeBenefit) {
		if(archetypeBenefit instanceof ArchetypeBenefit){
			ArchetypeBenefit benefit = (ArchetypeBenefit) archetypeBenefit;
			return benefit.getId().toString();
		} else {
			return null;
		}
	}

}
