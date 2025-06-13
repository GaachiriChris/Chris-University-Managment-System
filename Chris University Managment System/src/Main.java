
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Demonstrating University Department, Course, and Staff System ---");
        System.out.println("\n");

        // 1. Create Departments (demonstrates Composition with Office)
        System.out.println("--- Creating Departments (with Office Composition) ---");
        Department compSciDept = new Department("Computer Science", "CS", "LAB-201", "4888");
        Department electricalEngDept = new Department("Electrical Engineering", "EE", "ENG-305", "8569");
        Department humanitiesDept = new Department("Humanities", "HUM", "HUM-102", "2084");

        System.out.println("\n--- Department Details ---");
        System.out.println(compSciDept.getDepartmentInfo());
        System.out.println("\n" + electricalEngDept.getDepartmentInfo());
        System.out.println("\n" + humanitiesDept.getDepartmentInfo());
        System.out.println("\n");

        // 2. Create Staff Members (demonstrates Inheritance and Polymorphism)
        System.out.println("--- Creating Staff (Lecturers & Administrative Staff) ---");
        // Lecturer 1
        Lecturer profGachiri = new Lecturer("L001", "Dr. Chris Gachiri", "c.gachiri@uni.edu", "Artificial Intelligence");
        // Lecturer 2
        Lecturer drMbuki = new Lecturer("L002", "Dr. Moses Mbuki", "m.mbuki@uni.edu", "Digital Electronics");
        // Lecturer 3 (for aggregation example)
        Lecturer profWangari = new Lecturer("L003", "Prof. Wangari Wambui", "w.wangari@uni.edu", "Software Engineering");
        // Administrative Staff 1
        AdministrativeStaff adminClerk = new AdministrativeStaff("A001", "Mr. Kelvin Mungai", "k.mungai@uni.edu", "Department Secretary");
        // Administrative Staff 2
        AdministrativeStaff registrar = new AdministrativeStaff("A002", "Ms. Rose Nova", "r.nova@uni.edu", "Registrar");

        System.out.println("\n--- Staff Details (Polymorphism via getDetails()) ---");
        // Calling getDetails() on different staff types demonstrates polymorphism.
        // The JVM knows which overridden method to call based on the actual object type.
        System.out.println(profGachiri.getDetails());
        System.out.println("\n" + drMbuki.getDetails());
        System.out.println("\n" + adminClerk.getDetails());
        System.out.println("\n" + registrar.getDetails());
        System.out.println("\n");

        // 3. Demonstrate Association (Staff with Multiple Departments)
        System.out.println("--- Demonstrating Association (Staff with Multiple Departments) ---");
        profGachiri.addDepartment(compSciDept);
        profGachiri.addDepartment(electricalEngDept); // Dr. Smith teaches in both CS and EE
        drMbuki.addDepartment(electricalEngDept);
        adminClerk.addDepartment(compSciDept);
        adminClerk.addDepartment(humanitiesDept); // Admin clerk works for multiple departments

        System.out.println("\n--- Updated Staff Department Info ---");
        System.out.println(profGachiri.getName() + ": " + profGachiri.getAssignedDepartmentsInfo());
        System.out.println(adminClerk.getName() + ": " + adminClerk.getAssignedDepartmentsInfo());
        System.out.println("\n");

        // Verify departments also reflect the staff
        System.out.println("--- Department Staff Lists ---");
        System.out.println(compSciDept.getName() + " Staff:");
        for(Staff s : compSciDept.getStaffMembers()) {
            System.out.println(" - " + s.getName() + " (" + s.getStaffId() + ")");
        }
        System.out.println(electricalEngDept.getName() + " Staff:");
        for(Staff s : electricalEngDept.getStaffMembers()) {
            System.out.println(" - " + s.getName() + " (" + s.getStaffId() + ")");
        }
        System.out.println("\n");


        // 4. Create Courses (demonstrates Association with Department)
        System.out.println("--- Creating Courses (Association with Department) ---");
        Course programming101 = new Course("COMP101", "Introduction to Programming", 3, compSciDept);
        Course circuits = new Course("EE205", "Circuit Analysis I", 4, electricalEngDept);
        Course algorithms = new Course("COMP320", "Data Structures & Algorithms", 4, compSciDept);
        Course literature = new Course("HUM101", "World Literature", 3, humanitiesDept);

        System.out.println("\n--- Course Details ---");
        System.out.println(programming101.getCourseDetails());
        System.out.println("\n" + circuits.getCourseDetails());
        System.out.println("\n" + algorithms.getCourseDetails());
        System.out.println("\n");

        // 5. Demonstrate Aggregation (Course with Multiple Lecturers)
        System.out.println("--- Demonstrating Aggregation (Course with Multiple Lecturers) ---");
        programming101.addLecturer(profGachiri); // Prof. Gachiri teaches COMP101
        programming101.addLecturer(profWangari); // Prof. Wangari also teaches COMP101 (Aggregation: multiple lecturers per course)
        circuits.addLecturer(drMbuki);
        algorithms.addLecturer(profGachiri); // Prof. Gachiri teaches another course

        System.out.println("\n--- Updated Course Details (with Lecturers) ---");
        System.out.println(programming101.getCourseDetails());
        System.out.println("\n" + circuits.getCourseDetails());
        System.out.println("\n" + algorithms.getCourseDetails());
        System.out.println("\n");

        // Verify lecturers also reflect the courses they teach
        System.out.println("--- Lecturer Courses Teaching List ---");
        System.out.println(profGachiri.getName() + " is teaching:");
        for (Course c : profGachiri.getCoursesTeaching()) {
            System.out.println(" - " + c.getTitle() + " (" + c.getCourseCode() + ")");
        }
        System.out.println(drMbuki.getName() + " is teaching:");
        for (Course c : drMbuki.getCoursesTeaching()) {
            System.out.println(" - " + c.getTitle() + " (" + c.getCourseCode() + ")");
        }
        System.out.println(profWangari.getName() + " is teaching:");
        for (Course c : profWangari.getCoursesTeaching()) {
            System.out.println(" - " + c.getTitle() + " (" + c.getCourseCode() + ")");
        }
        System.out.println("\n");

        // Final check of department info after adding courses and staff
        System.out.println("--- Final Department Info Check ---");
        System.out.println(compSciDept.getDepartmentInfo());
        System.out.println("\n" + electricalEngDept.getDepartmentInfo());
    }
}