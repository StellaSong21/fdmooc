package service;

import com.google.gson.JsonObject;

public abstract class CourseService {

    public abstract int createCourse();

    public abstract int deleteCourse();

    public abstract int modifyCourse();

    public abstract JsonObject getCourseInfo();

    public abstract int createCoursePage();

    public abstract int deleteCoursePage();

    public abstract int modifyCoursePage();

    public abstract JsonObject getCoursePageInfo();

    public abstract int createHomework();

    public abstract int deleteHomework();

    public abstract int modifyHomework();

    public abstract JsonObject getHomeworkInfo();

    public abstract int createCourseTable();

    public abstract int deleteCourseTable();

    public abstract JsonObject courseTableInfo();

    public abstract int createAnswer();

    public abstract int deleteAnswer();

    public abstract int modifyAnswer();

    public abstract JsonObject getAnswerInfo();

    public abstract int createRecord();

    public abstract int deleteRecord();

    public abstract JsonObject getRecordInfo();

    public abstract int createResource();

    public abstract int deleteResource();

    public abstract int modifyResource();

    public abstract JsonObject getResourceInfo();

    public abstract JsonObject getTopHotCourse();

    public abstract JsonObject getLatestCourse();

    public abstract int doHomework();

    public abstract int doPage();

    public abstract int doCourse();

    public abstract JsonObject getCourseList();

    public abstract JsonObject doAnswer();
}
