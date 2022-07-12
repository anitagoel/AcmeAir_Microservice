package com.example.FlightService;

import java.util.List;

public interface FlightService {
    List<FlightInfo> findAllFlights();

    FlightInfo addFlight(FlightInfo flight);

    FlightInfo updateFlight(FlightInfo flight);

    FlightInfo deleteFlight(long flightId);

    List<FlightInfo> getBySourceAirport(String sourceAirport);

    List<FlightInfo> getByDestinationAirport(String destinationAirport);

    List<FlightInfo> getByFromDate(String fromDate);

    List<FlightInfo> getByToDate(String toDate);
}
