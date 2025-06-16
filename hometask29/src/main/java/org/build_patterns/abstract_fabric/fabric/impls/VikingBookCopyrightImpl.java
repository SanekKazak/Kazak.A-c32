package org.build_patterns.abstract_fabric.fabric.impls;

import org.build_patterns.abstract_fabric.fabric.interfaces.BookCopyright;
import org.build_patterns.abstract_fabric.book.book_parts.impls.VikingInsidePagesImpl;
import org.build_patterns.abstract_fabric.book.book_parts.impls.VikingMainPageImpl;
import org.build_patterns.abstract_fabric.book.book_parts.interfaces.InsidePages;
import org.build_patterns.abstract_fabric.book.book_parts.interfaces.MainPage;

public class VikingBookCopyrightImpl implements BookCopyright {
    @Override
    public MainPage getMain() {
        return new VikingMainPageImpl();
    }

    @Override
    public InsidePages getInside() {
        return new VikingInsidePagesImpl();
    }
}
