package dev.flynnpark.springcorebasics.discount;

import dev.flynnpark.springcorebasics.member.Grade;
import dev.flynnpark.springcorebasics.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mainDiscountPolicy")
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPrice = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPrice / 100;
        }
        return 0;
    }
}
