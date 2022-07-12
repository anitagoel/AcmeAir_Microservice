package com.example.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    private final FlightLoader repo;

    @Autowired
    public FlightServiceImpl(FlightLoader repo){
        this.repo=repo;
    }
    @Override
    public List<FlightInfo> findAllFlights() {
        return repo.findAll();
    }

    @Override
    public FlightInfo addFlight(FlightInfo flight) {
        flight.setToAirport(flight.getToAirport().toUpperCase());
        flight.setFromAirport(flight.getFromAirport().toUpperCase());
        flight.setFromDate(flight.getFromDate().toUpperCase());
        flight.setReturnDate(flight.getReturnDate().toUpperCase());
        return repo.save(flight);
    }

    @Override
    public FlightInfo updateFlight(FlightInfo flight) {
        FlightInfo oldFlight = repo.findFlightInfoById(flight.getId());
        flight.setFromDate(flight.getFromDate()==null? oldFlight.getFromDate() : flight.getFromDate());
        flight.setOneWay(flight.getOneWay()==null?oldFlight.getOneWay():flight.getOneWay());
        flight.setFromAirport(flight.getFromAirport()==null?oldFlight.getFromAirport(): flight.getFromAirport());
        flight.setReturnDate(flight.getReturnDate()==null? oldFlight.getReturnDate() : flight.getReturnDate());
        flight.setToAirport(flight.getToAirport()==null? oldFlight.getToAirport() : flight.getToAirport());
        return repo.save(flight);
    }

    @Override
    public FlightInfo deleteFlight(long flightId) {
        FlightInfo flight=repo.findFlightInfoById(flightId);
        repo.delete(flight);
        return flight;
    }

    @Override
    public List<FlightInfo> getBySourceAirport(String sourceAirport) {
        return repo.findFlightInfosByFromAirport(sourceAirport);
    }

    @Override
    public List<FlightInfo> getByDestinationAirport(String destinationAirport) {
        return repo.findFlightInfosByToAirport(destinationAirport);
    }

    @Override
    public List<FlightInfo> getByFromDate(String fromDate) {
        return repo.findFlightInfosByFromDate(fromDate);
    }

    @Override
    public List<FlightInfo> getByToDate(String toDate) {
        return repo.findFlightInfosByReturnDate(toDate);
    }
}
