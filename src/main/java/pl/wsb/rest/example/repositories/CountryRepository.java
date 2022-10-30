package pl.wsb.rest.example.repositories;

import org.springframework.stereotype.Repository;
import pl.wsb.rest.example.models.Country;
import pl.wsb.rest.example.models.CountryDto;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class CountryRepository {

static Long currentId = 33L;

private final List<Country> countries = new LinkedList<>(Arrays.asList(
            new Country(1L, "Austria", "niemiecki", "Wiedeń", "euro", 8.5),
            new Country(2L, "Belgia", "niderlandzki, francuski, niemiecki", "Bruksela", "euro", 11.2),
            new Country(3L, "Bułgaria", "bułgarski", "Sofia", "lew bułgarski", 7.3),
            new Country(4L, "Chorwacja", "chorwacki", "Zagrzeb", "kuna chorwacka", 4.3),
            new Country(5L, "Cypr", "grecki, turecki", "Nikozja", "euro", 0.87),
            new Country(6L, "Czechy", "czeski", "Praga", "korona czeska", 10.5),
            new Country(7L, "Dania", "duński", "Kopenhaga", "korona duńska", 5.6),
            new Country(8L, "Estonia", "estoński", "Tallin", "euro", 1.3),
            new Country(9L, "Finlandia", "fiński", "Helsinki", "euro", 5.4),
            new Country(10L, "Francja", "francuski", "Paryż", "euro", 65.6),
            new Country(11L, "Grecja", "grecki", "Ateny", "euro", 11.1),
            new Country(12L, "Hiszpania", "hiszpański", "Madryt", "euro", 46.7),
            new Country(13L, "Holandia", "niderlandzki", "Amsterdam", "euro", 16.8),
            new Country(14L, "Irlandia", "angielski, irlandzki", "Dublin", "euro", 4.6),
            new Country(15L, "Islandia", "islandzki", "Reykjavik", "korona islandzka", 0.32),
            new Country(16L, "Lichtenstein", "niemiecki", "Vaduz", "frank szwajcarski", 0.368),
            new Country(17L, "Litwa", "litewski", "Wilno", "lit litewski", 3.0),
            new Country(18L, "Luksemburg", "francuski, niemiecki, luksemburski", "Luksemburg", "euro", 0.537),
            new Country(19L, "Łotwa", "łotewski", "Ryga", "euro", 2.0),
            new Country(20L, "Malta", "angielski, maltański", "Valletta", "euro", 0.42),
            new Country(21L, "Niemcy", "niemiecki", "Berlin", "euro", 80.5),
            new Country(22L, "Norwegia", "norweski", "Oslo", "korona norweska", 5.1),
            new Country(23L, "Polska", "polski", "Warszawa", "złoty polski", 38.5),
            new Country(24L, "Portugalia", "portugalski", "Lizbona", "euro", 10.5),
            new Country(25L, "Rumunia", "rumuński", "Bukareszt", "lej", 20.1),
            new Country(26L, "Słowacja", "słowacki", "Bratysława", "euro", 5.4),
            new Country(27L, "Słowenia", "słoweński", "Lublana", "euro", 2.1),
            new Country(28L, "Szwajcaria", "francuski, niemiecki, włoski", "Berno", "frank szwajcarski", 8.0),
            new Country(29L, "Szwecja", "szwedzki", "Sztokholm", "korona szwedzka", 9.6),
            new Country(30L, "Węgry", "węgierski", "Budapeszt", "forint węgierski", 9.9),
            new Country(31L, "Wielka Brytania", "angielski", "Londyn", "funt szterling", 63.9),
            new Country(32L, "Włochy", "włoski", "Rzym", "euro", 59.7)



    ));

    public List<Country> getAll() { return countries;}

    public Optional<Country> get(Long id) {
        return countries.stream()
                .filter(song -> song.getId().equals(id))
                .findFirst();
    }

    public Country create(CountryDto countryDto) {
        Country newCountry = new Country(currentId++, countryDto);
        countries.add(newCountry);
        return newCountry;
    }

    public Country update(Country country, CountryDto countryDto) {
        country.setName(countryDto.getName());
        country.setLanguage(countryDto.getLanguage());
        country.setCapital(countryDto.getCapital());
        country.setCurrency(countryDto.getCurrency());
        country.setPopulation_in_millions(Double.valueOf(countryDto.getPopulation_in_millions()));
        return country;
    }

    public void delete(Country country) {
        countries.remove(country);
    }
}
