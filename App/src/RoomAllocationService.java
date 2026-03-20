import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (availability.get(roomType) != null && availability.get(roomType) > 0) {
            String roomId = generateRoomId(roomType);
            allocatedRoomIds.add(roomId);

            assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
            assignedRoomsByType.get(roomType).add(roomId);

            inventory.updateAvailability(roomType, availability.get(roomType) - 1);

            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() + ", Room ID: " + roomId);
        } else {
            System.out.println("No rooms available for Guest: " + reservation.getGuestName() + ", Room Type: " + roomType);
        }
    }

    private String generateRoomId(String roomType) {
        int count = assignedRoomsByType.containsKey(roomType) ? assignedRoomsByType.get(roomType).size() + 1 : 1;
        return roomType + "-" + count;
    }
}