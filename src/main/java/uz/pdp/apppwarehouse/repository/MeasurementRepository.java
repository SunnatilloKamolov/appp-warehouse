package uz.pdp.apppwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apppwarehouse.entity.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {
   boolean existsByName(String name);
}
