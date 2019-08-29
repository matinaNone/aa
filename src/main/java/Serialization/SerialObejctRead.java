package Serialization;

import java.io.*;

/**
 * Created by wangnan01 on 2019/8/2.
 */
public class SerialObejctRead {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("MygGame.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Object object1 = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            Object object3 = objectInputStream.readObject();

            GameCharacter gameCharacter1 = (GameCharacter)object1;
            GameCharacter gameCharacter2 = (GameCharacter)object2;
            GameCharacter gameCharacter3 = (GameCharacter)object3;

            System.out.println(object1.getClass());

            objectInputStream.close();

            System.out.println(gameCharacter1);
            System.out.println(gameCharacter2);
            System.out.println(gameCharacter3);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
