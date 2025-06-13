import java.util.ArrayList;
import java.util.List;

// Course.java
public class Course {
    // Private attributes for course details.
    private String courseCode; // e.g., "COMP 101"
    private String title;      // e.g., "Introduction to Programming"
    private int credits;
    // Association: A Course is offered by one Department.
    // This is a direct reference to a Department object.
    private Department offeringDepartment;
    // Aggregation: A Course can be taught by multiple Lecturers.
    // Lecturers exist independently of the course (aggregation, not composition).
    // If the course is deleted, the lecturers still exist.
    private List<Lecturer> lecturers;

    /**
     * Constructor for the Course class.
     * Initializes a new Course object and associates it with an offering department.
     * @param courseCode The unique code for the course.
     * @param title The full title of the course.
     * @param credits The number of academic credits for the course.
     * @param offeringDepartment The Department object that offers this course.
     */
    public Course(String courseCode, String title, int credits, Department offeringDepartment) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.offeringDepartment = offeringDepartment;
        this.lecturers = new ArrayList<>(); // Initialize the list to hold assigned lecturers

        // Optional: Automatically add this course to the department's list of courses
        // This helps maintain bidirectional consistency in the association.
        if (offeringDepartment != null) {
            offeringDepartment.addCourse(this);
        }
    }

    /**
     * Adds a lecturer to the list of lecturers teaching this course.
     * This demonstrates the aggregation relationship.
     * @param lecturer The Lecturer object to be added to the course.
     */
    public void addLecturer(Lecturer lecturer) {
        if (lecturer != null && !lecturers.contains(lecturer)) {
            lecturers.add(lecturer);
            // Optional: Also ensure the lecturer knows they are teaching this course
            if (!lecturer.getCoursesTeaching().contains(this)) {
                lecturer.assignCourse(this);
            }
            System.out.println("Lecturer '" + lecturer.getName() + "' assigned to course '" + this.title + "'.");
        }
    }

    /**
     * Returns a formatted string containing the course details,
     * including its offering department and assigned lecturers.
     * @return A string representation of the course's code, title, credits, department, and lecturers.
     */
    public String getCourseDetails() {
        String info = "Course Code: " + courseCode + "\n";
        info += "Title: " + title + "\n";
        info += "Credits: " + credits + "\n";
        if (offeringDepartment != null) {
            info += "Offered by Department: " + offeringDepartment.getName() + "\n";
        } else {
            info += "Offered by Department: Not assigned\n";
        }
        info += "Assigned Lecturers (" + lecturers.size() + "): ";
        if (lecturers.isEmpty()) {
            info += "None";
        } else {
            for (int i = 0; i < lecturers.size(); i++) {
                info += lecturers.get(i).getName();
                if (i < lecturers.size() - 1) {
                    info += ", ";
                }
            }
        }
        return info;
    }

    // --- Getter methods for Course attributes ---

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public Department getOfferingDepartment() {
        return offeringDepartment;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    // --- Setter methods for Course attributes (if needed) ---
    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setOfferingDepartment(Department offeringDepartment) {
        this.offeringDepartment = offeringDepartment;
        // Optional: Re-add or remove from old department if changing
    }
}