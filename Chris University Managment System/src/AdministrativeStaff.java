// AdministrativeStaff.java
// Extends the Staff base class, inheriting its attributes and behaviors.
public class AdministrativeStaff extends Staff {
    // Private attribute specific to Administrative Staff.
    private String role; // e.g., "Registrar", "Department Secretary"

    /**
     * Constructor for the AdministrativeStaff class.
     * Calls the superclass (Staff) constructor to initialize common attributes,
     * then initializes administrative staff-specific attributes.
     * @param staffId The unique identification number for the administrative staff.
     * @param name The full name of the administrative staff.
     * @param email The email address of the administrative staff.
     * @param role The specific administrative role (e.g., "Registrar").
     */
    public AdministrativeStaff(String staffId, String name, String email, String role) {
        super(staffId, name, email); // Call to the constructor of the base class (Staff)
        this.role = role;
    }

    /**
     * Overrides the abstract getDetails() method from the Staff base class.
     * This demonstrates polymorphism by providing an AdministrativeStaff-specific implementation.
     * @return A string containing detailed information about the administrative staff, including their role.
     */
    @Override // Annotation indicating that this method overrides a method from a superclass.
    public String getDetails() {
        String baseDetails = "Staff ID: " + getStaffId() + "\n";
        baseDetails += "Name: " + getName() + "\n";
        baseDetails += "Email: " + getEmail() + "\n";
        baseDetails += "Role: Administrative Staff (" + role + ")\n";
        baseDetails += getAssignedDepartmentsInfo(); // Include assigned departments
        return baseDetails;
    }

    /**
     * Retrieves the specific role of the administrative staff.
     * @return The role as a String.
     */
    public String getRole() {
        return role;
    }

    // Setter for role (if modification is needed)
    public void setRole(String role) {
        this.role = role;
    }
}