package com.example.demo_kr.repository;

import com.example.demo_kr.mapper.MapperProfile;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorySettings implements RepositoryProfile {
    private static final String SQL_INSERT_PROFILE =
            "insert into profile (email, password) values (:email, :password)";
    private final MapperProfile Mapperprofile;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    public RepositorySettings(
            MapperProfile Mapperprofile,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.Mapperprofile = Mapperprofile;
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void insertProfile(String email, String password) {
        //int uniqueId = new Random().nextInt(Integer.MAX_VALUE);
        var params = new MapSqlParameterSource();
        //params.addValue("id", uniqueId);
        params.addValue("email", email);
        params.addValue("password", password);
        jdbcTemplate.update(SQL_INSERT_PROFILE, params);
    }

}