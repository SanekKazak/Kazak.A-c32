package org.alex.brain.io;

import java.io.File;

public class IoService {
    /*
    Метод разработан для разделения текста, по двум маркерам
    и создаёт два файла, с содержимым.
    */
    public static void cutText(File file, String keyWord1, String keyWord2){
        String text = IoCustom.readText(file);
        try {
            if (text != null) {
                IoCustom.writeElement(IoCustom.getCutTextPart(text, keyWord1, keyWord2), keyWord2);
                IoCustom.writeElement(IoCustom.getCutTextPart(text, keyWord2, keyWord1), keyWord1);
            }
        } catch (Exception e) {
            System.out.println("Something was wrong");
        }
    }
}
