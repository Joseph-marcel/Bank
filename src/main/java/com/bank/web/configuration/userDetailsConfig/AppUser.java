package com.bank.web.configuration.userDetailsConfig;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AppUser {

	@Id
	private String userId;
	private String username;
	@Email
	@Column(unique = true)
	private String email;
	private String password;
	private String confirmPassword;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<AppRole> roles;
}
