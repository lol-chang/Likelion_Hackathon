package com.diliter.digital_literacy;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDto {

    private Long id;
    private String memberName;
    private String memberID;
    private String memberPassword;

    //private 으로 할 것인지, public으로 할 것인지 정하기 // 아무도 private으로 하는게 맞지만, 간단하게 public으로 가능할 듯
    public int memberX;

    public static MemberDto toMemberDTO(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(memberEntity.getId());
        memberDto.setMemberName(memberEntity.getMemberName());
        memberDto.setMemberID(memberEntity.getMemberId());
        memberDto.setMemberPassword(memberEntity.getMemberPassword());
        memberDto.setMemberX(memberEntity.getMemberX());
        return memberDto;
    }

}
