package wheel.knights.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wheel.knights.backend.dto.MiniatureRequestDto;
import wheel.knights.backend.dto.MiniatureResponseDto;
import wheel.knights.backend.mapper.MiniatureMapper;
import wheel.knights.backend.model.Miniature;
import wheel.knights.backend.service.MiniatureService;

import java.util.List;

@RestController
@RequestMapping("/miniatures")
@RequiredArgsConstructor
public class MiniatureController {
    private final MiniatureService service;

    @GetMapping
    public ResponseEntity<List<MiniatureResponseDto>> listAll(){
        List<Miniature> miniatures = service.listAll();

        if(miniatures.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        List<MiniatureResponseDto> dtoList = miniatures.stream()
                .map(MiniatureMapper::toResponseDto)
                .toList();

        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiniatureResponseDto> findById(@PathVariable int id){
        Miniature miniature = service.findById(id);
        return ResponseEntity.ok(MiniatureMapper.toResponseDto(miniature));
    }

    @PostMapping
    public ResponseEntity<MiniatureResponseDto> save(@Valid @RequestBody MiniatureRequestDto dto){
        Miniature miniature = MiniatureMapper.toMiniature(dto);
        return ResponseEntity.created(null).body(MiniatureMapper.toResponseDto(service.save(miniature)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MiniatureResponseDto> update(@PathVariable int id, @Valid @RequestBody MiniatureRequestDto dto){
        Miniature miniature = MiniatureMapper.toMiniature(dto);
        return ResponseEntity.ok(MiniatureMapper.toResponseDto(service.update(id, miniature)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
