package com.naver.idealproduction.bookmarket.service;

import com.naver.idealproduction.bookmarket.domain.Member;
import com.naver.idealproduction.bookmarket.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void register(Member member) {
        repository.add(member);
    }

    public boolean hasDuplicateID(String id) {
        Optional<Member> redundant = repository.getOne(id);
        return redundant.isPresent();
    }

}
