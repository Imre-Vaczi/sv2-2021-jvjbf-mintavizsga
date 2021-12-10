package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    public final static int CAPACITY = 20;
    private List<Fish> fishList = new ArrayList<>();

    public void addFish(Fish fish) {
        if (CAPACITY - getAquariumUtilization() < 5) {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }
        fishList.add(fish);
    }

    public void feed() {
        for (Fish specimen : fishList) {
            specimen.feed();
        }
    }

    public void removeFish(int maxWeight) {
        List<Fish> specimensToBeRemoved = new ArrayList<>();
        for (Fish specimen : fishList) {
            if (specimen.getWeight() > maxWeight) {
                specimensToBeRemoved.add(specimen);
            }
        }
        fishList.removeAll(specimensToBeRemoved);
    }

    public List<String> getStatus() {
        List<String> statusList = new ArrayList<>();
        for (Fish specimen : fishList) {
            statusList.add(specimen.getStatus());
        }
        return statusList;
    }

    public int getNumberOfFishWithMemoryLoss() {
        int result = 0;
        for (Fish specimen : fishList) {
            if (specimen.hasMemoryLoss()) {
                result++;
            }
        }
        return result;
    }

    public boolean isThereFishWithGivenColor(String color) {
        for (Fish specimen : fishList) {
            if (specimen.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish() {
        Fish smallest = fishList.get(0);
        for (Fish specimen : fishList) {
            if (specimen.getWeight() < smallest.getWeight()) {
                smallest = specimen;
            }
        }
        return smallest;
    }

    private int getAquariumUtilization() {
        return fishList.size()*5;
    }

}
