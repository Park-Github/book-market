package com.naver.idealproduction.bookmarket.repository;

import com.naver.idealproduction.bookmarket.domain.Member;
import com.naver.idealproduction.bookmarket.exception.MemberException;

import java.util.Optional;

public interface MemberRepository {

    void add(Member member) throws MemberException;
    Optional<Member> getOne(String id);

}
