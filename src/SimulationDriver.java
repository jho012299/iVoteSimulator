import java.util.ArrayList;

public class SimulationDriver {

    public static void main(String[] args) {
        ArrayList<String> trueFalse = new ArrayList<>(); // creates options for a true and false question
        trueFalse.add("A");
        trueFalse.add("B");

        ArrayList<String> singleChoice = new ArrayList<>(); // creates options for a single answer multiple choice question
        singleChoice.add("A");
        singleChoice.add("B");
        singleChoice.add("C");
        singleChoice.add("D");

        ArrayList<String> multiChoice = new ArrayList<>(); // creates options for a multiple answer multiple choice question
        multiChoice.add("A");
        multiChoice.add("B");
        multiChoice.add("C");
        multiChoice.add("D");

        VotingService vote = new VotingService(); // initialize VotingService

        vote.addStudent(); // add roster of students
        vote.addStudent();
        vote.addStudent();

        vote.addSingleQuestion("Which ocean is the largest ocean in the world?", singleChoice); //
        vote.submitAnswer(vote.getStudentAt(0), "A", 0); // answer submission process
        vote.submitAnswer(vote.getStudentAt(1), "B", 0);
        vote.submitAnswer(vote.getStudentAt(2), "C", 0);
        vote.printResults(0); // prints answers students selected

        vote.reset(); // clears Student answers, hasAnswered flag, and clears submitted answers list

        vote.addSingleQuestion("Dogs are real.", trueFalse); // only has two options
        vote.submitAnswer(vote.getStudentAt(0), "A", 1);
        vote.submitAnswer(vote.getStudentAt(1), "B", 1);
        vote.submitAnswer(vote.getStudentAt(2), "F", 1); // tests invalid answers
        vote.printResults(1);

        vote.reset();

        vote.addMultiQuestion("Which of the following are true?", multiChoice); // can have multiple answers
        vote.submitAnswer(vote.getStudentAt(0), "ABC", 2);
        vote.submitAnswer(vote.getStudentAt(1), "BC", 2);
        vote.submitAnswer(vote.getStudentAt(2), "CDA", 2);
        vote.printResults(2);

        vote.reset();

        vote.addMultiQuestion("What are the components of a BLT?", multiChoice);
        vote.submitAnswer(vote.getStudentAt(0), "DAB", 3);
        vote.submitAnswer(vote.getStudentAt(1), "CAB", 3);
        vote.submitAnswer(vote.getStudentAt(0), "BAD", 3); // tests student resubmission
        vote.printResults(3);
    }
}