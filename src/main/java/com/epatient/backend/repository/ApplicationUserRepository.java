package com.epatient.backend.repository;

import com.epatient.backend.model.dao.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
    List<ApplicationUser> findAllByUsernameContainingIgnoreCase(String username);
}
