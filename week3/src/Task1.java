import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @Description 用 List 来存储下表信息并遍历输出
 * @create 2021-02-09-23:24
 */
public class Task1 {
    public static void main(String[] args) {
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(1,"Joe",70000,3));
        list.add(new Employee(2,"Henry",80000,4));
        list.add(new Employee(3,"Sam",60000,null));
        list.add(new Employee(4,"Max",90000,null));
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

}

class Employee{
    private int id;
    private String name;
    private int salary;
    private Integer managerId;

    public Employee(){

    }
    public Employee(int id,String name,int salary,Integer managerId){
        this.id=id;
        this.salary=salary;
        this.name=name;
        this.managerId=managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", managerId=" + managerId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}
