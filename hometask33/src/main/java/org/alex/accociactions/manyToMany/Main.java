package org.alex.accociactions.manyToMany;

import org.alex.accociactions.manyToMany.entity.ProviderEntity;
import org.alex.accociactions.manyToMany.entity.TowerEntity;
import org.alex.accociactions.manyToMany.service.ProviderPersistenceService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var service = new ProviderPersistenceService();
        var provider = new ProviderEntity("a1");
        var provider1 = new ProviderEntity("mtc");
        var tower = new TowerEntity("beta-2");
        var tower1 = new TowerEntity("alpha-1");
        provider.addTower(tower);
        provider.addTower(tower1);
        provider1.addTower(tower);
        List<ProviderEntity> providers = List.of(provider1, provider);
        service.save(providers);
    }
}
