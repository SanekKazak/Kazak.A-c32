package org.build_patterns.abstract_fabric.book.book_parts.impls;

import org.build_patterns.abstract_fabric.book.book_parts.interfaces.MainPage;

public class AristotelMainPageImpl implements MainPage {
    @Override
    public String getMainPage() {
        return "Book will be about Areistotel history";
    }
}
