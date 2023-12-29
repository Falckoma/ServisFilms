package com.example.demo_kr.repository;

import com.example.demo_kr.mapper.MapperProfile;
import com.example.demo_kr.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryAuthent {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MapperProfile mapperProfile;

    @Autowired
    public RepositoryAuthent(NamedParameterJdbcTemplate jdbcTemplate, MapperProfile mapperProfile) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapperProfile = mapperProfile;
    }

    public Profile findByEmail(String email) {
        String sql = "SELECT * FROM profile WHERE email = :email";

        SqlParameterSource namedParameters = new MapSqlParameterSource("email", email);

        try {
            return jdbcTemplate.queryForObject(sql, namedParameters, mapperProfile);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}