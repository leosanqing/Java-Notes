package classroom;

public class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom(10);

        classroom.addStudent(new Student("张三"));
        classroom.addStudent(new Student("李四"));
        classroom.addStudent(new Student("王二麻子"));
        classroom.addStudent(new Student("屁屁猪"));
        Iterator iterator = classroom.iterator();
        while (iterator.hasNext()){
            System.out.println(((Student) iterator.next()).getName());
        }
    }

}
