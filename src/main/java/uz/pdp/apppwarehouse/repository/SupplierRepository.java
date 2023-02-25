package uz.pdp.apppwarehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apppwarehouse.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
