package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //final이 붙은 필수값들을 생성자로 만들어준다.
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;

    private final DiscountPolicy discountPolicy;
    //추상과 구현클래스 모두를 의존 >>  추상만시키게하기!
    //그런데 문제점이 있다.

    //@RequiredArgsConstructor가
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    //누군가 구현 객체를 대신 생성해줘야 코드가돌아간다 >> 스프링이 만들어서 생성해줄것

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //단일 책임원칙을 잘지킨사례

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
