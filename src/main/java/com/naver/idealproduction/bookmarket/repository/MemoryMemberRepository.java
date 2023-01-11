package com.naver.idealproduction.bookmarket.repository;

import com.naver.idealproduction.bookmarket.domain.Member;
import com.naver.idealproduction.bookmarket.exception.MemberException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private final List<Member> memberList = new ArrayList<>();

    @Override
    public void add(Member member) throws MemberException {
        validate(member);
        member.setId(member.getId().toLowerCase());
        memberList.add(member);
    }

    @Override
    public Optional<Member> getOne(String id) {
        return memberList.stream()
                .filter(m -> m.getId().equalsIgnoreCase(id))
                .findAny();
    }

    private void validate(Member member) throws MemberException {
        Optional<Member> redundant = getOne(member.getId());

        if (redundant.isPresent()) {
            throw new MemberException(MemberException.DUPLICATED_ID);
        }
    }

}
