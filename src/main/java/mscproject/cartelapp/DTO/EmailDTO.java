package mscproject.cartelapp.DTO;

public class EmailDTO {

    private String name;
    private Long totalWeight;

    private Integer numberOfEmailsSent;
    private Integer numberOfEmailsReceived;

    public EmailDTO(String name, Long totalWeight, Integer numberOfEmailsSent, Integer numberOfEmailsReceived) {
        this.name = name;
        this.totalWeight = totalWeight;
        this.numberOfEmailsSent = numberOfEmailsSent;
        this.numberOfEmailsReceived = numberOfEmailsReceived;
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


    public Integer getNumberOfEmailsSent() {
        return numberOfEmailsSent;
    }

    public void setNumberOfEmailsSent(Integer numberOfEmailsSent) {
        this.numberOfEmailsSent = numberOfEmailsSent;
    }

    public Integer getNumberOfEmailsReceived() {
        return numberOfEmailsReceived;
    }

    public void setNumberOfEmailsReceived(Integer numberOfEmailsReceived) {
        this.numberOfEmailsReceived = numberOfEmailsReceived;
    }

}
