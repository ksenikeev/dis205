package ru.itis.dis205.lab2_8.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.itis.dis205.lab2_8.model.Address;
import java.util.List;

@Repository
public class AddressRepository {

    public static final int countRowPerPage = 25;
    @PersistenceContext
    private EntityManager entityManager;

    public List<Address> findAddressByName(String name, Integer page) {
        Query queryCount =
                entityManager.createQuery("select count(a) from Address a where fullpath like :name ");
        queryCount.setParameter("name", "%" + name + "%");

        Long count = (Long) queryCount.getSingleResult();

        Long start = (page - 1) * count/countRowPerPage;

        Query queryAdr =
                entityManager.createQuery("select a from Address a where fullpath like :name ");
        queryAdr.setParameter("name", "%" + name + "%");
        queryAdr.setFirstResult(start.intValue());
        queryAdr.setMaxResults(countRowPerPage);
        return queryAdr.getResultList();
    }

    public Long countPages(String name) {
        Query queryCount =
                entityManager.createNativeQuery(
                        "select count(*) from address a where fullpath_tv @@ to_tsquery(:name) ");

        name = name.trim().replaceAll("\\s+", ":* & ") + ":*";

        queryCount.setParameter("name", name);

        return  (long)queryCount.getSingleResult() / countRowPerPage + ((long)queryCount.getSingleResult() % countRowPerPage > 0 ? 1 : 0) ;
    }

    public List<Address> findAddressByNameTS(String name, Integer page) {
        int start = (page - 1) * countRowPerPage;

        name = name.trim().replaceAll("\\s+", ":* & ") + ":*";

        Query queryAdr =
            entityManager.createNativeQuery(
                "select id, fullpath from address a where fullpath_tv @@ to_tsquery(:name) order by id", Address.class);
        queryAdr.setParameter("name", name);

        queryAdr.setFirstResult(start);
        queryAdr.setMaxResults(countRowPerPage);

        return queryAdr.getResultList();
    }
}
