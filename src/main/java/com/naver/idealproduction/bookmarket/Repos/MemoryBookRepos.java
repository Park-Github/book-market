package com.naver.idealproduction.bookmarket.Repos;

import com.naver.idealproduction.bookmarket.Domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemoryBookRepos {

    private final List<Book> list;

    public MemoryBookRepos(List<Book> list) {
        this.list = list;
        inputBookDB();
    }

    public void memoryAccess_saving(Book book) {
        list.add(book);
    }

    public List<Book> memoryAccess_copyDB() {
        return List.copyOf(list);
    }

    public Optional<Book> memoryAccess_searchBookById(String id) {
        return list.stream()
                .filter(i -> i.getId().equals(id))
                .findAny();
    }

    public void inputBookDB() {
        String[] Name = {"C# 교과서", "Node.js 교과서", "어도비 XD CC 2020 무작정 따라하기"};
        String[] Description = {"C# 교과서는 생애 첫 프로그래밍 언어로 C#을 시작하는 독자를 대상으로 한다. 특히 응용 프로그래머를 위한 C# 입문서로, C#을 사용하여 게임(유니티), 웹, 모바일, IoT 등을 개발할 때 필요한 C# 기초 문법을 익히고 기본기를 탄탄하게 다지는 것이 목적이다.",
                "이 책은 프런트부터 서버, 데이터베이스, 배포까지 아우르는 광범위한 내용을 다룬다. 군더더기 없는 직관적인 설명으로 기본 개념을 확실히 이해하고, 노드의 기능과 생태계를 사용해보면서 실제로 동작하는 서버를 만들어보자. 예제와 코드는 최신 문법을 사용했고 실무에 참고하거나 당장 적용할 수 있다.",
                "어도비 XD 시작부터 제대로 배운다. 최신 CC 2020 기능을 수록한 가장 완벽한 입문 활용서. 어도비 XD CC 2020 버전 출시에 맞춰 새롭게 선보이는 〈어도비 XD CC 2020 무작정 따라하기〉는 사용자가 단 한 권으로, 쉽고 빠르게 어도비 XD를 배울 수 있도록 구성한 책이다. 어도비 XD는 모바일 환경과 다양한 콘텐츠의 발달로 UI/UX 디자인을 쉽고 빠르게 구현하고자 만들어진 프로그램으로, 〈어도비 XD CC 2020 무작정 따라하기〉는 UI/UX 디자인 작업 전 미리 알아두어야 할 이론을 익히고, 기본 기능과 예제를 무작정 따라하여 기초를 탄탄히 쌓을 수 있으며, 실무 예제를 따라하여 어도비 XD를 제대로 활용할 수 있도록 도와준다."};
        String[] ID = {"ISBN1234", "ISBN1235", "ISBN1236"};
        String[] Author = {"박용준", "조현영", "김두한"};
        String[] Publisher = {"길벗", "길벗", "길벗"};
        String[] ReleaseDate = {"2020/05/29", "2020/07/25", "2019/05/29"};
        String[] Category = {"IT전문서", "IT전문서", "IT활용서"};
        int[] Stock = {473, 512, 350};
        int[] Price = {30000, 36000, 17500};

        for (int i = 0; i < 3; i++) {
            Book book = new Book();
            book.setName(Name[i]);
            book.setDescription(Description[i]);
            book.setId(ID[i]);
            book.setAuthor(Author[i]);
            book.setPublisher(Publisher[i]);
            book.setReleaseDate(ReleaseDate[i]);
            book.setCategory(Category[i]);
            book.setStock(Stock[i]);
            book.setPrice(Price[i]);
            list.add(book);
        }

    }
}



