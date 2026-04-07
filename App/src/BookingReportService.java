public class BookingReportService {

    public void generateReport(BookingHistory history) {
        System.out.println("Booking History Report");
        for (Reservation reservation : history.getConfirmedReservations()) {
            System.out.println("Guest: " + reservation.getGuestName() + ", Room Type: " + reservation.getRoomType());
        }
    }
}