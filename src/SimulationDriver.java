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

        VotingService vote = new VotingService();
        vote.addSingleQuestion("What is the biggest ocean in the world?", singleChoice);
        vote.addStudent();
        vote.addStudent();
        vote.addStudent();
        vote.submitAnswer(vote.getStudentAt(0), "A", 0);
        vote.submitAnswer(vote.getStudentAt(1), "B", 0);
        vote.submitAnswer(vote.getStudentAt(2), "C", 0);
        vote.printResults(0);

        vote.reset();

        vote.addSingleQuestion("Dogs are real.", trueFalse);
        vote.submitAnswer(vote.getStudentAt(0), "A", 1);
        vote.submitAnswer(vote.getStudentAt(1), "B", 1);
        vote.submitAnswer(vote.getStudentAt(0), "B", 1);
        vote.printResults(1);

        vote.reset();

        vote.addMultiQuestion("What of the following are true?", multiChoice);
        vote.submitAnswer(vote.getStudentAt(0), "ABC", 2);
        vote.submitAnswer(vote.getStudentAt(1), "BC", 2);
        vote.submitAnswer(vote.getStudentAt(0), "CDA", 2);
        vote.printResults(2);

        vote.reset();

        vote.addMultiQuestion("What materials do you use to craft a Diamond Sword?", multiChoice);
        vote.submitAnswer(vote.getStudentAt(0), "DAB", 3);
        vote.submitAnswer(vote.getStudentAt(1), "CAB", 3);
        vote.submitAnswer(vote.getStudentAt(0), "BAD", 3);
        vote.printResults(3);
    }
}

// use ONLY for "replacing" the UI
// driver calls all the methods from VotingService
// generate students here bc it's like a "generate students" button on a UI
