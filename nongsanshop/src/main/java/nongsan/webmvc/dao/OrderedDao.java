package nongsan.webmvc.dao;

import nongsan.webmvc.model.Ordered;

import java.util.List;

public interface OrderedDao {
    void insert(Ordered ordered);

    void edit(Ordered ordered);

    void delete(String id);

    Ordered get(int id);

    Ordered get(String name);

    List<Ordered> getAll();
}
