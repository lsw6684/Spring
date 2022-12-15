package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // @Component 스캔의 대상이 됨.
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); // static. 실제(동시에 여러 스레드 접근)로는 hashmap 쓰면 안 됨.
    private static long sequence = 0L; // static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {     // id파라미터를 사용 안 하니까 차라리 새로 객체를 만드는 게 권장됨.
                                                            // 중복이냐 명확성이냐를 따질 땐 명확성.
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
