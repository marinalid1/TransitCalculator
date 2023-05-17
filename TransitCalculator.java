import java.lang.Math;
// Best Fare Calculator tutorial by codeCademy
public class TransitCalculator {
  // number of days person will be using the transit system
  int days;
  // number of individual rides
  int rides;
  // prices array keeps track of the prices for the threee options
  double[] prices = {2.75, 33.00, 127.00};
  // plans array stores string of plans
  String[] plans = {"Pay-per-ride", "7-day Unlimited Plan", "30-day Unlimited Plan"};

  // TransitCalculator constructor accepts numDays, numRides
  public TransitCalculator(int numDays, int numRides) {
    // sets numDays to days
    this.days = numDays;
    // sets numRides to rides
    this.rides = numRides;

  }

  //  The method returns the overall price per ride of using the 7-day Unlimited option.
  public double unlimited7Price() {
    // numberOfSevenDayPasses rounds days / 7 up
    double numberOfSevenDayPasses = Math.ceil(days / 7.0);
    // cost per ride take numberOfSevenDayPasses * prices[1] and divides it up num of rides
    double costPerRide = (numberOfSevenDayPasses * prices[1]) / rides;
    // return costPerRide
    return costPerRide; 
  }

  // getRides calculats the price per ride for each fare option
  public double[] getRidePrices() {
    // perRidePrice is first element in prices array
    double perRidePrice = prices[0];
    // unlimited7Price calls method by same name
    double unlimited7Price = unlimited7Price();
    // unlimited30Price takes price of 30 day unlimited plan and divides by number of rides
    double unlimited30Price = prices[2] / rides;

    // prices array stores price per ride for each plan
    double prices[] = {perRidePrice, unlimited7Price, unlimited30Price};
    return prices;
  }

// getBestFare return a String that lets customer know best plan to choose and cost per ride
  public String getBestFare() {
    // double ridePrices array
    double[] ridePrices = getRidePrices();
    // set index to 0
    int winningIndex = 0;

    // for loop
    for (int i = 0; i < ridePrices.length; i++) {
      // if element at i is less than element at winningIndex set winningIndex to i
      if (ridePrices[i] < ridePrices[winningIndex]) {
        winningIndex = i;
      }
    }
    // return string with best plan and cost per ride
    return "You should get the " + plans[winningIndex] + " option at " + Math.round(ridePrices[winningIndex] * 100.0) / 100.0 + " per ride.";
  }
  public static void main(String[] args) {
    // create new TransitCalculator instance
    TransitCalculator myCalc = new TransitCalculator(19, 20);
    System.out.println(myCalc.getBestFare());
  }
}