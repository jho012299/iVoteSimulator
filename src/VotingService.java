import java.util.ArrayList;

public class VotingService {
    private ArrayList<Student> studentList;
    private ArrayList<Question> questionBank;

    public VotingService() {
        studentList = new ArrayList<>();
        questionBank = new ArrayList<>();
    }

    public void addStudent(){ // generates students to add to list
        studentList.add(new Student());
    }

    public void addSingleQuestion(String q, ArrayList<String> options) { // adds Single Choice Question to bank
        questionBank.add(new SingleChoice(q, options));
    }

    public void addMultiQuestion(String q, ArrayList<String> options) { // adds Multiple Choice Question to bank
        questionBank.add(new MultipleChoice(q, options));
    }

    public void submitAnswer(Student student, String answer){
        // get question
        // check if answer is valid
        //
    }

    public void printResults(){}

    public String getStudentAt(int i) {
        return studentList.get(i).getId();
    }

    // no hash map, use regular arraylist or array of students
    // bank of questions (arraylist? array? how to add question to bank?)
    // list of students; how to add student to roster? need methods
    // store answers

    /*// "When a student submits an answer, the program : "
public void submitAnswer(String studentId, String answer, int questionNum){

  // "it should also make sure the answer is a valid answer"
  if(!questions.get(questionNum).validateAnswer(answer)){
    sout("Student " + studentId + " did not give a valid answer.");
    return;
  }

  // "Let me know if the user already answered and changed their mind"
  for( Student stu: ArrayList<Student>){
    if(stu.getID().equals(studentId)){
      if(stu.hasAnswered()){
        sout("Student " + studentId + " rewrote their answer!");
      }
      stu.setAnswer(answer);
    }

  }
}*/

}
