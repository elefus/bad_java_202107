public class User {
    private String userName;
    private int age;

    User(String name, int age){
        userName = name;
        this.age = age;
    }

    public void setUserName(String name) {
        userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserAge(int age) {
        this.age = age;
    }

    public int getUserAge() {
        return age;
    }
}
