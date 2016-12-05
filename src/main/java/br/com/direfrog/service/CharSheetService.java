package br.com.direfrog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.direfrog.dao.CharSheetDAO;
import br.com.direfrog.exception.DAOException;
import br.com.direfrog.exception.ServiceException;
import br.com.direfrog.entity.CharSheet;


@Service
public class CharSheetService {
	
	@Autowired
	CharSheetDAO csDAO;
	
	
	public CharSheet save(CharSheet cs) throws ServiceException{
		try{
			return csDAO.save(cs);			
		} catch (Exception e){
			throw new ServiceException("Não foi Possivel Salvar", e);
		}
	}
	
	
	public void delete(CharSheet cs) throws ServiceException{
		try{
			csDAO.delete(cs);
		}catch (DAOException e){
			throw new ServiceException("Não foi Possivel Excluir", e);
		}
	}
	
	public CharSheet findById(Integer id){
		return csDAO.findById(id);
	}

}
