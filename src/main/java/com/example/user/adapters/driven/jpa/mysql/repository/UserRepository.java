package com.example.user.adapters.driven.jpa.mysql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.adapters.driven.jpa.mysql.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

    Optional<UserEntity> findByEmail(String email);
}
