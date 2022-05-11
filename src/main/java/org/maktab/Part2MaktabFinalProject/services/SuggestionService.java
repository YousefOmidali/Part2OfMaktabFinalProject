package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Suggestion;
import org.maktab.Part2MaktabFinalProject.repository.SuggestionRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuggestionService implements BaseService<Suggestion, Long> {
    SuggestionRepository suggestionRepository;

    @Override
    @Transactional
    public Suggestion saveOrUpdate(Suggestion suggestion) {
        return suggestionRepository.save(suggestion);
    }

    @Override
    @Transactional
    public List<Suggestion> findAll() {
        return suggestionRepository.findAll();
    }

    @Override
    @Transactional
    public Suggestion findById(Long id) {
        return suggestionRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        suggestionRepository.deleteById(id);
    }

    @Transactional
    public void suggestionsOfAnOrder(Long orderId) {
        suggestionRepository.findSuggestionsByOrder_IdOrderBySuggestedPriceAsc(orderId);
    }
}