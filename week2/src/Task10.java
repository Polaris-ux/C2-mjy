import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @Description
 * @create 2021-02-01-12:00
 */
public class Task10 {
    public static void main(String[] args) {
        PetShop shop = new PetShop();
        shop.add(new Dog("二哈", 1));
        shop.add(new Dog("阿拉斯加", 2));
        shop.add(new Cat("波斯猫", 2));
        shop.add(new Cat("蓝猫", 3));
        shop.add(new Bird("鹦鹉", 1));
        shop.add(new Bird("百灵鸟", 1));
        List<Pet> list = shop.getList();
        for (Pet pet : list) {
            System.out.println(pet);
        }
        System.out.println("--------------------------");
        shop.delete(new Cat("波斯猫", 2));
        List<Pet> list1 = shop.getList();
        for (Pet pet : list1) {
            System.out.println(pet);
        }
        System.out.println("--------------------------");
        List<Pet> search = shop.search(2);
        for (Pet pet : search) {
            System.out.println(pet);
        }
    }

}

interface Pet {
    //获取宠物的名字
    String getName();

    //获取宠物的年龄
    int getAge();
}

class Cat implements Pet {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "宠物姓名：" + name + ",年龄：" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (age != cat.age) return false;
        return name != null ? name.equals(cat.name) : cat.name == null;
    }

}

class Dog implements Pet {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "宠物姓名：" + name + ",年龄：" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (age != dog.age) return false;
        return name != null ? name.equals(dog.name) : dog.name == null;
    }

}

class Bird implements Pet {
    private String name;
    private int age;

    public Bird(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "宠物姓名：" + name + ",年龄：" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bird bird = (Bird) o;

        if (age != bird.age) return false;
        return name != null ? name.equals(bird.name) : bird.name == null;
    }
}

class PetShop {
    private List<Pet> list = new ArrayList<>();

    public void add(Pet pet) {
        list.add(pet);
    }

    public void delete(Pet pet) {
        list.remove(pet);
    }

    public List<Pet> search(String str) {
        List<Pet> list1 = new ArrayList<>();
        //检索用户输入的关键字
        for (Pet pet : list) {
            if (pet.getName().contains(str)) {
                list1.add(pet);
            }
        }
        return list1;
    }

    public List<Pet> search(int age) {
        List<Pet> list1 = new ArrayList<>();
        //检索用户输入的关键字
        for (Pet pet : list) {
            if (pet.getAge() == age) {
                list1.add(pet);
            }
        }
        return list1;
    }

    public List<Pet> search(String name, int age) {
        List<Pet> list1 = new ArrayList<>();
        //检索用户输入的关键字
        for (Pet pet : list) {
            if (pet.getAge() == age && pet.getName().equals(name)) {
                list1.add(pet);
            }
        }
        return list1;
    }

    public List<Pet> getList() {
        return list;
    }
}
