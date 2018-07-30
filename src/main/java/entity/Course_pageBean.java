package entity;

public class coursePageBean {
    private String pid;
    private String cid;
    private String number;
    private String title;
    private String content;
    private String url;

    public coursePageBean() {
    }

    public coursePageBean(String cid, String number, String title, String content, String url) {
        this.cid = cid;
        this.number = number;
        this.title = title;
        this.content = content;
        this.url = url;
    }

    public coursePageBean(String pid, String cid, String number, String title, String content, String url) {
        this.pid = pid;
        this.cid = cid;
        this.number = number;
        this.title = title;
        this.content = content;
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
