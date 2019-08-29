package Serialization;

import java.io.Serializable;

/**
 * Created by wangnan01 on 2019/8/2.
 */
public class Weapon implements Serializable {
    private String name;

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
