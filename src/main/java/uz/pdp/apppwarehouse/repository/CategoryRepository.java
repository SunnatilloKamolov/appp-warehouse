package uz.pdp.apppwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apppwarehouse.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
