package br.ufes.inf.nemo.marvin.core.domain;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;

@Generated(value="Dali", date="2016-07-28T09:01:26.009-0300")
@StaticMetamodel(RPGCharacter.class)
public class RPGCharacter_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<RPGCharacter, String> playerName;
	public static volatile SingularAttribute<RPGCharacter, String> name;
	public static volatile SingularAttribute<RPGCharacter, String> impactQuote;
	public static volatile SingularAttribute<RPGCharacter, String> traits;
	public static volatile SingularAttribute<RPGCharacter, String> conditions;
	public static volatile SingularAttribute<RPGCharacter, String> horror;
	public static volatile SingularAttribute<RPGCharacter, Integer> conviction;
	public static volatile SingularAttribute<RPGCharacter, String> trumps;
	public static volatile SingularAttribute<RPGCharacter, Date> creationDate;
	public static volatile SingularAttribute<RPGCharacter, Date> lastUpdateDate;
}
