package com.kafein.devopz.adopt.repository;

import com.kafein.devopz.adopt.model.Adopt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptRepository extends JpaRepository<Adopt, Integer> {
}
