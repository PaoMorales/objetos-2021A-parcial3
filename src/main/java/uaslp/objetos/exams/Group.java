package uaslp.objetos.exams;
import java.util.List;
import java.util.ArrayList;

public class Group {

    private List<Student> students;
    private int capacity;
    private int availability;


    public Group(int capacity) {
        this.capacity = capacity;
        availability = capacity;
        students = new ArrayList<>(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailability() {
        return availability;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (availability <= 0)
            throw new GroupIsFullException();
        students.add(student);
        availability--;
    }

    public double getAverage() {
        Student student;
        double average = 0;

        for (int i = 0; i<students.size(); i++){
            student = students.get(i);
            average = average + student.getAverage();
        }
        average = average/students.size();
        return average;
    }
}
