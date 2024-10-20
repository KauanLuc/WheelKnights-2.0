package wheel.knights.backend.mapper;

import wheel.knights.backend.dto.miniatura.MiniatureRequestDto;
import wheel.knights.backend.dto.miniatura.MiniatureResponseDto;
import wheel.knights.backend.model.Miniature;

public class MiniatureMapper {
    public static Miniature toMiniature(MiniatureRequestDto dto){
        if(dto == null){
            return null;
        }

        return Miniature.builder()
                .model(dto.model())
                .manufacturer(dto.manufacturer())
                .theme(dto.theme())
                .vehicleType(dto.vehicleType())
                .purchasePrice(dto.purchasePrice())
                .imagePath(dto.imagePath())
                .build();
    }

    public static MiniatureResponseDto toResponseDto(Miniature miniature){
        if(miniature == null){
            return null;
        }

        return MiniatureResponseDto.builder()
                .id(miniature.getId())
                .model(miniature.getModel())
                .manufacturer(miniature.getManufacturer())
                .theme(miniature.getTheme())
                .vehicleType(miniature.getVehicleType())
                .purchasePrice(miniature.getPurchasePrice())
                .imagePath(miniature.getImagePath())
                .build();
    }
}
