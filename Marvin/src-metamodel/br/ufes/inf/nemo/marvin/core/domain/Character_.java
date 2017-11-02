package br.ufes.inf.nemo.marvin.core.domain;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;

@Generated(value="Dali", date="2016-07-28T09:01:26.009-0300")
@StaticMetamodel(Character.class)
public class Character_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Character, String> playerName;
	public static volatile SingularAttribute<Character, String> name;
	public static volatile SingularAttribute<Character, String> impactQuote;
	public static volatile SingularAttribute<Character, String> traits;
	public static volatile SingularAttribute<Character, String> conditions;
	public static volatile SingularAttribute<Character, String> horror;
	public static volatile SingularAttribute<Character, String> conviction;
	public static volatile SingularAttribute<Character, String> trumps;
	public static volatile SingularAttribute<Character, Date> creationDate;
	public static volatile SingularAttribute<Character, Date> lastUpdateDate;
}
