package com.example.wd.proj.repository;

import com.example.wd.proj.entity.ItemManiaBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemManiaRepository {
    static final Logger log = LoggerFactory.getLogger(ItemManiaRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ItemManiaBoard> list() throws Exception {
        log.info("Mania Repository list()");

        List<ItemManiaBoard> results = jdbcTemplate.query(
                "select cust_no, id, pw, nickname, " +
                        "item_name, price, reg_date from item_mania " +
                        "where cust_no > 0 order by " +
                        "cust_no desc, reg_date desc",
                new RowMapper<ItemManiaBoard>() {
                    @Override
                    public ItemManiaBoard mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        ItemManiaBoard board = new ItemManiaBoard();

                        board.setCustNo(rs.getInt("cust_no"));
                        board.setUserId(rs.getString("id"));
                        board.setUserPw(rs.getString("pw"));
                        board.setNickName(rs.getString("nickname"));
                        board.setItemName(rs.getString("item_name"));
                        board.setPrice(rs.getInt("price"));
                        board.setRegDate(rs.getDate("reg_date"));

                        return board;
                    }
                });
        return results;
    }
}
