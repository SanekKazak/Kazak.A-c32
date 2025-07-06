package org.alex.accociactions.oneToMany;

import org.alex.accociactions.oneToMany.entity.ClothEntity;
import org.alex.accociactions.oneToMany.entity.WardrobeEntity;
import org.alex.accociactions.oneToMany.service.WardrobePersistenceService;

public class Main {
    public static void main(String[] args) {
        var service = new WardrobePersistenceService();
        var wardrobe = new WardrobeEntity("blue wardrobe");
        var first = new ClothEntity("t-shirt");
        var second = new ClothEntity("boots");
        var third = new ClothEntity("jeans");
        wardrobe.addCloth(first);
        wardrobe.addCloth(second);
        wardrobe.addCloth(third);
        service.save(wardrobe);
    }
}
