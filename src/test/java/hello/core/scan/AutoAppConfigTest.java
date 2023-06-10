package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        /*
            @Autowired는 객체를 Type으로 조회한다.
            -> Type이 같은 객체가 2개 이상 있다면?
            -> OrderServiceImpl의 DiscountPolicy의 의존성을 주입할 때
                , fixDiscountPolicy,rateDiscountPolicy 2개가 발견된다.

            NoUniqueBeanDefinitionException: No qualifying bean of type
            'hello.core.discount.DiscountPolicy' available: expected single matching bean
             but found 2: fixDiscountPolicy,rateDiscountPolicy
         */
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
