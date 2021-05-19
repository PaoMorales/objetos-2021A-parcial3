package uaslp.objetos.exams;

public class Student {

    private String name;
    private int code;
    private Integer score[];


    public Student(String name, int code) {
        this.name = name;
        this.code = code;
        score = new Integer[3];
    }

    public void setScore(int partial, int score)  throws InvalidPartialException{

        if(partial == 0 || partial > 3)
            throw new InvalidPartialException();
        this.score[partial -1] = score;
    }


    public double getAverage() throws MissingScoreException {
        double average = 0;

        for (int i = 0; i < 3; i++) {

            if (score[i] == null)
                throw new MissingScoreException("Missing partial " + (i + 1));
            average = average + score[i];
        }
        average = average / 3;
        return average;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
