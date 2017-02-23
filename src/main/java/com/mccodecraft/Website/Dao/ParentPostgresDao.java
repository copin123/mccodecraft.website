package com.mccodecraft.Website.Dao;

import com.mccodecraft.Website.DbObjects.Parent;
import com.mccodecraft.Website.DbService.ParentDbService;

import java.sql.*;

/**
 * Created by james on 2/20/17.
 */
public class ParentPostgresDao <T extends Parent> implements ParentDbService<T> {

    private Connection conn;
    private Statement stmnt;

    public ParentPostgresDao() {
        String user= "postgres";
        String passwd = "postgres";
        String dbName = "sparkledb";
        String uri = "jdbc:postgressql://localhost/"+dbName;


//        Integer pId, String pName, String fName, String lName, String pWord, Date joinDate,Boolean isDeleted, Date dateDeleted
         String createTableQuery =
                "CREATE TABLE IF NOT EXISTS parent(" +
                        "pId          SERIAL       PRIMARY KEY," +
                        "pName        VARCHAR(64)  NOT NULL," +
                        "fName        VARCHAR(512) NOT NULL," +
                        "lName        VARCHAR(64)  NOT NULL," +
                        "pWord        VARCHAR(64)  NOT NULL,"  +
                        "dateCreated  DATE         NOT NULL" +
                        "deleted      BOOLEAN      DEFAULT FALSE," +
                        "dateDeleted  DATE         NOT NULL" +
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
            String insertQuery = "INSERT INTO parent(pId, pName, fName, lName, pWord, joinDate) VALUES(?,?,?,?,?,?);";
            //Prepared statements allow us to avoid sql inject attacks
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);

            //jdbc bindings here
            pstmt.setInt(1, entity.getpID());
            pstmt.setString(2, entity.getfName());
            pstmt.setString(3, entity.getlName());
            pstmt.setString(4, entity.getpWord());
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
    public T read(Integer pId) {
        Parent gottenParent = null;
        try {
            String getParentQuery = "SELECT * FROM parent where pID = ?";
            PreparedStatement pstmt = conn.prepareStatement(getParentQuery);

            pstmt.setInt(1, pId);
            ResultSet results = pstmt.getResultSet();

            gottenParent = new Parent(
                    results.getInt("pId"),
                    results.getString("pName" ),
                    results.getString( "fName" ),
                    results.getString("lName" ),
                    results.getString("pWord" ),
                    results.getDate("dateCreated" ),
                    results.getBoolean("deleted" ),
                    results.getDate("dateDeleted" ));
            pstmt.close();
            return (T) gottenParent;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            closeDB(stmnt, conn);
        }
        return (T) gottenParent;

    }

    @Override
    public Boolean update( Integer pId, String pName, String fName, String lName, String pWord, String joinDate ) {
        try {
        String updateQuery = "UPDATE parent SET pId = ?, pName= ?, fName = ?, lName = ?" +
                ", pWord = ?, joinDate = ? WHERE pId = ?";
        PreparedStatement pstmt = conn.prepareStatement(updateQuery);

        pstmt.setInt(1, pId);
        pstmt.setString(2, pName);
        pstmt.setString(3, fName);
        pstmt.setString(4, lName);
        pstmt.setString(5, pWord);

        pstmt.setDate(6, java.sql.Date.valueOf(joinDate));

        pstmt.executeUpdate();
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        closeDB(stmnt, conn);
    }
        return true;
    }

    @Override
    public Boolean delete(Integer pId) {
        try {
            String deleteQuery = "DELETE FROM parent WHERE pID = ?";
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, pId);
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
