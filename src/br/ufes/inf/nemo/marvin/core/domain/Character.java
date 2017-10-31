package br.ufes.inf.nemo.marvin.core.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.marvin.people.domain.Person;

/**
 * TODO: document this type.
 *
 * @author Vítor E. Silva Souza (vitorsouza@gmail.com)
 * @version 1.0
 */
@Entity
public class Character extends Person {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** Character's name. */
	@Basic
	@NotNull
	@Size(max = 30)
	private String name;
	
	/** Player */
	@OneToOne
	@PrimaryKeyJoinColumn(name="PLAYER_ID", referencedColumnName="PLR_ID")
	@NotNull
	private Player player;
	
	/** Race */
	@Basic
	@NotNull
	@Size(max = 15)
	private String race;
	
	/** Class */
	@Basic
	@NotNull
	@Size(max = 15)
	private String charClass;
	
	/** Character's age */
	@Basic
	private int age;
	
	/** Level */
	@Basic
	private int level = 1;
	
	@Basic
	private int xp = 0;
	
	@Basic
	private int strength;
	
	@Basic
	private int agility;
	
	@Basic
	private int intelligence;
	
	@Basic
	private int will;
	
	@Basic
	private int hp;
	
	@Basic
	private int mp;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}

	/**
	 * @return the charClass
	 */
	public String getCharClass() {
		return charClass;
	}

	/**
	 * @param charClass the charClass to set
	 */
	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the xp
	 */
	public int getXp() {
		return xp;
	}

	/**
	 * @param xp the xp to set
	 */
	public void setXp(int xp) {
		this.xp = xp;
	}

	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * @param strength the strength to set
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	/**
	 * @return the agility
	 */
	public int getAgility() {
		return agility;
	}

	/**
	 * @param agility the agility to set
	 */
	public void setAgility(int agility) {
		this.agility = agility;
	}

	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return intelligence;
	}

	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	/**
	 * @return the will
	 */
	public int getWill() {
		return will;
	}

	/**
	 * @param will the will to set
	 */
	public void setWill(int will) {
		this.will = will;
	}

	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the mp
	 */
	public int getMp() {
		return mp;
	}

	/**
	 * @param mp the mp to set
	 */
	public void setMp(int mp) {
		this.mp = mp;
	}
}
