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


    public Car(String carName, String numberPlate, Integer seats, Integer totCars) {
        this.carName = carName;
        this.numberPlate = numberPlate;
        this.seats = seats;
        this.totCars = totCars;
    }

    
}
