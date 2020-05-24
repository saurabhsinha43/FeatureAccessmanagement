package com.moneylion.saurabhassesment.moneylionfirstassesmentone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moneylion.saurabhassesment.moneylionfirstassesmentone.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
