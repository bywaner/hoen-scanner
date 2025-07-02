package com.skyscanner;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SearchResource {

    private final List<SearchResult> allResults;

    public SearchResource(List<SearchResult> allResults) {
        this.allResults = allResults;
    }

    @POST
    public List<SearchResult> search(Search search) {
        return allResults.stream()
                .filter(r -> r.getCity().equalsIgnoreCase(search.getCity()))
                .collect(Collectors.toList());
    }
}
