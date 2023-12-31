package com.example.demo_kr.mapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.example.demo_kr.model.Profile;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapperProfile implements RowMapper<Profile> {

    @Override
    public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Profile(
                rs.getString("email"),
                rs.getString("password")
        );
    }
}