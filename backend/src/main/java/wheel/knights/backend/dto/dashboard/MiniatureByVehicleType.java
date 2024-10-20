package wheel.knights.backend.dto.dashboard;

import wheel.knights.backend.enums.VehicleType;

public record MiniatureByVehicleType(
        VehicleType vehicleType,
        long quantity
) {
}
