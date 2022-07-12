package com.example.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class FlightREST {

    private final FlightServiceImpl service;

    @Autowired
    public FlightREST(FlightServiceImpl service){
        this.service=service;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFlights(){
        try{
            return ResponseEntity.ok(service.findAllFlights());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/addFlight")
    public ResponseEntity<?> addFlight(@RequestBody FlightInfo flight){
        try{
            return ResponseEntity.ok(service.addFlight(flight));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PatchMapping("/updateFlight")
    public ResponseEntity<?> updateFlight(@RequestBody FlightInfo flight){
        try{
            return ResponseEntity.ok(service.updateFlight(flight));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteFlight/{flightId}")
    public ResponseEntity<?> deleteFlight(@PathVariable long flightId){
        try{
            return ResponseEntity.ok(service.deleteFlight(flightId));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/getBySourceAirport/{sourceAirport}")
    public ResponseEntity<?> findBySourceAirport(@PathVariable String sourceAirport){
        try{
            sourceAirport=sourceAirport.toUpperCase();
            return ResponseEntity.ok(service.getBySourceAirport(sourceAirport));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/getByToAirport/{destinationAirport}")
    public ResponseEntity<?> findByDestinationAirport(@PathVariable String destinationAirport){
        try{
            destinationAirport=destinationAirport.toUpperCase();
            return ResponseEntity.ok(service.getByDestinationAirport(destinationAirport));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/getByFromDate/{fromDate}")
    public ResponseEntity<?> findByFromDate(@PathVariable String fromDate){
        try{
            return ResponseEntity.ok(service.getByFromDate(fromDate));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/getByToDate/{toDate}")
    public ResponseEntity<?> findByToDate(@PathVariable String toDate){
        try{
            return ResponseEntity.ok(service.getByToDate(toDate));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
