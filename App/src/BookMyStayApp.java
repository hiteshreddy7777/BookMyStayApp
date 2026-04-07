public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking History and Reporting");
        System.out.println();

        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        reportService.generateReport(history);
    }
}