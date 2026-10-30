package campsite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PlotTest {
    private Plot staticPlot;
    private Plot normalPlot;
    private Guest guest;
    private Booking booking;
    private LocalDate startDate;
    private LocalDate endDate;

    @BeforeEach
    void setUp() {
        staticPlot = new Plot("1001", "Lake View Bungalow", "Bungalow", null, false, 2, 60, 100, "WiFi, Air Conditioning", 4);
        normalPlot = new Plot("2001", "Caravan Plot", null, "Caravan", true, 0, 50, 40, "Water Connection", 5);
        guest = new Guest("John Smith", LocalDate.of(1990, 5, 15), 1001, "0871234567", "None");
        startDate = LocalDate.of(2027, 6, 10);
        endDate = LocalDate.of(2027, 6, 15);
        booking = new Booking(1, guest, staticPlot, "Copper Coast Campsite", "Lake View Area", startDate, endDate, "Bungalow", 2, true, 50, 2, 1000);
    }

    @AfterEach
    void tearDown() {
        staticPlot = null;
        normalPlot = null;
        guest = null;
        booking = null;
    }

    @Test
    void getPlotID() {
        assertEquals("1001", staticPlot.getPlotID());
    }

    @Test
    void setPlotID() {
        staticPlot.setPlotID("9999");
        assertEquals("9999", staticPlot.getPlotID());
    }

    @Test
    void getName() {
        assertEquals("Lake View Bungalow", staticPlot.getName());
    }

    @Test
    void setName() {
        staticPlot.setName("Garden Bungalow");
        assertEquals("Garden Bungalow", staticPlot.getName());
    }

    @Test
    void getStaticDwelling() {
        assertEquals("Bungalow", staticPlot.getStaticDwelling());
    }

    @Test
    void setStaticDwelling() {
        staticPlot.setStaticDwelling("Apartment");
        assertEquals("Apartment", staticPlot.getStaticDwelling());
    }

    @Test
    void isStaticDwelling() {
        assertTrue(staticPlot.isStaticDwelling());
    }

    @Test
    void getDwelling() {
        assertEquals("Caravan", normalPlot.getDwelling());
    }

    @Test
    void setDwelling() {
        normalPlot.setDwelling("Campervan");
        assertEquals("Campervan", normalPlot.getDwelling());
    }

    @Test
    void isPowered() {
        assertTrue(staticPlot.isPowered());
        assertTrue(normalPlot.isPowered());
    }

    @Test
    void setHasPower() {
        normalPlot.setHasPower(false);
        assertFalse(normalPlot.isPowered());

        normalPlot.setHasPower(true);
        assertTrue(normalPlot.isPowered());
    }

    @Test
    void getBedrooms() {
        assertEquals(2, staticPlot.getBedrooms());
    }

    @Test
    void setBedrooms() {
        staticPlot.setBedrooms(3);
        assertEquals(3, staticPlot.getBedrooms());
    }

    @Test
    void getSize() {
        assertEquals(60, staticPlot.getSize());
    }

    @Test
    void setSize() {
        staticPlot.setSize(75);
        assertEquals(75, staticPlot.getSize());
    }

    @Test
    void getCost() {
        assertEquals(100, staticPlot.getCost());
    }

    @Test
    void setCost() {
        staticPlot.setCost(120);
        assertEquals(120, staticPlot.getCost());
    }

    @Test
    void getFacilities() {
        assertEquals("WiFi, Air Conditioning", staticPlot.getFacilities());
    }

    @Test
    void setFacilities() {
        staticPlot.setFacilities("WiFi, Television");
        assertEquals("WiFi, Television", staticPlot.getFacilities());
    }

    @Test
    void getBeds() {
        assertEquals(4, staticPlot.getBeds());
    }

    @Test
    void setBeds() {
        staticPlot.setBeds(6);
        assertEquals(6, staticPlot.getBeds());
    }

    @Test
    void getPlotType() {
        assertEquals("Bungalow", staticPlot.getPlotType());
    }

    @Test
    void getBookings() {
        LinkedList<Booking> bookings = staticPlot.getBookings();

        assertNotNull(bookings);
        assertTrue(bookings.isEmpty());
        assertEquals(0, bookings.size());
    }

    @Test
    void addBooking() {
        staticPlot.addBooking(booking);
        assertAll(() -> assertEquals(1, staticPlot.getBookings().size()), () -> assertSame(booking, staticPlot.getBookings().get(0)));
    }

    @Test
    void findBooking() {
        staticPlot.addBooking(booking);
        Booking result = staticPlot.findBooking(1);
        assertSame(booking, result);
    }

    @Test
    void removeBooking() {
        staticPlot.addBooking(booking);
        boolean removed = staticPlot.removeBooking(1);
        assertAll(() -> assertTrue(removed), () -> assertTrue(staticPlot.getBookings().isEmpty()), () -> assertNull(staticPlot.findBooking(1)));
    }

    @Test
    void isAvailable() {
        assertTrue(staticPlot.isAvailable(LocalDate.of(2027, 6, 10), LocalDate.of(2027, 6, 15)));
    }
}