package dev.flynnpark.springcorebasics;

import dev.flynnpark.springcorebasics.discount.DiscountPolicy;
import dev.flynnpark.springcorebasics.discount.RateDiscountPolicy;
import dev.flynnpark.springcorebasics.member.MemberRepository;
import dev.flynnpark.springcorebasics.member.MemberService;
import dev.flynnpark.springcorebasics.member.MemberServiceImpl;
import dev.flynnpark.springcorebasics.member.MemoryMemberRepository;
import dev.flynnpark.springcorebasics.order.OrderService;
import dev.flynnpark.springcorebasics.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
