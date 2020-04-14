import src.Student;
import src.StudentStreamFunction;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  public Stream<Student> findSecondAndThirdTopStudentForGivenCourse(Stream<Student> studentStream, String name){

    Comparator<Student> cmp = new Comparator<Student>() {
      @Override
      public int compare(Student o1, Student o2) {
        Double d1 = o1.getCoursesResults().get(name);
        Double d2 = o2.getCoursesResults().get(name);
        if (d1 > d2) return 1;
        if (d1 < d2) return -1;
        return 0;
      }
    };

    return studentStream
            .filter(student -> student.getCoursesResults().containsKey(name))
            .sorted(cmp)
            .skip(1)
            .limit(2);
  }

  public Object[] computeAverageForStudentInSection(Stream<Student> studentStream, int section){

    return studentStream
            .filter(student -> student.getSection() == section)
            .map(student -> new Object[] {"Student " + student.getFirstName() + " " + student.getLastName(),
                    student.getCoursesResults().values().stream().reduce(Double::sum).orElse(0.0) / student.getCoursesResults().size()
            }).toArray();
  }

  public int getNumberOfSuccessfulStudents(Stream<Student> studentStream){
    //TODO YOUR CODE HERE
  }

  public Student findLastInLexicographicOrder(Stream<Student> studentStream){
    //TODO YOUR CODE HERE
  }

  public double getFullSum(Stream<Student> studentStream){
    //TODO YOUR CODE HERE
  }
}
