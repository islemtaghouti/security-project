package com.example.springsecuritytuto.sec.reppo;

import com.example.springsecuritytuto.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String name);
}
