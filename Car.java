public class Car {
    String carName;
    String numberPlate;
    Integer seats=0;
    Integer totKms=0;
    Boolean isAvailable=true;
    Integer borrowedCount=0;
    Integer rentPerDay=0;
    Integer priceOfCar=0;
    Integer tenure=0;
    Integer serviceKms = 3000;
    Boolean isServiced = true;
    Admin addedBy;

    public Car(String carName, String numberPlate, Integer seats,Admin addeBy,Integer rentPerDay,Integer priceOfCar) {
        this.carName = carName;
        this.numberPlate = numberPlate;
        this.seats = seats;
        this.addedBy=addeBy;
        this.rentPerDay=rentPerDay;
        this.priceOfCar=priceOfCar;
    }

}
