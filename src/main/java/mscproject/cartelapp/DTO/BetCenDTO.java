
    package mscproject.cartelapp.DTO;

    public class BetCenDTO {

        private String name;
        private Double betweennessCentrality;

        public BetCenDTO(String name, Double betweennessCentrality) {
            this.name = name;
            this.betweennessCentrality = betweennessCentrality;
        }

        // Getter and Setter methods
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getBetweennessCentrality() {
            return betweennessCentrality;
        }

        public void setPageRank(Double pageRank) {
            this.betweennessCentrality = betweennessCentrality;
        }

        @Override
        public String toString() {
            return "PageRankDTO{" +
                    "name='" + name + '\'' +
                    ", betweennessCentrality=" + betweennessCentrality +
                    '}';
        }
    }

