package br.ufes.inf.nemo.marvin.core.application;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.marvin.core.domain.RPGLocation;
import br.ufes.inf.nemo.marvin.core.persistence.RPGLocationDAO;

@Stateless
public class ManageRPGLocationsServiceBean extends CrudServiceBean<RPGLocation> implements ManageRPGLocationsService {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RPGLocationDAO rpgLocationDAO;
	
	@Override
	public BaseDAO<RPGLocation> getDAO() {
		return rpgLocationDAO;
	}
	
	@Override
	protected RPGLocation validate(RPGLocation newEntity, RPGLocation oldEntity) {
		// New locations must have their creation date set.
		Date now = new Date(System.currentTimeMillis());
		if (oldEntity == null) newEntity.setCreationDate(now);

		// All locations have their last update date set when persisted.
		newEntity.setLastUpdateDate(now);

		return newEntity;
	}
}
