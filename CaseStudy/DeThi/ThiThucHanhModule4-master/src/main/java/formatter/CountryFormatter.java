package formatter;

import model.Country;
import org.springframework.format.Formatter;
import service.CountryService;

import java.text.ParseException;
import java.util.Locale;

public class CountryFormatter implements Formatter<Country> {
    private CountryService countryService;

    public CountryFormatter(CountryService countryService) {
        this.countryService= countryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return countryService.findById(Long.valueOf(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return object.toString();
    }
}
