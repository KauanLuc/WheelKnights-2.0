package wheel.knights.backend.dto.dashboard;

import wheel.knights.backend.enums.Manufacturer;

public record ExpensesPerManufacturer(
        Manufacturer manufacturer,
        double expense
) {
}
