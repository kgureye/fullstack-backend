package com.codewithkani.fullstackbackend.repository;

import com.codewithkani.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
