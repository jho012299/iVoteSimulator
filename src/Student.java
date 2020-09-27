import java.util.UUID;

public class Student {
    private String id;
    private boolean hasAnswered;
    private String answer;

    public Student() {
        id = UUID.randomUUID().toString(); // students given randomly generated ID
        hasAnswered = false; // tracks whether students have answered already
    }

    // setters and getters

    public void setAnswer(String a) {
        answer = a;
    }

    public String getAnswer() {
        return answer;
    }

    public String getId() {
        return id;
    }

    public void setHasAnswered(boolean h) {
        hasAnswered = h;
    }

    public boolean getHasAnswered() {
        return hasAnswered;
    }

}
