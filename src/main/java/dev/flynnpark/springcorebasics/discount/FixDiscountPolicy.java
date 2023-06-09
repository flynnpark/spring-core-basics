package dev.flynnpark.springcorebasics.discount;

import dev.flynnpark.springcorebasics.member.Grade;
import dev.flynnpark.springcorebasics.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
