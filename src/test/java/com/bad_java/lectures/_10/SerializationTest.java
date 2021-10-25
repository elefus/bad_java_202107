package com.bad_java.lectures._10;

import com.bad_java.lectures._03.library.domain.User;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

public class SerializationTest {

    @Test
    void user() {
        User admin = User.builder()
                        .id(42)
                        .type(User.Type.ADMIN)
                        .username("adm_username")
                        .password("pwd")
                        .build();

        User manager = User.builder()
                         .id(43)
                         .type(User.Type.MANAGER)
                         .username("manager_username")
                         .password("pwd")
                         .build();

        List<User> users = List.of(admin, manager);

        isAuthorizedUsers(users, "op");
    }

    @SneakyThrows
    public static boolean isAuthorizedUsers(List<User> users, String operation) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (FileOutputStream fos = new FileOutputStream("data/extern.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

//            A a = new A("My final string");
//            B b = new B(a);
//            a.setB(b);

//            oos.writeObject(a);

            oos.writeObject(new C(55, "string", true));
        }

//        oos.writeObject(users);
//        oos.writeObject(operation);

        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("data/extern.out")))) {
//            A a = (A) in.readObject();
//            System.out.println(a.getStringField());
//            System.out.println(a);

            C c = (C) in.readObject();
            System.out.println(c);
        }


        return true;
    }
}

class A implements Serializable {

    private static final long serialVersionUID = 501;

    private final String stringField;

    B b;

    A(String stringField) {
        System.out.println("ctor");
        this.stringField = stringField;
    }

    public void setB(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public String getStringField() {
        return stringField;
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }

    public void method() {

    }
}

class B implements Serializable {

    private static final long serialVersionUID = 500;

    A a ;

    public B(A a) {
        this.a = a;
    }
}

class C implements Externalizable {

    private int intField;
    private String strField;
    private boolean boolField;

    public C(int intField, String strField, boolean boolField) {
        this.intField = intField;
        this.strField = strField;
        this.boolField = boolField;
    }

    public C() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(strField);
        out.writeInt(intField);
        out.write(boolField ? 1 : 0);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        strField = (String) in.readObject();
        intField = in.readInt();
        boolField = in.read() == 1;
    }

    @Override
    public String toString() {
        return "C{" +
                "intField=" + intField +
                ", strField='" + strField + '\'' +
                ", boolField=" + boolField +
                '}';
    }
}

