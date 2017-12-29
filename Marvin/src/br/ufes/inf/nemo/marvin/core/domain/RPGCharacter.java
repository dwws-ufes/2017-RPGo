package br.ufes.inf.nemo.marvin.core.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import org.primefaces.model.UploadedFile;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

@Entity
public class RPGCharacter extends PersistentObjectSupport implements Comparable<RPGCharacter> {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	/** The player's name. */
	@Basic
	@NotNull
	@Size(max = 100)
	private String playerName;
	
	/** The character's name. */
	@Basic
	@NotNull
	@Size(max = 100)
	private String name;

	/** The character's impact quotation. */
	@Basic
	@NotNull
	@Size(max = 200)
	private String impactQuote;
	
	/** The character's traits. */
	@Basic
	@NotNull
	@Size(max = 2000)
	private String traits;
	
	/** The character's conditions. */
	@Basic
	@Size(max = 2000)
	private String conditions;
	
	/** The character's horror. */
	@Basic
	@NotNull
	private String horror;
	
	/** The character's conviction. */
	@Basic
	@NotNull
	private Integer conviction;
	
	/** The character's trumps. */
	@Basic
	@NotNull
	@Size(max = 2000)
	private String trumps;
	
	/** The timestamp of the moment this character was created. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	/** The last time the data about the character was updated. */
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date lastUpdateDate;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImpactQuote() {
		return impactQuote;
	}

	public void setImpactQuote(String impactQuote) {
		this.impactQuote = impactQuote;
	}

	public String getTraits() {
		return traits;
	}

	public void setTraits(String traits) {
		this.traits = traits;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	
	public String getHorror() {
		return horror;
	}

	public void setHorror(String horror) {
		this.horror = horror;
	}
	
	public Integer getConviction() {
		return conviction;
	}

	public void setConviction(Integer conviction) {
		this.conviction = conviction;
	}

	public String getTrumps() {
		return trumps;
	}

	public void setTrumps(String trumps) {
		this.trumps = trumps;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	@Override
	public int compareTo(RPGCharacter o) {
		// Compare the persons' names
		if (name == null) return 1;
		if (o.name == null) return -1;
		int cmp = name.compareTo(o.name);
		if (cmp != 0) return cmp;

		// If it's the same name, check if it's the same entity.
		return uuid.compareTo(o.uuid);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
