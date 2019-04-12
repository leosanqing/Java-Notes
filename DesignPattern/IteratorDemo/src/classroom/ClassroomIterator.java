package classroom;


public class ClassroomIterator implements Iterator {
    private Classroom classroom;
    private int index ;


    public ClassroomIterator(Classroom classroom) {
        this.classroom = classroom;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        if(index < classroom.getLength()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Object next() {
        Student student = classroom.getStudentAt(index);
        index++;
        return student;
    }
}
