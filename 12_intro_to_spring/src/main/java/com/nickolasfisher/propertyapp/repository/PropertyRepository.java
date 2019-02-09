package com.nickolasfisher.propertyapp.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.nickolasfisher.propertyapp.model.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PropertyRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String PRIMARY_KEY_CONDITION = " WHERE id = ?";

    private static final String FULL_SQL_FOR_PROPERTIES = "SELECT id, " +
            "ADDRESS_LINE_1, " +
            "ADDRESS_LINE_2, " +
            "ZIP_CODE, " +
            "SQ_FOOTAGE, " +
            "LOT_SIZE, " +
            "ASKING_PRICE FROM PROPERTIES";

    private static final String SQL_PROP_BY_PRIM_KEY =
            FULL_SQL_FOR_PROPERTIES + PRIMARY_KEY_CONDITION;

    private static final String SQL_PROP_BY_ZIP =
            FULL_SQL_FOR_PROPERTIES + " WHERE ZIP_CODE = ?";

    public Optional<Property> findById(int primaryKey) {
        List<Property> queryResult = jdbcTemplate.query(SQL_PROP_BY_PRIM_KEY,
                ps -> ps.setInt(1, primaryKey),
                propertyFullRowMapper());

        return queryResult.stream().findFirst();
    }

    private RowMapper<Property> propertyFullRowMapper() {
        return (rs, rowNum) ->
                Property.builder()
                        .id(rs.getInt("id"))
                        .addressLine1(rs.getString("address_line_1"))
                        .zipCode(rs.getInt("zip_code"))
                        .sqFootage(rs.getInt("sq_footage"))
                        .lotSize(rs.getInt("lot_size"))
                        .askingPrice(rs.getLong("asking_price"))
                        .build();
    }

    public List<Property> findByZipCode(int zipCode) {
        return jdbcTemplate.query(SQL_PROP_BY_ZIP,
                ps -> ps.setInt(1, zipCode),
                propertyFullRowMapper());
    }
}
