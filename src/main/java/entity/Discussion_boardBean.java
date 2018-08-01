package entity;

public class Discussion_boardBean {
    private String did;
    private String content;
    private String time;
    private String uid;

    public Discussion_boardBean() {
    }

    public Discussion_boardBean(String did, String content, String time, String uid) {
        this.did = did;
        this.content = content;
        this.time = time;
        this.uid = uid;
    }

    public Discussion_boardBean(String content, String time, String uid) {
        this.content = content;
        this.time = time;
        this.uid = uid;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
