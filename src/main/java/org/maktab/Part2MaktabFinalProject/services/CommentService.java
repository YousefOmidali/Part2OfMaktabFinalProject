package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Comment;
import org.maktab.Part2MaktabFinalProject.repository.CommentRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService implements BaseService<Comment, Long> {
    CommentRepository commentRepository;

    @Override
    public Comment saveOrUpdate(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> commentsOfACustomer(Long id) {
        return commentRepository.findAllByCustomer_Id(id);
    }
}