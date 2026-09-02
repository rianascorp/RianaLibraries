package rianaLibraries.controller;

import jakarta.persistence.EntityManager;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public interface RianaUpdateJpa {
    void Update(EntityManager entityManager) throws SQLException;

}
