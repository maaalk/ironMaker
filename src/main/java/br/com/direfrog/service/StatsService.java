package br.com.direfrog.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.direfrog.dao.StatsDAO;
import br.com.direfrog.exception.DAOException;
import br.com.direfrog.exception.ServiceException;
import br.com.direfrog.entity.Stats;


@Service
public class StatsService {
	
	@Autowired
	StatsDAO statsDAO;
	
	
	public Stats save(Stats stats) throws ServiceException{
		try{
			return statsDAO.save(stats);			
		} catch (Exception e){
			throw new ServiceException("Não foi Possivel Salvar", e);
		}
	}
	
	@PostConstruct
	public void init(){
		
	}
	
	public void delete(Stats stats) throws ServiceException{
		try{
			statsDAO.delete(stats);
		}catch (DAOException e){
			throw new ServiceException("Não foi Possivel Excluir", e);
		}
	}
	
	public Stats findById(Integer id){
		return statsDAO.findById(id);
	}

}
