package wheel.knights.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import wheel.knights.backend.enums.Manufacturer;
import wheel.knights.backend.enums.Theme;
import wheel.knights.backend.enums.VehicleType;

public record MiniatureRequestDto(
        @NotBlank
        String model,
        Manufacturer manufacturer,
        Theme theme,
        VehicleType vehicleType,
        @NotNull @PositiveOrZero
        Double purchasePrice,
        String imagePath
) {
}
