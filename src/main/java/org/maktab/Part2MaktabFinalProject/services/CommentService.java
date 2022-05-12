package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Comment;
import org.maktab.Part2MaktabFinalProject.repository.CommentRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService implements BaseService<Comment, Long> {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    @Transactional
    public Comment saveOrUpdate(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    @Transactional
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Transactional
    public List<Comment> commentsOfACustomer(Long id) {
        return commentRepository.findAllByCustomer_Id(id);
    }
}
