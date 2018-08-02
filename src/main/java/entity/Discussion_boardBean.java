package entity;

public class Discussion_boardBean {
    private String did;
    private String content;
    private String time;
    private String username;

    public Discussion_boardBean() {
    }

    public Discussion_boardBean(String did, String content, String time, String username) {
        this.did = did;
        this.content = content;
        this.time = time;
        this.username = username;
    }

    public Discussion_boardBean(String content, String time, String username) {
        this.content = content;
        this.time = time;
        this.username = username;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
