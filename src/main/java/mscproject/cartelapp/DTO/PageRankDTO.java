
    package mscproject.cartelapp.DTO;

    /**
     * This class is a Data Transfer Object used to store and encapsulate data related to operations with
     * the application of the pageRank algorithm.
     *
     */

    public class PageRankDTO {

        private String name;
        private Double pageRank;

        public PageRankDTO(String name, Double pageRank) {
            this.name = name;
            this.pageRank = pageRank;
        }

        // Getter and Setter methods
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPageRank() {
            return pageRank;
        }

        public void setPageRank(Double pageRank) {
            this.pageRank = pageRank;
        }

        @Override
        public String toString() {
            return "PageRankDTO{" +
                    "name='" + name + '\'' +
                    ", pageRank=" + pageRank +
                    '}';
        }
    }

