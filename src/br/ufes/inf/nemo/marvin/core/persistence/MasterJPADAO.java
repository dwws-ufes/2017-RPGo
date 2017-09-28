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
import br.ufes.inf.nemo.marvin.core.domain.Master;
import br.ufes.inf.nemo.marvin.core.domain.Master_;

@Stateless
public class MasterJPADAO extends BaseJPADAO<Master> implements MasterDAO {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** The logger. */
	private static final Logger logger = Logger.getLogger(MasterJPADAO.class.getCanonicalName());

	/** The application's persistent context provided by the application server. */
	@PersistenceContext
	private EntityManager entityManager;

	/** @see br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO#getEntityManager() */
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/** @see br.ufes.inf.nemo.marvin.core.persistence.AcademicDAO#retrieveByEmail(java.lang.String) */
	@Override
	public Master retrieveByEmail(String email) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Retrieving the master whose e-mail is \"{0}\"...", email);

		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Master> cq = cb.createQuery(Master.class);
		Root<Master> root = cq.from(Master.class);

		// Filters the query with the email.
		cq.where(cb.equal(root.get(Master_.email), email));
		Master result = executeSingleResultQuery(cq, email);
		logger.log(Level.INFO, "Retrieve master by the email \"{0}\" returned \"{1}\"", new Object[] { email, result });
		return result;
	}
	
	public Master retrieveByUsername(String username) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Retrieving the master whose username is \"{0}\"...", username);

		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Master> cq = cb.createQuery(Master.class);
		Root<Master> root = cq.from(Master.class);

		// Filters the query with the email.
		cq.where(cb.equal(root.get(Master_.username), username));
		Master result = executeSingleResultQuery(cq, username);
		logger.log(Level.INFO, "Retrieve master by the username \"{0}\" returned \"{1}\"", new Object[] { username, result });
		return result;
	}
}
