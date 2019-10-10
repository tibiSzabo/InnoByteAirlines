package hu.rszoft.tibi.innobyteairlines.dao;

import hu.rszoft.tibi.innobyteairlines.service.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BaseDao<T> {
    T getById(String id);
    List<T> getAll();
}
