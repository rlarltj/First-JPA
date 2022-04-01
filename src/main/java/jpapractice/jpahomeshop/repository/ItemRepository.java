package jpapractice.jpahomeshop.repository;

import jpapractice.jpahomeshop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){
        if(item.getId() == null){
            //Item은 처음 저장할 때 id를 가지고 있지 않다.
            em.persist(item);
        }else{
            em.merge(item); //강제 업데이트
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        String query = "select i from Item i";
        return em.createQuery(query, Item.class).getResultList();
    }
}
