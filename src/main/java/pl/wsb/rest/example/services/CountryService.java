package pl.wsb.rest.example.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wsb.rest.example.exceptions.ResourceNotFoundException;
import pl.wsb.rest.example.models.CountryDto;
import pl.wsb.rest.example.repositories.CountryRepository;
import pl.wsb.rest.example.models.Country;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getAll() {
        return countryRepository.getAll();

    }

    public Country get(Long id) {
        return countryRepository
                .get(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Country create(CountryDto countryDto) {
        return countryRepository.create(countryDto);

    }
    public Country update(Long id, CountryDto countryDto) {
        Country country= get(id);
        return countryRepository.update(country, countryDto);
    }

    public void delete(Long id) {
        Country country = get(id);
        countryRepository.delete(country);
    }
}
