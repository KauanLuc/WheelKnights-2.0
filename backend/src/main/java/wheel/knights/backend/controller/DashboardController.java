package wheel.knights.backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wheel.knights.backend.dto.dashboard.ExpensesPerManufacturer;
import wheel.knights.backend.dto.dashboard.ExpensesPerVehicleType;
import wheel.knights.backend.dto.dashboard.MiniatureByManufacturer;
import wheel.knights.backend.dto.dashboard.MiniatureByVehicleType;
import wheel.knights.backend.service.MiniatureService;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final MiniatureService service;

    @GetMapping("/total")
    public ResponseEntity<Long> total(){
        return ResponseEntity.ok(service.count());
    }

    @GetMapping("/collection-value")
    public ResponseEntity<Double> collectionValue(){
        return ResponseEntity.ok(service.sumByPurchasePrice() / 1.8);
    }

    @GetMapping("/more-expensive")
    public ResponseEntity<Double> moreExpensive(){
        return ResponseEntity.ok(service.findTopByOrderByPurchasePriceDesc().getPurchasePrice());
    }

    @GetMapping("/cheaper")
    public ResponseEntity<Double> cheaper(){
        return ResponseEntity.ok(service.findTopByOrderByPurchasePriceAsc().getPurchasePrice());
    }

    @GetMapping("/miniatures-by-manufacturer")
    public ResponseEntity<List<MiniatureByManufacturer>> miniaturesByManufacturer(){
        List<MiniatureByManufacturer> miniatures = service.countMiniatureByManufacturer();

        if(miniatures.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(miniatures);
    }

    @GetMapping("/expenses-per-manufacturer")
    public ResponseEntity<List<ExpensesPerManufacturer>> expensesPerManufacturer(){
        List<ExpensesPerManufacturer> expenses = service.countExpensesPerManufacturer();

        if(expenses.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/miniatures-by-vehicle-type")
    public ResponseEntity<List<MiniatureByVehicleType>> miniaturesByVehicleType(){
        List<MiniatureByVehicleType> miniatures = service.countMiniatureByVehicleType();

        if(miniatures.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(miniatures);
    }

    @GetMapping("/expenses-per-vehicle-type")
    public ResponseEntity<List<ExpensesPerVehicleType>> expensesPerVehicleType(){
        List<ExpensesPerVehicleType> expenses = service.countExpensesPerVehicleType();

        if(expenses.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(expenses);
    }
}
