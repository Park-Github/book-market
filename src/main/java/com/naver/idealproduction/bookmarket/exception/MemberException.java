package com.naver.idealproduction.bookmarket.exception;

public class MemberException extends Throwable {

    public static final int DUPLICATED_ID = 0;

    private final int reason;

    public MemberException(int reason) {
        this.reason = reason;
    }

    public int getReason() {
        return this.reason;
    }

}
