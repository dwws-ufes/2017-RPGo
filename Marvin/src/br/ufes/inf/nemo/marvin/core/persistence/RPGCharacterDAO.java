package br.ufes.inf.nemo.marvin.core.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.nemo.marvin.core.domain.RPGCharacter;

@Local
public interface RPGCharacterDAO extends BaseDAO<RPGCharacter> {
	RPGCharacter retrieveByPlayerName(String playerName) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException;
}
