package br.ufes.inf.nemo.marvin.core.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.nemo.marvin.core.application.ManageRPGCharactersService;
import br.ufes.inf.nemo.marvin.core.domain.RPGCharacter;

@Named
@SessionScoped
public class ManageRPGCharactersController extends CrudController<RPGCharacter> {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageRPGCharactersService manageRPGCharactersService;
	
	@Override
	protected CrudService<RPGCharacter> getCrudService() {
		return manageRPGCharactersService;
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("manageRPGCharacters.filter.byName", "name", getI18nMessage("msgsCore", "manageRPGCharacters.text.filter.byName")));
	}

}
