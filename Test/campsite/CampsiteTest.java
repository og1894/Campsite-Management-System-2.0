package campsite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class CampsiteTest {
    private Campsite campsite;
    private CampingArea lakeArea;
    private CampingArea gardenArea;
    private Plot lakePlot;
    private Plot replacementPlot;
    private Guest guest;
    private LocalDate startDate;
    private LocalDate endDate;

    @BeforeEach
    void setUp() {
        campsite = new Campsite("Copper Coast Campsite", "Waterford", 4, "051123456");
        lakeArea = new CampingArea("AREA1", "Lake view camping area");
        gardenArea = new CampingArea("AREA2", "Garden camping area");
        lakePlot = new Plot("1001", "Lake View Bungalow", "Bungalow", null, true, 2, 60, 100, "WiFi and air conditioning", 4);
        replacementPlot = new Plot("1002", "Garden Bungalow", "Bungalow", null, true, 3, 70, 110, "WiFi", 5);
        guest = new Guest("John Smith", LocalDate.of(1990, 5, 15), 1001, "0871234567", "None");
        startDate = LocalDate.of(2027, 6, 10);
        endDate = LocalDate.of(2027, 6, 15);
    }

    @AfterEach
    void tearDown() {
        campsite = null;
        lakeArea = null;
        gardenArea = null;
        lakePlot = null;
        replacementPlot = null;
        guest = null;
        startDate = null;
        endDate = null;
    }

    @Test
    void getName() {
        assertEquals("Copper Coast Campsite", campsite.getName());
    }

    @Test
    void setName() {
        campsite.setName("Sunny Bay Campsite");
        assertEquals("Sunny Bay Campsite", campsite.getName());
    }

    @Test
    void getAddress() {
        assertEquals("Waterford", campsite.getAddress());
    }

    @Test
    void setAddress() {
        campsite.setAddress("Tramore, County Waterford");
        assertEquals("Tramore, County Waterford", campsite.getAddress());
    }

    @Test
    void getNumberOfStars() {
        assertEquals(4, campsite.getNumberOfStars());
    }

    @Test
    void setNumberOfStars() {
        campsite.setNumberOfStars(5);
        assertEquals(5, campsite.getNumberOfStars());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("051123456", campsite.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        campsite.setPhoneNumber("051987654");
        assertEquals("051987654", campsite.getPhoneNumber());
    }

    @Test
    void getFacilities() {
        assertNotNull(campsite.getFacilities());
        assertTrue(campsite.getFacilities().isEmpty());
    }

    @Test
    void getNumberOfFacilities() {
        assertEquals(0, campsite.getNumberOfFacilities());
        campsite.addFacility("WiFi");
        campsite.addFacility("Swimming Pool");
        assertEquals(2, campsite.getNumberOfFacilities());
    }

    @Test
    void addFacility() {
        boolean result = campsite.addFacility("WiFi");
        assertAll(() -> assertTrue(result), () -> assertEquals(1, campsite.getNumberOfFacilities()), () -> assertEquals("WiFi", campsite.getFacilities().get(0)));
    }

    @Test
    void hasFacility() {
        campsite.addFacility("WiFi");
        assertTrue(campsite.hasFacility("WiFi"));
    }

    @Test
    void getFacilitiesReport() {
        campsite.addFacility("WiFi");
        campsite.addFacility("Swimming Pool");
        campsite.addFacility("Restaurant");
        assertEquals("WiFi, Swimming Pool, Restaurant", campsite.getFacilitiesReport());
    }

    @Test
    void getCampingAreas() {
        assertNotNull(campsite.getCampingAreas());
        assertTrue(campsite.getCampingAreas().isEmpty());
    }

    @Test
    void getNumberOfCampingAreas() {
        assertEquals(0, campsite.getNumberOfCampingAreas());
        campsite.addCampingArea(lakeArea);
        campsite.addCampingArea(gardenArea);
        assertEquals(2, campsite.getNumberOfCampingAreas());
    }

    @Test
    void addCampingArea() {
        boolean result = campsite.addCampingArea(lakeArea);
        assertAll(() -> assertTrue(result), () -> assertEquals(1, campsite.getNumberOfCampingAreas()), () -> assertSame(lakeArea, campsite.getCampingAreas().get(0)));
    }

    @Test
    void findCampingArea() {
        campsite.addCampingArea(lakeArea);
        CampingArea result = campsite.findCampingArea("AREA1");
        assertSame(lakeArea, result);
    }
}