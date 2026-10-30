package campsite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class GuestTest {
    private Guest guest;
    private Plot plot;
    private Booking booking;

    @BeforeEach
    void setUp() {
        guest = new Guest("John Smith", LocalDate.of(1990, 5, 15), 1001, "0871234567", "Requires accessible accommodation");
        plot = new Plot("1001", "Lake View Bungalow", "Bungalow", null, true, 2, 60, 100, "WiFi and air conditioning", 4);
        booking = new Booking(1, guest, plot, "Copper Coast Campsite", "Lake View Area", LocalDate.of(2027, 6, 10), LocalDate.of(2027, 6, 15), "Bungalow", 2, true, 50, 2, 1000);
    }

    @AfterEach
    void tearDown() {
        guest = null;
        plot = null;
        booking = null;
    }

    @Test
    void setName() {
        guest.setName("Mary Murphy");
        assertEquals("Mary Murphy", guest.getName());
    }

    @Test
    void getName() {
        assertEquals("John Smith", guest.getName());
    }

    @Test
    void setDateOfBirth() {
        LocalDate newDateOfBirth = LocalDate.of(1985, 10, 20);
        guest.setDateOfBirth(newDateOfBirth);
        assertEquals(newDateOfBirth, guest.getDateOfBirth());
    }

    @Test
    void getDateOfBirth() {
        assertEquals(LocalDate.of(1990, 5, 15), guest.getDateOfBirth());
    }

    @Test
    void setGuestID() {
        guest.setGuestID(2000);
        assertEquals(2000, guest.getGuestID());
    }

    @Test
    void getGuestID() {
        assertEquals(1001, guest.getGuestID());
    }

    @Test
    void setPhoneNumber() {
        guest.setPhoneNumber("0867654321");
        assertEquals("0867654321", guest.getPhoneNumber());
    }

    @Test
    void getPhoneNumber() {
        guest.setAncillaryInfo("Travelling with a guide dog");
        assertEquals("Travelling with a guide dog", guest.getAncillaryInfo());
    }

    @Test
    void setAncillaryInfo() {
        guest.setAncillaryInfo("Travelling with a guide dog");
    }

    @Test
    void getAncillaryInfo() {
        assertEquals("Requires accessible accommodation", guest.getAncillaryInfo());
    }

    @Test
    void getBookings() {
        assertNotNull(guest.getBookings());
        assertTrue(guest.getBookings().isEmpty());
        assertEquals(0, guest.getBookings().size());
    }

    @Test
    void addBooking() {
        guest.addBooking(booking);
        assertAll(() -> assertEquals(1, guest.getBookings().size()), () -> assertSame(booking, guest.getBookings().get(0)));
    }
}