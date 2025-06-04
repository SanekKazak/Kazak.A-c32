package org.build_patterns.abstract_fabric.fabric.impls;

import org.build_patterns.abstract_fabric.fabric.interfaces.BookCopyright;
import org.build_patterns.abstract_fabric.book.book_parts.impls.AristotelInsidePagesImpl;
import org.build_patterns.abstract_fabric.book.book_parts.impls.AristotelMainPageImpl;
import org.build_patterns.abstract_fabric.book.book_parts.interfaces.InsidePages;
import org.build_patterns.abstract_fabric.book.book_parts.interfaces.MainPage;

public class AristotelBookCopyrightImpl implements BookCopyright {
    @Override
    public MainPage getMain() {
        return new AristotelMainPageImpl();
    }

    @Override
    public InsidePages getInside() {
        return new AristotelInsidePagesImpl();
    }
}
