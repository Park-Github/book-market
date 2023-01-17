package com.naver.idealproduction.bookmarket.Service;

import com.naver.idealproduction.bookmarket.Domain.Member;
import com.naver.idealproduction.bookmarket.Repos.MemoryMemberRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final MemoryMemberRepos memoryMemberRepos;

    @Autowired
    public RegisterService(MemoryMemberRepos memoryMemberRepos) {
        this.memoryMemberRepos = memoryMemberRepos;
    }

    public void saveMemberInfo(Member member) {
        memoryMemberRepos.memoryAccess_saving(member);
    }
    public boolean checkIDRedundancy(String id) {
        return memoryMemberRepos.memoryAccess_redundancy(id);
    }
}