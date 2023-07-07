package dev.flynnpark.springcorebasics.singleton;

import dev.flynnpark.springcorebasics.AppConfig;
import dev.flynnpark.springcorebasics.member.MemberRepository;
import dev.flynnpark.springcorebasics.member.MemberServiceImpl;
import dev.flynnpark.springcorebasics.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        assertThat(memberRepository).isSameAs(memberRepository1);
        assertThat(memberRepository1).isSameAs(memberRepository2);
    }
}
