package com.alevel.trucking.repository;

import com.alevel.trucking.model.person.manager.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager findByUsername(String username);

    Manager findByEmail(String email);

}
