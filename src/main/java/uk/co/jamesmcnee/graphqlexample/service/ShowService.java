package uk.co.jamesmcnee.graphqlexample.service;

import org.springframework.stereotype.Service;
import uk.co.jamesmcnee.graphqlexample.domain.Show;

import java.util.List;

@Service
public class ShowService {

    public List<Show> getAvailableShows() {
        return List.of(
                new Show.Builder().withTitle("Stranger Things").withReleaseYear(2016).build(),
                new Show.Builder().withTitle("Ozark").withReleaseYear(2017).build(),
                new Show.Builder().withTitle("The Crown").withReleaseYear(2016).build(),
                new Show.Builder().withTitle("Dead to Me").withReleaseYear(2019).build(),
                new Show.Builder().withTitle("Orange is the New Black").withReleaseYear(2013).build()
        );
    }
}