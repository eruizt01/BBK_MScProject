package mscproject.cartelapp.DTO;

public class InteractionsDTO {

    private String person1;
    private String person2;
    private Long totalWeight;

    public InteractionsDTO(String person1, String person2, Long totalWeight) {
        this.person1 = person1;
        this.person2 = person2;
        this.totalWeight = totalWeight;
    }

    public String getPerson1() {
        return person1;
    }

    public void setPerson1(String person1) {
        this.person1 = person1;
    }

    public String getPerson2() {
        return person2;
    }

    public void setPerson2(String person2) {
        this.person2 = person2;
    }

    public Long getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Long totalWeight) {
        this.totalWeight = totalWeight;
    }

}
