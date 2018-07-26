package entity;


public class UserBean {
    private String uid;
    private String username;
    private String nickname;
    private String password;
    private String authority;
    private String email;

    public UserBean() {
    }

    public UserBean(String uid, String username, String nickname, String password, String authority, String email) {
        this.uid = uid;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.authority = authority;
        this.email = email;
    }

    public String getAuthority() {
        return authority;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
