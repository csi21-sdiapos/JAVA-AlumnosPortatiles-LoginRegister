package com.AlumnosPortatiles.project.app.entities;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "authorities", schema = "public")
public class Authority implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/******************************************* ATRIBUTOS *********************************************/
	@Id
	@Column(table = "authorities", name = "id", insertable = false, updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(table = "authorities", name = "authority", insertable = true, updatable = true, unique = false, nullable = false)
    private String authority;
	
	/******************************************* RELACIONES *********************************************/
	@ManyToOne
    @JoinColumn(name = "username")
    private User user;

	
	/******************************************* CONSTRUCTORES *********************************************/
	public Authority(String authority, User user) {
		super();
		this.authority = authority;
		this.user = user;
	}

	public Authority() {
		super();
	}


	/******************************************* GETTER Y SETTERS *********************************************/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	/******************************************* MÉTODOS *********************************************/

	
	/******************************************* HashCode y Equals *********************************************/

	
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "\nAuthority [" + 
					", id=" + id + 
					", user=" + user.getUsername() +
					", authority=" + authority + 
				"]";
	}
	
}