package entity;

public class Course_tableBean {
    private String cid;
    private String uid;

    public Course_tableBean() {
    }

    public Course_tableBean(String cid, String uid) {
        this.cid = cid;
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
