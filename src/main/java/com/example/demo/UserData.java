package com.example.demo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "userData")
public class UserData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column
	private long id;
	
	@NotBlank(message = "名前を入力してください")
    @Size(min = 4, message = "名前は4文字以上で入力してください")
	@Column(length = 20, nullable = false)
	private String name;
	
	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "メールアドレスを正しく入力してください")
	@Column(length = 50, nullable = false)
	private String mail;
	
	@Size(min = 4, message = "パスワードは4文字以上で入力してください")
	@Column(length = 30, nullable = false)
	private String pass;
		
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getMail() {return mail;}
	public void setMail(String mail) {this.mail = mail;}
	
	public String getPass() {return pass;}
	public void setPass(String pass) {this.pass = pass;}
	
	
	@OneToMany(mappedBy = "userData")
	private List<TweetData> tweetData;
	public List<TweetData> getTweetData() {return tweetData;}
	public void setTweetData(List<TweetData> tweetData) {this.tweetData = tweetData;}
}
