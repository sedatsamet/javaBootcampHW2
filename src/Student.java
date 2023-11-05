public class Student {
    private String name;
    private int grade;
    private String className;

    Student(String name, int grade, String className) {
        this.name = name;
        this.grade = grade;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Student Name: " + name + " Grade: " + grade + " Class Name: " + className;
    }
}
