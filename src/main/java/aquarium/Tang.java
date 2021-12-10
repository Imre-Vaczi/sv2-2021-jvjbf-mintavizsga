package aquarium;

public class Tang extends Fish{

    private boolean memoryIssue = true;

    public Tang(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        setWeight(getWeight() + 1);
    }

    @Override
    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(", weight: ")
                .append(getWeight())
                .append(", color: ")
                .append(getColor())
                .append(", short-term memory loss: ")
                .append(hasMemoryLoss());
        return sb.toString();
    }

    @Override
    public boolean hasMemoryLoss() {
        return memoryIssue;
    }
}
