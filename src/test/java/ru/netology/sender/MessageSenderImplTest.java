package ru.netology.sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageSenderImplTest {
    GeoService geoService;
    LocalizationService localizationService;
    MessageSender messageSender;

    @BeforeEach
    void initServices() {
        geoService = Mockito.spy(GeoServiceImpl.class);
        localizationService = Mockito.spy(LocalizationServiceImpl.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    void testSendRussianTextIfRussianIp() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.*");
        String actual = messageSender.send(headers);
        String expected = "Добро пожаловать";
        assertEquals(actual, expected);
    }

    @Test
    void testSendRussianTextIfNotRussianIp() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.*");
        String actual = messageSender.send(headers);
        String expected = "Welcome";
        assertEquals(actual, expected);
    }
}