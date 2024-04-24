package com.example.user.domain.model;

public class User {

    private Long id;
    private String name;
    private String lastName;
    private Long docIdent;
    private Long cellPhone;
    private String email;
    private String password;
    private Roles role;    
    

    

    public User(Long id, String name, String lastName, Long docIdent, Long cellPhone, String email, String password,
            Roles role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.docIdent = docIdent;
        this.cellPhone = cellPhone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getDocIdent() {
        return docIdent;
    }

    public void setDocIdent(Long docIdent) {
        this.docIdent = docIdent;
    }

    public Long getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    

    
}
