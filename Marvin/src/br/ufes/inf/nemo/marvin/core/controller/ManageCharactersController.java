package br.ufes.inf.nemo.marvin.core.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.nemo.marvin.core.application.ManageCharactersService;
import br.ufes.inf.nemo.marvin.core.domain.Character;

@Named
@SessionScoped
public class ManageCharactersController extends CrudController<Character> {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageCharactersService manageCharactersService;
	
	@Override
	protected CrudService<Character> getCrudService() {
		return manageCharactersService;
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("manageCharacters.filter.byName", "name", getI18nMessage("msgsCore", "manageCharacters.text.filter.byName")));
	}

}
