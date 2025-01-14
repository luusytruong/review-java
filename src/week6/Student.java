package week6;

public class Student {
    private int id;
    private String fullName;
    private int age;
    private String phoneNumber;
    private String address;

    public Student(int id, String fullName, int age, String phoneNumber, String address) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Student(String fullName, int age, String phoneNumber, String address) {
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", fullName=" + fullName + ", age=" + age + ", phoneNumber=" + phoneNumber
                + ", address=" + address + "]";
    }

}
