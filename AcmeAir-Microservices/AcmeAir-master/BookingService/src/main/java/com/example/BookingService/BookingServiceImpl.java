package com.example.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    private final BookingLoader repo;

    @Autowired
    public BookingServiceImpl(BookingLoader repo){
        this.repo=repo;
    }


    @Override
    public List<BookingInfo> getAllBookings() {
        return repo.findAll();
    }

    @Override
    public BookingInfo addBooking(BookingInfo booking) {
        return repo.save(booking);
    }

    @Override
    public BookingInfo updateBooking(BookingInfo booking) {
        BookingInfo oldBooking = repo.findBookingInfoById(booking.getId());
        booking.setOneWay(booking.getOneWay()==null?oldBooking.getOneWay():booking.getOneWay());
        booking.setToFlightId(booking.getToFlightId()==null?oldBooking.getToFlightId(): booking.getToFlightId());
        booking.setRetFlightId(booking.getRetFlightId()==null?oldBooking.getRetFlightId():booking.getRetFlightId());
        booking.setUserId(booking.getUserId()==null?oldBooking.getUserId():booking.getUserId());
        return repo.save(booking);
    }

    @Override
    public BookingInfo deleteBooking(long bookingId) {
        BookingInfo bookingInfo = repo.findBookingInfoById(bookingId);
        repo.delete(bookingInfo);
        return bookingInfo;
    }

    @Override
    public List<BookingInfo> findBookingsByUserId(long userId){
        return repo.findBookingInfosByUserId(userId);
    }

    @Override
    public List<BookingInfo> findBookingsByToId(long toId) {
        return repo.findBookingInfosByToFlightId(toId);
    }

    @Override
    public List<BookingInfo> findBookingsByFromId(long fromId) {
        return repo.findBookingInfosByRetFlightId(fromId);
    }
}
