public class Car {
    String carName;
    String numberPlate;
    Integer seats;
    Integer totKms;
    Integer totCount;
    Integer carsAvailable;
    Integer borrowedCount;
    Integer serviceKms = 3000;
    Boolean isServiced = true;
    Admin addedBy;

    public Car(String carName, String numberPlate, Integer seats, Integer totCount,Admin addeBy) {
        this.carName = carName;
        this.numberPlate = numberPlate;
        this.seats = seats;
        this.totCount = totCount;
        this.addedBy=addeBy;
    }

}
