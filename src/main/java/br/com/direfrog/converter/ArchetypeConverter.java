package br.com.direfrog.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.direfrog.entity.Archetype;
import br.com.direfrog.entity.ArchetypeBenefit;
import br.com.direfrog.service.ArchetypeService;

@Component
public class ArchetypeConverter implements Converter{

	@Autowired
	private ArchetypeService service;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String archetype) {
		try{			
			System.out.println(archetype);
			String s = (String) archetype;
			//return (Archetype) archetype;
			Archetype arch = service.findByName(s);
			return arch;
		}catch (Exception e) {
			e.getStackTrace();
			return null;
		}	

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object archetype) {
		System.out.println("CONVERTER");
		if(archetype instanceof ArchetypeBenefit){
			Archetype arch = (Archetype) archetype;
			return arch.getId().toString();
		} else {
			return null;
		}
	}

}
