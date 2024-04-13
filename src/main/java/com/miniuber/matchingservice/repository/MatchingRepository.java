package com.miniuber.matchingservice.repository;

import com.miniuber.matchingservice.entity.Matching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchingRepository extends JpaRepository<Matching, Long> {
}
