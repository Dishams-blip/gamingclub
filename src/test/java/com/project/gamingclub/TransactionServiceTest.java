package com.project.gamingclub;

import com.project.gamingclub.entity.Transactions;
import com.project.gamingclub.repository.TransactionRepository;
import com.project.gamingclub.service.TransactionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    @Mock
    private TransactionRepository txnRepo;

    @InjectMocks
    private TransactionService txnService;

    private Transactions txn;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        txn = new Transactions("member123", "game123");
        txn.setId("txn001");
    }

    @Test
    void testCreateTransaction() {
        when(txnRepo.save(any(Transactions.class))).thenReturn(txn);

        Transactions saved = txnService.create(txn);

        assertNotNull(saved);
        assertEquals("member123", saved.getMemberId());
        assertEquals("game123", saved.getGameId());
        verify(txnRepo, times(1)).save(any(Transactions.class));
    }

    @Test
    void testFindAllTransactions() {
        when(txnRepo.findAll()).thenReturn(List.of(txn));

        List<Transactions> txns = txnService.findAll();

        assertEquals(1, txns.size());
        assertEquals("txn001", txns.get(0).getId());
    }
}
