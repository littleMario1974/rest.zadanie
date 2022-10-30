package pl.wsb.rest.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Country {

    private Long id;
    private String name;
    private String language;
    private String capital;
    private String currency;
    private Double population_in_millions;

    public Country(Long id, CountryDto countryDto) {
        this.id = id;
        this.name = countryDto.getName();
        this.language = countryDto.getLanguage();
        this.capital = countryDto.getCapital();
        this.currency = countryDto.getCurrency();
        this.population_in_millions = countryDto.getPopulation_in_millions();
    }
}
