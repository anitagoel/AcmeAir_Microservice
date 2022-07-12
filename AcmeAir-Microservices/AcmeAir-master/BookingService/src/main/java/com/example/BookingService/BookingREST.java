package com.example.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingREST {

    private final BookingServiceImpl service;

    @Autowired
    public BookingREST(BookingServiceImpl service){
        this.service=service;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllBookings(){
        try{
            return ResponseEntity.ok(service.getAllBookings());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/addBooking")
    public ResponseEntity<?> addBooking(@RequestBody BookingInfo booking){
        try{
            return ResponseEntity.ok(service.addBooking(booking));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PatchMapping("/updateBooking")
    public ResponseEntity<?> updateBooking(@RequestBody BookingInfo booking){
        try{
            return ResponseEntity.ok(service.updateBooking(booking));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<?> deleteBooking(@PathVariable long bookingId){
        try{
            return ResponseEntity.ok(service.deleteBooking(bookingId));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<?> findBookingsByUserId(@PathVariable long userId){
        try{
            return ResponseEntity.ok(service.findBookingsByUserId(userId));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/getByDestinationId/{toId}")
    public ResponseEntity<?> findBookingsByDestinationId(@PathVariable long toId){
        try{
            return ResponseEntity.ok(service.findBookingsByToId(toId));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/getBySourceId/{fromId}")
    public ResponseEntity<?> findBookingsByFromId(@PathVariable long fromId){
        try {
            return ResponseEntity.ok(service.findBookingsByFromId(fromId));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
