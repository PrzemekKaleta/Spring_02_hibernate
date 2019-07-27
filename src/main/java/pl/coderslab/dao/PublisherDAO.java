package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Publisher;

@Repository
public class PublisherDAO extends GenericDAO<Publisher>{
    public PublisherDAO(){
        super(Publisher.class);
    }
}
