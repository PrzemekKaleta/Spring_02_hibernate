package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.StudentGroup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Transactional
public class GenericDAO<T> {

    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> clazz;

    public GenericDAO(Class<T> clazz){
        this.clazz = clazz;
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public T findById(long id) {
        return entityManager.find(clazz, id);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    public Collection<T> findAll() {
        TypedQuery<T> query = entityManager.createQuery(String.format("select  s from %s s", clazz.getSimpleName()), clazz);
        //tu dajemy getSimple name bo nie możemy inaczej podać nazwy klasy którje bedziemy szukać
        return query.getResultList();

    }
}