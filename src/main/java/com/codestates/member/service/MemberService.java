package com.codestates.member.service;

import com.codestates.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public Member createMember(Member member){
        // 전달받은 member 객체를 Data Access 계층에 전달하여 DB에 저장하고 저장한 Member 객체를 다시 Controller로 반환

        // 안배웠으니까 저장은 일단 했다 침 ㅅㄱ.
        return member;
    }

    public Member updateMember(Member member){
        // 전달받은 member 객체를 보고 DB에 있는 원래 회원 정보를 가져와서 변경해야 할 부분만 변경한 새로운 Member를 만들고,
        // 새로 만든 member를 DB에 저장하고 저장한 member를 반환

        // 했다침
        return member;
    }

    public Member findMember(long memberId){
        // DB에 조회했다 치고가 안되니까 더미데이터 만듦.
        Member member = new Member(memberId, "taekho1225@gmail.com", "택호", "010-2401-5119");

        return member;
    }

    public List<Member> findMembers(){
        List<Member> members = List.of(
                new Member(1, "taekho1225@gmail.com", "택호1", "010-2401-5119"),
                new Member(2, "taekho2225@gmail.com", "택호2", "110-2401-5119"),
                new Member(3, "taekho3225@gmail.com", "택호3", "210-2401-5119"),
                new Member(4, "taekho4225@gmail.com", "택호4", "310-2401-5119")
        );
        return members;
    }

    public void deleteMember(long memberId){

    }
}
