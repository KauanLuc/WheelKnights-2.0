package wheel.knights.backend.dto.dashboard;

import wheel.knights.backend.enums.VehicleType;

public record ExpensesPerVehicleType(
        VehicleType vehicleType,
        double expense
) {
}
