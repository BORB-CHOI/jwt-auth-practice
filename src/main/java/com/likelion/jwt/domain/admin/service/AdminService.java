package com.likelion.jwt.domain.admin.service;

import com.likelion.jwt.domain.auth.dto.response.MemberInfoResponse;
import com.likelion.jwt.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<MemberInfoResponse> findAllMembers() {
        return memberRepository.findAll().stream()
                .map(member -> new MemberInfoResponse(member.getUsername(), member.getRole()))
                .toList();
    }
}
