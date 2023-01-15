package com.naver.idealproduction.bookmarket.repository;

import com.naver.idealproduction.bookmarket.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    void add(Member member);
    void addPasswordHash(Member member, String hash);
    Optional<Member> getOne(String id);
    boolean matchHash(String id, String hash);

}
