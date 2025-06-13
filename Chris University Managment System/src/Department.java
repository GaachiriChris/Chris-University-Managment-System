import java.util.ArrayList; // Import ArrayList to use dynamic arrays
import java.util.List;    // Import List interface for type hinting

// Department.java
public class Department {
    // Private attributes to store department information.
    private String name;
    private String departmentCode;
    // Composition: Department "has-a" Office. The Office object is created and managed
    // internally by the Department. If the Department ceases to exist, its Office object
    // conceptually also ceases to exist with it.
    private Office office;
    // Association: A Department can have a head, which is a Staff member.
    private Staff headOfDepartment; // Could be null initially or set later.
    // Association: A Department offers multiple Courses.
    private List<Course> coursesOffered;
    // Association: A Department has multiple Staff members.
    private List<Staff> staffMembers;

    /**
     * Constructor for the Department class.
     * Initializes a new Department object and creates its associated Office object
     * demonstrating composition.
     * @param name The name of the department (e.g., "Computer Science").
     * @param departmentCode The unique code for the department (e.g., "CS").
     * @param officeRoomNumber The room number for the department's office.
     * @param officePhoneExtension The phone extension for the department's office.
     */
    public Department(String name, String departmentCode, String officeRoomNumber, String officePhoneExtension) {
        this.name = name;
        this.departmentCode = departmentCode;
        // Composition in action: creating an Office object directly within the Department's constructor.
        this.office = new Office(officeRoomNumber, officePhoneExtension);
        this.coursesOffered = new ArrayList<>(); // Initialize the list to hold courses
        this.staffMembers = new ArrayList<>();   // Initialize the list to hold staff members
    }

    /**
     * Adds a course to the list of courses offered by this department.
     * Demonstrates an association between Department and Course.
     * @param course The Course object to be added.
     */
    public void addCourse(Course course) {
        if (course != null && !coursesOffered.contains(course)) {
            coursesOffered.add(course);
            System.out.println("Course '" + course.getTitle() + "' added to " + this.name + " Department.");
        }
    }

    /**
     * Adds a staff member to the list of staff belonging to this department.
     * Demonstrates an association between Department and Staff.
     * @param staffMember The Staff object to be added.
     */
    public void addStaffMember(Staff staffMember) {
        if (staffMember != null && !staffMembers.contains(staffMember)) {
            staffMembers.add(staffMember);
            // Also, update the staff member's list of departments if they are not already associated
            if (!staffMember.getAssignedDepartments().contains(this)) {
                staffMember.addDepartment(this);
            }
            System.out.println("Staff member '" + staffMember.getName() + "' added to " + this.name + " Department.");
        }
    }

    /**
     * Sets the head of the department. This is a specific association.
     * @param headOfDepartment The Staff object who is the head of the department.
     */
    public void setHeadOfDepartment(Staff headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
        System.out.println(headOfDepartment.getName() + " set as Head of " + this.name + " Department.");
    }

    /**
     * Returns a formatted string containing the department's information,
     * including its associated office details (demonstrating composition).
     * @return A string representation of the department's name, code, and office details.
     */
    public String getDepartmentInfo() {
        String info = "Department Name: " + name + "\n";
        info += "Department Code: " + departmentCode + "\n";
        info += "Office Details: " + office.getOfficeDetails(); // Accessing composed Office object
        if (headOfDepartment != null) {
            info += "\nHead of Department: " + headOfDepartment.getName();
        }
        info += "\nCourses Offered (" + coursesOffered.size() + "): ";
        if (coursesOffered.isEmpty()) {
            info += "None";
        } else {
            for (Course course : coursesOffered) {
                info += "\n  - " + course.getTitle() + " (" + course.getCourseCode() + ")";
            }
        }
        info += "\nStaff Members (" + staffMembers.size() + "): ";
        if (staffMembers.isEmpty()) {
            info += "None";
        } else {
            for (Staff staff : staffMembers) {
                info += "\n  - " + staff.getName() + " (" + staff.getStaffId() + ")";
            }
        }
        return info;
    }

    // --- Getter methods for Department attributes ---
    public String getName() {
        return name;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public Office getOffice() {
        return office;
    }

    public Staff getHeadOfDepartment() {
        return headOfDepartment;
    }

    public List<Course> getCoursesOffered() {
        return coursesOffered;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }
}