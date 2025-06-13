import java.util.ArrayList;
import java.util.List;

// Staff.java
// This is an abstract base class. It cannot be instantiated directly.
// Its purpose is to provide common attributes and behaviors for all types of staff members.
public abstract class Staff {
    // Private attributes common to all staff members.
    private String staffId;
    private String name;
    private String email;
    // Association: A staff member can be assigned to multiple departments.
    // This is a List of Department objects.
    protected List<Department> assignedDepartments; // Protected to allow subclasses direct access if needed, though public methods are better practice.

    /**
     * Constructor for the Staff base class.
     * Initializes a new Staff object with basic identification details.
     * @param staffId The unique identification number for the staff member.
     * @param name The full name of the staff member.
     * @param email The email address of the staff member.
     */
    public Staff(String staffId, String name, String email) {
        this.staffId = staffId;
        this.name = name;
        this.email = email;
        this.assignedDepartments = new ArrayList<>(); // Initialize the list of departments
    }

    /**
     * Abstract method to return role-specific details.
     * This method must be implemented (overridden) by every concrete subclass of Staff.
     * This is the core of polymorphism requirement: "Override one method in each subclass to return role-specific details."
     * @return A string containing details specific to the staff member's role.
     */
    public abstract String getDetails(); // No body here, implemented by subclasses

    /**
     * Adds a department to the list of departments this staff member is assigned to.
     * Demonstrates an association from Staff to Department.
     * @param department The Department object to associate with this staff member.
     */
    public void addDepartment(Department department) {
        if (department != null && !assignedDepartments.contains(department)) {
            assignedDepartments.add(department);
            // Optional: Also add the staff member to the department's staff list if not already there
            if (!department.getStaffMembers().contains(this)) {
                department.addStaffMember(this);
            }
            System.out.println(this.name + " assigned to " + department.getName() + " Department.");
        }
    }

    /**
     * Retrieves the names of departments this staff member is assigned to.
     * @return A formatted string listing the assigned departments.
     */
    public String getAssignedDepartmentsInfo() {
        if (assignedDepartments.isEmpty()) {
            return "No departments assigned.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Assigned Departments: ");
        for (int i = 0; i < assignedDepartments.size(); i++) {
            sb.append(assignedDepartments.get(i).getName());
            if (i < assignedDepartments.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    // --- Getter methods for Staff attributes ---

    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Department> getAssignedDepartments() {
        return assignedDepartments;
    }

    // --- Setter methods for Staff attributes (if needed) ---
    public void setEmail(String email) {
        this.email = email;
    }
}