package eu.mobit.rest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TestThread {


    public static void main(String[] args){
        long startTime=System.currentTimeMillis();
        String sql = null;
        String select = null;
        String add = null;
        List<String> stringList = new ArrayList<String>();
        List<String> selectList = new ArrayList<String>();
        List<String> addList = new ArrayList<String>();
        sql = "SELECT  count(*)  FROM action";
        stringList.add(0,sql);
        sql = "SELECT  count(*)  FROM app_message";
        stringList.add(1,sql);
        sql = "SELECT  count(*)  FROM app_message_user";
        stringList.add(2,sql);
        sql = "SELECT  count(*)  FROM app_version";
        stringList.add(3,sql);
        sql = "SELECT  count(*)  FROM bike_day";
        stringList.add(4,sql);
        sql = "SELECT  count(*)  FROM bonus_bike";
        stringList.add(5,sql);
        sql = "SELECT  count(*)  FROM bonus_bike_type";
        stringList.add(6,sql);
        sql = "SELECT  count(*)  FROM bplog";
        stringList.add(7,sql);
        sql = "SELECT  count(*)  FROM bpedit_log";
        stringList.add(8,sql);
        sql = "SELECT  count(*)  FROM business_condition";
        stringList.add(9,sql);
        sql = "SELECT  count(*)  FROM business_policy";
        stringList.add(10,sql);
        sql = "SELECT  count(*)  FROM city";
        stringList.add(11,sql);
        sql = "SELECT  count(*)  FROM coupon";
        stringList.add(12,sql);
        sql = "SELECT  count(*)  FROM coupon_type";
        stringList.add(13,sql);
        sql = "SELECT  count(*)  FROM factory_excel";
        stringList.add(14,sql);
        sql = "SELECT  count(*)  FROM fee_set";
        stringList.add(15,sql);
        sql = "SELECT  count(*)  FROM geofence_type";
        stringList.add(16,sql);
        sql = "SELECT  count(*)  FROM global_config";
        stringList.add(17,sql);
        sql = "SELECT  count(*)  FROM group_account";
        stringList.add(18,sql);
        sql = "SELECT  count(*)  FROM group_info";
        stringList.add(19,sql);
        sql = "SELECT  count(*)  FROM coupon_qr_code";
        stringList.add(20,sql);
        sql = "SELECT  count(*)  FROM illegal_move";
        stringList.add(21,sql);
        sql = "SELECT  count(*)  FROM illegal_move_detail";
        stringList.add(22,sql);
        sql = "SELECT  count(*)  FROM installation_log";
        stringList.add(23,sql);
        sql = "SELECT  count(*)  FROM lock_type";
        stringList.add(24,sql);
        sql = "SELECT  count(*)  FROM maintenance";
        stringList.add(25,sql);
        sql = "SELECT  count(*)  FROM manager";
        stringList.add(26,sql);
        sql = "SELECT  count(*)  FROM message_template";
        stringList.add(27,sql);
        sql = "SELECT  count(*)  FROM message_template_detail";
        stringList.add(28,sql);
        sql = "SELECT  count(*)  FROM pay_history";
        stringList.add(29,sql);
        sql = "SELECT  count(*)  FROM order_detail";
        stringList.add(30,sql);
        sql = "SELECT  count(*)  FROM order_discount_history";
        stringList.add(31,sql);
        sql = "SELECT  count(*)  FROM orders";
        stringList.add(32,sql);
        sql = "SELECT  count(*)  FROM problem";
        stringList.add(33,sql);
        sql = "SELECT  count(*)  FROM problem_details";
        stringList.add(34,sql);
        sql = "SELECT  count(*)  FROM problem_repair";
        stringList.add(35,sql);
        sql = "SELECT  count(*)  FROM problem_repair_detail";
        stringList.add(36,sql);
        sql = "SELECT  count(*)  FROM questions";
        stringList.add(37,sql);
        sql = "SELECT  count(*)  FROM questions_type";
        stringList.add(38,sql);
        sql = "SELECT  count(*)  FROM request_refund";
        stringList.add(39,sql);
        sql = "SELECT  count(*)  FROM resource";
        stringList.add(40,sql);
        sql = "SELECT  count(*)  FROM resource_role";
        stringList.add(41,sql);
        sql = "SELECT  count(*)  FROM role";
        stringList.add(42,sql);
        sql = "SELECT  count(*)  FROM share_reg_log";
        stringList.add(43,sql);
        sql = "SELECT  count(*)  FROM backend_log";
        stringList.add(44,sql);
        sql = "SELECT  count(*)  FROM system_general";
        stringList.add(45,sql);
        sql = "SELECT  count(*)  FROM company";
        stringList.add(46,sql);
        sql = "SELECT  count(*)  FROM users_app";
        stringList.add(47,sql);
        sql = "SELECT  count(*)  FROM orders_gps_info";
        stringList.add(48,sql);
        sql = "SELECT  count(*)  FROM user_bill";
        stringList.add(49,sql);
        sql = "SELECT  count(*)  FROM user_pass";
        stringList.add(50,sql);
        sql = "SELECT  count(*)  FROM user_pass_detail";
        stringList.add(51,sql);
        sql = "SELECT  count(*)  FROM user_rating";
        stringList.add(52,sql);
        sql = "SELECT  count(*)  FROM user_share_code";
        stringList.add(53,sql);
        sql = "SELECT  count(*)  FROM users";
        stringList.add(54,sql);
        sql = "SELECT  count(*)  FROM wallet";
        stringList.add(55,sql);
        sql = "SELECT  count(*)  FROM object_type";
        stringList.add(56,sql);
        sql = "SELECT  count(*)  FROM dict_info";
        stringList.add(57,sql);
        sql = "SELECT  count(*)  FROM group_account_main";
        stringList.add(58,sql);
        for (int i =0;i<stringList.size();i++){
            if (i<=7){
                continue;
            }
            String tale = stringList.get(i).toString();
            Division division = new Division();
            division.division(stringList.get(i).toString());
            int time = 0;
            if (Division.time == 0){
                time= Division.time;
                JdbcUtils jdbcUtils=new JdbcUtils(time, Division.residue,i);
                System.out.println(tale.substring(23)+"表线程");
                new Thread(jdbcUtils,"新线程"+1).start();
            }else {
                time= Division.time +1;
                System.out.println(tale.substring(23)+"表"+time);
                for(int j=0;j<time;j++){
                    JdbcUtils jdbcUtils = null;
                    if (j==time){
                        jdbcUtils=new JdbcUtils(j*60000, Division.residue,i);
                    }else {
                        jdbcUtils=new JdbcUtils(j*60000,60000,i);
                    }
                    System.out.println(tale.substring(23)+"表线程"+j);
                    new Thread(jdbcUtils,"新线程"+i).start();
                }
            }
        }

        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

    }
}
