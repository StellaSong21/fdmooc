package entity;

public class ResourceBean {
    private String cid;
    private String url;
    private String number;

    public ResourceBean() {
    }

    public ResourceBean(String cid, String url, String number) {
        this.cid = cid;
        this.url = url;
        this.number = number;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
