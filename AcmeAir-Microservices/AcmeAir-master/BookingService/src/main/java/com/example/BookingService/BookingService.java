package com.example.BookingService;

import java.util.List;

public interface BookingService {

    List<BookingInfo> getAllBookings();

    BookingInfo addBooking(BookingInfo booking);

    BookingInfo updateBooking(BookingInfo booking);

    BookingInfo deleteBooking(long bookingId);

    List<BookingInfo> findBookingsByUserId(long userId);

    List<BookingInfo> findBookingsByToId(long toId);

    List<BookingInfo> findBookingsByFromId(long fromId);
}
