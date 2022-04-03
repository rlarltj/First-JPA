package jpapractice.jpahomeshop.service;

import jpapractice.jpahomeshop.domain.Member;
import jpapractice.jpahomeshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // 생성자 주입
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member){
        validDuplicateName(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validDuplicateName(Member member) {
        List<Member> findOne = memberRepository.findByName(member.getName());
        if(!findOne.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }
}
