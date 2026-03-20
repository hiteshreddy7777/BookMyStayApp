public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection");

        AddOnServiceManager serviceManager = new AddOnServiceManager();

        Service breakfast = new Service("Breakfast", 500.0);
        Service spa = new Service("Spa", 1000.0);

        serviceManager.addService("Single-1", breakfast);
        serviceManager.addService("Single-1", spa);

        System.out.println("Reservation ID: Single-1");
        System.out.println("Total Add-On Cost: " + serviceManager.calculateTotalServiceCost("Single-1"));
    }
}