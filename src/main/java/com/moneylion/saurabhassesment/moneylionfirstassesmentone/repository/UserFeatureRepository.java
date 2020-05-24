package com.moneylion.saurabhassesment.moneylionfirstassesmentone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moneylion.saurabhassesment.moneylionfirstassesmentone.model.Feature;
import com.moneylion.saurabhassesment.moneylionfirstassesmentone.model.User;
import com.moneylion.saurabhassesment.moneylionfirstassesmentone.model.UserFeature;
import com.moneylion.saurabhassesment.moneylionfirstassesmentone.model.UserFeatureId;

public interface UserFeatureRepository extends JpaRepository<UserFeature, UserFeatureId> {

	UserFeature findByUserAndFeature(User user, Feature feature);

}
