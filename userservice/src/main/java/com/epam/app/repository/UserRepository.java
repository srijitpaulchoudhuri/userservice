package com.epam.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
