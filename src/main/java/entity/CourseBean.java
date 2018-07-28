package entity;

public class CourseBean {
    private String cid;
    private String title;
    private String teacher_uid;
    private String pic_url;
    private String content;

    public CourseBean() {
    }

    public CourseBean(String cid, String title, String teacher_uid, String pic_url, String content) {
        this.cid = cid;
        this.title = title;
        this.teacher_uid = teacher_uid;
        this.pic_url = pic_url;
        this.content = content;
    }

    public CourseBean(String title, String teacher_uid, String pic_url, String content) {
        this.title = title;
        this.teacher_uid = teacher_uid;
        this.pic_url = pic_url;
        this.content = content;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacher_uid() {
        return teacher_uid;
    }

    public void setTeacher_uid(String teacher_uid) {
        this.teacher_uid = teacher_uid;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
