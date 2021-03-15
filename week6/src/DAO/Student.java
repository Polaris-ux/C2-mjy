package DAO;

/**
 * @author
 * @description
 * @create 2021-03-15 12:17
 */
public class Student {
    private String sno;
    private String name;
    private int age;
    private String college;

    public Student() {
    }

    public Student(String sno, String name, int age, String college) {
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.college = college;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "DAO.Student{" +
                "sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", college='" + college + '\'' +
                '}';
    }
}
