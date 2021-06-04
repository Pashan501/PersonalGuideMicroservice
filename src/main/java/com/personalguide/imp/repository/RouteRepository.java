package com.personalguide.imp.repository;

import com.personalguide.api.repository.IRouteRepository;
import com.personalguide.imp.entity.RouteEntity;
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
@Transactional
@Data
@NoArgsConstructor
public class RouteRepository implements IRouteRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public RouteRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<RouteEntity> getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM RouteEntity where id = :id");
        query.setParameter("id",id);
        RouteEntity routeEntity = (RouteEntity) query.uniqueResult();
        return Optional.ofNullable(routeEntity);
    }

    @Override
    public List<RouteEntity> getAll() {
        return  sessionFactory.getCurrentSession().createQuery("FROM RouteEntity ").getResultList();
    }
}
