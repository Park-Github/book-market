package com.naver.idealproduction.bookmarket.Service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class HomeService {

    public String getServerT() {

        String pattern = "yyyy년 MM월 d일 a h시 m분 s초 z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("kr", "KR"));
        String serverTime = simpleDateFormat.format(new Date());

        return serverTime;
    }

}
