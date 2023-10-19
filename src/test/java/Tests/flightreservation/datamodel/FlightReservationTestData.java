package Tests.flightreservation.datamodel;

public record FlightReservationTestData(String firstName,String lastName,String email,String password,String street,String city,String zipcode,String passengerCount,String expectedPrice) {
}
