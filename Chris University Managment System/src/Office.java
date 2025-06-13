
public class Office {
    // Private attributes to store the room number and phone extension.
    /* Making them private enforces encapsulation, meaning they can only be accessed
     or modified through the class's methods.*/
    private String roomNumber;
    private String phoneExtension;

    /**
     * Constructor for the Office class.
     * Initializes a new Office object with a specified room number and phone extension.
     * @param roomNumber The physical room number of the office.
     * @param phoneExtension The phone extension for the office.
     */
    public Office(String roomNumber, String phoneExtension) {
        this.roomNumber = roomNumber; // 'this' refers to the current object's instance variable.
        this.phoneExtension = phoneExtension;
    }

    /**
     * Returns a formatted string containing the office details.
     * This method provides a way to access the office's information.
     * @return A string representation of the office's room number and phone extension.
     */
    public String getOfficeDetails() {
        return "Room: " + roomNumber + ", Extension: " + phoneExtension;
    }

    // --- Getter methods for attributes (optional but good practice for access) ---

    /**
     * Retrieves the room number of the office.
     * @return The room number as a String.
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Retrieves the phone extension of the office.
     * @return The phone extension as a String.
     */
    public String getPhoneExtension() {
        return phoneExtension;
    }

    // --- Setter methods for attributes (optional, if you need to modify after creation) ---

    /**
     * Sets a new room number for the office.
     * @param roomNumber The new room number to set.
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Sets a new phone extension for the office.
     * @param phoneExtension The new phone extension to set.
     */
    public void setPhoneExtension(String phoneExtension) {
        this.phoneExtension = phoneExtension;
    }
}