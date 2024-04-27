package ecommerce.repository;

import ecommerce.model.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolEntityRepository extends JpaRepository<RolEntity,Long> {
}
