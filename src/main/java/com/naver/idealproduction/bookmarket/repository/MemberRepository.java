package com.naver.idealproduction.bookmarket.repository;

import com.naver.idealproduction.bookmarket.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    void add(Member member);
    Optional<Member> getOne(String id);

}
