package A4_Flights;

import java.util.ArrayList;

public class FlightSchedule {

    private final Flight[] flights;

    /**
     * Creates a new schedule based on the specified flights.
     *
     * @param flights the flights to be contained in this schedule
     */
    public FlightSchedule(Flight[] flights) {
        this.flights = flights;
    }

    /**
     * Gets all of the flights in this schedule.
     *
     * @return all of the flights in this schedule
     */
    public Flight[] getAllFlights() {
        return flights;
    }

    public Flight[] getFlightsByDestination(String locationCode) {
        ArrayList<Flight> flights = new ArrayList<>();
        for (Flight f : this.getAllFlights()){
            if(f.getDestination().getLocationCode().equals(locationCode)) 
                flights.add(f);
        }
        Flight[] result = flights.toArray(Flight[]::new);
        return result;
    }

    private int countFlightsByDestination(String locationCode) {
        ArrayList<Flight> flights = new ArrayList<>();
        for (Flight f : this.getAllFlights()){
            if(f.getDestination().getLocationCode().equals(locationCode)) 
                flights.add(f);
        }
        int result = flights.size();
        return result;
    }

    public Flight[] getFlightsByType(String flightType) {
        ArrayList<Flight> flights = new ArrayList<>();
        for (Flight f : this.getAllFlights()){
            if(f.getFlightType().equals(flightType)) 
                flights.add(f);
        }
        Flight[] result = flights.toArray(Flight[]::new);
        return result;
    }

    private int countFlightsByType(String flightType) {
        ArrayList<Flight> flights = new ArrayList<>();
        for (Flight f : this.getAllFlights()){
            if(f.getFlightType().equals(flightType)) 
                flights.add(f);
        }
        int result = flights.size();
        return result;
    }


} // end class FlightSchedule
