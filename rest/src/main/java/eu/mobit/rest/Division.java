package eu.mobit.rest;

import java.sql.*;

public class Division {
   //rm-4xo39n0mvozqv4fj7eo.mysql.germany.rds.aliyuncs.com   Mobit_db-AL-2017_
    static String driver = "com.mysql.jdbc.Driver"; //  com.mysql.jdbc.Driver
    static String url="jdbc:mysql://rm-4xo39n0mvozqv4fj7eo.mysql.germany.rds.aliyuncs.com:3306/mobit";
    static String user="mobit";
    static String pwd = "Mobit_db-AL-2017_";
    public static int time=0;
    public static int residue=0;
    public void division(String sql){
        Connection cons=null;
        PreparedStatement pss=null;
        ResultSet rss = null;
        //获取要导入的总的数据条数
       // String sql3="SELECT  count(*)  FROM user_pass_detail";
        try {
            Class.forName(driver);
            cons = DriverManager.getConnection(url,user,pwd);
            pss=cons.prepareStatement(sql);
            rss=pss.executeQuery();
            int sum=0;
            while(rss.next()){
                System.out.println(sql.substring(23)+"表总记录条数:"+rss.getInt(1));
                sum=rss.getInt(1);
            }
            //每30000条记录作为一个分割点
            if(sum>=60000){
                time=sum/60000;
                residue=sum%60000;
            }else{
                residue=sum;
                time = 0; //加
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
