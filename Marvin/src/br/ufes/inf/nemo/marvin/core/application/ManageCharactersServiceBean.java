package br.ufes.inf.nemo.marvin.core.application;

import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.marvin.core.domain.Character;
import br.ufes.inf.nemo.marvin.core.persistence.CharacterDAO;

@Stateless
public class ManageCharactersServiceBean extends CrudServiceBean<Character> implements ManageCharactersService {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CharacterDAO characterDAO;
	
	@Override
	public BaseDAO<Character> getDAO() {
		return characterDAO;
	}

	@Override
	protected Character validate(Character newEntity, Character oldEntity) {
		// New characters must have their creation date set.
		Date now = new Date(System.currentTimeMillis());
		if (oldEntity == null) newEntity.setCreationDate(now);

		// All characters have their last update date set when persisted.
		newEntity.setLastUpdateDate(now);

		return newEntity;
	}
}
