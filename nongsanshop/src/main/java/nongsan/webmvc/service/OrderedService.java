package nongsan.webmvc.service;

import nongsan.webmvc.model.Ordered;

import java.util.List;

public interface OrderedService {
    void insert(Ordered ordered);

    void edit(Ordered ordered);

    void delete(String id);

    Ordered get(int id);

    Ordered get(String name);

    List<Ordered> getAll();
}
