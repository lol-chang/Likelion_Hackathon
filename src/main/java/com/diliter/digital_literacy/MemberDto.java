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

    public static MemberDto toMemberDTO(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(memberEntity.getId());
        memberDto.setMemberName(memberEntity.getMemberName());
        memberDto.setMemberID(memberEntity.getMemberId());
        memberDto.setMemberPassword(memberEntity.getMemberPassword());
        return memberDto;
    }

}
