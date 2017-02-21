package com.mccodecraft.Website;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by james on 2/7/17.
 */
public class ArticlePostgresDao <T extends Article> implements ArticleDbService<T> {

    private Connection conn;
    private Statement stmnt;

    public ArticlePostgresDao() {
        String user= "postgres";
        String passwd = "postgres";
        String dbName = "sparkledb";
        String uri = "jdbc:postgressql://localhost/"+dbName;

        String createTableQuery =
                "CREATE TABLE IF NOT EXISTS article(" +
                        "id         INT         PRIMARY KEY NOT NULL," +
                        "title      VARCHAR(64) NOT NULL," +
                        "content    VARCHAR(512)NOT NULL," +
                        "summary    VARCHAR(64) NOT NULL," +
                        "deleted    BOOLEAN     DEFAULT FALSE," +
                        "createdAt  DATE        NOT NULL" +
                        ")";
        try {
            conn = DriverManager.getConnection(uri, user, passwd);
            stmnt = conn.createStatement();
            stmnt.execute(createTableQuery);
            System.out.println("Connecting to PostgreSQL database");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            closeDB(stmnt, conn);
        }
    }

    @Override
    public Boolean create(T entity) {
        try {
            String insertQuery = "INSERT INTO article(id, title, content, summary, createdAt) VALUES(?,?,?,?,?);";
            //Prepared statements allow us to avoid sql inject attacks
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);

            //jdbc bindings here
            pstmt.setInt(1, entity.getId());
            pstmt.setString(2, entity.getTitle());
            pstmt.setString(3, entity.getContent());
            pstmt.setString(4, entity.getSummary());

            java.sql.Date sqlNow = new java.sql.Date(new java.util.Date().getTime());
            pstmt.setDate(5, sqlNow);
            pstmt.executeUpdate();
            // Unless closed prepared statement connections will linger
            // Not very important for a trivial app but it will burn you in a professional large codebase
            pstmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            closeDB(stmnt, conn);
            return false;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T readOne(int id) {
        try {
            String selectQuery = "SELECT * FROM article wher id = ?";
            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.getResultSet();

            if(result.next()) {
                Article entity = new Article(
                        result.getString("title"),
                        result.getString("summary"),
                        result.getString("content"),
                        result.getInt("id"),
                        result.getDate("createdat"),
                        result.getBoolean("deleted") );
                pstmt.close();
                return (T) entity;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            closeDB(stmnt, conn);
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<T> readAll() {
        ArrayList results = (ArrayList<Article>) new ArrayList<T>();
        try {
            String query = "SELECT * FROM article;";
            stmnt.execute(query);
            ResultSet resultSet = stmnt.getResultSet();

            while (resultSet.next()) {
                Article entity = new Article(
                        resultSet.getString("title"),
                        resultSet.getString("summary"),
                        resultSet.getString("content"),
                        resultSet.getInt("id"),
                        resultSet.getDate("createdat"),
                        resultSet.getBoolean("deleted"));
                results.add(entity);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            closeDB(stmnt, conn);

        }

        return (ArrayList<T>) results;
    }

    @Override
    public Boolean update(int id, String title, String summary, String content, java.util.Date date, Boolean delete) {
        try {
            String updateQuery = "UPDATE article SET title = ?, summary = ?, content = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);

            pstmt.setString(1, title);
            pstmt.setString(2, summary);
            pstmt.setString(3, content);
            pstmt.setInt(4, id);

            pstmt.executeUpdate();;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            closeDB(stmnt, conn);
        }
        return true;
    }

    @Override
    public Boolean delete(int id) {
        try {
            String deleteQuery = "DELETE FROM article WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            closeDB(stmnt, conn);
        }
        return true;
    }

    private void closeDB(Statement stmnt, Connection conn) {
        try{
            if(null !=stmnt) { stmnt.close(); }
            if(null != conn) { conn.close(); }
        } catch(SQLException exc) {
            exc.printStackTrace();
        }
    }
}
