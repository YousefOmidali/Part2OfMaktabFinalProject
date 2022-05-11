package org.maktab.Part2MaktabFinalProject.repository;

import org.maktab.Part2MaktabFinalProject.entity.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubServiceRepository extends JpaRepository<SubService,Long> {
}
