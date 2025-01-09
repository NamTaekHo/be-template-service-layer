package com.codestates.member.mapper;

import com.codestates.member.dto.MemberPatchDto;
import com.codestates.member.dto.MemberPostDto;
import com.codestates.member.dto.MemberResponseDto;
import com.codestates.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member memberPostDtoToMember (MemberPostDto memberPostDto){
        Member member = new Member();
        member.setEmail(memberPostDto.getEmail());
        member.setPhone(memberPostDto.getPhone());
        member.setName(memberPostDto.getName());
        return member;
    }

    public Member memberPatchDtoToMember (MemberPatchDto memberPatchDto){
        Member member = new Member();
        member.setMemberId(memberPatchDto.getMemberId());
        member.setName(memberPatchDto.getName());
        member.setPhone(memberPatchDto.getPhone());
        return member;
    }

    public MemberResponseDto memberToMemberResponseDto(Member member){
        MemberResponseDto memberResponseDto = new MemberResponseDto(member.getMemberId(), member.getName(), member.getEmail(), member.getPhone());
        return memberResponseDto;
    }
}
