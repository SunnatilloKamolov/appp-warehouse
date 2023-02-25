package uz.pdp.apppwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import uz.pdp.apppwarehouse.entity.UserWarehouse;

@Service
public interface UserWarehouseRepository extends JpaRepository<UserWarehouse,Integer> {

}
