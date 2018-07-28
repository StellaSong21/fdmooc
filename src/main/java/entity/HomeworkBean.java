package entity;

public class HomeworkBean {
    private String hid;
    private String start_time;
    private String title;
    private String content;
    private String end_time;
    private String cid;

    public HomeworkBean() {
    }

    public HomeworkBean(String hid, String start_time, String title, String content, String end_time, String cid) {
        this.hid = hid;
        this.start_time = start_time;
        this.title = title;
        this.content = content;
        this.end_time = end_time;
        this.cid = cid;
    }

    public HomeworkBean(String start_time, String title, String content, String end_time, String cid) {
        this.start_time = start_time;
        this.title = title;
        this.content = content;
        this.end_time = end_time;
        this.cid = cid;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
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

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
