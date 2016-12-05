package br.com.direfrog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import br.com.direfrog.entity.CharSheet;
import br.com.direfrog.exception.ControllerException;
import br.com.direfrog.exception.ServiceException;
import br.com.direfrog.service.CharSheetService;


@Controller(value="csCtrl")
public class CharSheetController {
	
	@Autowired
	private CharSheetService csService;
	
	private CharSheet cs = new CharSheet();
	
	public void salvar() throws ControllerException{
		try{
			csService.salvar(cs);
		}catch (ServiceException e){
			throw new ControllerException("Não salvou",e);
		}
		
	}

	public CharSheet getCs() {
		return cs;
	}

	public void setCs(CharSheet cs) {
		this.cs = cs;
	}
		
	

}
