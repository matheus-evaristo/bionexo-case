package com.example.spring.data;

import com.example.spring.model.Ubs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UbsRepository extends PagingAndSortingRepository<Ubs, Long> {
    Ubs findById(long id);

    /**
     * Queries all of the registers from ubs table, ordering by the distance from the given parameters lon and lat,
     * from the closest to the farthest, using a spatial query provided by the Postgis extension (PostgreSQL ecosystem).
     * @param lon starting longitude to build the query
     * @param lat starting latitude to build the query
     * @param pageable specifies a page size and index to limit the query size
     * @return a Page object, delimited by a pageable object, with elements ordered by distance
     */
    @Query(value = "SELECT * FROM ubs u ORDER BY ST_DISTANCE(ST_MAKEPOINT(u.vlr_longitude, u.vlr_latitude), " +
            "ST_MAKEPOINT(:lon, :lat))", nativeQuery = true)
    Page<Ubs> findAllByDistance(@Param("lon") double lon, @Param("lat") double lat, Pageable pageable);
}
