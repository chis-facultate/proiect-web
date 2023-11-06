package com.example.demo.repository;

import com.example.demo.persistence.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
