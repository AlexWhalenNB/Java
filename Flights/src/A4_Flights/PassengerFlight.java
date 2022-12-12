package A4_Flights;

/**
 * A passenger flight has no cargo
 */
public class PassengerFlight extends Flight {

    //Class Attributes
    private int numPassengers;
    
    /**
     * Creates a flight with the specified parameters.
     * @param flightNumber a string representing the flight number
     * @param dayOfWeek a three letter string representing the day
     * @param departureTime a 4 digit int representing the departure time
     * @param destination a 3 letter code representing the destination
     * @param numCrew an int representing the number of crew
     * @param numPassengers an int representing the number of passengers
     */
    PassengerFlight​(String flightNumber, String dayOfWeek, int departureTime, 
            Location destination, int numCrew, int numPassengers){
        super(flightNumber, dayOfWeek, departureTime, destination, numCrew);
        this.numPassengers = numPassengers;
    }
    
    @Override
    public int calculateWeight(){
        int res;
        int crewWeight = super.calculateWeight();
        int passengerWeight = this.numPassengers * Common.AVERAGE_PERSON_WEIGHT;
        res = crewWeight + passengerWeight;
        return res;
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
        res += "\tPassenger Weight: " + (this.numPassengers * Common.AVERAGE_PERSON_WEIGHT) + "\n";
        res += "\tTotal Weight: " + this.calculateWeight();
        
        return res;
    }
    
    /**
     * Creates a string ready for archiving listing the flight details. details
     * are listed separated by a comma
     * @return a String containing flight info separated by commas
     */
    @Override
    public String toArchiveFormat() {
        String res = "";
        res += this.getFlightType() + ",";
        res += super.toArchiveFormat() + ",";
        res += this.getNumPassengers();
        return res;
    }
    
    //policy checker interface implementation
    
    @Override
    public boolean checkWeight(){
        boolean res = false;
        if(this.calculateWeight() <= Common.MAXIMUM_WEIGHT) res = true;
        return res;
    }
    
    @Override
    public boolean checkPassengers(){
        boolean res = false;
        if(this.getNumPassengers() >= Common.MINIMUM_PASSENGERS) res = true;
        return res;
    }
    
    //Get Methods
    public int getNumPassengers() {
        return this.numPassengers;
    }
    
    @Override
    public String getFlightType() {
        return Common.PASSENGER;
    }
} // end class PassengerFlight
