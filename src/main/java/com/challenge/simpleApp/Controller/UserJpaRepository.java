package com.challenge.simpleApp.Controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.simpleApp.Model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer>{

}
