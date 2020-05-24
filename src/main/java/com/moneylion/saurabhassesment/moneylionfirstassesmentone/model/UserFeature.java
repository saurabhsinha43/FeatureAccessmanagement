package com.moneylion.saurabhassesment.moneylionfirstassesmentone.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserFeature {

	@JsonIgnore
	@EmbeddedId
	private UserFeatureId userFeatureId = new UserFeatureId();

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("email")
	@JsonIgnore
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("featureName")
	@JsonIgnore
	private Feature feature;

	@Column(name = "canAccess")
	private boolean canAccess;

	public UserFeature() {
		super();
	}

	public UserFeature(Feature feature, boolean canAccess) {
		this.feature = feature;
		this.canAccess = canAccess;
	}

	public UserFeature(boolean canAccess) {
		super();
		this.canAccess = canAccess;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public boolean isCanAccess() {
		return canAccess;
	}

	public void setCanAccess(boolean canAccess) {
		this.canAccess = canAccess;
	}

}
