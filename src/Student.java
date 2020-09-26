import java.util.UUID;

public class Student {
    private String id;

    public Student() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    // hasAnswered: whether the student has answered the question or not
    // method to reinitialize hasAnswered to false
    // method to reinitialize hasAnswered to true
}
