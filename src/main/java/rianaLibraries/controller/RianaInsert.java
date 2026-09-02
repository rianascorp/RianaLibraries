package rianaLibraries.controller;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.SQLException;

public interface RianaInsert {
    void Insert(SqlSession sqlSession) throws SQLException, IOException;
}
