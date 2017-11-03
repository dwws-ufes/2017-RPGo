package br.ufes.inf.nemo.marvin.core.application;

import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.marvin.core.domain.RPGCharacter;
import br.ufes.inf.nemo.marvin.core.persistence.RPGCharacterDAO;

@Stateless
public class ManageRPGCharactersServiceBean extends CrudServiceBean<RPGCharacter> implements ManageRPGCharactersService {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RPGCharacterDAO rpgCharacterDAO;
	
	@Override
	public BaseDAO<RPGCharacter> getDAO() {
		return rpgCharacterDAO;
	}

	@Override
	protected RPGCharacter validate(RPGCharacter newEntity, RPGCharacter oldEntity) {
		// New characters must have their creation date set.
		Date now = new Date(System.currentTimeMillis());
		if (oldEntity == null) newEntity.setCreationDate(now);

		// All characters have their last update date set when persisted.
		newEntity.setLastUpdateDate(now);

		return newEntity;
	}
}
