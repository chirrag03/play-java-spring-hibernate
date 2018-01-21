package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import play.libs.Json;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseService<Entity, EntityDao extends BaseDao<Entity>> {

    @Autowired
    EntityDao entityDao;

    private Class<Entity> entityClass;

    public BaseService() {
        entityClass = (Class<Entity>) ((ParameterizedType) getClass
                ().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Transactional
    public List<Entity> list() {
        return entityDao.list(entityClass);
    }

    @Transactional
    public Entity find(int primaryKey) {
        return entityDao.find(entityClass, primaryKey);
    }

    @Transactional
    public Entity save(JsonNode jsonData) {
        Entity model = Json.fromJson(jsonData, entityClass);
        return entityDao.save(model);
    }

    @Transactional
    public Entity edit(JsonNode jsonData) {
        Entity model = Json.fromJson(jsonData, entityClass);
        return entityDao.edit(model);
    }

    @Transactional
    public void remove(int primaryKey) {
        entityDao.remove(entityClass, primaryKey);
    }

}
