package ma.xproce.controlprep.service;

import ma.xproce.controlprep.dto.AvionDTO;

import java.util.List;

public interface AvionService {

    public List<AvionDTO> getAvionByModel(String model);
    public List<AvionDTO> getAvionByModelAndPrice(String model, float Price);
    public AvionDTO saveAvion(AvionDTO avionDTO);
    public boolean deleteAvion(Long id);

    public List<AvionDTO> saveAvions(List<AvionDTO> avionDtos);

}
