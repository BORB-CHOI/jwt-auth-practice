package com.likelion.jwt.domain.admin.controller;

import com.likelion.jwt.domain.admin.service.AdminService;
import com.likelion.jwt.domain.auth.dto.response.MemberInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/members")
    public ResponseEntity<List<MemberInfoResponse>> findAllMembers() {
        return ResponseEntity.ok(adminService.findAllMembers());
    }
}
