import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        addStudentsToList(studentList);

        //MARK: Question-A
        /*groupByClassName(studentList).values().stream().forEach(studentLists -> {
            System.out.println("Class: " + studentLists.get(0).getClassName());
            System.out.println(studentLists);
        });*/

        // MARK : Question-B
        //highestGradeOfEachClass(studentList).forEach(student -> System.out.println(student));

        // MARK : Question-C
        //Student highestGradeStudent = highestGradeStudent(studentList);
        //System.out.println("Highest Grade Student : " + highestGradeStudent.getName() + " - Grade : " + highestGradeStudent.getGrade());

        // MARK : Question-D
        //higherThanSeventyGrades(studentList).forEach(student -> System.out.println(student));

        // MARK : Question-E
        sortedByGrades(studentList).forEach(student -> System.out.println(student));

    }

    // MARK : Question-A
    public static Map<String, List<Student>> groupByClassName(List<Student> studentList) {
        return studentList.stream().collect(Collectors.groupingBy(Student::getClassName));
    }

    // MARK : Question-B
    public static List<Student> highestGradeOfEachClass(List<Student> studentList) {
        List<Student> highestGradeStudents = new ArrayList<>();

        Map<String, List<Student>> studentsGroupedByClass = studentList.stream().collect(Collectors.groupingBy(Student::getClassName));
        List<List<Student>> groupedByStudentLists = studentsGroupedByClass.values().stream().toList();

        groupedByStudentLists.stream().map(studentLists -> studentLists.stream().sorted(Comparator.comparing(Student::getGrade).reversed())).forEach(studentLists -> {
            highestGradeStudents.add(studentLists.toList().get(0));
        });
        return highestGradeStudents;
    }

    // MARK : Question-C
    public static Student highestGradeStudent(List<Student> studentList) {
        return studentList.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).toList().get(0);
    }

    // MARK : Question-D
    public static List<Student> higherThanSeventyGrades(List<Student> studentList) {
        return studentList.stream().filter(student -> student.getGrade() > 70).toList();
    }

    // MARK : Question-E
    public static List<Student> sortedByGrades(List<Student> studentList) {
        return studentList.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).toList();
    }

    public static void addStudentsToList(List<Student> studentList) {
        studentList.add(new Student("Sedat", 100, "A"));
        studentList.add(new Student("Samet", 97, "B"));
        studentList.add(new Student("Ahmet", 69, "C"));
        studentList.add(new Student("Sude", 74, "A"));
        studentList.add(new Student("Mehmet", 70, "B"));
        studentList.add(new Student("Beyza", 93, "C"));
        studentList.add(new Student("Sena", 91, "A"));
        studentList.add(new Student("Sedef", 65, "B"));
        studentList.add(new Student("Emel", 54, "C"));
        studentList.add(new Student("Mustafa", 45, "A"));
        studentList.add(new Student("Tolga", 63, "B"));
        studentList.add(new Student("Selin", 82, "C"));
        studentList.add(new Student("Aykut", 66, "A"));
        studentList.add(new Student("Ceren", 82, "B"));
        studentList.add(new Student("Ali", 94, "C"));
    }
}