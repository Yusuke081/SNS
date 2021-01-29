package com.example.demo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserData")
public class UserData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column
	private long id;
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(length = 30, nullable = false)
	private String pass;
		
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getPass() {return pass;}
	public void setPass(String pass) {this.pass = pass;}
	
	
	@OneToMany(mappedBy = "userData")
	private List<TweetData> tweetData;
	public List<TweetData> getTweetData() {return tweetData;}
	public void setTweetData(List<TweetData> tweetData) {this.tweetData = tweetData;}
}
