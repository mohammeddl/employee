package model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String post;
    private String phone;
    private String position;

    public Employee(String name, String email, String post, String phone, String position) {
        this.name = name;
        this.email = email;
        this.post = post;
        this.phone = phone;
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }   

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }




}
