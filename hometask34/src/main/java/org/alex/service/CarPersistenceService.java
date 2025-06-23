package org.alex.service;

import org.alex.config.SessionPersistence;
import org.alex.dto.SearchDto;
import org.alex.entity.CarEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaPredicate;

import java.util.ArrayList;
import java.util.List;

public class CarPersistenceService {
    private final SessionFactory factory = SessionPersistence.getSession();

    public void save(CarEntity car){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(car);

        transaction.commit();
        session.close();
    }

    public List<CarEntity> getByFilter(SearchDto dto){
        var session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        var builder = session.getCriteriaBuilder();

        var query = builder.createQuery(CarEntity.class);

        var root = query.from(CarEntity.class);

        List<JpaPredicate> predicate = new ArrayList<>();

        if(dto.getBrand()!=null){
            var brandBy = builder.equal(root.get("brand"), dto.getBrand());
            predicate.add(brandBy);
        }

        if(dto.getRelease()!=null){
            var releaseBy = builder.greaterThan(root.get("released"), dto.getRelease());
            predicate.add(releaseBy);
        }

        if(dto.getCostFrom()!=null && dto.getCostTo()!=null){
            var costBetweenBy = builder.between(root.get("cost"), dto.getCostFrom(), dto.getCostTo());
            predicate.add(costBetweenBy);
        }else{
            if (dto.getCostFrom() != null) {
                var costFromBy = builder.greaterThanOrEqualTo(root.get("cost"), dto.getCostFrom());
                predicate.add(costFromBy);
            }
            if (dto.getCostTo() != null) {
                var costToBy = builder.lessThanOrEqualTo(root.get("cost"), dto.getCostTo());
                predicate.add(costToBy);
            }
        }

        if(dto.getMileageFrom()!=null && dto.getMileageTo()!=null){
            var costBetweenBy = builder.between(root.get("mileage"), dto.getMileageFrom(), dto.getMileageTo());
            predicate.add(costBetweenBy);
        } else {
            if (dto.getMileageFrom() != null) {
                var mileageFromBy = builder.greaterThanOrEqualTo(root.get("mileage"), dto.getMileageFrom());
                predicate.add(mileageFromBy);
            }
            if (dto.getMileageTo() != null) {
                var mileageToBy = builder.lessThanOrEqualTo(root.get("mileage"), dto.getMileageTo());
                predicate.add(mileageToBy);
            }
        }

        query.where(predicate.toArray(new JpaPredicate[0]));

        var result = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return result;
    }
}
