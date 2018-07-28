package entity;

public class AnswerBean {
    private String uid;
    private String hid;
    private String content;
    private String grade;

    public AnswerBean() {
    }

    //参数为空时传""
    public AnswerBean(String uid, String hid, String content, String grade) {
        this.uid = uid;
        this.hid = hid;
        this.content = content;
        this.grade = grade;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
