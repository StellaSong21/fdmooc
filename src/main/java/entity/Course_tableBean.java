package entity;

public class courseTableBean {
    private String cid;
    private String uid;

    public courseTableBean() {
    }

    public courseTableBean(String cid, String uid) {
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
