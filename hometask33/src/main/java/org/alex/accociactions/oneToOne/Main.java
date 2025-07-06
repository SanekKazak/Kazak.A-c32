package org.alex.accociactions.oneToOne;

import org.alex.accociactions.oneToOne.entity.HomeEntity;
import org.alex.accociactions.oneToOne.entity.PersonEntity;
import org.alex.accociactions.oneToOne.service.PersonPersistenceService;

public class Main {
    public static void main(String[] args) {
        var service = new PersonPersistenceService();
        var person = new PersonEntity("Alex", new HomeEntity("pr lyndicova"));
        service.save(person);
    }
}
