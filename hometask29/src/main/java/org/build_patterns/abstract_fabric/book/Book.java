package org.build_patterns.abstract_fabric.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Book {
    private String mainPage;
    private String insidePage;
}
