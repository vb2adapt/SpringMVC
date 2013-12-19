package com.webappspringmvc;

import java.util.List;



import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;




@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class PersonRegisterbean {
	
	@Persistent
	String firstName;
	@Persistent
	String LastName;
	@Persistent
	String emailId;
	@PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	String userName;
	@Persistent
	String password;
	@Persistent
	String country;
	
	PersonRegisterbean(String firstname,String lastName,String emailId,String userName,String password,String country){
		this.firstName=firstname;
		this.LastName=lastName;
		this.emailId=emailId;
		this.userName=userName;
		this.password=password;
		this.country=country;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getCountry() {
		return country;
	}
	
	
	public static void insert(String firstname,String lastName,String emailId,String userName,String password,String country){
		PersonRegisterbean entry = new PersonRegisterbean(firstname,lastName,emailId,userName,password,country);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(entry);
		pm.close();
		
	}
	public static List<PersonRegisterbean> getData(){
	PersistenceManager pm = PMF.get().getPersistenceManager();
	Query query=pm.newQuery(PersonRegisterbean.class);	
	List<PersonRegisterbean> entries=(List<PersonRegisterbean>) query.execute();
	return entries;
	
		
	}
	public static List<PersonRegisterbean> getEntriesbyname(String Name){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query=pm.newQuery(PersonRegisterbean.class);
		query.setFilter("userName == Name");
		query.declareParameters("String Name");
		List<PersonRegisterbean> entries=(List<PersonRegisterbean>)query.execute(Name);
		query.closeAll();
		return entries;
	}
	}
