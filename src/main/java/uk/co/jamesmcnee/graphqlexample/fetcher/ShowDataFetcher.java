package uk.co.jamesmcnee.graphqlexample.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import uk.co.jamesmcnee.graphqlexample.domain.Show;
import uk.co.jamesmcnee.graphqlexample.representation.ShowRepresentation;
import uk.co.jamesmcnee.graphqlexample.service.ShowService;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@DgsComponent
public class ShowDataFetcher {

    private final ShowService showService;

    @Autowired
    public ShowDataFetcher(ShowService showService) {
        this.showService = showService;
    }

    @DgsData(parentType = "Query", field = "shows")
    public List<ShowRepresentation> getShows(@InputArgument("titleFilter") String titleFilter) {
        List<Show> shows = showService.getAvailableShows();

        return shows.stream().filter(show -> isNull(titleFilter) || show.getTitle().toLowerCase().contains(titleFilter.toLowerCase())).map(ShowRepresentation::fromDomain).collect(toList());
    }


}
