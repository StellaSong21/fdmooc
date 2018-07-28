package entity;

public class RecordBean {
    private String uid;
    private String cid;
    private String pid;

    public RecordBean() {
    }

    public RecordBean(String uid, String cid, String pid) {
        this.uid = uid;
        this.cid = cid;
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
