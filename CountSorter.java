import java.util.Comparator;

public class CountSorter implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return Vehicle.bikes.get(o1).size()-Vehicle.bikes.get(o2).size();
    }
    
}
