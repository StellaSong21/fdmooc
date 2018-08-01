package service;

import com.google.gson.JsonObject;

public abstract class DiscussionService {
    public abstract int append();

    public abstract JsonObject boardInfo();
}
