package wheel.knights.backend.enums;

public enum VehicleType {
    CARRO("Carro"),
    MOTO("Moto"),
    CAMINHAO("Caminhão"),
    MILITAR("Militar"),
    BARCO("Barco"),
    AVIAO("Avião"),
    ONIBUS("Ônibus"),
    CONSTRUCAO("Construção"),
    EMERGENCIA("Emergência"),
    ESPACIAL("Espacial"),
    OUTRO("Outro");

    private final String vehicleType;

    VehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
