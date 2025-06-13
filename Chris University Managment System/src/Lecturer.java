import java.util.ArrayList;
import java.util.List;

// Lecturer.java
// Extends the Staff base class, inheriting its attributes and behaviors.
public class Lecturer extends Staff {
    // Private attribute specific to a Lecturer.
    private String specialization;
    // Aggregation: A Lecturer can teach multiple Courses. Courses are "given" to the lecturer,
    // and lecturers exist independently of courses.
    private List<Course> coursesTeaching;

    /**
     * Constructor for the Lecturer class.
     * Calls the superclass (Staff) constructor to initialize common attributes,
     * then initializes lecturer-specific attributes.
     * @param staffId The unique identification number for the lecturer.
     * @param name The full name of the lecturer.
     * @param email The email address of the lecturer.
     * @param specialization The area of expertise for the lecturer.
     */
    public Lecturer(String staffId, String name, String email, String specialization) {
        super(staffId, name, email); // Call to the constructor of the base class (Staff)
        this.specialization = specialization;
        this.coursesTeaching = new ArrayList<>(); // Initialize the list of courses this lecturer teaches
    }

    /**
     * Overrides the abstract getDetails() method from the Staff base class.
     * This demonstrates polymorphism by providing a Lecturer-specific implementation.
     * @return A string containing detailed information about the lecturer, including specialization.
     */
    @Override // Annotation indicating that this method overrides a method from a superclass.
    public String getDetails() {
        String baseDetails = "Staff ID: " + getStaffId() + "\n";
        baseDetails += "Name: " + getName() + "\n";
        baseDetails += "Email: " + getEmail() + "\n";
        baseDetails += "Role: Lecturer\n";
        baseDetails += "Specialization: " + specialization + "\n";
        baseDetails += getAssignedDepartmentsInfo(); // Include assigned departments
        return baseDetails;
    }

    /**
     * Assigns a course to this lecturer.
     * This method helps demonstrate the aggregation relationship with the Course class.
     * @param course The Course object to be assigned to this lecturer.
     */
    public void assignCourse(Course course) {
        if (course != null && !coursesTeaching.contains(course)) {
            coursesTeaching.add(course);
            // Optional: Also ensure the course knows about this lecturer if not already added
            if (!course.getLecturers().contains(this)) {
                course.addLecturer(this);
            }
            System.out.println(this.getName() + " is now assigned to teach '" + course.getTitle() + "'.");
        }
    }

    /**
     * Retrieves the specialization of the lecturer.
     * @return The specialization as a String.
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Retrieves the list of courses this lecturer is currently teaching.
     * @return A List of Course objects.
     */
    public List<Course> getCoursesTeaching() {
        return coursesTeaching;
    }

    // Setter for specialization (if modification is needed)
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}