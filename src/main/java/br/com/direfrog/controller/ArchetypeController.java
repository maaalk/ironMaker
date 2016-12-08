package br.com.direfrog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.direfrog.entity.Archetype;
import br.com.direfrog.service.ArchetypeService;

@Controller
public class ArchetypeController {

	@Autowired
	private ArchetypeService service;
	
	private List<Archetype> archetypeList = new ArrayList<Archetype>();

	@PostConstruct
	public void init(){
		archetypeList = service.findAll();
	}
	
	public List<Archetype> getArchetypeList() {
		return archetypeList;
	}

	public void setArchetypeList(List<Archetype> archetypeList) {
		this.archetypeList = archetypeList;
	}

	
}
