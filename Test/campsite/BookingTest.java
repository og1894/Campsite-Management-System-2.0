package campsite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    private Guest guest;
    private Guest secondGuest;
    private Plot plot;
    private Plot replacementPlot;
    private Booking booking;
    private LocalDate startDate;
    private LocalDate endDate;

    @BeforeEach
    void setUp() {
        guest = new Guest("John Smith", LocalDate.of(1990, 5, 15), 1001, "0871234567", "None");
        secondGuest = new Guest("Mary Murphy", LocalDate.of(1995, 8, 20), 1002, "0861234567", "None");
        plot = new Plot("1001", "Lake View Bungalow", "Bungalow", null, true, 2, 60, 100, "WiFi, Air Conditioning", 4);
        replacementPlot = new Plot("1002", "Garden Bungalow", "Bungalow", null, true, 3, 70, 110, "WiFi", 5);
        startDate = LocalDate.of(2027, 6, 10);
        endDate = LocalDate.of(2027, 6, 15);
        booking = new Booking(1, guest, plot, "Copper Coast Campsite", "Lake View Area 1", startDate, endDate, "Bungalow", 2, true, 50, 2, 1000);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBookingID() {
        assertEquals(1, booking.getBookingID());
    }

    @Test
    void setBookingID() {
        booking.setBookingID(50);
        assertEquals(50, booking.getBookingID());
    }

    @Test
    void getGuest() {
        assertSame(guest, booking.getGuest());
    }

    @Test
    void setGuest() {
        booking.setGuest(secondGuest);
        assertSame(secondGuest, booking.getGuest());
    }

    @Test
    void getAssignedPlot() {
        assertSame(plot, booking.getAssignedPlot());
    }

    @Test
    void setAssignedPlot() {
        booking.setAssignedPlot(replacementPlot);
        assertSame(replacementPlot, booking.getAssignedPlot());
    }

    @Test
    void getCampsiteName() {
        assertEquals("Copper Coast Campsite", booking.getCampsiteName());
    }

    @Test
    void setCampsiteName() {
        booking.setCampsiteName("Waterford Holiday Park");
        assertEquals("Waterford Holiday Park", booking.getCampsiteName());
    }

    @Test
    void getCampingAreaID() {
        assertEquals("Lake View Area 1", booking.getCampingAreaID());
    }

    @Test
    void setCampingAreaID() {
        booking.setCampingAreaID("Garden Area 2");
        assertEquals("Garden Area 2", booking.getCampingAreaID());
    }

    @Test
    void getStartDate() {
        assertEquals(LocalDate.of(2027, 6, 10), booking.getStartDate());
    }

    @Test
    void getEndDate() {
        assertEquals(LocalDate.of(2027, 6, 15), booking.getEndDate());
    }

    @Test
    void setDates() {
        LocalDate newStart = LocalDate.of(2027, 7, 1);
        LocalDate newEnd = LocalDate.of(2027, 7, 8);

        booking.setDates(newStart, newEnd);
        assertAll(() -> assertEquals(newStart, booking.getStartDate()), () -> assertEquals(newEnd, booking.getEndDate()));
    }

    @Test
    void getPreferredPlotType() {
        assertEquals("Bungalow", booking.getPreferredPlotType());
    }

    @Test
    void setPreferredPlotType() {
        booking.setPreferredPlotType("Apartment");
        assertEquals("Apartment", booking.getPreferredPlotType());
    }

    @Test
    void getNumberOfGuests() {
        assertEquals(2, booking.getNumberOfGuests());
    }

    @Test
    void setNumberOfGuests() {
        booking.setNumberOfGuests(4);
        assertEquals(4, booking.getNumberOfGuests());
    }

    @Test
    void isPowerRequired() {
        assertTrue(booking.isPowerRequired());
    }

    @Test
    void setPowerRequired() {
        booking.setPowerRequired(false);
        assertFalse(booking.isPowerRequired());
    }

    @Test
    void getMinimumSize() {
        assertEquals(50, booking.getMinimumSize());
    }

    @Test
    void setMinimumSize() {
        booking.setMinimumSize(55);
        assertEquals(55, booking.getMinimumSize());
    }

    @Test
    void getMinimumBedrooms() {
        assertEquals(2, booking.getMinimumBedrooms());
    }

    @Test
    void setMinimumBedrooms() {
        booking.setMinimumBedrooms(1);
        assertEquals(1, booking.getMinimumBedrooms());
    }

    @Test
    void getMaximumBudget() {
        assertEquals(1000, booking.getMaximumBudget());
    }

    @Test
    void setMaximumBudget() {
        booking.setMaximumBudget(1200);
        assertEquals(1200, booking.getMaximumBudget());
    }

    @Test
    void getStatus() {
        assertEquals(BookingStatus.PENDING, booking.getStatus()
        );
    }

    @Test
    void isPending() {
        assertTrue(booking.isPending());
        //assertFalse(booking.isCompleted());
        //assertFalse(booking.isCancelled());
    }

    @Test
    void cancelBooking() {
        booking.cancelBooking();
        assertEquals(BookingStatus.CANCELLED, booking.getStatus());
    }

    @Test
    void completeBooking() {
        booking.completeBooking();
        assertEquals(BookingStatus.COMPLETED, booking.getStatus());
    }

    @Test
    void getNumberOfNights() {
        assertEquals(5, booking.getNumberOfNights());
    }

    @Test
    void calculateTotalCost() {
        //5 nights, €100 x 5
        assertEquals(500, booking.calculateTotalCost());
    }

    @Test
    void getTotalCost() {
        assertEquals(500, booking.getTotalCost());
    }

    @Test
    void isWithinBudget() {
        assertTrue(booking.isWithinBudget());
    }

    @Test
    void assignedPlotMatchesPreferences() {
        assertTrue(booking.assignedPlotMatchesPreferences());
    }

    @Test
    void overlaps() {
        boolean result = booking.overlaps(LocalDate.of(2027, 6, 12), LocalDate.of(2027, 6, 18));
    }

    @Test
    void reassignPlot() {
        booking.reassignPlot(replacementPlot, "Garden Area 1");
        assertAll(() -> assertSame(replacementPlot, booking.getAssignedPlot()), () -> assertEquals("Garden Area 1", booking.getCampingAreaID()), () -> assertEquals(550, booking.getTotalCost()));
    }
}