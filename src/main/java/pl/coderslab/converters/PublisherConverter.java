package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.PublisherDAO;
import pl.coderslab.dao.StudentGroupDAO;
import pl.coderslab.entity.Publisher;
import pl.coderslab.entity.StudentGroup;

public class PublisherConverter implements Converter<String, Publisher> {

    @Autowired
    private PublisherDAO publisherDao;
    @Override
    public Publisher convert(String s) {
        return publisherDao.findById(Long.parseLong(s));
    }
}
