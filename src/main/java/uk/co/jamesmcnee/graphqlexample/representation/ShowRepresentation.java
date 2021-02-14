package uk.co.jamesmcnee.graphqlexample.representation;

import uk.co.jamesmcnee.graphqlexample.domain.Show;

public class ShowRepresentation {

    private final String title;
    private final Integer releaseYear;

    private ShowRepresentation(String title, Integer releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public static ShowRepresentation fromDomain(Show domain) {
        return new Builder()
                .withTitle(domain.getTitle())
                .withReleaseYear(domain.getReleaseYear())
                .build();
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

        public ShowRepresentation build() {
            return new ShowRepresentation(title, releaseYear);
        }
    }
}
