package uz.pdp.apppwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apppwarehouse.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
  boolean existsByPhoneNumber(String phoneNumber);
}
