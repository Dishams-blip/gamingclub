package com.project.gamingclub;

import com.project.gamingclub.entity.members;
import com.project.gamingclub.repository.MemberRepository;
import com.project.gamingclub.service.MemberService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateMember() {
        members m = new members("John", 0, "9876543210");
        when(memberRepository.save(any(members.class))).thenReturn(m);

        members saved = memberService.create(m);
        assertEquals("John", saved.getName());
    }

    @Test
    void testFindById() {
        members m = new members("John", 100, "9876543210");
        m.setId("abc123");
        when(memberRepository.findById("abc123")).thenReturn(Optional.of(m));

        members found = memberService.findById("abc123");
        assertEquals("John", found.getName());
    }
}
