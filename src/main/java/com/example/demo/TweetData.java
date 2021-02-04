package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class TweetData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column 
	private long id;
	
	@Column(length = 20, nullable = false)
	private String comment;
		
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	
	public String getComment() {return comment;}
	public void setComment(String comment) {this.comment = comment;}
	
	
	@ManyToOne
	private UserData userData;
    public UserData getUserData() {return userData;}
    public void setUserData(UserData userData) {this.userData = userData;}

}
