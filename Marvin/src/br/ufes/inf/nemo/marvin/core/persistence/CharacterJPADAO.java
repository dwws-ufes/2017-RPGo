package br.ufes.inf.nemo.marvin.core.persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.nemo.marvin.core.domain.Character;
import br.ufes.inf.nemo.marvin.core.domain.Character_;

@Stateless
@PermitAll
public class CharacterJPADAO extends BaseJPADAO<Character> implements CharacterDAO {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** The logger. */
	private static final Logger logger = Logger.getLogger(CharacterJPADAO.class.getCanonicalName());

	/** The application's persistent context provided by the application server. */
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Character retrieveByPlayerName(String playerName)
			throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Retrieving the character whose player is \"{0}\"...", playerName);

		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Character> cq = cb.createQuery(Character.class);
		Root<Character> root = cq.from(Character.class);

		// Filters the query with the email.
		cq.where(cb.equal(root.get(Character_.playerName), playerName));
		Character result = executeSingleResultQuery(cq, playerName);
		logger.log(Level.INFO, "Retrieve character by player name \"{0}\" returned \"{1}\"", new Object[] { playerName, result });
		return result;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
