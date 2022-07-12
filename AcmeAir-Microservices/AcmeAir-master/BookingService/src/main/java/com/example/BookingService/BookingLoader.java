package com.example.BookingService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingLoader extends JpaRepository<BookingInfo,Long> {
    BookingInfo findBookingInfoById(long bookingId);
    List<BookingInfo> findBookingInfosByUserId(long userId);

    List<BookingInfo> findBookingInfosByToFlightId(long toId);

    List<BookingInfo> findBookingInfosByRetFlightId(long retId);
}
