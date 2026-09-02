package rianaLibraries.controller;

import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public interface RianaUpdate {
    void Update(SqlSession sqlSession) throws SQLException;
}
