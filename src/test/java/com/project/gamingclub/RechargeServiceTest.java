package com.project.gamingclub;

import com.project.gamingclub.entity.members;
import com.project.gamingclub.entity.Recharge;
import com.project.gamingclub.repository.MemberRepository;
import com.project.gamingclub.repository.RechargeRepository;
import com.project.gamingclub.service.RechargeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RechargeServiceTest {

    @Mock
    private RechargeRepository rechargeRepo;

    @Mock
    private MemberRepository memberRepo;

    @InjectMocks
    private RechargeService rechargeService;

    private members member;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        member = new members("John Doe", 0, "9876543210");
        member.setId("1");
    }

    @Test
    void testDoRecharge_Success() {
        when(memberRepo.findById("1")).thenReturn(Optional.of(member));
        when(rechargeRepo.findByMemberIdAndDateBetween(eq("1"), any(), any())).thenReturn(List.of());
        when(memberRepo.save(any(members.class))).thenReturn(member);

        Recharge recharge = rechargeService.doRecharge("1", 200);

        assertNotNull(recharge);
        assertEquals(200, recharge.getAmount());
        verify(memberRepo, times(1)).save(any(members.class));
        verify(rechargeRepo, times(1)).save(any(Recharge.class));
    }

    @Test
    void testDoRecharge_FailsIfAmountTooLow() {
        when(memberRepo.findById("1")).thenReturn(Optional.of(member));

        Exception ex = assertThrows(RuntimeException.class, () -> {
            rechargeService.doRecharge("1", 50);
        });

        assertTrue(ex.getMessage().contains("minimum amount is 100"));
    }

    @Test
    void testDoRecharge_FailsIfMoreThan5PerDay() {
        when(memberRepo.findById("1")).thenReturn(Optional.of(member));
        when(rechargeRepo.findByMemberIdAndDateBetween(eq("1"), any(), any()))
                .thenReturn(List.of(
                        new Recharge("1", 100), new Recharge("1", 100),
                        new Recharge("1", 100), new Recharge("1", 100),
                        new Recharge("1", 100)
                ));

        Exception ex = assertThrows(RuntimeException.class, () -> {
            rechargeService.doRecharge("1", 200);
        });

        assertTrue(ex.getMessage().contains("Max 5 recharges per day"));
    }
}
