package models.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BaseDao<Entity> {

    @PersistenceContext
    protected EntityManager em ;

    public List<Entity> list(Class<Entity> entityClass) {
        CriteriaQuery<Entity> cq = em.getCriteriaBuilder().createQuery(entityClass);
        Root<Entity> rootEntry = cq.from(entityClass);
        CriteriaQuery<Entity> all = cq.select(rootEntry);
        TypedQuery<Entity> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public Entity find(Class<Entity> entityClass, Integer primaryKey) {
        try {
            return em.find(entityClass, primaryKey);
        }catch(Exception ex){
            throw new RuntimeException("Entity not found for id: " + primaryKey);
        }
    }

    public Entity save(Entity entity) {
        em.persist(entity);
        em.flush();
        return entity ;
    }

    public Entity edit(Entity entity) {
        entity = em.merge(entity);
        em.flush();
        return entity;
    }

    public void remove(Class<Entity> entityClass, Integer primaryKey) {
        Entity entity = em.find(entityClass, primaryKey);
        if (entity != null) {
            em.remove(entity);
        }else {
            throw new RuntimeException("Entity not found for id: " + primaryKey);
        }
    }
}
