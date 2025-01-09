package com.codestates.member.controller;

import com.codestates.member.dto.MemberPatchDto;
import com.codestates.member.dto.MemberPostDto;
import com.codestates.member.dto.MemberResponseDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.mapper.MemberMapper2;
import com.codestates.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v2/members")
@Validated
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper2 memberMapper;

    public MemberController(MemberService memberService, MemberMapper2 memberMapper){
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }



    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {
        Member member = memberService.createMember(memberMapper.memberPostDtoToMember(memberDto));
        MemberResponseDto memberResponseDto = memberMapper.memberToMemberResponseDto(member);
        return new ResponseEntity<>(memberResponseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto) {
        Member member = memberService.updateMember(memberMapper.memberPatchDtoToMember(memberPatchDto));
        MemberResponseDto memberResponseDto = memberMapper.memberToMemberResponseDto(member);
        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        Member member = memberService.findMember(memberId);
        MemberResponseDto memberResponseDto = memberMapper.memberToMemberResponseDto(member);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findMembers();
//        List<MemberResponseDto> memberResponseDtos = new ArrayList<>();
//        members.forEach(member -> {
//            memberResponseDtos.add(memberMapper.memberToMemberResponseDto(member));
//        });
        List<MemberResponseDto> memberResponseDtos = members.stream()
                .map(member -> memberMapper.memberToMemberResponseDto(member))
                .collect(Collectors.toList());

        return new ResponseEntity<>(memberResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 회원 정보는 구현해야 할 실습이 없습니다!
}
