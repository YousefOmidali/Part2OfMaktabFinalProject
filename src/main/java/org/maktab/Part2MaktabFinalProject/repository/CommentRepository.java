package org.maktab.Part2MaktabFinalProject.repository;

import org.maktab.Part2MaktabFinalProject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
