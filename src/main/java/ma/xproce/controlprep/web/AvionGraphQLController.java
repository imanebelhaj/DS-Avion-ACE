package ma.xproce.controlprep.web;

import ma.xproce.controlprep.dto.AvionDTO;
import ma.xproce.controlprep.service.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class AvionGraphQLController {
    @Autowired
    AvionService avionService;

    // Query Equivalent to a "GET" request in REST APIs.
    //Mutation Equivalent to "POST," "PUT," or "DELETE" requests in REST APIs.
    @MutationMapping
    public AvionDTO saveAvion(@Argument AvionDTO avion){
        return avionService.saveAvion(avion);
    }
    @MutationMapping
    public boolean deleteAvion(@Argument Long id)
    {
        return avionService.deleteAvion(id);
    }
    @QueryMapping
    public List<AvionDTO> getAvionByModel(@Argument String model){
        return avionService.getAvionByModel(model);
    }

    @QueryMapping
    public List<AvionDTO> getAvionByModelAndPrice(@Argument String model, @Argument float price){
        return avionService.getAvionByModelAndPrice(model, price);
    }
}
