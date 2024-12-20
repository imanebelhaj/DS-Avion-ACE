package ma.xproce.controlprep.mapper;

import ma.xproce.controlprep.dao.entities.Avion;
import ma.xproce.controlprep.dto.AvionDTO;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class AvionMapper {
    private final ModelMapper mapper = new ModelMapper();

    public Avion fromAvionDtoToAvion(AvionDTO avionDto){
        return mapper.map(avionDto, Avion.class);
    }

    public AvionDTO fromAvionToAvionDto(Avion avion){
        return mapper.map(avion, AvionDTO.class);
    }
}
