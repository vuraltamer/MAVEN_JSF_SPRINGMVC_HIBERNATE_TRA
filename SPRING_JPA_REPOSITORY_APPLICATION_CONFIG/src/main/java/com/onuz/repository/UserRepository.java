package com.onuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.onuz.entity.UserEntity;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	}