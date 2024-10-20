package wheel.knights.backend.dto.dashboard;

import wheel.knights.backend.enums.Manufacturer;

public record MiniatureByManufacturer(
        Manufacturer manufacturer,
        long quantity
) {
}
