package br.ufes.inf.nemo.marvin.core.persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.nemo.marvin.core.domain.RPGLocation;
import br.ufes.inf.nemo.marvin.core.domain.RPGLocation_;

@Stateless
public class RPGLocationJPADAO extends BaseJPADAO<RPGLocation> implements RPGLocationDAO {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(AcademicJPADAO.class.getCanonicalName());
	
	@Override
	public RPGLocation retrieveByName(String name)
			throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Retrieving the RPGLocation whose e-mail is \"{0}\"...", name);

		// Constructs the query over the RPGLocation class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<RPGLocation> cq = cb.createQuery(RPGLocation.class);
		Root<RPGLocation> root = cq.from(RPGLocation.class);

		// Filters the query with the name.
		cq.where(cb.equal(root.get(RPGLocation_.name), name));
		RPGLocation result = executeSingleResultQuery(cq, name);
		logger.log(Level.INFO, "Retrieve RPGLocation by the name \"{0}\" returned \"{1}\"", new Object[] { name, result });
		return result;
	}

	/** The application's persistent context provided by the application server. */
	@PersistenceContext
	private EntityManager entityManager;

	/** @see br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO#getEntityManager() */
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
