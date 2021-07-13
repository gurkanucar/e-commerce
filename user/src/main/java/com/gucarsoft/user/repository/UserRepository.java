package com.gucarsoft.user.repository;

import com.gucarsoft.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
