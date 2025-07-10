package repository;

import model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT MAX(o.code) FROM Order o")
    Integer findMaxCode();
    Order findByCode(Integer code);

}
