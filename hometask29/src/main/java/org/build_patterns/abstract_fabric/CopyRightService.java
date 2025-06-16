package org.build_patterns.abstract_fabric;

import lombok.AllArgsConstructor;
import org.build_patterns.abstract_fabric.book.Book;
import org.build_patterns.abstract_fabric.fabric.interfaces.BookCopyright;

@AllArgsConstructor
public class CopyRightService {
    private BookCopyright bookCopyright;

    public Book printNewBook(){
        return new Book(bookCopyright.getMain().getMainPage(), bookCopyright.getInside().getInsidePages());
    }
}
