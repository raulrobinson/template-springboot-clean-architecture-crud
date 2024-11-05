package com.rasysbox.crudspringboot.adapter.repository;

import com.rasysbox.crudspringboot.adapter.persistence.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserJpaEntity, Long> {
}
