package wheel.knights.backend.dto.miniatura;

import lombok.Builder;
import wheel.knights.backend.enums.Manufacturer;
import wheel.knights.backend.enums.Theme;
import wheel.knights.backend.enums.VehicleType;

@Builder
public record MiniatureResponseDto(
        Integer id,
        String model,
        Manufacturer manufacturer,
        Theme theme,
        VehicleType vehicleType,
        Double purchasePrice,
        String imagePath
) {
}
