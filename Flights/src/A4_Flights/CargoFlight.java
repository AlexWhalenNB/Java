package A4_Flights;

/**
 * Cargo inherits from Flight
 * Cargo flights have crew, cargo, but no passengers
 */
public class CargoFlight extends Flight {

    // Class Attributes
    private int cargoWeight;

    /**
     * Creates a flight with the specified parameters.
     * @param flightNumber a string representing the flight number
     * @param dayOfWeek a three letter string representing the day
     * @param departureTime a 4 digit int representing the departure time
     * @param destination a 3 letter code representing the destination
     * @param numCrew an int representing the number of crew
     * @param cargoWeight an int representing the total cargo weight
     */
    public CargoFlight​(String flightNumber, String dayOfWeek, int departureTime,
            Location destination, int numCrew, int cargoWeight){
        super(flightNumber, dayOfWeek, departureTime, destination, numCrew);
        this.cargoWeight = cargoWeight;
    }
    

    /**
     * Returns the weight of the passengers and the cargo added together
     * @return an int representing the total flight weight
     */
    @Override
    public int calculateWeight(){
        int res;
        double crewWeight = super.calculateWeight();
        res = (int) (crewWeight + this.getCargoWeight()); 
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
        res += "\tCargo Weight: " + this.getCargoWeight() + "\n";
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
        res += this.getCargoWeight();
        return res;
    }
    
    //policy checker interface implementation
    
    @Override
    public boolean checkWeight(){
        boolean res = false;
        if(this.calculateWeight() <= Common.MAXIMUM_WEIGHT) res = true;
        return res;
    }
    
    //get methods
    
    @Override
    public String getFlightType(){
        return Common.CARGO;
    }
    
    public double getCargoWeight(){
        return cargoWeight;
    }
    
} // end class CargoFlight
