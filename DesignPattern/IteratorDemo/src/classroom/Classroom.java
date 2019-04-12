package classroom;

public class Classroom implements Aggregate{

    private Student[] students ;
    private int last = 0;

    public Classroom(int maxNum) {
        this.students = new Student[maxNum];
    }

    public void addStudent(Student student){
        this.students[last] = student;
        last++;

    }
    public int getLength(){
        return last;
    }

    public Student getStudentAt(int index){
        return students[index];
    }

    @Override
    public Iterator iterator() {
        return new ClassroomIterator(this);
    }
}
