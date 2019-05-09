package com.sample.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.sample.model.Authority;
import com.sample.model.User;

@Entity
@Table(name = "user_authority")

public class UserAuthority implements Serializable {

	    private static final long serialVersionUID = 1L;
	    @Id
		@GeneratedValue(generator = "uuid2")
		@GenericGenerator(name = "uuid2", strategy = "uuid2")
		@Type(type = "pg-uuid")
		@Basic(optional = false)
		@Column(columnDefinition = "BINARY(16)", name = "id")
	    private UUID id;
	    @JoinColumn(name = "fkey_authority_id", referencedColumnName = "id")
	    @ManyToOne(optional = false)
	    private Authority fkeyAuthorityId;
	    @JoinColumn(name = "fkey_user_id", referencedColumnName = "id")
	    @ManyToOne(optional = false)
	    private User fkeyUserId;

	    public UserAuthority() {
	    }


	    public UserAuthority(UUID id) {
			this.id = id;
		}


		public UUID getId() {
			return id;
		}


		public void setId(UUID id) {
			this.id = id;
		}


		public Authority getFkeyAuthorityId() {
	        return fkeyAuthorityId;
	    }

	    public void setFkeyAuthorityId(Authority fkeyAuthorityId) {
	        this.fkeyAuthorityId = fkeyAuthorityId;
	    }

	    public User getFkeyUserId() {
	        return fkeyUserId;
	    }

	    public void setFkeyUserId(User fkeyUserId) {
	        this.fkeyUserId = fkeyUserId;
	    }

	}
	
	

