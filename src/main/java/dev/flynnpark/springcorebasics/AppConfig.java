package dev.flynnpark.springcorebasics;

import dev.flynnpark.springcorebasics.discount.DiscountPolicy;
import dev.flynnpark.springcorebasics.discount.FixDiscountPolicy;
import dev.flynnpark.springcorebasics.member.MemberRepository;
import dev.flynnpark.springcorebasics.member.MemberService;
import dev.flynnpark.springcorebasics.member.MemberServiceImpl;
import dev.flynnpark.springcorebasics.member.MemoryMemberRepository;
import dev.flynnpark.springcorebasics.order.OrderService;
import dev.flynnpark.springcorebasics.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    private MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
