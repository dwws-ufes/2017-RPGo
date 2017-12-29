package br.ufes.inf.nemo.marvin.core.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

@Entity
public class RPGLocation extends PersistentObjectSupport implements Comparable<RPGLocation> {
	private static final long serialVersionUID = 1L;

	@Basic
	@NotNull
	@Size(max = 200)
	private String name;
	
	@Basic
	@NotNull
	@Size(max = 2000)
	private String description;
	
	/** The timestamp of the moment this character was created. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	/** The last time the data about the character was updated. */
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date lastUpdateDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	public int compareTo(RPGLocation o) {
		// Compare the location's names
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
