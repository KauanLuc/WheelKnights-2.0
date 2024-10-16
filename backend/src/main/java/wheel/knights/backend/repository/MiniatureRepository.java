package wheel.knights.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wheel.knights.backend.model.Miniature;

@Repository
public interface MiniatureRepository extends JpaRepository<Miniature, Integer> {
}
