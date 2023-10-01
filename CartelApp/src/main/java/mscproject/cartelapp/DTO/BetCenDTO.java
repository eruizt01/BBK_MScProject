
    package mscproject.cartelapp.DTO;

    /**
     * This class is a Data Transfer Object used to store and encapsulate data related to operations with the application
     * of the betweenness centrality algorithm.
     * @author eruizt01
     */

    public class BetCenDTO {

        private String name;
        private Double betweennessCentrality;

        /**
         * Constructor for BetCenDTO
         * @param name
         * @param betweennessCentrality
         */

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

