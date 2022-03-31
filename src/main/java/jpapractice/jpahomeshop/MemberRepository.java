package jpapractice.jpahomeshop;


import jpapractice.jpahomeshop.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;
//  스프링 부트가 EntityManager를 자동 생성해줌. (스타터 팩)

    public Long save(Member member){
        em.persist(member);
        return member.getId();
        // 저장 한 후 id값을 받으면 다시 조회할 수 있다. 고로 Member를 반환받을 필요 없다.
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }


}
