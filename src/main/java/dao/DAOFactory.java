package dao;

public class DAOFactory {
    public static UserDAO getUserDAOInstance() {
        return new UserDAOImplement();
    }

    public static AnswerDAO getAnswerDAOInstance() {
        return new AnswerDAOImplement();
    }

    public static CourseDAO getCourseDAOInstance() {
        return new CourseDAOImplement();
    }

    public static Course_pageDAO getCourse_pageDAOInstance() {
        return new Course_pageDAOImplement();
    }

    public static Course_tableDAO getCourse_tableDAOInstance() {
        return new Course_tableDAOImplement();
    }

    public static Discussion_boardDAO getDiscussion_boardDAOInstance() {
        return new Discussion_boardDAOImplement();
    }

    public static HomeworkDAO getHomeworkDAOInstance() {
        return new HomeworkDAOImplement();
    }

    public static RecordDAO getRecordDAOInstance() {
        return new RecordDAOImplement();
    }

    public static ResourceDAO getResourceDAOInstance() {
        return new ResourceDAOImplement();
    }
}