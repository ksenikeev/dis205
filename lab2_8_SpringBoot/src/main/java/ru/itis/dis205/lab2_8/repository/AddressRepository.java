package ru.itis.dis205.lab2_8.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.itis.dis205.lab2_8.model.Address;

import java.util.Arrays;
import java.util.List;

@Repository
public class AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Address> findAddressByName(String name, Integer page) {
        Query queryCount =
                entityManager.createQuery("select count(a) from Address a where fullpath like :name ");
        queryCount.setParameter("name", "%" + name + "%");

        Long count = (Long) queryCount.getSingleResult();

        Long start = (page - 1) * count/10;

        Query queryAdr =
                entityManager.createQuery("select a from Address a where fullpath like :name ");
        queryAdr.setParameter("name", "%" + name + "%");
        queryAdr.setFirstResult(start.intValue());
        queryAdr.setMaxResults(10);
        return queryAdr.getResultList();
    }

    public Long countPages(String name) {
        Query queryCount =
                entityManager.createNativeQuery(
                        "select count(*) from address a where fullpath_tv @@ to_tsquery(:name) ");

        name = name.trim().replaceAll("\\s+", ":* & ") + ":*";

        queryCount.setParameter("name", name);

        return  (Long) queryCount.getSingleResult();
    }

    public List<Address> findAddressByNameTS(String name, Integer page) {
        Query queryCount =
                entityManager.createNativeQuery(
                        "select count(*) from address a where fullpath_tv @@ to_tsquery(:name) ");

        name = name.trim().replaceAll("\\s+", ":* & ") + ":*";

        queryCount.setParameter("name", name);

        Long count = (Long) queryCount.getSingleResult();

        Long start = (page - 1) * count/10;

        Query queryAdr =
            entityManager.createNativeQuery(
                "select id, fullpath from address a where fullpath_tv @@ to_tsquery(:name) order by id", Address.class);
        queryAdr.setParameter("name", name);

        queryAdr.setFirstResult(start.intValue());
        queryAdr.setMaxResults(10);

        return queryAdr.getResultList();
    }
}
