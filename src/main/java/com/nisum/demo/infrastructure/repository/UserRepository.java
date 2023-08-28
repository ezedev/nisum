package com.nisum.demo.infrastructure.repository;

import com.nisum.demo.domain.model.NisumUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<NisumUser, Long> {

    Boolean existsByEmail(String email);
}
