package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName("스프링이 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1.조회: 호출할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2.조회: 호출할때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른거 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        //메모리에 객체가 계속 생성되서 커질것이다. 웹 어플리케이션은 고객의 요청이 상당히 크다.

        //memberservice 1은 2와 다른 객체이다.
        //DI 컨테이너인 AppConfig는 요청을 할때마다 개체를 새로 생성한다
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);


    }
}
