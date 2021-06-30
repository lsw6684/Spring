package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepositor;
    public MemberService(MemberRepository memberRepositor) {
        this.memberRepositor = memberRepositor;
    }


    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 중복 이름 허용 불가
        validateDuplicateMember(member);    // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())   // Ctrl + Alt + V
                .ifPresent(m -> { // 동일 값이 이미 있으면 throw
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 화면 조회
     */

    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
