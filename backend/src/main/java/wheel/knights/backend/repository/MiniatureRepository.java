package wheel.knights.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wheel.knights.backend.dto.dashboard.ExpensesPerManufacturer;
import wheel.knights.backend.dto.dashboard.ExpensesPerVehicleType;
import wheel.knights.backend.dto.dashboard.MiniatureByManufacturer;
import wheel.knights.backend.dto.dashboard.MiniatureByVehicleType;
import wheel.knights.backend.model.Miniature;

import java.util.List;

@Repository
public interface MiniatureRepository extends JpaRepository<Miniature, Integer> {
    long count();

    @Query("SELECT SUM(m.purchasePrice) FROM Miniature m")
    Double sumByPurchasePrice();

    Miniature findTopByOrderByPurchasePriceDesc();

    Miniature findTopByOrderByPurchasePriceAsc();

    @Query("""
           SELECT new wheel.knights.backend.dto.dashboard.MiniatureByManufacturer(m.manufacturer, COUNT(m)) 
           FROM Miniature m 
           GROUP BY m.manufacturer 
           ORDER BY COUNT(m) DESC
           """)
    List<MiniatureByManufacturer> countMiniatureByManufacturer();

    @Query("""
           SELECT new wheel.knights.backend.dto.dashboard.ExpensesPerManufacturer(m.manufacturer, SUM(m.purchasePrice)) 
           FROM Miniature m 
           GROUP BY m.manufacturer 
           ORDER BY SUM(m.purchasePrice) DESC
           """)
    List<ExpensesPerManufacturer> countExpensesPerManufacturer();

    @Query("""
           SELECT new wheel.knights.backend.dto.dashboard.MiniatureByVehicleType(m.vehicleType, COUNT(m)) 
           FROM Miniature m 
           GROUP BY m.vehicleType 
           ORDER BY COUNT(m) DESC
           """)
    List<MiniatureByVehicleType> countMiniatureByVehicleType();

    @Query("""
           SELECT new wheel.knights.backend.dto.dashboard.ExpensesPerVehicleType(m.vehicleType, SUM(m.purchasePrice)) 
           FROM Miniature m 
           GROUP BY m.vehicleType 
           ORDER BY SUM(m.purchasePrice) DESC
           """)
    List<ExpensesPerVehicleType> countExpensesPerVehicleType();
}
