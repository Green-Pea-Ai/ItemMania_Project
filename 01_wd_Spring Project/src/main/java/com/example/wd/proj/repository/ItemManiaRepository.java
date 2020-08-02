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
import java.util.Date;
import java.util.List;

@Repository
public class ItemManiaRepository {
    static final Logger log = LoggerFactory.getLogger(ItemManiaRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // list : 아이템 리스트 보기 =========================================================================================
    public List<ItemManiaBoard> mbList() throws Exception {
        log.info("Mania Repository list()");

        // 리스트의 순서를 바꾸려면 DB 건드릴 필요없이
        // list 폼만 바꾸면 된다.
        // (가격을 등록했는데 닉네임 열에 값이 들어가서 열 수정할때)
        List<ItemManiaBoard> results = jdbcTemplate.query(
                "select cust_no, nickname, price, id, pw, " +
                        "item_name, reg_date, content from item_mania " +
                        "where cust_no > 0 order by " +
                        "cust_no desc, reg_date desc",
                new RowMapper<ItemManiaBoard>() {
                    @Override
                    public ItemManiaBoard mapRow(ResultSet rs, int rowNum)
                                                    throws SQLException {

                        ItemManiaBoard board = new ItemManiaBoard();

                        board.setCustomerNo(rs.getInt("cust_no"));
                        board.setUserId(rs.getString("id"));
                        board.setUserPw(rs.getString("pw"));
                        board.setNickName(rs.getString("nickname"));
                        board.setItemName(rs.getString("item_name"));
                        board.setPrice(rs.getInt("price"));
                        board.setRegDate(rs.getDate("reg_date"));
                        board.setContent(rs.getString("content"));

                        return board;
                    }
                });
        return results;
    }

    // register : 아이템 등록 =========================================================================================
    public void itemInsert(ItemManiaBoard board) throws Exception {
        log.info("Repository create()");

        String query = "insert into item_mania(" +
                "item_name, nickname, id, pw, price, content) " +
                "values(?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query,
                board.getItemName(),
                board.getNickName(),
                board.getUserId(),
                board.getUserPw(),
                board.getPrice(),
                board.getContent());
    }

    // remove : 아이템 삭제 =========================================================================================
    // 다른 클래스가 가진 custNo의 쓰임새?
    public void removeFromRepo(Integer customerNo) throws Exception {
        String query = "delete from item_mania where cust_no = ?";
        jdbcTemplate.update(query, customerNo);
    }

    // read : 아이템 상세보기 =========================================================================================
    public ItemManiaBoard readFromRepo(Integer customerNo) throws Exception {

        /*"select cust_no, id, pw, nickname, " +
                "item_name, price, reg_date, content from item_mania " +
                "where cust_no > 0 order by " +
                "cust_no desc, reg_date desc",*/

        List<ItemManiaBoard> results = jdbcTemplate.query(
                "select cust_no, id, pw, nickname, " +
                        "item_name, price, reg_date, content from item_mania " +
                        "where cust_no = ?",
                new RowMapper<ItemManiaBoard>() {
                    @Override
                    public ItemManiaBoard mapRow(ResultSet rs, int rowNum) throws SQLException {

                        ItemManiaBoard board = new ItemManiaBoard();

                        board.setCustomerNo(rs.getInt("cust_no"));
                        board.setItemName(rs.getString("item_name"));
                        board.setPrice(rs.getInt("price"));
                        board.setNickName(rs.getString("nickname"));
                        board.setUserId(rs.getString("id"));
                        board.setUserPw(rs.getString("pw"));
                        board.setContent(rs.getString("content"));
                        board.setRegDate(rs.getDate("reg_date"));

                        return board;
                    }
                }, customerNo
                //List<ItemManiaBoard> results = jdbcTemplate.query(데이터, custNo);
        );

        return results.isEmpty() ? null : results.get(0);
    }

    // modify : 아이템 정보 수정 =========================================================================================
    public void modifyFromRepo(ItemManiaBoard board) throws Exception {

        String query = "update item_mania set item_name = ?, price = ?, " +
                "content = ? where cust_no = ?";

        jdbcTemplate.update(
                query,
                board.getItemName(),
                board.getPrice(),
                board.getContent()
        );
    }
}
