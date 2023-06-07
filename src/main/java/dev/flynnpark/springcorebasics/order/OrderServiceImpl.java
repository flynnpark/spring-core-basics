package dev.flynnpark.springcorebasics.order;

import dev.flynnpark.springcorebasics.discount.DiscountPolicy;
import dev.flynnpark.springcorebasics.discount.FixDiscountPolicy;
import dev.flynnpark.springcorebasics.member.Member;
import dev.flynnpark.springcorebasics.member.MemberRepository;
import dev.flynnpark.springcorebasics.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
