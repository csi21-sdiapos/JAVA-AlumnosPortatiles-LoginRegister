package com.AlumnosPortatiles.project.app.entities;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "users", schema = "public")
public class User implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/******************************************* ATRIBUTOS *********************************************/
	@Id
	@Column(table = "users", name = "username", insertable = true, updatable = true, unique = true, nullable = false)
    private String username;

	@Column(table = "users", name = "password", insertable = true, updatable = true, unique = false, nullable = false)
    private String password;
    
	@Column(table = "users", name = "enabled", insertable = true, updatable = true, unique = false, nullable = false)
    private short enabled;
	/******************************************* RELACIONES *********************************************/
/*
	@OneToMany
	private List<Authority> authorities;
*/
	
	/******************************************* CONSTRUCTORES *********************************************/
    public User(String username, String password, short enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = (short)1;
		// this.authorities = new ArrayList<>();
	}

	public User() {
		super();
		this.enabled = (short)1;
		// this.authorities = new ArrayList<>();
	}

	
	/******************************************* GETTER Y SETTERS *********************************************/	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public short getEnabled() {
		return enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}
/*
	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

		
	/******************************************* MÉTODOS *********************************************/
	
	
	/******************************************* HashCode y Equals *********************************************/

	
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "\nUser [" + 
					", username=" + username + 
					", password=" + password + 
					", enabled=" + enabled + 
				"]";
	}
	
}