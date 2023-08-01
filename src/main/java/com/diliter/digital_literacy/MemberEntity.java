package com.diliter.digital_literacy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String memberName;

    @Column
    private String memberId;

    @Column
    private String memberPassword;

    public static MemberEntity toMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberName(memberDto.getMemberName());
        memberEntity.setMemberId(memberDto.getMemberID());
        memberEntity.setMemberPassword(memberDto.getMemberPassword());

        return memberEntity;
    }
}
