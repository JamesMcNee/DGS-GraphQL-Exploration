package uk.co.jamesmcnee.graphqlexample.domain;

public class Show {

    private final String title;
    private final Integer releaseYear;

    private Show(String title, Integer releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }


    public static final class Builder {

        private String title;
        private Integer releaseYear;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withReleaseYear(Integer releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Show build() {
            return new Show(title, releaseYear);
        }
    }
}
