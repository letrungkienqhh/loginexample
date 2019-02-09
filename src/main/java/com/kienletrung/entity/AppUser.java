package com.kienletrung.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name ="App_User",uniqueConstraints= {@UniqueConstraint(name= "App_User_Uk",columnNames="User_Name")})
public class AppUser {
	@Id
	@GeneratedValue
	@Column(name="User_ID",nullable=false)
	private long id;
	@Column(name="User_name",length=50,nullable=false)
	private String userName;
	@Column(name="Encrypted_Password",length=50,nullable=false)
	private String encryptedPassWord;
	@Column(name="Enable",length=1,nullable=false)
	private boolean enable;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEncryptedPassWord() {
		return encryptedPassWord;
	}
	public void setEncryptedPassWord(String encryptedPassWord) {
		this.encryptedPassWord = encryptedPassWord;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
}
