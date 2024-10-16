package wheel.knights.backend.model;

import jakarta.persistence.*;
import lombok.*;
import wheel.knights.backend.enums.Manufacturer;
import wheel.knights.backend.enums.Theme;
import wheel.knights.backend.enums.VehicleType;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Miniature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String model;

    @Column
    @Enumerated(EnumType.STRING)
    private Manufacturer manufacturer;

    @Column
    @Enumerated(EnumType.STRING)
    private Theme theme;

    @Column
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column
    private Double purchasePrice;
}
