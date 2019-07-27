package pl.coderslab.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BookRepositoryImpl implements BookRepoCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void resetRating(int rating) {

       Query q = entityManager.createQuery("UPDATE Book b SET b.rating = :rating");
       q.setParameter("rating", rating).executeUpdate();

    }

}
