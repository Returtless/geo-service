package ru.netology.geo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    void test_byIp() {
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);

        Location actualRusLocation = geoService.byIp("172.*");
        Location expectedRusLocation = new Location("Moscow", Country.RUSSIA, null, 0);
        assertEquals(actualRusLocation, expectedRusLocation);

        Location actualUsaLocation = geoService.byIp("96.*");
        Location expectedUsaLocation = new Location("New York", Country.USA, null, 0);
        assertEquals(actualUsaLocation, expectedUsaLocation);

        Location actualMoscowLocation = geoService.byIp(GeoServiceImpl.MOSCOW_IP);
        Location expectedMoscowLocation = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        assertEquals(actualMoscowLocation, expectedMoscowLocation);

        Location actualNYLocation = geoService.byIp(GeoServiceImpl.NEW_YORK_IP);
        Location expectedNYLocation = new Location("New York", Country.USA, " 10th Avenue", 32);
        assertEquals(actualNYLocation, expectedNYLocation);

        Location actualLocalhostLocation = geoService.byIp(GeoServiceImpl.LOCALHOST);
        Location expectedLocalhostLocation = new Location(null, null, null, 0);
        assertEquals(actualLocalhostLocation, expectedLocalhostLocation);

    }
}