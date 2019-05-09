package com.sample.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import com.sample.model.Authority;

@Entity
@Table(name = "\"user\"", schema = "HRProcess")
public class User {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Type(type = "pg-uuid")
	@Basic(optional = false)
	@Column(columnDefinition = "BINARY(16)", name = "id")
	private UUID id;
	@Size(max = 30)
	@Column(name = "username")
	private String userName;
	@Size(max = 30)
	@Column(name = "email")
	private String email;
	@Size(max = 150)
	@Column(name = "password")
	private String password;
	@Column(name = "activated")
	private Boolean activated;
	@Size(max = 30)
	@Column(name = "activationKey")
	private String activationKey;
	@Size(max = 30)
	@Column(name = "resetpasswordkey")
	private String resetPasswordKey;
    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = @JoinColumn(name = "fkey_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fkey_authority_id"))
    private List<Authority> authorities;

	public User() {
	}

	public User(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public String getResetPasswordKey() {
		return resetPasswordKey;
	}

	public void setResetPasswordKey(String resetPasswordKey) {
		this.resetPasswordKey = resetPasswordKey;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	
}
