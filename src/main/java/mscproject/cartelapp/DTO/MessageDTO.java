package mscproject.cartelapp.DTO;

public class MessageDTO {

    private String name;
    private Long totalWeight;

    private Integer numberOfMessagesSent;

    private Integer numberOfMessagesReceived;

    public MessageDTO(String name, Long totalWeight, Integer numberOfMessagesSent, Integer numberOfMessagesReceived) {
        this.name = name;
        this.totalWeight = totalWeight;
        this.numberOfMessagesSent = numberOfMessagesSent;
        this.numberOfMessagesReceived = numberOfMessagesReceived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Long totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getNumberOfMessagesSent() {
        return numberOfMessagesSent;
    }

    public void setNumberOfMessagesSent(Integer numberOfMessagesSent) {
        this.numberOfMessagesSent = numberOfMessagesSent;
    }

    public Integer getNumberOfMessagesReceived() {
        return numberOfMessagesReceived;
    }

    public void setNumberOfMessagesReceived(Integer numberOfMessagesReceived) {
        this.numberOfMessagesReceived = numberOfMessagesReceived;
    }

}
