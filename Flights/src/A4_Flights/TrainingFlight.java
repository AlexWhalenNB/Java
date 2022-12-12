package A4_Flights;

/**
 * A Training Flight has no passengers, and no cargo
 */
public class TrainingFlight extends Flight {

    /**
     * Creates a flight with the specified parameters.
     * @param flightNumber a string representing the flight number
     * @param dayOfWeek a three letter string representing the day
     * @param departureTime a 4 digit int representing the departure time
     * @param destination a 3 letter code representing the destination
     * @param numCrew an int representing the number of crew
     */
    public TrainingFlight​(String flightNumber, String dayOfWeek, 
            int departureTime, Location destination, int numCrew){
        super(flightNumber, dayOfWeek, departureTime, destination, numCrew);
    }
    
    /**
     * Creates a string containing detailed information about this flight.
     * @return a String detailing the flight details in a displayable format
     */
    @Override
    public String toDisplayReport() {
        String flight = super.toDisplayReport();
        String res = "";
        res += this.getFlightType() + " Flight = " + flight;
        res += "\tTotal Weight: " + super.calculateWeight();
        
        return res;
    }
    
    //policy checker interface implementation    
    @Override
    public boolean checkTime(){
        boolean res = false;
        if(this.getDepartureTime() >= Common.EARLIEST_DEPARTURE && 
                this.getDepartureTime() <= Common.LATEST_DEPARTURE) res = true;
        return res;
    }
    
    @Override
    public boolean checkWeight(){
        boolean res = false;
        if(this.calculateWeight() <= Common.MAXIMUM_WEIGHT) res = true;
        return res;
    }
    
    //Get Methods
    
    @Override
    public String getFlightType() {
        return Common.TRAINING;
    }
    
    

} // end class TrainingFlight
