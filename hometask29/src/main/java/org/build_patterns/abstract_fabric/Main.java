package org.build_patterns.abstract_fabric;

import org.build_patterns.abstract_fabric.fabric.impls.VikingBookCopyrightImpl;

public class Main {
    public static void main(String[] args) {
        CopyRightService copyRightService = new CopyRightService(
                new VikingBookCopyrightImpl());
        System.out.println(copyRightService.printNewBook());
    }
}
