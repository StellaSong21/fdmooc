package service;

import com.google.gson.JsonObject;

public class ServiceFactory {
    public static UserServiceImplement getUserServiceInstance(JsonObject param) {
        return new UserServiceImplement(param);
    }

    public static UserServiceImplement getUserServiceInstance() {
        return new UserServiceImplement();
    }

    public static CourseServiceImplement getCourseServiceInstance(JsonObject param) {
        return new CourseServiceImplement(param);
    }

    public static CourseServiceImplement getCourseServiceInstance() {
        return new CourseServiceImplement();
    }

    public static MailService getMailServiceInstance() {
        return new MailService();
    }

    public static DiscussionServiceImplement getDiscussionInstance(JsonObject param) {
        return new DiscussionServiceImplement(param);
    }
}
