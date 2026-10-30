package campsite;

public enum BookingStatus {
    PENDING,
    COMPLETED,
    CANCELLED
}

//UNUSED GOOD CODE

/* BOOKING CLASS

    public void changeDates(LocalDate newStartDate, LocalDate newEndDate) {
        if (!isPending()) {
            throw new IllegalStateException("Only pending bookings can be changed.");
        }

        if (!assignedPlot.isAvailable(newStartDate, newEndDate)) {
            throw new IllegalArgumentException("The plot is unavailable for the new dates.");
        }

        setDates(newStartDate, newEndDate);
        totalCost = calculateTotalCost();

        if (!isWithinBudget()) {
            throw new IllegalArgumentException("The changed booking exceeds the budget.");
        }
    }
 */

/*CAMPINGAREA CLASS

    public Plot findPlotForBooking(int bookingID) {
        for (int i = 0; i < plots.size(); i++) {
            Plot plot = plots.get(i);

            if (plot.findBooking(bookingID) != null) {
                return plot;
            }
        }
        return null;
    }
 */

/*CAMPSITE CLASS

    public boolean removeFacility(String facility) {
        if (facility == null || facility.isBlank()) {
            return false;
        }

        for (int i = 0; i < facilities.size(); i++) {
            String currentFacility = facilities.get(i);

            if (currentFacility.equalsIgnoreCase(facility.trim())) {
                facilities.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeCampingArea(String campingAreaID) {
        if (campingAreaID == null || campingAreaID.isBlank()) {
            return false;
        }

        for (int i = 0; i < campingAreas.size(); i++) {
            CampingArea area = campingAreas.get(i);

            if (area.getCampingAreaID().equalsIgnoreCase(campingAreaID.trim())) {
                if (area.getNumberOfPendingBookings() > 0) {
                    return false;
                }

                campingAreas.remove(i);
                return true;
            }
        }
        return false;
    }

    // --------------------------------------------------
    // Plot management
    // --------------------------------------------------

    public boolean addPlot(String campingAreaID, Plot plot) {
        CampingArea area = findCampingArea(campingAreaID);

        if (area == null) {
            return false;
        }
        return area.addPlot(plot);
    }

    public Plot findPlot(String campingAreaID, String plotID) {
        CampingArea area = findCampingArea(campingAreaID);

        if (area == null) {
            return null;
        }
        return area.findPlot(plotID);
    }
 */