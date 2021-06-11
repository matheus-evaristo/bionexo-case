package com.example.spring.controller;

import com.example.spring.data.UbsRepository;
import com.example.spring.model.UbsList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UbsRestController {
    @Autowired
    private UbsRepository ubsRepository;

    /**
     *
     * @param queryCoordinates String value separated by comma, ordered lat,lon
     * @param page Current page to retrieve
     * @param perPage Number of returned registers per query
     * @return object with metadata about the return and list of found registers, with perPage as limit and page as offset
     */
    @GetMapping("/find_ubs")
    public UbsList getUBSListingByGeographicReference(
            @RequestParam(value = "query", defaultValue = "1,1") String queryCoordinates,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "per_page", defaultValue = "10") int perPage
    ) {
        String[] c = queryCoordinates.split(",");
        double lon =  Double.parseDouble(c[1]);
        double lat = Double.parseDouble(c[0]);

        Pageable pageable = PageRequest.of(page, perPage);
        Page sorted = ubsRepository.findAllByDistance(lon, lat, pageable);
        sorted.getTotalElements();

        return new UbsList(page, perPage, sorted.getTotalElements(), sorted.getContent());
    }

    /**
     * Test if server is online and receiving requests
     * @return a simples informative text
     */
    @GetMapping("/test")
    public String testRoute() { return "Server online"; }
}
