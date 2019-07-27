package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.StudentGroupDAO;
import pl.coderslab.entity.StudentGroup;


public class StudentGroupConverter implements Converter<String, StudentGroup> {
    @Autowired
    private StudentGroupDAO studentGroupDao;
    @Override
    public StudentGroup convert(String s) {
        return studentGroupDao.findById(Long.parseLong(s));
    }
}