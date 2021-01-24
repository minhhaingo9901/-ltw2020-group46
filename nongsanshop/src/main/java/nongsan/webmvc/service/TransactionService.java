package nongsan.webmvc.service;

import nongsan.webmvc.model.Transactions;

import java.util.List;

public interface TransactionService {
    void insert(Transactions transaction);

    void edit(Transactions transaction);

    void delete(String id);

    Transactions get(int id);

    Transactions get(String name);

    List<Transactions> getAll();

}
