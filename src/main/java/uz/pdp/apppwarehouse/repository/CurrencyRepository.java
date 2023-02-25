package uz.pdp.apppwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apppwarehouse.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    boolean existsByName(String name);
}
