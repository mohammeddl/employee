package model;

public class Employee {
    private String name;
    private String email;
    private String post;
    private String phone;
    private String addresdepartments;

    public Employee(String name, String email, String post, String phone, String addresdepartments) {
        this.name = name;
        this.email = email;
        this.post = post;
        this.phone = phone;
        this.addresdepartments = addresdepartments;
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

    public String getPost() {
        return post;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddresdepartments() {
        return addresdepartments;
    }


}
