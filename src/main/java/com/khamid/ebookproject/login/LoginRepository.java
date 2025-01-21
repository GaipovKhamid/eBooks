package com.khamid.ebookproject.login;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoginRepository extends CrudRepository<LoginEntity, Integer> {
    Optional<LoginEntity> findByEmail(String email);

    boolean existsByEmail(String username);
}
