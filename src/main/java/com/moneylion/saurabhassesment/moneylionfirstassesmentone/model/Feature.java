package com.moneylion.saurabhassesment.moneylionfirstassesmentone.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FEATURE")
public class Feature {
	@Id
	@Column(name = "featurename")
	private String featureName;

	@OneToMany(mappedBy = "feature", cascade = CascadeType.ALL)
	private Set<UserFeature> userFeature = new HashSet<>();

	public Feature() {
		super();
	}

	public Feature(String featureName) {
		this.featureName = featureName;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public Set<UserFeature> getUserFeature() {
		return userFeature;
	}

	public void setUserFeature(Set<UserFeature> userFeature) {
		this.userFeature = userFeature;
	}

}
