package aquarium;

public class Clownfish extends Fish{

    private boolean memoryIssue = false;

    public Clownfish(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        setWeight(getWeight() + 1);
    }

    @Override
    public boolean hasMemoryLoss() {
        return memoryIssue;
    }

    @Override
    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName())
                .append(", weight: ")
                .append(getWeight())
                .append(", color: ")
                .append(getColor())
                .append(", short-term memory loss: ")
                .append(hasMemoryLoss());
        return sb.toString();
    }
}
