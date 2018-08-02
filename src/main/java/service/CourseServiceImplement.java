package service;

import com.google.gson.JsonObject;
import dao.*;
import entity.*;
import util.ComparatorCoursePage;

import java.util.*;

public class CourseServiceImplement extends CourseService {
    private JsonObject jsonObject;
    private CourseDAO courseDAO;
    private AnswerDAO answerDAO;
    private Course_pageDAO course_pageDAO;
    private Course_tableDAO course_tableDAO;
    private HomeworkDAO homeworkDAO;
    private RecordDAO recordDAO;
    private ResourceDAO resourceDAO;

    protected CourseServiceImplement(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
        courseDAO = DAOFactory.getCourseDAOInstance();
        answerDAO = DAOFactory.getAnswerDAOInstance();
        course_pageDAO = DAOFactory.getCourse_pageDAOInstance();
        course_tableDAO = DAOFactory.getCourse_tableDAOInstance();
        homeworkDAO = DAOFactory.getHomeworkDAOInstance();
        recordDAO = DAOFactory.getRecordDAOInstance();
        resourceDAO = DAOFactory.getResourceDAOInstance();
    }

    CourseServiceImplement() {
        courseDAO = DAOFactory.getCourseDAOInstance();
        answerDAO = DAOFactory.getAnswerDAOInstance();
        course_pageDAO = DAOFactory.getCourse_pageDAOInstance();
        course_tableDAO = DAOFactory.getCourse_tableDAOInstance();
        homeworkDAO = DAOFactory.getHomeworkDAOInstance();
        recordDAO = DAOFactory.getRecordDAOInstance();
        resourceDAO = DAOFactory.getResourceDAOInstance();
    }

    @Override
    public int createCourse() {
        String title = jsonObject.get("title").getAsString();
        String teacher_id = jsonObject.get("teacher_id").getAsString();
        String pic_url = jsonObject.get("pic_url").getAsString();
        String content = jsonObject.get("content").getAsString();

        if (courseDAO.append(new CourseBean(title, teacher_id, pic_url, content)) == -1)
            return 0x020101;

        CourseBean c = new CourseBean();
        c.setTeacher_uid(teacher_id);
        List<Map<String, String>> list = courseDAO.infoList(c);
        if (list == null || list.size() == 0) return 0x020101;
        return Integer.parseInt(list.get(list.size() - 1).get("cid"));
    }

    @Override
    public int deleteCourse() {
        String cid = jsonObject.get("cid").getAsString();
        if (courseDAO.delete(cid) == -1)
            return 0x020207;
        return 0x020200;
    }

    @Override
    public int modifyCourse() {
        String title = "", teacher_id = "", pic_url = "", content = "";
        String cid = jsonObject.get("cid").getAsString();
        if (jsonObject.has("teacher_id"))
            teacher_id = jsonObject.get("teacher_id").getAsString();
        if (jsonObject.has("title"))
            title = jsonObject.get("title").getAsString();
        if (jsonObject.has("pic_url"))
            pic_url = jsonObject.get("pic_url").getAsString();
        if (jsonObject.has("content"))
            content = jsonObject.get("content").getAsString();

        return courseDAO.modify(new CourseBean(cid, title, teacher_id, pic_url, content)) == -1 ? 0x020301 : 0x020300;
    }

    public JsonObject doCourseInfo() {
        if (jsonObject.has("cid"))
            return getCourseInfo();
        if (jsonObject.has("tid"))
            return myCourse();
        if (jsonObject.has("uid"))
            return myCourseTable();
        return getCourseList();
    }

    public JsonObject myCourse() {
        String cid = jsonObject.get("tid").getAsString();
        CourseBean course = new CourseBean();
        course.setTeacher_uid(cid);
        List<Map<String, String>> list = courseDAO.infoList(course);

        JsonObject jsonObject = new JsonObject();

        if (list == null) return jsonObject;

        Map<String, String> map;
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            JsonObject j = new JsonObject();
            j.addProperty("cid", map.get("cid"));
            j.addProperty("title", map.get("title"));
            j.addProperty("teacher_id", map.get("teacher_id"));
            j.addProperty("pic_url", map.get("pic_url"));
            j.addProperty("content", map.get("content"));
            jsonObject.add(i + "", j);
        }

