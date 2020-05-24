package com.moneylion.saurabhassesment.moneylionfirstassesmentone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneylion.saurabhassesment.moneylionfirstassesmentone.model.DataModel;
import com.moneylion.saurabhassesment.moneylionfirstassesmentone.model.Feature;
import com.moneylion.saurabhassesment.moneylionfirstassesmentone.model.User;
import com.moneylion.saurabhassesment.moneylionfirstassesmentone.model.UserFeature;
import com.moneylion.saurabhassesment.moneylionfirstassesmentone.repository.FeatureRepository;
import com.moneylion.saurabhassesment.moneylionfirstassesmentone.repository.UserFeatureRepository;
import com.moneylion.saurabhassesment.moneylionfirstassesmentone.repository.UserRepository;

@RestController
@RequestMapping(path = "/feature")
public class PostController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FeatureRepository featureRepository;
	@Autowired
	private UserFeatureRepository userFeatureRepository;

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createFeature(@RequestBody DataModel dataModel) {
		String email = dataModel.getEmail();
		String featureName = dataModel.getFeatureName();
		boolean canAccess = dataModel.isEnable();
		System.out.println("featureName:::" + featureName);
		System.out.println("email:::" + email);
		System.out.println("enable:::" + canAccess);

		Feature feature = new Feature(featureName);
		UserFeature existingUserFeature = userFeatureRepository.findByUserAndFeature(new User(email), feature);

		if (existingUserFeature == null) {
			featureRepository.save(feature);
			UserFeature userFeature = new UserFeature(feature, canAccess);
			User user = new User(email, userFeature);
			userRepository.save(user);
		} else {
			existingUserFeature.setCanAccess(canAccess);
			userFeatureRepository.save(existingUserFeature);
		}

		return ResponseEntity.ok("");
	}

	@GetMapping(params = { "email", "featureName" }, produces = "application/json")
	public UserFeature getProductByOwnerEmailID(@RequestParam String email, @RequestParam String featureName) {
		System.out.println("email:::" + email);
		System.out.println("featureName:::" + featureName);
		UserFeature userFeature = userFeatureRepository.findByUserAndFeature(new User(email), new Feature(featureName));
		if (userFeature == null) {
			userFeature = new UserFeature(false);
		}
		return userFeature;
	}

}
