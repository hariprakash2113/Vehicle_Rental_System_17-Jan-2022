public class Car {
    String carName;
    String numberPlate;
    Integer seats=0;
    Integer totKms=0;
    Integer carsAvailable=0;
    Integer borrowedCount=0;
    Integer rentPerDay=0;
    Integer serviceKms = 3000;
    Boolean isServiced = true;
    Admin addedBy;

    public Car(String carName, String numberPlate, Integer seats,Admin addeBy,Integer rentPerDay) {
        this.carName = carName;
        this.numberPlate = numberPlate;
        this.seats = seats;
        this.addedBy=addeBy;
        this.rentPerDay=rentPerDay;
    }

}
