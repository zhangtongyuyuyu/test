public class Student {
    private String name;
    private int score;

    public Student(String studentName, int studentScore){
        name = studentName;
        score = studentScore;
    }
    @Override
    public String toString(){
        return String.format("Student(name: %s,score: %d)",name,score);
    }

    public static void main(String[] args) {
        Array<Student> ar = new Array<>();
        ar.addList(new Student("ZhangSan",20));
        ar.addList(new Student("Zhang",50));
        ar.addList(new Student("San",30));
        System.out.println(ar);
    }
}
