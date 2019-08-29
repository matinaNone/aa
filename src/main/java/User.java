import io.vertx.core.json.JsonObject;

/**
 * Created by wangnan01 on 2017/3/10.
 */
public class User {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(){

    }

    public User(JsonObject jsonObject){
        User user = jsonObject.mapTo(User.class);
    }
}
