package com.likelion.jwt.domain.auth.service;

import com.likelion.jwt.domain.auth.dto.request.LoginRequest;
import com.likelion.jwt.domain.auth.dto.request.SignupRequest;
import com.likelion.jwt.domain.auth.dto.response.MemberInfoResponse;
import com.likelion.jwt.domain.auth.dto.response.TokenResponse;
import com.likelion.jwt.domain.member.entity.Member;
import com.likelion.jwt.domain.member.repository.MemberRepository;
import com.likelion.jwt.global.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public void signup(SignupRequest request) {
        // 빈칸
    }

    @Transactional(readOnly = true)
    public TokenResponse login(LoginRequest request) {
        // 빈칸
    }

    @Transactional(readOnly = true)
    public MemberInfoResponse getMyInfo(String username) {
        // 빈칸
    }
}