        return jsonObject;
    }

    public JsonObject myCourseTable() {

        List<Map<String, String>> list = courseDAO.infoList(jsonObject.get("uid").getAsString());

        JsonObject jsonObject = new JsonObject();

        if (list == null) return jsonObject;

        Map<String, String> map;
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            JsonObject j = new JsonObject();
            j.addProperty("cid", map.get("cid"));
            j.addProperty("title", map.get("title"));
            jsonObject.add(i + "", j);
        }

        return jsonObject;
    }

    @Override
    public JsonObject getCourseInfo() {
        String cid = jsonObject.get("cid").getAsString();
        CourseBean course = new CourseBean();
        course.setCid(cid);
        List<Map<String, String>> list = courseDAO.infoList(course);

        JsonObject jsonObject = new JsonObject();

        if (list == null) return jsonObject;

        for (Map<String, String> map : list) {
            jsonObject.addProperty("cid", map.get("cid"));
            jsonObject.addProperty("title", map.get("title"));
            jsonObject.addProperty("teacher_id", map.get("teacher_id"));
            jsonObject.addProperty("pic_url", map.get("pic_url"));
            jsonObject.addProperty("content", map.get("content"));
        }

        return jsonObject;
    }

    //匹配查找
    public JsonObject getCourseList() {
        String content = "", name = "", title = "";
        if (jsonObject.has("content"))
            content = jsonObject.get("content").getAsString();
        if (jsonObject.has("name"))
            name = jsonObject.get("name").getAsString();
        if (jsonObject.has("title"))
            title = jsonObject.get("title").getAsString();
        List<Map<String, String>> list;
        if (jsonObject.get("order").getAsString().equals("hot"))
            list = courseDAO.infoListHot(title, content, name, jsonObject.get("choose").getAsString());
        else
            list = courseDAO.infoList(title, content, name, jsonObject.get("choose").getAsString());
        JsonObject jsonObject = new JsonObject();

        if (list == null) return jsonObject;
        Map<String, String> map;
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            JsonObject j = new JsonObject();
            j.addProperty("cid", map.get("cid"));
            j.addProperty("title", map.get("title"));
            j.addProperty("nickname", map.get("nickname"));
            j.addProperty("pic_url", map.get("pic_url"));
            j.addProperty("content", map.get("content"));
            jsonObject.add(i + "", j);
        }

        return jsonObject;
    }

    @Override
    public int createCoursePage() {
        String cid = jsonObject.get("cid").getAsString();
        String number = jsonObject.get("number").getAsString();
        String title = jsonObject.get("title").getAsString();
        String content = jsonObject.get("content").getAsString();
        String url = "";
        if (jsonObject.has("url"))
            url = jsonObject.get("url").getAsString();

        if (course_pageDAO.append(new Course_pageBean(cid, number, title, content, url)) == -1)
            return 0x020101;

        Course_pageBean page = new Course_pageBean();
        page.setCid(cid);
        List<Course_pageBean> list = course_pageDAO.infoList(page);
        if (list == null || list.size() == 0) return 0x020102;
        return Integer.parseInt(list.get(list.size() - 1).getPid());
    }

    @Override
    public int deleteCoursePage() {
        String pid = jsonObject.get("pid").getAsString();
        if (course_pageDAO.delete(pid) == -1)
            return 0x020207;
        return 0x020200;
    }

    @Override
    public int modifyCoursePage() {
        String number = "", title = "", content = "", url = "";
        String pid = jsonObject.get("pid").getAsString();
        if (jsonObject.has("number"))
            number = jsonObject.get("number").getAsString();
        if (jsonObject.has("title"))
            title = jsonObject.get("title").getAsString();
        if (jsonObject.has("content"))
            content = jsonObject.get("content").getAsString();
        if (jsonObject.has("url"))
            url = jsonObject.get("url").getAsString();
        return course_pageDAO.modify(new Course_pageBean(pid, "", number, title, content, url)) == -1 ? 0x020301 : 0x020300;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JsonObject getCoursePageInfo() {
        Course_pageBean course = new Course_pageBean();
        course.setCid(jsonObject.get("cid").getAsString());
        List<Course_pageBean> list = course_pageDAO.infoList(course);

        JsonObject jsonObject = new JsonObject();
        if (list == null) return jsonObject;

        list.sort(new ComparatorCoursePage());

        Course_pageBean page;
        for (int i = 0; i < list.size(); i++) {
            page = list.get(i);
            JsonObject j = new JsonObject();
            j.addProperty("pid", page.getPid());
            j.addProperty("title", page.getTitle());
            j.addProperty("content", page.getContent());
            j.addProperty("number", page.getNumber());
            j.addProperty("url", page.getUrl());
            jsonObject.add(i + "", j);
        }

        return jsonObject;
    }

    @Override
    public int createHomework() {
        String cid = jsonObject.get("cid").getAsString();
        String start_time = jsonObject.get("start_time").getAsString();
        String end_time = jsonObject.get("end_time").getAsString();
        String title = jsonObject.get("title").getAsString();
        String content = jsonObject.get("content").getAsString();

        if (homeworkDAO.append(new HomeworkBean(start_time, title, content, end_time, cid)) == -1)
            return 0x020101;

        HomeworkBean homeworkBean = new HomeworkBean();
        homeworkBean.setCid(cid);
        List<Map<String, String>> list = homeworkDAO.infoList(homeworkBean);
        if (list == null || list.size() == 0) return 0x020101;
        return Integer.parseInt(list.get(list.size() - 1).get("hid"));
    }

    @Override
    public int deleteHomework() {
        String hid = jsonObject.get("hid").getAsString();

        if (homeworkDAO.delete(hid) == -1)
            return 0x111111;
        return 0x000000;
    }

    @Override
    public int modifyHomework() {
        String start_time = "", title = "", content = "", end_time = "";
        String hid = jsonObject.get("hid").getAsString();
        if (jsonObject.has("start_time"))
            start_time = jsonObject.get("start_time").getAsString();
        if (jsonObject.has("end_time"))
            end_time = jsonObject.get("end_time").getAsString();
        if (jsonObject.has("title"))
            title = jsonObject.get("title").getAsString();
        if (jsonObject.has("content"))
            content = jsonObject.get("content").getAsString();
        return homeworkDAO.modify(new HomeworkBean(hid, start_time, title, content, end_time, "")) == -1 ? 0x020301 : 0x020300;
    }

    @Override
    public JsonObject getHomeworkInfo() {
        HomeworkBean homeworkBean = new HomeworkBean();
        if (jsonObject.has("cid"))
            homeworkBean.setCid(jsonObject.get("cid").getAsString());
        if (jsonObject.has("hid"))
            homeworkBean.setHid(jsonObject.get("hid").getAsString());
        List<Map<String, String>> list = homeworkDAO.infoList(homeworkBean);

        JsonObject jsonObject = new JsonObject();

        if (list == null) return jsonObject;

        Map<String, String> map;
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            JsonObject j = new JsonObject();
            j.addProperty("hid", map.get("hid"));
            j.addProperty("cid", map.get("cid"));
            j.addProperty("start_time", map.get("start_time"));
            j.addProperty("title", map.get("title"));
            j.addProperty("content", map.get("content"));
            j.addProperty("end_time", map.get("end_time"));
            jsonObject.add(i + "", j);
        }

        return jsonObject;
    }

    @Override
    public int createCourseTable() {
        String cid = jsonObject.get("cid").getAsString();
        String uid = jsonObject.get("uid").getAsString();

        return course_tableDAO.append(new Course_tableBean(cid, uid)) == -1 ? 0x020101 : 0x020100;
    }

    @Override
    public int deleteCourseTable() {
        Course_tableBean c = new Course_tableBean();
        if (jsonObject.has("cid"))
            c.setCid(jsonObject.get("cid").getAsString());
        if (jsonObject.has("uid"))
            c.setUid(jsonObject.get("uid").getAsString());

        return course_tableDAO.delete(c) == -1 ? 0x020101 : 0x020101;
    }

    @Override
    public JsonObject courseTableInfo() {
        Course_tableBean courseTableBean = new Course_tableBean();
        if (jsonObject.has("cid"))
            courseTableBean.setCid(jsonObject.get("cid").getAsString());
        if (jsonObject.has("uid"))
            courseTableBean.setUid(jsonObject.get("uid").getAsString());
        List<Map<String, String>> list = course_tableDAO.infoList(courseTableBean);

        JsonObject jsonObject = new JsonObject();

        if (list == null) return jsonObject;

        Map<String, String> map;
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            JsonObject j = new JsonObject();
            j.addProperty("uid", map.get("uid"));
            j.addProperty("cid", map.get("cid"));
            jsonObject.add(i + "", j);
        }

        return jsonObject;
    }

    @Override
    public int createAnswer() {
        String hid = jsonObject.get("hid").getAsString();
        String uid = jsonObject.get("uid").getAsString();
        String content = jsonObject.get("content").getAsString();

        return answerDAO.append(new AnswerBean(uid, hid, content, "")) == -1 ? 0x020101 : 0x020100;
    }

    @Override
    public int deleteAnswer() {
        String hid = "", uid = "";
        if (jsonObject.has("hid"))
            hid = jsonObject.get("hid").getAsString();
        if (jsonObject.has("uid"))
            uid = jsonObject.get("uid").getAsString();

        return answerDAO.delete(uid, hid) == -1 ? 0x020101 : 0x020100;
    }

    @Override
    public int modifyAnswer() {
        String grade = "", content = "";
        String hid = jsonObject.get("hid").getAsString();
        String uid = jsonObject.get("uid").getAsString();
        if (jsonObject.has("grade"))
            grade = jsonObject.get("grade").getAsString();
        if (jsonObject.has("content"))
            content = jsonObject.get("content").getAsString();
        return answerDAO.modify(new AnswerBean(uid, hid, content, grade)) == -1 ? 0x020301 : 0x020300;
    }

    @Override
    public JsonObject getAnswerInfo() {
        AnswerBean answer = new AnswerBean();
        if (jsonObject.has("hid"))
            answer.setHid(jsonObject.get("hid").getAsString());
        if (jsonObject.has("uid"))
            answer.setUid(jsonObject.get("uid").getAsString());
        List<Map<String, String>> list = answerDAO.infoList(answer);

        JsonObject jsonObject = new JsonObject();

        if (list == null) return jsonObject;

        Map<String, String> map;
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            JsonObject j = new JsonObject();
            j.addProperty("uid", map.get("uid"));
            j.addProperty("hid", map.get("hid"));
            j.addProperty("content", map.get("content"));
            j.addProperty("grade", map.get("grade"));
            jsonObject.add(i + "", j);
        }

        return jsonObject;
    }

    @Override
    public int createRecord() {
        String cid = jsonObject.get("cid").getAsString();
        String uid = jsonObject.get("uid").getAsString();
        String pid = jsonObject.get("pid").getAsString();
        List<Map<String, String>> list = recordDAO.infoList(new RecordBean(uid, "", pid));
        if (list == null || list.size() == 0)
            return recordDAO.append(new RecordBean(uid, cid, pid)) == -1 ? 0x020101 : 0x020100;
        return 0x020101;
    }

    @Override
    public int deleteRecord() {
        RecordBean recordBean = new RecordBean();
        if (jsonObject.has("cid"))
            recordBean.setCid(jsonObject.get("cid").getAsString());
        if (jsonObject.has("uid"))
            recordBean.setUid(jsonObject.get("uid").getAsString());
        if (jsonObject.has("pid"))
            recordBean.setPid(jsonObject.get("pid").getAsString());

        return recordDAO.delete(recordBean) == -1 ? 0x020101 : 0x020100;
    }

    @Override
    public JsonObject getRecordInfo() {
        RecordBean recordBean = new RecordBean();
        if (jsonObject.has("cid"))
            recordBean.setCid(jsonObject.get("cid").getAsString());
//        if (jsonObject.has("uid"))
//            recordBean.setUid(jsonObject.get("uid").getAsString());
//        if (jsonObject.has("pid"))
//            recordBean.setPid(jsonObject.get("pid").getAsString());
        List<Map<String, String>> list = recordDAO.infoList(recordBean);

        JsonObject jsonObject = new JsonObject();

        if (list == null) return jsonObject;

        Map<String, String> map;
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            JsonObject j = new JsonObject();
            j.addProperty("uid", map.get("uid"));
            j.addProperty("nickname", map.get("nickname"));
            j.addProperty("count", map.get("count(pid)"));
            jsonObject.add((i + 1) + "", j);
        }

        return jsonObject;
    }

    @Override
    public int createResource() {
        String cid = jsonObject.get("cid").getAsString();
        String url = jsonObject.get("url").getAsString();
        String number = jsonObject.get("number").getAsString();

        return resourceDAO.append(new ResourceBean(cid, url, number)) == -1 ? 0x020101 : 0x020100;
    }

    @Override
    public int deleteResource() {
        ResourceBean resourceBean = new ResourceBean();
        if (jsonObject.has("cid"))
            resourceBean.setCid(jsonObject.get("cid").getAsString());
        if (jsonObject.has("url"))
            resourceBean.setUrl(jsonObject.get("url").getAsString());
        if (jsonObject.has("number"))
            resourceBean.setNumber(jsonObject.get("number").getAsString());

        return resourceDAO.delete(resourceBean) == -1 ? 0x020101 : 0x020100;
    }

    @Override
    public int modifyResource() {
        ResourceBean resourceBean = new ResourceBean();
        if (jsonObject.has("cid"))
            resourceBean.setCid(jsonObject.get("cid").getAsString());
        if (jsonObject.has("url"))
            resourceBean.setUrl(jsonObject.get("url").getAsString());
        if (jsonObject.has("number"))
            resourceBean.setNumber(jsonObject.get("number").getAsString());

        return resourceDAO.modify(resourceBean) == -1 ? 0x020101 : 0x020100;
    }

    @Override
    public JsonObject getResourceInfo() {
        ResourceBean resourceBean = new ResourceBean();
        if (jsonObject.has("cid"))
            resourceBean.setCid(jsonObject.get("cid").getAsString());
        if (jsonObject.has("number"))
            resourceBean.setUrl(jsonObject.get("number").getAsString());
        List<Map<String, String>> list = resourceDAO.infoList(resourceBean);

        JsonObject jsonObject = new JsonObject();

        if (list == null) return jsonObject;

        Map<String, String> map;
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            JsonObject j = new JsonObject();
            j.addProperty("cid", map.get("cid"));
            j.addProperty("number", map.get("number"));
            j.addProperty("url", map.get("url"));
            jsonObject.add(i + "", j);
        }

        return jsonObject;
    }

    @Override
    public JsonObject getTopHotCourse() {
        List<Map<String, String>> list = course_tableDAO.infoList(new Course_tableBean());
        JsonObject jsonObject = new JsonObject();
        if (list == null) return jsonObject;
        Map<String, Integer> counter = new HashMap<>();
        for (Map<String, String> map : list) {
            if (counter.containsKey(map.get("cid")))
                counter.put(map.get("cid"), counter.get(map.get("cid")) + 1);
            else
                counter.put(map.get("cid"), 1);
        }
        //System.out.println(counter.toString());
        List<Map.Entry<String, Integer>> result = new ArrayList<Map.Entry<String, Integer>>(counter.entrySet());
        result.sort(new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        //System.out.println(result.toString());
        int size = result.size() > 3 ? 3 : result.size();
        int i = result.size() - 1;
        for (int k = 0; k < size; i--, k++) {
            Map.Entry<String, Integer> e = result.get(i);
            CourseBean c = new CourseBean();
            c.setCid(e.getKey());
            List<Map<String, String>> course = courseDAO.infoList(c);
            if (course == null)
                continue;
            Map<String, String> map = course.get(0);
            JsonObject j = new JsonObject();
            j.addProperty("cid", map.get("cid"));
            j.addProperty("title", map.get("title"));
            j.addProperty("teacher_id", map.get("teacher_id"));
            j.addProperty("pic_url", map.get("pic_url"));
            j.addProperty("content", map.get("content"));
            jsonObject.add(k + "", j);
        }

        return jsonObject;
    }

    @Override
    public JsonObject getLatestCourse() {
        List<Map<String, String>> list = courseDAO.infoList(new CourseBean());

        JsonObject jsonObject = new JsonObject();

        if (list == null) return jsonObject;

        int size = list.size() > 3 ? 3 : list.size();
        int i = list.size() - 1;
        for (int k = 0; k < size; i--, k++) {
            Map<String, String> map = list.get(i);
            JsonObject j = new JsonObject();
            j.addProperty("cid", map.get("cid"));
            j.addProperty("title", map.get("title"));
            j.addProperty("teacher_id", map.get("teacher_id"));
            j.addProperty("pic_url", map.get("pic_url"));
            j.addProperty("content", map.get("content"));
            jsonObject.add(k + "", j);
        }

        return jsonObject;
    }

    @Override
    public int doHomework() {
        if (jsonObject.has("hid")) {
            if (jsonObject.has("title"))
                return modifyHomework();
            else
                return deleteHomework();
        } else
            return createHomework();
    }

    @Override
    public int doPage() {
        if (jsonObject.has("pid")) {
            if (jsonObject.has("title"))
                return modifyCoursePage();
            else
                return deleteCoursePage();
        } else
            return createCoursePage();
    }

    @Override
    public int doCourse() {
        if (jsonObject.has("cid")) {
            if (jsonObject.has("title"))
                return modifyCourse();
            else
                return deleteCourse();
        } else
            return createCourse();
    }

    public JsonObject doAnswer() {
        if (jsonObject.has("content") || jsonObject.has("grade")) {
            if (getAnswerInfo().has("0"))
                modifyAnswer();
            else
                createAnswer();
        } else
            return getAnswerInfo();
        return null;
    }
}