package pl.wsb.rest.example.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private String name;
    private String language;
    private String capital;
    private String currency;
    private Double population_in_millions;

}
