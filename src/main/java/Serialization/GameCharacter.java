package Serialization;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by wangnan01 on 2019/8/2.
 */
public class GameCharacter implements Serializable {
    public enum CharacterType{
        ELF, TROLL, MAGICIAN
    }
    private int power;
    private CharacterType type;
    private Weapon[] weapons;

    public GameCharacter(int power, CharacterType type, Weapon[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void increasePower() {
        this.power++;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "power=" + power +
                ", type=" + type +
                ", weapons=" + Arrays.toString(weapons) +
                '}';
    }
}
