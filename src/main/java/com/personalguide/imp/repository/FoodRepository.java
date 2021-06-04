package com.personalguide.imp.repository;

import com.personalguide.api.repository.IFoodRepository;
import com.personalguide.imp.entity.FoodEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Data
@NoArgsConstructor
@Transactional
public class FoodRepository implements IFoodRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public FoodRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<FoodEntity> getById(int id) {
        Query query =  sessionFactory.getCurrentSession().createQuery("FROM FoodEntity where id =:id");
        query.setParameter("id",id);
        FoodEntity foodEntity = (FoodEntity) query.uniqueResult();
        return Optional.ofNullable(foodEntity);
    }

    @Override
    public List<FoodEntity> getAll() {
        return (List<FoodEntity>) sessionFactory.getCurrentSession().createQuery("FROM FoodEntity ").getResultList();
    }
}
