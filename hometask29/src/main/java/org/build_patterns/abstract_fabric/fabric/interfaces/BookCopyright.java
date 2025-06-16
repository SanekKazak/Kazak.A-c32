package org.build_patterns.abstract_fabric.fabric.interfaces;

import org.build_patterns.abstract_fabric.book.book_parts.interfaces.InsidePages;
import org.build_patterns.abstract_fabric.book.book_parts.interfaces.MainPage;

public interface BookCopyright {
    MainPage getMain();
    InsidePages getInside();

}
