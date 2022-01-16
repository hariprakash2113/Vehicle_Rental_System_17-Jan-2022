public class Bike {
    String bikeName;
    String numberPlate;
    Integer totKms;
    Integer totCount;
    Integer bikesAvailable;
    Integer borrowedCount;
    Integer serviceKms = 1500;
    Boolean isServiced = true;
    Admin addedBy;

    public Bike(String bikeName, String numberPlate, Integer totCount, Admin addedBy) {
        this.bikeName = bikeName;
        this.numberPlate = numberPlate;
        this.totCount = totCount;
        this.addedBy=addedBy;
    }


}
