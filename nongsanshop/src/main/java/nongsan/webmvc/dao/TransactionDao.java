package nongsan.webmvc.dao;

import nongsan.webmvc.model.Transactions;

import java.util.List;

public interface TransactionDao {
    void insert(Transactions transaction);

    void edit(Transactions admin);

    void delete(String id);

    Transactions get(int id);

    Transactions get(String name);

    List<Transactions> getAll();
}
