package pl.wszib.pizzamarket.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wszib.pizzamarket.data.entities.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
