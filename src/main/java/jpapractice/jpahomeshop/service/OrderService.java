package jpapractice.jpahomeshop.service;

import jpapractice.jpahomeshop.domain.Delivery;
import jpapractice.jpahomeshop.domain.Member;
import jpapractice.jpahomeshop.domain.Order;
import jpapractice.jpahomeshop.domain.OrderItem;
import jpapractice.jpahomeshop.domain.item.Item;
import jpapractice.jpahomeshop.repository.ItemRepository;
import jpapractice.jpahomeshop.repository.MemberRepository;
import jpapractice.jpahomeshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    //주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count){
        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //주문 상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Order order = Order.createOrder(member, delivery, orderItem);


        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }


    //취소
    @Transactional
    public void cancelOrder(Long orderId){
        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);

        //주문 취소
        order.cancel();
    }
    //검색

//    public List<Order> findOrders(OrderSearch orderSearch){
//        return orderRepository.findAll(orderSearch);
//    }
}
