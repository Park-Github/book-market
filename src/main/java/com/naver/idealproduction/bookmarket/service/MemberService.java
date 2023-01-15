package com.naver.idealproduction.bookmarket.service;

import com.naver.idealproduction.bookmarket.domain.Member;
import com.naver.idealproduction.bookmarket.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        String password = member.getPassword();
        String hash = produceHash(password);
        repository.addPasswordHash(member, hash);
    }

    public boolean exists(String id) {
        Optional<Member> redundant = repository.getOne(id);
        return redundant.isPresent();
    }

    public String produceHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512/256");
            byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
            byte[] digest = md.digest(bytes);
            BigInteger bigInt = new BigInteger(1, digest);
            StringBuilder builder = new StringBuilder(bigInt.toString(16));

            while (builder.length() < 64) {
                builder.insert(0, '0');
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean matchPassword(String id, String password) {
        String hash = produceHash(password);
        return repository.matchHash(id, hash);
    }

}
