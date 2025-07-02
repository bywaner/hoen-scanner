package com.skyscanner;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

import java.util.ArrayList;
import java.util.List;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {
        // Nothing needed for now
    }

    @Override
    public void run(final HoenScannerConfiguration configuration, final Environment environment) {
        // 🔹 Temporary hardcoded results (you can load from JSON later)
        List<SearchResult> results = new ArrayList<>();
        SearchResult sampleHotel = new SearchResult();
        sampleHotel.setCity("petalborough");
        sampleHotel.setKind("hotel");
        sampleHotel.setTitle("Petalborough Grand Hotel");

        results.add(sampleHotel);

        // 🔹 Register the /search endpoint
        environment.jersey().register(new SearchResource(results));
    }
}
