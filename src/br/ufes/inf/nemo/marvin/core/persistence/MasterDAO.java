package br.ufes.inf.nemo.marvin.core.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.nemo.marvin.core.domain.Master;

@Local
public interface MasterDAO extends BaseDAO<Master> {
	
	Master retrieveByEmail(String email) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException;

	Master retrieveByUsername(String username) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException;

}
