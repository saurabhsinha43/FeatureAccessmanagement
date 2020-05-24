package com.moneylion.saurabhassesment.moneylionfirstassesmentone.model;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
	@Id
	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserFeature> userFeature;

	public User() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserFeature> getUserFeature() {
		return userFeature;
	}

	public void setUserFeature(Set<UserFeature> userFeature) {
		this.userFeature = userFeature;
	}

	public User(String email, UserFeature... userFeature) {
		this.email = email;
		for (UserFeature UserFeature : userFeature)
			UserFeature.setUser(this);
		this.userFeature = Stream.of(userFeature).collect(Collectors.toSet());
	}

}
