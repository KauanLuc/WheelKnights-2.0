package wheel.knights.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wheel.knights.backend.model.Miniature;

public interface MiniatureRepository extends JpaRepository<Miniature, Integer> {
}
