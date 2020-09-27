package Utilities;

import Controller.RouteCollection;
import RouteObject.Coordinates;
import RouteObject.LocationFrom;
import RouteObject.LocationTo;
import RouteObject.Route;

import java.sql.*;
import java.util.Vector;

public class DBworking {
        private static final String url = "jdbc:postgresql://pg:5432/studs";
    private static final String user = "s286557";
    private static final String password = "tii864";

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement preparedStatement;
    private static ResultSet rs;


    public  Boolean ConnectionToDB() throws SQLException {
        try {
            connection = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    public Boolean userExist(String user, String password) throws SQLException {
    ConnectionToDB();
        try {
            preparedStatement = connection.prepareStatement("select *  from userdb d where exists( select * from userdb where d.login = ? and d.password= ?)");
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,password);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {

        }
        return false;
    }
    public Boolean routeExist(Long id) throws SQLException {
        ConnectionToDB();
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select *  from routes where id="+id);
            if (rs.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {

        }
        return false;
    }

    public Boolean addNewUser(String user, String password) throws SQLException {
        ConnectionToDB();
        try {
            preparedStatement = connection.prepareStatement("insert into userdb values (?,?)");
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,password);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {

            return false;
        }
    }
    public void uploadAllRoute() throws SQLException {
        ConnectionToDB();
        try {
            stmt = connection.createStatement();
            stmt.execute("TRUNCATE routes");
            Vector<Route> routes = RouteCollection.getCollection();
            routes.forEach(x -> {
                try {
                    preparedStatement = connection.prepareStatement("INSERT into routes values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    preparedStatement.setLong(1, Math.toIntExact(x.getId()));
                    preparedStatement.setString(2, x.getName());
                    preparedStatement.setLong(3, x.getCoordinates().getX());
                    preparedStatement.setLong(4, x.getCoordinates().getY());
                    preparedStatement.setTimestamp(5, x.getCreationDate());
                    preparedStatement.setDouble(6, x.getFrom().getX());
                    preparedStatement.setLong(7, x.getFrom().getY());
                    preparedStatement.setInt(8, x.getFrom().getZ());
                    preparedStatement.setString(9, x.getFrom().getName());
                    preparedStatement.setInt(10, x.getTo().getX());
                    preparedStatement.setDouble(11, x.getTo().getY());
                    preparedStatement.setLong(12, x.getTo().getZ());
                    preparedStatement.setLong(13, x.getDistance());
                    preparedStatement.setString(14, x.getUser());
                    preparedStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void loadAllRoutes() throws SQLException {
        ConnectionToDB();
        try {
            RouteCollection.getCollection().clear();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from routes");
            while (rs.next()){
                 Route route = new Route();
                 route.setId(rs.getLong(1));
                 route.setName(rs.getString(2));
                Coordinates coordinates = new Coordinates();
                coordinates.setX(rs.getLong(3));
                coordinates.setY(rs.getInt(4));
                route.setCoordinates(coordinates);
                route.setCreationDate(rs.getTimestamp(5));
                LocationFrom locationFrom = new LocationFrom();
                LocationTo locationTo = new LocationTo();
                try{
                    locationFrom.setX(rs.getFloat(6));
                    locationFrom.setY(rs.getLong(7));
                    locationFrom.setZ(rs.getInt(8));
                    locationFrom.setName(rs.getString(9));
                } catch (NullPointerException e){
                    route.setFrom(null);
                }
                route.setFrom(locationFrom);
                try{
                    locationTo.setX(rs.getInt(10));
                    locationTo.setY(rs.getFloat(11));
                    locationTo.setZ(rs.getLong(12));
                } catch (NullPointerException e){
                    route.setTo(null);
                }
                route.setTo(locationTo);
                try{
                route.setDistance(rs.getLong(13));
                } catch (NullPointerException e){
                    route.setDistance(null);
                }
                route.setUser(rs.getString(14));
                RouteCollection.getCollection().add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}