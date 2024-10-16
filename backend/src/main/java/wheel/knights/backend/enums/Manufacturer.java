package wheel.knights.backend.enums;

public enum Manufacturer {
    HOT_WHEELS("Hot Wheels"),
    MATCHBOX("Matchbox"),
    KYOSHO("Kyosho"),
    TOMY("Tomy"),
    SIKU("Siku"),
    JADA("Jada"),
    JOHNNY_LIGHTNING("Johnny Lightning"),
    MAISTO("Maisto"),
    BURAGO("Burago"),
    AUTOART("Autoart"),
    GREENLIGHT("Greenlight"),
    WELLY("Welly"),
    TOMICA("Tomica"),
    CORGI("Corgi"),
    MAJORETTE("Majorette"),
    NOREV("Norev"),
    SCHUCO("Schuco"),
    MINICHAMPS("Minichamps"),
    SOLIDO("Solido"),
    M2_MACHINES("M2 Machines"),
    MOTOR_MAX("Motor Max"),
    SUN_STAR("Sun Star"),
    AUTO_WORLD("Auto World"),
    ROAD_SIGNATURE("Road Signature"),
    SIGNATURE_MODELS("Signature Models"),
    KINSMART("Kinsmart"),
    OUTRA("Outra");

    private final String manufacturer;

    Manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
