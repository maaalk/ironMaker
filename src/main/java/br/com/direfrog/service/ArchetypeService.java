package br.com.direfrog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.direfrog.dao.ArchetypeDAO;
import br.com.direfrog.entity.Archetype;

@Service
public class ArchetypeService {

	@Autowired
	private ArchetypeDAO dao;
	
	public List<Archetype> findAll() {
		return dao.findAll();
	}

}
