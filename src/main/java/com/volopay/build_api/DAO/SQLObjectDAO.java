package com.volopay.build_api.DAO;

import com.volopay.build_api.entity.SQLObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SQLObjectDAO extends JpaRepository<SQLObject, Integer>
{
    // API 1
    @Query(value =
            "SELECT * FROM data d " +
            "WHERE d.department = ?3 AND d.date BETWEEN ?2 AND ?1", nativeQuery = true)
    List<SQLObject> find_total_items(
            String startTime,
            String endTime,
            String dept);

    // API 2.1
    @Query(value =
            "SELECT TOP (?3) * FROM data d " +
            "WHERE d.date BETWEEN ?1 AND ?2 " +
            "ORDER BY d.seats DESC", nativeQuery = true)
    List<SQLObject> find_item_by_quantity(
            String startTime,
            String endTime,
            int n);

    // API 2.2
    @Query(value =
            "SELECT TOP (?3) * FROM data " +
            "WHERE date BETWEEN ?1 AND ?2 " +
            "ORDER BY amount DESC", nativeQuery = true)
    List<SQLObject> find_item_by_price(
            String startTime,
            String endTime,
            int n);

    // API 3
    @Query(value =
            "SELECT " +
                    "0 as id, '0' as date, '0' as 'user', " +
                    "grp_table.department, " +
                    "'0' as software, " +
                    "100 * total_seats / SUM(total_seats) OVER () AS seats, " +
                    "'0' as amount " +
            "FROM " +
                "( " +
                    "SELECT SUM(d1.seats) as total_seats, d1.department FROM data d1 " +
                    "WHERE d1.date BETWEEN ?1 and ?2 " +
                    "GROUP BY d1.department) " +
                "as grp_table ", nativeQuery = true)
    List<SQLObject> find_percentage_departmentwise(
            String startTime,
            String endTime);
}
