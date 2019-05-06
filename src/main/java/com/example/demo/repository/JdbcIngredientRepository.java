package com.example.demo.repository;

import com.example.demo.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// Repository that acts as the data acess layer
// This is only necessary if I am not using persistance
// handling the repo layer manually.
// In this case, I would also want to create a DAO Layer and use a Service instead of a repo
/*@Repository
public class JdbcIngredientRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll(){
        return jdbc.query("select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbc.queryForObject(
                "select id, name, type from Ingredient where id=?",
                new RowMapper<Ingredient>() {
                    public Ingredient mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        return new Ingredient(
                                rs.getString("id"),
                                rs.getString("name"),
                                Ingredient.Type.valueOf(rs.getString("type")));
                    };
                }, id);
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum)
            throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update(
                "insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

}*/
