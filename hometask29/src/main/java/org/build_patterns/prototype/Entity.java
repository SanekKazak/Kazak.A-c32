package org.build_patterns.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entity implements Cloneable{
    private String name;
    private String data;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
