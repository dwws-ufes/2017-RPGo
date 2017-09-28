package br.ufes.inf.nemo.marvin.core.domain;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;

import br.ufes.inf.nemo.marvin.people.domain.Person_;

public class Master_ extends Person_ {
	public static volatile SingularAttribute<Master, String> username;
	public static volatile SingularAttribute<Master, String> email;
	public static volatile SingularAttribute<Master, String> password;
	public static volatile SingularAttribute<Master, Date> creationDate;
	public static volatile SingularAttribute<Master, Date> lastUpdateDate;
	public static volatile SingularAttribute<Master, Date> lastLoginDate;
}
