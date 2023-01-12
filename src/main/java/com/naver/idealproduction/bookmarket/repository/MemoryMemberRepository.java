package com.naver.idealproduction.bookmarket.repository;

import com.naver.idealproduction.bookmarket.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private final List<Member> memberList = new ArrayList<>();

    @Override
    public void add(Member member) {
        member.setId(member.getId().toLowerCase());
        memberList.add(member);
    }

    @Override
    public Optional<Member> getOne(String id) {
        return memberList.stream()
                .filter(m -> m.getId().equalsIgnoreCase(id))
                .findAny();
    }

}
