package org.alex.brain.io;

import java.io.File;

public class IoService {
    /*
    Метод разработан для разделения текста, по двум делителям
    и создаёт два файла, с содержимым принадлежащим этим частям.
    Юзабелен для текстовых файлов со структурой типа:
    ElementA ....
    ElementB ....
    ElementA ....
    и т.д
        - где, ElementA - keyWord1+[^a-zA-Z0-9], ElementB - keyWord2+[^a-zA-Z0-9]
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
