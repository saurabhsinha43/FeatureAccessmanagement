package com.moneylion.saurabhassesment.moneylionfirstassesmentone.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserFeatureId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "email")
	private String email;
	@Column(name = "featurename")
	private String featureName;

	public UserFeatureId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((featureName == null) ? 0 : featureName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFeatureId other = (UserFeatureId) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (featureName == null) {
			if (other.featureName != null)
				return false;
		} else if (!featureName.equals(other.featureName))
			return false;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserFeatureId(String email, String featureName) {
		super();
		this.email = email;
		this.featureName = featureName;
	}

}
