package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalizationServiceImplTest {

    @Test
    void localeRussianTest() {
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

        String russianActualLocale = localizationService.locale(Country.RUSSIA);
        String russianExpectedLocale = "Добро пожаловать";
        assertEquals(russianActualLocale, russianExpectedLocale);
    }

    @Test
    void localeLatinTest() {
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

        String notRussianActualLocale = localizationService.locale(Country.BRAZIL);
        String notRussianExpectedLocale = "Welcome";
        assertEquals(notRussianActualLocale, notRussianExpectedLocale);
    }
}