package com.example.FlightService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightLoader extends JpaRepository<FlightInfo,Long> {

    FlightInfo findFlightInfoById(long flightId);
    List<FlightInfo> findFlightInfosByFromAirport(String fromAirport);
    List<FlightInfo> findFlightInfosByToAirport(String toAirport);
    List<FlightInfo> findFlightInfosByFromDate(String fromDate);
    List<FlightInfo> findFlightInfosByReturnDate(String retDate);
}
