package nongsan.webmvc.model;

public class User {
    private Long id;
    private Long roleid;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String status;
    private String created;
    private Role role = new Role();

    public Long getRoleid(long roleid) {
        return this.roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getStatus() {
        return status;
    }

    public User(Long id, Long roleid, String name, String email, String phone, String username, String password, String status, String created) {
        this.id = id;
        this.roleid = roleid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.status = status;
        this.created = created;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleid() {
        return roleid;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus(String status) {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setRole(Role role) {
    }

    public Role getRole() {
        return role;
    }
}
