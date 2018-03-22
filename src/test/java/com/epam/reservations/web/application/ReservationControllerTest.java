package com.epam.reservations.web.application;

import com.epam.reservations.business.service.ReservationService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    private final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    @MockBean
    private ReservationService reservationService;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void getReservations() throws Exception {
//        Date date = DATE_FORMAT.parse("2018-01-01");
//        List<RoomReservation> mockReservationList = new ArrayList<>();
//
//        RoomReservation mockRoomReservation = new RoomReservation();
//        mockRoomReservation.setFirstName("John");
//        mockRoomReservation.setLastName("Doe");
//        mockRoomReservation.setRoomNumber("J1");
//        mockRoomReservation.setRoomId(100);
//        mockRoomReservation.setDate(date);
//        mockRoomReservation.setGuestId(1);
//        mockRoomReservation.setRoomName("Room name");
//
//        mockReservationList.add(mockRoomReservation);
//
//        given(reservationService.getRoomReservationsForDate(date)).willReturn(mockReservationList);
//        mockMvc.perform(get("/reservaions?date=2018-01-01"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Doe, Room name")));
//
//
//    }
}