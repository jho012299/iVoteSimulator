import java.util.UUID;

public class Student {
    private String id;
    private boolean hasAnswered;
    // private String answer;

    public Student() {
        id = UUID.randomUUID().toString();
        hasAnswered = false;
    }

    public String getId() {
        return id;
    }

    public boolean getHasAnswered() {
        return hasAnswered;
    }

    // hasAnswered: whether the student has answered the question or not
    // method to reinitialize hasAnswered to false
    // method to reinitialize hasAnswered to true
}
