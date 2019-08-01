package io.khasang.gahelp.model.impl;

import io.khasang.gahelp.model.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service("createTable")
public class CreateTableImpl implements CreateTable {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String tableCreationStatus() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS dogs;");
        jdbcTemplate.execute("create table dogs\n" +
                "(\n" +
                "\tid serial not null,\n" +
                "\tname varchar(255) not null,\n" +
                "\tdescription varchar(255),\n" +
                "\tcolor_id integer not null\n" +
                ");\n" +
                "\n" +
                "create unique index dogs_id_uindex\n" +
                "\ton dogs (id);\n" +
                "\n" +
                "alter table dogs\n" +
                "\tadd constraint dogs_pk\n" +
                "\t\tprimary key (id);\n");

        return "Table created";
    }

    public Integer getInfo(String name){
        String sql = "select count(*) from cats where name = :name";
        SqlParameterSource namedParameters = new MapSqlParameterSource("name", name);
        return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
    }


    public Integer setUpdateHair(String name) {
        jdbcTemplate.update("update cats set color_id = 3 where name = ?", name);
        return getInfo(name);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
}
