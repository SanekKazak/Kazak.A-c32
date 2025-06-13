package org.build_patterns.abstract_fabric.book.book_parts.impls;

import org.build_patterns.abstract_fabric.book.book_parts.interfaces.InsidePages;

public class AristotelInsidePagesImpl implements InsidePages {
    @Override
    public String getInsidePages() {
        return "Book contains Aristotel history";
    }
}
