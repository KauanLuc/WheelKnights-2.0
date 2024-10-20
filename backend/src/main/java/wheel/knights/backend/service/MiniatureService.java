package wheel.knights.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wheel.knights.backend.dto.dashboard.ExpensesPerManufacturer;
import wheel.knights.backend.dto.dashboard.ExpensesPerVehicleType;
import wheel.knights.backend.dto.dashboard.MiniatureByManufacturer;
import wheel.knights.backend.dto.dashboard.MiniatureByVehicleType;
import wheel.knights.backend.exception.MiniatureNotFoundException;
import wheel.knights.backend.model.Miniature;
import wheel.knights.backend.repository.MiniatureRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiniatureService {
    private final MiniatureRepository repository;

    public List<Miniature> listAll(){
        return repository.findAll();
    }

    public Miniature findById(int id){
        return repository.findById(id).orElseThrow(
                () -> new MiniatureNotFoundException("Miniature not found.")
        );
    }

    public Miniature save(Miniature miniature){
        return repository.save(miniature);
    }
    
    public Miniature update(int id, Miniature miniature){
        Miniature miniatureToUpdate = findById(id);

        miniatureToUpdate.setModel(miniature.getModel());
        miniatureToUpdate.setManufacturer(miniature.getManufacturer());
        miniatureToUpdate.setTheme(miniature.getTheme());
        miniatureToUpdate.setVehicleType(miniature.getVehicleType());
        miniatureToUpdate.setPurchasePrice(miniature.getPurchasePrice());
        miniatureToUpdate.setImagePath(miniatureToUpdate.getImagePath());

        return repository.save(miniatureToUpdate);
    }

    public void delete(int id){
        Miniature miniature = findById(id);
        repository.delete(miniature);
    }

    public long count(){
        return repository.count();
    }

    public Double sumByPurchasePrice(){
        return repository.sumByPurchasePrice() != null ? repository.sumByPurchasePrice() : 0.0;
    }

    public Miniature findTopByOrderByPurchasePriceDesc(){
        return repository.findTopByOrderByPurchasePriceDesc() != null ? repository.findTopByOrderByPurchasePriceDesc() : Miniature.builder().purchasePrice(0.0).build();
    }

    public Miniature findTopByOrderByPurchasePriceAsc(){
        return repository.findTopByOrderByPurchasePriceAsc() != null ? repository.findTopByOrderByPurchasePriceAsc() : Miniature.builder().purchasePrice(0.0).build();
    }

    public List<MiniatureByManufacturer> countMiniatureByManufacturer(){
        return repository.countMiniatureByManufacturer();
    }

    public List<ExpensesPerManufacturer> countExpensesPerManufacturer(){
        return repository.countExpensesPerManufacturer();
    }

    public List<MiniatureByVehicleType> countMiniatureByVehicleType(){
        return repository.countMiniatureByVehicleType();
    }

    public List<ExpensesPerVehicleType> countExpensesPerVehicleType(){
        return repository.countExpensesPerVehicleType();
    }
}
