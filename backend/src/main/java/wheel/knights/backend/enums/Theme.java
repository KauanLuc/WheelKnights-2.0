package wheel.knights.backend.enums;

public enum Theme {
    OS_SIMPSONS("Os Simpsons"),
    BATMAN("Batman"),
    OS_FLINTSTONES("Os Flintstones"),
    SCOOBY_DOO("Scooby-Doo!"),
    VELOZES_E_FURIOSOS("Velozes e Furiosos"),
    STAR_WARS("Star Wars"),
    MARIO_KART("Mario Kart"),
    BACK_TO_THE_FUTURE("Back to the Future"),
    GHOSTBUSTERS("Ghostbusters"),
    HARRY_POTTER("Harry Potter"),
    JAMES_BOND("James Bond"),
    JURASSIC_PARK("Jurassic Park"),
    TRANSFORMERS("Transformers"),
    SUPERNATURAL("Supernatural"),
    OUTRO("Outro"),
    NENHUM("Nenhum");


    private final String theme;

    Theme(String theme) {
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }
}
