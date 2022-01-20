public class Bike {
    String bikeName;
    String numberPlate;
    Integer totKms=0;
    Boolean isAvailable=true;
    Integer borrowedCount=0;
    Integer rentPerDay=0;
    Integer priceOfBike=0;
    Integer tenure=0;
    
    Integer serviceKms = 1500;
    Boolean isServiced = true;
    Admin addedBy;

    public Bike(String bikeName, String numberPlate, Admin addedBy,Integer rentPerDay,Integer priceOfBike) {
        this.bikeName = bikeName;
        this.numberPlate = numberPlate;
        this.addedBy=addedBy;
        this.rentPerDay = rentPerDay;
        this.priceOfBike=priceOfBike;
    }


}
