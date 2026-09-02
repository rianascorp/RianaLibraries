package rianaLibraries.controller;

import jakarta.persistence.EntityManager;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.SQLException;

public interface RianaInsertJpa {
    void Insert(EntityManager entityManager) throws SQLException, IOException;

}
