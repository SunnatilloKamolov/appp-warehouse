package uz.pdp.apppwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apppwarehouse.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
