public class Bike {
    String bikeName;
    String numberPlate;
    Integer totKms;
    Integer totCount;
    Integer bikesAvailable;
    Integer borrowedCount;
    Integer serviceKms = 1500;
    Boolean isServiced = true;

    public Bike(String bikeName, String numberPlate, Integer totCount, Integer bikesAvailable) {
        this.bikeName = bikeName;
        this.numberPlate = numberPlate;
        this.totCount = totCount;
        this.bikesAvailable = bikesAvailable;
    }

    


}
