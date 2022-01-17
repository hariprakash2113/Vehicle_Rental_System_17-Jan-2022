import java.util.Comparator;

public class CountSorter implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        if(Vehicle.bikes.containsKey(o1)){
            return Vehicle.bikes.get(o1).size()-Vehicle.bikes.get(o2).size();
        }
        return Vehicle.cars.get(o1).size()-Vehicle.cars.get(o2).size();
    }
    
}
