package ma.xproce.controlprep.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AvionDTO {
    String model;
    String color;
    String matricul;
    float price;
}
