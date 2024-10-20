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

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturer")
    @Enumerated(EnumType.STRING)
    private Manufacturer manufacturer;

    @Column(name = "theme")
    @Enumerated(EnumType.STRING)
    private Theme theme;

    @Column(name = "vehicle_type")
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "image_path")
    private String imagePath;
}
