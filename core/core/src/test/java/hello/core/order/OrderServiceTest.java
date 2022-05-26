package hello.core.order;

import hello.core.AppConfig;
import hello.core.Order.Order;
import hello.core.Order.OrderService;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach     // 테스트 실행 전에 우선적으로 실행 됩니다.
    public void beforeEach(){
        AppConfig appconfig = new AppConfig();
        memberService = appconfig.memberService();
        orderService = appconfig.orderService();
    }


    @Test
    void createOrder() {
        Long memberId =  1L;    // long 으로 쓰면 null이 불가능 하여 Long으로 함.
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
