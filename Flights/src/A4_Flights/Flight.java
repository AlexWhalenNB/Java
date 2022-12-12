package A4_Flights;

/**
 * Flight - a nonstop flight departing from the home airport
 * Flight is the parent class for Training, Cargo, and Passenger Flights
 */
public abstract class  Flight implements PolicyRules {

    // Class attributes
    private String FlightNumber;
    private String dayOfWeek;
    private int departureTime;
    private Location destination;
    private int numCrew;
    
    
    
    /**
     * Creates a flight with the specified parameters.
     * @param flightNumber a string representing the flight number
     * @param dayOfWeek a three letter string representing the day
     * @param departureTime a 4 digit int representing the departure time
     * @param destination a 3 letter code representing the destination
     * @param numCrew an int representing the number of crew
     */
    public Flight​(String flightNumber, String dayOfWeek, int departureTime, 
            Location destination, int numCrew){
        this.FlightNumber = flightNumber;
        this.dayOfWeek = dayOfWeek;
        this.departureTime = departureTime;
        this.destination = destination;
        this.numCrew = numCrew;
        
    }
            
    /**
     * Calculates the weight of this flight as the weight of the crew members.
     * @return the weight as an int
     */
    public int calculateWeight() {
        int weight = this.getNumCrew() * Common.AVERAGE_PERSON_WEIGHT;
        return weight;
    }

    /**
     * Creates a string containing detailed information about this flight.
     * @return a String detailing the flight details in a displayable format
     */
    public String toDisplayReport() {
        String res = "";
        res += this.getFlightNumber() + ", ";
        res += "Day = " + this.getDayOfWeek() + ", ";
        res += "Time = " + this.getDepartureTime() + "\n";
        res += "\tDestination: " + this.destination.toDisplayFormat() + "\n";
        res += "\tNumber of Crew: " + this.getNumCrew() + "\n";
        return res;
        
    }

    /**
     * Creates a string ready for archiving listing the flight details. details
     * are listed separated by a comma
     * @return a String containing flight info separated by commas
     */
    public String toArchiveFormat() {
        String res = "";
        res += this.getFlightNumber() + ",";
        res += this.getDayOfWeek() + ",";
        res += this.getDepartureTime() + ",";
        res += this.destination.getLocationCode() + ",";
        res += this.getNumCrew();
        return res;
    }
    
    //policy checker interface implementation
    @Override
    public boolean checkCrew(){
        boolean res = false;
        if(this.getNumCrew() >= Common.MINIMUM_CREW) res = true;
        return res;
    }
    
    @Override
    public boolean checkWeight(){
        boolean res = true;
        return res;
    }
    
    @Override
    public boolean checkPassengers(){
        boolean res = true;
        return res;
    }
    
    @Override
    public boolean checkTime(){
        boolean res = true;
        return res;
    }
    //Get Methods
    
    public String getFlightNumber(){
        return FlightNumber;
    }
    
    public String getDayOfWeek(){
        return dayOfWeek;
    }
    
    public int getDepartureTime(){
        return departureTime;
    }
    
    public Location getDestination(){
        return destination;
    }
    
    public int getNumCrew(){
        return numCrew;
    }
    
    public abstract String getFlightType();

} // end class Flight
