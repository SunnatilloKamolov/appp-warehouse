package uz.pdp.apppwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apppwarehouse.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
    boolean existsByName(String name);
}
