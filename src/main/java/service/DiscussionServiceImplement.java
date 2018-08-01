package service;

import com.google.gson.JsonObject;
import dao.DAOFactory;
import dao.Discussion_boardDAO;
import entity.Discussion_boardBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DiscussionServiceImplement extends DiscussionService {
    private JsonObject jsonObject;
    private Discussion_boardDAO discussion_boardDAO;

    public DiscussionServiceImplement(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
        discussion_boardDAO = DAOFactory.getDiscussion_boardDAOInstance();
    }

    @Override
    public int append() {
        String content = jsonObject.get("content").getAsString();
        String uid = jsonObject.get("uid").getAsString();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        if (discussion_boardDAO.append(new Discussion_boardBean(content, time, uid)) == -1)
            return 0x020101;

        return 0x020101;
    }

    @Override
    public JsonObject boardInfo() {
        List<Map<String, String>> list = discussion_boardDAO.infoList(new Discussion_boardBean());

        JsonObject jsonObject = new JsonObject();

        if (list == null) return jsonObject;
        Map<String, String> map;
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            JsonObject j = new JsonObject();
            j.addProperty("did", map.get("did"));
            j.addProperty("content", map.get("content"));
            j.addProperty("time", map.get("time"));
            j.addProperty("uid", map.get("uid"));
            jsonObject.add(i + "", j);
        }

        return jsonObject;
    }
}
