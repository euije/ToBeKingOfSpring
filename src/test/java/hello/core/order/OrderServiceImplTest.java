package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        /*
            * setter 주입의 단점 (생성자 주입의 장점) *
            1. 순수한 자바 코드만으로 테스트 코드를 작성하려고 할 때,
                OrderServiceImpl이 어느 것에 의존하고 있는지 알 수 없다.
            2. 생성자 주입을 사용하면, 가짜 memberRepositorty를 생성하여 테스트를 진행할 수 있다.
            3. final 키워드를 넣을 수 있다 (생성자에서만 값을 넣어 줄 수 있다).
         */
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        // 하위의 코드는 NullPointerException 발생
        // OrderServiceImpl orderService = new OrderServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}