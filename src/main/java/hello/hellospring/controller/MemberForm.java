package hello.hellospring.controller;

public class MemberForm {
    private String name; // input = "name" value 값이 자동으로 들어온다.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
