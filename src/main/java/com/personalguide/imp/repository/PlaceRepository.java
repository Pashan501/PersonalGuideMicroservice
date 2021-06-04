package com.personalguide.imp.repository;

import com.personalguide.api.repository.IPlaceRepository;
import com.personalguide.imp.entity.PlaceEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@Data
@NoArgsConstructor
public class PlaceRepository implements IPlaceRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public PlaceRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PlaceEntity> getAll(){

        return (List<PlaceEntity>) sessionFactory.getCurrentSession().createQuery("FROM PlaceEntity").getResultList();
    }

    @Override
    public Optional<PlaceEntity> getById(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM PlaceEntity where id = :id");
        query.setParameter("id",id);
        PlaceEntity entity = (PlaceEntity) query.uniqueResult();

        return Optional.ofNullable(entity);
    }

}
