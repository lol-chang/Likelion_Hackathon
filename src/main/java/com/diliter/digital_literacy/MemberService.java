package com.diliter.digital_literacy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDto memberDto) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDto);
        memberRepository.save(memberEntity);
    }

    public MemberDto login(MemberDto memberDto) {            
        Optional<MemberEntity> byMemberID = memberRepository.findByMemberId(memberDto.getMemberID());

        if (byMemberID.isPresent()) {
            MemberEntity memberEntity = byMemberID.get();
            if (memberEntity.getMemberPassword().equals(memberDto.getMemberPassword())) {
                MemberDto dto = MemberDto.toMemberDTO(memberEntity);
                return dto;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }

    }


    public void updateMember(MemberEntity memberEntity) {
        memberRepository.save(memberEntity);
    }
}
