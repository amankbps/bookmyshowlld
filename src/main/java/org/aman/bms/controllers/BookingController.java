package org.aman.bms.controllers;


import org.aman.bms.dto.BlockSeatsRequestDto;
import org.aman.bms.dto.BookSeatRequestDto;
import org.aman.bms.models.Ticket;
import org.aman.bms.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

      private final BookingService bookingService;

      public BookingController(BookingService bookingService) {
          this.bookingService = bookingService;
      }

     @PostMapping("/block")
     public boolean blockSeat(@RequestBody BlockSeatsRequestDto blockSeatsRequestDto){

          return bookingService.blockSeats(blockSeatsRequestDto.getShowId(),
                  blockSeatsRequestDto.getSeatId(), blockSeatsRequestDto.getUserId());
     }
    @DeleteMapping
    public void clearAllSeatLocks() {
        bookingService.clearAllSeatLocks();
    }

    @PostMapping("/confirm")
    public Optional<Ticket> confirmBooking(@RequestBody BookSeatRequestDto bookSeatRequestDto) {
        return bookingService.bookTicket(
                bookSeatRequestDto.getShowId(),
                bookSeatRequestDto.getSeatId(),
                bookSeatRequestDto.getUserId()
        );
    }

}
