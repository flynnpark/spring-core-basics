package dev.flynnpark.springcorebasics;

import dev.flynnpark.springcorebasics.member.Grade;
import dev.flynnpark.springcorebasics.member.Member;
import dev.flynnpark.springcorebasics.member.MemberService;
import dev.flynnpark.springcorebasics.member.MemberServiceImpl;
import dev.flynnpark.springcorebasics.order.Order;
import dev.flynnpark.springcorebasics.order.OrderService;
import dev.flynnpark.springcorebasics.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order " + order);
        System.out.println("order.calculatePrice " + order.calculatePrice());
    }
}
