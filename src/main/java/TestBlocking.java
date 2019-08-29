import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Created by wangnan01 on 2017/7/12.
 */
public class TestBlocking extends AbstractVerticle {

    String url = "jdbc:mysql://192.168.10.131:3308/jj_shop" ;
    String username = "shopdev" ;
    String password = "loshop123";

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.executeBlocking(future->{
            try{
                BigDecimal priceCurrentWh = new BigDecimal(0);
                priceCurrentWh = priceCurrentWh.add(new BigDecimal(0.01).multiply(new BigDecimal(498)));
                Connection con = DriverManager.getConnection(url , username , password );
                Statement stmt = con.createStatement() ;
                stmt.execute("INSERT INTO test1 (money) values ("+ priceCurrentWh +")");
                stmt.close();
                con.close();
            }catch(SQLException se){
                System.out.println("Error!");
                se.printStackTrace() ;
            }
        }, res->{

        });
    }

    public static void main(String[] args){
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(TestBlocking.class.getName());
    }
}