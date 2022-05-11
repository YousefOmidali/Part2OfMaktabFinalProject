package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Wallet;
import org.maktab.Part2MaktabFinalProject.repository.WalletRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WalletService implements BaseService<Wallet, Long> {
    WalletRepository walletRepository;

    @Override
    public Wallet saveOrUpdate(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet findById(Long id) {
        return walletRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        walletRepository.deleteById(id);
    }
}
