package com.naver.idealproduction.bookmarket.Repos;

import com.naver.idealproduction.bookmarket.Domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepos {

    List<Member> list = new ArrayList<>();
    private static int member_identifier = 0;

    public void memoryAccess_saving(Member member) {
        list.add(member_identifier++, member);
    } // todo 저장소에 Member 객체를 저장하기 전에 중복검사를 한다

    public boolean memoryAccess_redundancy(String id) {
        long count = list.stream().filter( i -> i.getId().equals(id)).count();
        return count == 0L;
    }

//    public String getMemberId(Member member) {
//        String memberId = null;
//        Optional<Member> mem = list.stream()
//                                  .filter( i -> i.getId().equals(member.getId()))
//                                  .findAny();
//        memberId = mem.get().getId();
//        return memberId;
//    } //todo mem에 아무것도 없으면 nullPointException 발생.

}
