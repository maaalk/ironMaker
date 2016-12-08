package br.com.direfrog.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.direfrog.dao.RaceDAO;
import br.com.direfrog.exception.DAOException;
import br.com.direfrog.exception.ServiceException;
import br.com.direfrog.entity.Race;


@Service
public class RaceService {
	
	@Autowired
	RaceDAO raceDAO;
	
	
	public Race save(Race race) throws ServiceException{
		try{
			return raceDAO.save(race);			
		} catch (Exception e){
			throw new ServiceException("Não foi Possivel Salvar", e);
		}
	}
	
	@PostConstruct
	public void init(){
		
	}
	
	public void delete(Race race) throws ServiceException{
		try{
			raceDAO.delete(race);
		}catch (DAOException e){
			throw new ServiceException("Não foi Possivel Excluir", e);
		}
	}
	
	public Race findById(Integer id){
		return raceDAO.findById(id);
	}

}
