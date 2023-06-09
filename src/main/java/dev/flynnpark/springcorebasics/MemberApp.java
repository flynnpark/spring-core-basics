package dev.flynnpark.springcorebasics;

import dev.flynnpark.springcorebasics.member.Grade;
import dev.flynnpark.springcorebasics.member.Member;
import dev.flynnpark.springcorebasics.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }
}
