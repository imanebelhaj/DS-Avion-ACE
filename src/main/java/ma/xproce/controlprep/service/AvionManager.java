package ma.xproce.controlprep.service;

import ma.xproce.controlprep.dao.entities.Avion;
import ma.xproce.controlprep.dao.repositories.AvionRepository;
import ma.xproce.controlprep.dto.AvionDTO;
import ma.xproce.controlprep.mapper.AvionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvionManager implements AvionService{
    @Autowired
    private AvionRepository avionRepository;
    @Autowired
    private AvionMapper avionMapper;

    @Override
    public AvionDTO saveAvion(AvionDTO avionDto) {
        Avion avion = avionMapper.fromAvionDtoToAvion(avionDto);
        avion = avionRepository.save(avion);
        avionDto = avionMapper.fromAvionToAvionDto(avion);
        return avionDto;

        //return avionMapper.fromAvionToAvionDto(avionRepository.save(avionMapper.fromAvionDtoToAvion(avionDto)));
    }

    @Override
    public boolean deleteAvion(Long id) {
        try {
            avionRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<AvionDTO> getAvionByModel(String model) {
        List<Avion> avions = avionRepository.findByModel(model);
        List<AvionDTO> avionDtos = new ArrayList<>();
        for (Avion avion : avions) {
            avionDtos.add(avionMapper.fromAvionToAvionDto(avion));
        }
        return avionDtos;
    }

    @Override
    public List<AvionDTO> getAvionByModelAndPrice(String model, float price) {
        List<Avion> avions = avionRepository.findByModelAndPrice(model, price);
        List<AvionDTO> avionDtos = new ArrayList<>();
        for (Avion avion : avions) {
            avionDtos.add(avionMapper.fromAvionToAvionDto(avion));
        }
        return avionDtos;
    }

    @Override
    public List<AvionDTO> saveAvions(List<AvionDTO> avionDtos) {

        List<Avion> avions = new ArrayList<>();
        for (AvionDTO avionDto : avionDtos) {
            avions.add(avionMapper.fromAvionDtoToAvion(avionDto));
        }

        avions = avionRepository.saveAll(avions);

        avionDtos = new ArrayList<>();
        for (Avion avion : avions) {
            avionDtos.add(avionMapper.fromAvionToAvionDto(avion));
        }
        return avionDtos;
    }
}
