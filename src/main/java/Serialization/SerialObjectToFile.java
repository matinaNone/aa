package Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by wangnan01 on 2019/8/2.
 */
public class SerialObjectToFile {
    public static void main(String[] args) {
        GameCharacter character1 = new GameCharacter(50, GameCharacter.CharacterType.ELF, new Weapon[]{new Weapon("bow"), new Weapon("sword")});
        GameCharacter character2 = new GameCharacter(100, GameCharacter.CharacterType.TROLL, new Weapon[]{new Weapon("base"), new Weapon("hands")});
        GameCharacter character3 = new GameCharacter(80, GameCharacter.CharacterType.MAGICIAN, new Weapon[]{new Weapon("big ax"), new Weapon("spells")});

        FileOutputStream fileOutputStream;

        {
            try {
                fileOutputStream = new FileOutputStream("MygGame.ser");
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

                outputStream.writeObject(character1);
                outputStream.writeObject(character2);
                outputStream.writeObject(character3);

                outputStream.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
