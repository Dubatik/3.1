import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Game {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Date date = new Date();
        createDirectory("C://Games/src");
        createDirectory("C://Games/res");
        createDirectory("C://Games/savegames");
        createDirectory("C://Games/temp");
        createDirectory("C://Games/src/main");
        createDirectory("C://Games/src/test");
        createFile("C://Games/src/main/Main.java");
        createFile("C://Games/src/main/Utils.java");
        createDirectory("C://Games/res/drawables");
        createDirectory("C://Games/res/vectors");
        createDirectory("C://Games/res/icons");
        createFile("C://Games/temp/temp.txt");
        System.out.println(stringBuilder);

        try (FileWriter writer = new FileWriter("C://Games/temp/temp.txt", false)) {
            writer.write(String.valueOf(stringBuilder));
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createDirectory(String par) {
        File myfile = new File(par);
        if (myfile.mkdir()) {
            stringBuilder.append("Создан каталог " + par + " " + new Date() + "\n");
        } else {
            stringBuilder.append("Каталог " + par + " не создан" + new Date() + "\n");
        }
    }

    private static void createFile(String par) {
        File myfile = new File(par);
        try {
            if (myfile.createNewFile()) {
                stringBuilder.append("Файл " + myfile + " был создан " + new Date() + "\n");
            }
        } catch (IOException e) {
            stringBuilder.append("Файл " + myfile + " не был создан " + new Date() + "\n");
        }
    }

}