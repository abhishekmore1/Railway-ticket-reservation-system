package com.example.booking.service;

import com.example.booking.service.controller.BookingController;
import com.example.booking.service.entity.Bookings;
import com.example.booking.service.entity.Trains;
import com.example.booking.service.repository.BookingRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class BookingServiceApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	BookingController bookingController;

	//testing ticket boooking
	@Test
	@DisplayName("AddBooking")
	void addBooking() {
		Bookings booking=new Bookings();
		booking.setTrainId(1L);
		booking.setPassengerName("aaa");
		booking.setPassengerPhNo("123456789");
		booking.setPassengerEmail("aaa@gmail.com");
		booking.setSource("xxx");
		booking.setDestination("yyy");
		booking.setNoOfTickets(3L);
		bookingRepository.save(booking);
		assertNotNull(bookingRepository.getByPassengerEmail("aaa@gmail.com"));
	}

	//Testing get ticket
	@Test
	@DisplayName("GetTicket")
	void getTicket() {
//		when(bookingRepository.findAll()).thenReturn(Stream.of(
//			new Bookings(1L,1L,"aaa","123456789","aaa@gmail.com","xxx","yyy",1L,200.0),
//			new Bookings(2L,1L,"bbb","125446789","bbb@gmail.com","xxx","yyy",1L,200.0),
//		).collect(Collectors.toList()));
//		assertEquals(3,bookingController.getAllBooking().size());

		List<Bookings> booking=bookingRepository.findAll();
		assertNotNull(booking);
	}

	//Testing ticket deletion
	@Test
	@DisplayName("DeleteTicket")
	void deleteTicket() {
		bookingRepository.deleteById(12L);
		assertFalse(bookingRepository.existsById(12L));
	}

}
