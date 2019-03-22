package eu.mobit.rest;

import java.sql.*;


//rm-4xo39n0mvozqv4fj7eo.mysql.germany.rds.aliyuncs.com  Mobit_db-AL-2017_
public class JdbcUtils implements Runnable {
    static String driver = "com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://rm-4xo39n0mvozqv4fj7eo.mysql.germany.rds.aliyuncs.com:3306/mobit?"+"useUnicode=true&characterEncoding=UTF8";
    static String user="mobit";
    static String pwd = "Mobit_db-AL-2017_";
    //目标地址
    static String url2="jdbc:mysql://47.254.176.249:3306/mobit?"+"useUnicode=true&characterEncoding=UTF8";
    static String user2="root";
    static String pwd2 = "Mobit2018ACCMobitTDB";
    private Connection cons=null;
    private Statement stas=null;
    private  Connection con=null;
    private Statement sta=null;
    private final int startNum;
    private final int pageSize;
    private final int dateSize;
    public JdbcUtils(int startNum, int pageSize, int dateSize){
        this.startNum=startNum;
        this.pageSize=pageSize;
        this.dateSize = dateSize;
        try {
            Class.forName(driver);
            cons = DriverManager.getConnection(url,user,pwd);
             stas = cons.createStatement();
            //
            Class.forName(driver);
             con = DriverManager.getConnection(url2,user2,pwd2);
             sta = con.createStatement();
          //  con.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void  insert(int startNum,int pageSize,int dateSize)throws ClassNotFoundException{
        ResultSet rss = null;
        PreparedStatement pstmt=null;
        String sql1 = null;
        try {


              if (dateSize==0){
                  sql1="SELECT * FROM action order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("action表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO bpaction (`id`, `class_path`, `method_name`, `name`, `params`, `type_id`) VALUES (?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,"eu.mobit.service.businessPolicy.BPActionService");
                          pstmt.setString(3,rss.getString("method_name"));
                          pstmt.setString(4,rss.getString("name"));
                          pstmt.setString(5,rss.getString("params"));
                          pstmt.setString(6,rss.getString("type_id"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
                  if (dateSize==1){
                      sql1="SELECT * FROM app_message order by id limit "+startNum+","+pageSize+";";
                      rss=stas.executeQuery(sql1);
                      System.out.println("app_message表添加数据");
                      while(rss.next()){
                          String sql = "INSERT INTO app_message (`id`, `content`, `creation_date`, `image_title`, `send_by`, `template_detail_id`, `template_updated_time`, `title`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                          try {
                              pstmt = (PreparedStatement) con.prepareStatement(sql);
                              pstmt.setString(1,rss.getString("id"));
                              pstmt.setString(2,rss.getString("content"));
                              pstmt.setString(3,rss.getString("add_time"));
                              pstmt.setString(4,rss.getString("image_title"));
                              pstmt.setString(5,rss.getString("send_manager_id"));
                              pstmt.setString(6,rss.getString("template_detail_id"));
                              pstmt.setString(7,rss.getString("template_update_time"));
                              pstmt.setString(8,rss.getString("title"));
                              int i =pstmt.executeUpdate();
                              System.out.println(pstmt);
                          } catch (Exception e) {
                              e.printStackTrace();
                          }
                      }

                  }
                  if (dateSize==2){
                  sql1="SELECT * FROM app_message_user order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("app_message表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO app_message_user (`id`, `already_reminded_by_popup`, `app_message_id`, `creation_date`, `is_deleted`, `read_time`, `status`, `type`, `user_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("already_reminded_by_popup"));
                          pstmt.setString(3,rss.getString("message_id"));
                          pstmt.setString(4,rss.getString("add_time"));
                          pstmt.setString(5,rss.getString("is_deleted"));
                          pstmt.setString(6,rss.getString("read_time"));
                          pstmt.setString(7,rss.getString("status"));
                          pstmt.setString(8,rss.getString("type"));
                          pstmt.setString(9,rss.getString("user_id"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize==3){
                  sql1="SELECT * FROM app_version order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("app_version 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO app_version (`id`, `creation_date`, `force_upgrade_version`, `os_type`, `release_note`, `version_number`) VALUES (?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("add_time"));
                          pstmt.setString(3,rss.getString("type"));
                          pstmt.setString(4,rss.getString("release_note"));
                          pstmt.setString(5,rss.getString("version"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize==4){
                  sql1="SELECT * FROM bike_day order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("bike_daily_summary 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO bike_daily_summary (`id`, `back_code`, `connection_status`, `creation_date`, `distance`, `duration`, `front_code`, `is_defect`, `is_deleted`, `last_offline_time`, `last_updated_date`, `launched_city_id`, `linked_group`, `linked_group_names`, `lock_id`, `lock_status`, `number_of_rides`, `number_of_users`, `show_on_app`, `sim_card_iccid`, `summary_date`, `voltage`, `voltage_percentage`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("back_code"));
                          pstmt.setString(3,rss.getString("status"));
                          pstmt.setString(4,rss.getString("add_time"));
                          pstmt.setString(5,rss.getString("distance"));
                          pstmt.setString(6,rss.getString("duration"));
                          pstmt.setString(7,rss.getString("front_code"));
                          pstmt.setString(8,rss.getString("is_broken"));
                          pstmt.setString(9,rss.getString("is_delete"));
                          pstmt.setString(10,rss.getString("last_offline_time"));
                          pstmt.setString(11,rss.getString("last_update_time"));
                          pstmt.setString(12,rss.getString("launched_city_id"));
                          pstmt.setString(13,rss.getString("group_ids"));
                          pstmt.setString(14,rss.getString("group_names"));
                          pstmt.setString(15,rss.getString("imsi"));
                          pstmt.setString(16,rss.getString("lock_status"));
                          pstmt.setString(17,rss.getString("order_count"));
                          pstmt.setString(18,rss.getString("user_count"));
                          pstmt.setString(19,rss.getString("view_able"));
                          pstmt.setString(20,rss.getString("ccid"));
                          pstmt.setString(21,rss.getString("day_time"));
                          pstmt.setString(22,rss.getString("battery"));
                          pstmt.setString(23,rss.getString("bttery_percent"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize==5){
                  sql1="SELECT * FROM bonus_bike order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("bonus_bike 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO bonus_bike (`id`, `created_by`, `creation_date`, `description`, `lock_id`, `ride_id`, `type_id`, `used_time`, `user_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("set_manager"));
                          pstmt.setString(3,rss.getString("add_time"));
                          pstmt.setString(4,rss.getString("description"));
                          pstmt.setString(5,rss.getString("imsi"));
                          pstmt.setString(6,rss.getString("order_id"));
                          pstmt.setString(7,rss.getString("type_id"));
                          pstmt.setString(8,rss.getString("use_time"));
                          pstmt.setString(9,rss.getString("user_id"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize==6){
                  sql1="SELECT * FROM bonus_bike_type order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("bonus_bike_type 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO bonus_bike_type (`id`, `created_by`, `creation_date`, `credit`, `description`, `discount`, `icon`, `linked_coupon_id`, `name`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("manager_id"));
                          pstmt.setString(3,rss.getString("add_time"));
                          pstmt.setString(4,rss.getString("credit"));
                          pstmt.setString(5,rss.getString("description"));
                          pstmt.setString(6,rss.getString("discount"));
                          pstmt.setString(7,rss.getString("icon"));
                          pstmt.setString(8,rss.getString("coupon_id"));
                          pstmt.setString(9,rss.getString("name"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 7){
               /*   sql1="SELECT * FROM bplog order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("bpexecution_log 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO bpexecution_log (`id`, `action_id`, `bp_id`, `condition_id`, `condition_res`, `creation_date`, `ride_id`) VALUES (?, ?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("action_id"));
                          pstmt.setString(3,rss.getString("bp_id"));
                          pstmt.setString(4,rss.getString("condition_id"));
                          pstmt.setString(5,rss.getString("condition_res"));
                          pstmt.setString(6,rss.getString("creation_time"));
                          pstmt.setString(7,rss.getString("order_id"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }*/

              }
              if (dateSize == 8){
                  sql1="SELECT * FROM bpedit_log order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("bpedit_log 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO bpedit_log (`id`, `bp_id`, `last_updated_by`, `last_updated_time`, `note`) VALUES (?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("bp_id"));
                          pstmt.setString(3,rss.getString("last_updated_by"));
                          pstmt.setString(4,rss.getString("last_updated_time"));
                          pstmt.setString(5,rss.getString("note"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize ==9){
                  sql1="SELECT * FROM business_condition order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("bpcondition 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO bpcondition (`id`, `class_path`, `method_name`, `name`, `params`, `type_id`) VALUES (?, ?, ?, ?, ?, ?);";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,"eu.mobit.service.businessPolicy.BPConditionService");
                          pstmt.setString(3,rss.getString("method_name"));
                          pstmt.setString(4,rss.getString("name"));
                          pstmt.setString(5,rss.getString("params"));
                          pstmt.setString(6,rss.getString("type_id"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 10){
                  sql1="SELECT * FROM business_policy order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("business_policy 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO business_policy (`id`, `actions`, `conditions`, `created_by`, `creation_date`, `cron`, `json`, `last_updated_by`, `last_updated_time`, `name`, `status`, `type`, `type_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("actions"));
                          pstmt.setString(3,rss.getString("conditions"));
                          pstmt.setString(4,rss.getString("add_manager"));
                          pstmt.setString(5,rss.getString("add_time"));
                          pstmt.setString(6,rss.getString("cron"));
                          pstmt.setString(7,rss.getString("json"));
                          pstmt.setString(8,rss.getString("last_updated_by"));
                          pstmt.setString(9,rss.getString("edit_time"));
                          pstmt.setString(10,rss.getString("name"));
                          pstmt.setString(11,rss.getString("status"));
                          pstmt.setString(12,rss.getString("type"));
                          pstmt.setString(13,rss.getString("type_id"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize ==11){
                  sql1="SELECT * FROM city order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("city 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO city (`id`, `last_modified_date`, `latitude`, `longitude`, `name`) VALUES (?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("last_edit_time")); // 还有一个时间
                          pstmt.setString(3,rss.getString("lat"));
                          pstmt.setString(4,rss.getString("lng"));
                          pstmt.setString(5,rss.getString("name"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 12){
                  sql1="SELECT * FROM coupon order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("coupon 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO coupon (`id`, `begin_time`, `coupon_pack_id`, `coupon_value`, `creation_date`, `end_time`, `status`, `used_time`, `user_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("start_time"));
                          pstmt.setString(3,rss.getString("type_id"));
                          pstmt.setString(4,rss.getString("price"));
                          pstmt.setString(5,rss.getString("add_time"));
                          pstmt.setString(6,rss.getString("end_time"));
                          pstmt.setString(7,rss.getString("status"));
                          pstmt.setString(8,rss.getString("use_time"));
                          pstmt.setString(9,rss.getString("user_id"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 13){
                  sql1="SELECT * FROM coupon_type order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("coupon_pack 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO coupon_pack (`id`, `count_per_outgiving`, `coupon_qr_code_id`, `coupon_value`, `created_by`, `creation_date`, `expired_date`, `generate_method`, `is_active`, `linked_message_template_id`, `name`, `outgiven_count`, `outgiving_end_date`, `outgiving_start_date`, `total_quantity`, `valid_days`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("max_count"));//
                          pstmt.setString(3,rss.getString("qr_code_id"));
                          pstmt.setString(4,rss.getString("price"));
                          pstmt.setString(5,rss.getString("generate_method"));
                          pstmt.setString(6,rss.getString("add_time"));
                          pstmt.setString(7,rss.getString("destory_time"));
                          pstmt.setString(8,rss.getString("generate_method"));
                          pstmt.setString(9,rss.getString("status"));
                          pstmt.setString(10,rss.getString("message_template_id"));
                          pstmt.setString(11,rss.getString("name"));
                          pstmt.setString(12,rss.getString("outgiven_count"));
                          pstmt.setString(13,rss.getString("end_time"));
                          pstmt.setString(14,rss.getString("start_time"));
                          pstmt.setString(15,rss.getString("quantity"));
                          pstmt.setString(16,rss.getString("days"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 14){
                  sql1="SELECT * FROM factory_excel order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("factory_production_record 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO factory_production_record (`id`, `back_code`, `ble_key`, `ble_mac`, `ble_password`, `creation_date`, `lock_id`, `sim_card_iccid`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("houcode"));
                          pstmt.setString(3,rss.getString("ble_key"));
                          pstmt.setString(4,rss.getString("mac"));
                          pstmt.setString(5,rss.getString("ble_password"));
                          pstmt.setString(6,rss.getString("add_time"));
                          pstmt.setString(7,rss.getString("imsi"));
                          pstmt.setString(8,rss.getString("ccid"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 15){
                  sql1="SELECT * FROM fee_set order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("fee_set 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO fee_set (`id`, `begin_time`, `end_time`, `last_edit_user`, `last_update_time`, `price`) VALUES (?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("begin_time"));
                          pstmt.setString(3,rss.getString("end_time"));
                          pstmt.setString(4,rss.getString("last_edit_user"));
                          pstmt.setString(5,rss.getString("last_update_time"));
                          pstmt.setString(6,rss.getString("price"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 16){
                  sql1="SELECT * FROM geofence_type order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("efence_type 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO efence_type (`id`, `automatic_expanded_zone`, `border_color`, `border_size`, `color`, `layer`, `linked_user_pass_id`, `name`, `show_on_app`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("auto_expand"));
                          pstmt.setString(3,rss.getString("border_color"));
                          pstmt.setString(4,rss.getString("border_size"));
                          pstmt.setString(5,rss.getString("color"));
                          pstmt.setString(6,rss.getString("layer"));
                          pstmt.setString(7,rss.getString("user_pass_id"));
                          pstmt.setString(8,rss.getString("name"));
                          pstmt.setString(9,rss.getString("show_app"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 17){
                  sql1="SELECT * FROM global_config order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("general_config 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO general_config (`id`, `adyen_app_id`, `adyen_hmac`, `adyen_merchant_account_for_balance`, `adyen_merchant_account_for_deposit`, `adyen_pay_url`, `adyen_secret_key`, `adyen_skin_code`, `adyen_user_name`, `adyen_user_password`, `adyen_web_pay_failure_url`, `adyen_web_pay_success_url`, `adyen_web_pay_url`, `deposit`, `illegal_movement_threshold`, `last_modifiedby`, `last_modified_time`, `need_deposit`, `receive_mail_account`, `send_mail_account`, `send_mail_account_password`, `send_mail_smtp`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("adyen_app_id"));
                          pstmt.setString(3,rss.getString("adyen_hmac"));
                          pstmt.setString(4,rss.getString("adyen_merchant_account"));
                          pstmt.setString(5,rss.getString("adyen_merchant_account_for_deposit"));
                          pstmt.setString(6,rss.getString("adyen_pay_url"));
                          pstmt.setString(7,rss.getString("adyen_secret_key"));
                          pstmt.setString(8,rss.getString("adyen_skin_code"));
                          pstmt.setString(9,rss.getString("adyen_user_name"));
                          pstmt.setString(10,rss.getString("adyen_user_passwd"));
                          pstmt.setString(11,rss.getString("adyen_web_pay_fail_url"));
                          pstmt.setString(12,rss.getString("adyen_web_pay_success_url"));
                          pstmt.setString(13,rss.getString("adyen_web_pay_url"));
                          pstmt.setString(14,rss.getString("deposit"));
                          pstmt.setString(15,rss.getString("illegal_move_distance"));
                          pstmt.setString(16,rss.getString("last_edit_user"));
                          pstmt.setString(17,rss.getString("last_edit_time"));
                          pstmt.setString(18,rss.getString("need_deposit"));
                          pstmt.setString(19,rss.getString("receive_mail_account"));
                          pstmt.setString(20,rss.getString("send_mail_account"));
                          pstmt.setString(21,rss.getString("send_mail_account_pass"));
                          pstmt.setString(22,rss.getString("send_mail_smtp"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 18){
                  sql1="SELECT * FROM group_account order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("group_account 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO group_account (`id`, `accept_date`, `accepted`, `creation_date`, `linked_user_id`, `main_account_user_id`) VALUES (?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("accept_date"));
                          pstmt.setString(3,rss.getString("accepted"));
                          pstmt.setString(4,rss.getString("add_time"));
                          pstmt.setString(5,rss.getString("linked_user_id"));
                          pstmt.setString(6,rss.getString("main_account_user_id"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 19){
                  sql1="SELECT * FROM group_info order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("group_info 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO group_info (`id`, `discount_rate`, `display_order`, `last_update_time`, `launched_city_group`, `launched_city_id`, `linked_user_pass_id`, `name`, `promotional_end_time`, `promotional_start_time`, `show_on_app`, `sorting`, `type`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("discount_rate"));
                          pstmt.setString(3,null);//暂无
                          pstmt.setString(4,rss.getString("update_time"));
                          pstmt.setString(5,rss.getString("launched_city_group"));
                          pstmt.setString(6,rss.getString("launched_city_id"));
                          pstmt.setString(7,rss.getString("user_pass_id"));
                          pstmt.setString(8,rss.getString("name"));
                          pstmt.setString(9,rss.getString("promotional_end_time"));
                          pstmt.setString(10,rss.getString("promotional_start_time"));
                          pstmt.setString(11,rss.getString("view_able"));
                          pstmt.setString(12,rss.getString("xx"));
                          pstmt.setString(13,rss.getString("type"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize ==20){
                  sql1="SELECT * FROM coupon_qr_code order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("coupon_qr_code 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO coupon_qr_code (`id`, `code`, `creation_date`, `description`, `name`, `user_id`) VALUES (?, ?, ?, ?, ?, ?);";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("code"));
                          pstmt.setString(3,rss.getString("add_time"));
                          pstmt.setString(4,rss.getString("description"));
                          pstmt.setString(5,rss.getString("name"));
                          pstmt.setString(6,rss.getString("user_id"));

                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 21){
                  sql1="SELECT * FROM illegal_move order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("lock_alarm 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO lock_alarm (`id`, `creation_date`, `distance`, `lock_id`) VALUES (?, ?, ?, ?);";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("add_time"));
                          pstmt.setString(3,rss.getString("distance"));
                          pstmt.setString(4,rss.getString("imsi"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 22){
                  sql1="SELECT * FROM illegal_move_detail order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("lock_alarm_detail 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO lock_alarm_detail (`id`, `creation_date`, `latitude`, `lock_alarm_id`, `lock_id`, `longitude`) VALUES (?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("add_time"));
                          pstmt.setString(3,rss.getString("lat"));
                          pstmt.setString(4,rss.getString("im_id"));
                          pstmt.setString(5,null);//lock_alarm 表里有参数
                          pstmt.setString(6,rss.getString("lon"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 23){
                  sql1="SELECT * FROM installation_log order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("lock2bike_link 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO lock2bike_link (`id`, `linked_by_manager_id`, `back_code`, `bike_id`, `creation_date`, `front_code`, `linked_by_manager_name`, `linked_manager_mobile_phone_imei`, `lock_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("manager_id"));
                          pstmt.setString(3,rss.getString("hou_code"));
                          pstmt.setString(4,rss.getString("chejia_code"));
                          pstmt.setString(5,rss.getString("add_time"));
                          pstmt.setString(6,rss.getString("qian_code"));
                          pstmt.setString(7,rss.getString("installation_person"));
                          pstmt.setString(8,rss.getString("imei"));
                          pstmt.setString(9,rss.getString("imsi"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize == 24){
                  sql1="SELECT * FROM lock_type order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("lock_type 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO lock_type (`id`, `lock_id_regx`, `manufacturer`, `simple_name`) VALUES (?, ?, ?, ?);";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("lock_imsi_regx"));
                          pstmt.setString(3,rss.getString("manufacturer"));
                          pstmt.setString(4,rss.getString("simple_name"));

                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize ==25){
                  sql1="SELECT * FROM maintenance order by id limit "+startNum+","+pageSize+";";
                  rss=stas.executeQuery(sql1);
                  System.out.println("maintenance 表添加数据");
                  while(rss.next()){
                      String sql = "INSERT INTO maintenance (`id`, `back_code`, `created_by`, `created_by_manager_name`, `creation_date`, `lock_id`) VALUES (?, ?, ?, ?, ?, ?)";
                      try {
                          pstmt = (PreparedStatement) con.prepareStatement(sql);
                          pstmt.setString(1,rss.getString("id"));
                          pstmt.setString(2,rss.getString("back_code"));
                          pstmt.setString(3,rss.getString("manager"));
                          pstmt.setString(4,rss.getString("manager_name"));
                          pstmt.setString(5,rss.getString("add_time"));
                          pstmt.setString(6,rss.getString("imsi"));
                          int i =pstmt.executeUpdate();
                          System.out.println(pstmt);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

              }
              if (dateSize ==26){
                sql1="SELECT * FROM manager order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("maintenance 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO manager (`id`, `created_by`, `creation_date`, `is_default_user`, `last_modified_date`, `last_reseted_time`, `linked_group`, `name`, `password`, `role_id`, `show_all_defect_bike_on_service_app`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("add_user"));
                        pstmt.setString(3,rss.getString("create_time"));
                        pstmt.setString(4,rss.getString("is_default_user"));
                        pstmt.setString(5,rss.getString("last_update_time"));
                        pstmt.setString(6,rss.getString("last_password_reset_time"));
                        pstmt.setString(7,rss.getString("bind_group"));
                        pstmt.setString(8,rss.getString("name"));
                        pstmt.setString(9,rss.getString("passwd"));
                        pstmt.setString(10,rss.getString("role_id"));
                        pstmt.setString(11,rss.getString("show_all_defect_bike_on_service_app"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            if (dateSize == 27){
                sql1="SELECT * FROM message_template order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("message_template 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO message_template (`id`, `created_by`, `creation_date`, `message_channel_type`, `message_type`, `name`) VALUES (?, ?, ?, ?, ?, ?);";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("add_manager"));
                        pstmt.setString(3,rss.getString("create_time"));
                        pstmt.setString(4,rss.getString("message_type"));
                        pstmt.setString(5,rss.getString("type"));
                        pstmt.setString(6,rss.getString("name"));

                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            if (dateSize == 28){
                sql1="SELECT * FROM message_template_detail order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("message_template_detail 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO message_template_detail (`id`, `content`, `creation_date`, `image_title`, `language`, `last_modified_date`, `template_id`, `title`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("content"));
                        pstmt.setString(3,rss.getString("add_time"));
                        pstmt.setString(4,rss.getString("image_title"));
                        pstmt.setString(5,rss.getString("language"));
                        pstmt.setString(6, String.valueOf(rss.getTimestamp("update_time")));
                        pstmt.setString(7,rss.getString("template_id"));
                        pstmt.setString(8,rss.getString("title"));

                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            if (dateSize == 29){
                sql1="SELECT * FROM pay_history order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("payment 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO payment (`id`, `auth_response`, `creation_date`, `psp_reference`, `quantity`, `status`, `type`, `user_id`, `uuid`, `payment_method`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("auth_response"));
                        pstmt.setString(3,rss.getString("create_time"));
                        pstmt.setString(4,rss.getString("payment_method"));
                        pstmt.setString(5,rss.getString("quantity"));
                        pstmt.setString(6,rss.getString("status"));
                        pstmt.setString(7,rss.getString("type"));
                        pstmt.setString(8,rss.getString("user_id"));
                        pstmt.setString(9,rss.getString("uuid"));
                        pstmt.setString(10,rss.getString("payment_method"));

                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            if (dateSize == 30){
                sql1="SELECT * FROM order_detail order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("ride_detail 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO ride_detail (`id`, `creation_date`, `event_type`, `latitude`, `longitude`, `note`, `ride_id`) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("creation_time"));
                        pstmt.setString(3,rss.getString("event_type"));
                        pstmt.setString(4,rss.getString("latitude"));
                        pstmt.setString(5,rss.getString("longitude"));
                        pstmt.setString(6,rss.getString("remark"));
                        pstmt.setString(7,rss.getString("order_id"));

                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            if (dateSize == 31){
                sql1="SELECT * FROM order_discount_history order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("discount_log 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO discount_log (`id`, `creation_date`, `discount_price`, `group_info_id`, `ride_id`, `ride_total_price`) VALUES (?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("add_time"));
                        pstmt.setString(3,rss.getString("discount_price"));
                        pstmt.setString(4,rss.getString("group_info_id"));
                        pstmt.setString(5,rss.getString("order_id"));
                        pstmt.setString(6,rss.getString("totale_price"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            if (dateSize == 32){
                sql1="SELECT * FROM orders order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("ride 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO ride (`id`, `actual_payment_amount`, `back_code`, `bp_executed`, `calories_burned`, `city_name`, `co2saved`, `created_via`, `current_status`, `discounted_amount`, `distance`, `duration`, `end_latitude`, `end_longitude`, `end_time`, `front_code`, `is_ended`, `is_viewed_by_user`, `last_updated_time`, `lock_id`, `sms_warning`, `start_latitude`, `start_longitude`, `start_time`, `total_amount`, `used_coupon_id`, `used_user_pass_detail_id`, `user_id`, `uuid`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("pay_price"));
                        pstmt.setString(3,rss.getString("back_code"));
                        pstmt.setString(4,rss.getString("exec_bp"));
                        pstmt.setString(5,rss.getString("calories"));
                        pstmt.setString(6,rss.getString("city_name"));
                        pstmt.setString(7,rss.getString("carbon"));
                        if (rss.getString("create_method") == null){
                            pstmt.setString(8,"2");
                        }else {
                            pstmt.setString(8,rss.getString("create_method"));
                        }
                        if (rss.getString("current_status") == null){
                            pstmt.setString(9,"4");
                        }else {
                            pstmt.setString(9,rss.getString("current_status"));
                        }
                        pstmt.setString(10,rss.getString("discounted"));
                        pstmt.setString(11,rss.getString("distance"));//
                        pstmt.setString(12,rss.getString("duration"));//
                        pstmt.setString(13,rss.getString("end_lat"));//
                        pstmt.setString(14,rss.getString("end_lon"));//
                        pstmt.setString(15,rss.getString("end_time"));//
                        pstmt.setString(16,rss.getString("fron_code"));//
                        pstmt.setString(17,rss.getString("status"));//
                        pstmt.setString(18,rss.getString("viwe_status"));//
                        pstmt.setString(19,rss.getString("edit_time"));//
                        pstmt.setString(20,rss.getString("imsi"));//
                        pstmt.setString(21,rss.getString("sms_warning"));//
                        pstmt.setString(22,rss.getString("start_lat"));//
                        pstmt.setString(23,rss.getString("start_lon"));//
                        pstmt.setString(24,rss.getString("start_time"));//
                        pstmt.setString(25,rss.getString("total_fee"));//
                        pstmt.setString(26,rss.getString("coupon_id"));//
                        pstmt.setString(27,rss.getString("user_pass_detail_id"));
                        pstmt.setString(28,rss.getString("user_id"));
                        pstmt.setString(29,rss.getString("uuid"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            if (dateSize == 33){
                sql1="SELECT * FROM problem order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("defect_report 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO defect_report (`id`, `assigned_time`, `assigned_to`, `backend_admin_record`, `confirmed_by`, `confirmed_time`, `created_by_user_id`, `creation_date`, `description`, `details_ids`, `latitude`, `lock_id`, `longitude`, `photo`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("replce_time"));
                        pstmt.setString(3,rss.getString("manager_id"));//
                        pstmt.setString(4,rss.getString("backend_admin_record"));
                        pstmt.setString(5,rss.getString("replace_manager"));//
                        pstmt.setString(6,rss.getString("completion_time"));//
                        pstmt.setString(7,rss.getString("add_user"));//
                        pstmt.setString(8,rss.getString("add_time"));//
                        pstmt.setString(9,rss.getString("description"));//
                        pstmt.setString(10,rss.getString("details_ids"));//
                        pstmt.setString(11,rss.getString("lat"));//
                        pstmt.setString(12,rss.getString("imsi"));//
                        pstmt.setString(13,rss.getString("lon"));
                        pstmt.setString(14,rss.getString("photo"));
                        pstmt.setString(15,rss.getString("status"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            if (dateSize == 34){
                sql1="SELECT * FROM problem_details order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("defect_report_details 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO defect_report_details (`id`, `problem_id`, `type`) VALUES (?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("problem_id"));
                        pstmt.setString(3,rss.getString("type"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 35){
                sql1="SELECT * FROM problem_repair order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("defect_repair 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO defect_repair (`id`, `created_by`, `creation_date`, `description`, `problem_id`, `result_type`) VALUES (?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("manager_id"));
                        pstmt.setString(3,rss.getString("add_time"));
                        pstmt.setString(4,rss.getString("description"));
                        pstmt.setString(5,rss.getString("problem_id"));
                        pstmt.setString(6,rss.getString("result_type"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 36){
                sql1="SELECT * FROM problem_repair_detail order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("defect_repair_detail 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO defect_repair_detail (`id`, `part_type`, `repair_id`) VALUES (?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("part_type"));
                        pstmt.setString(3,rss.getString("repair_id"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 37){
                sql1="SELECT * FROM questions order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("question_and_answer 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO question_and_answer (`id`, `answer`, `display_order`, `icon`, `last_modified_date`, `title`, `type_id`) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        String answer = rss.getString("answer");
                        pstmt.setString(2,answer);
                        pstmt.setString(3,rss.getString("sort_num"));
                        pstmt.setString(4,rss.getString("icon"));
                        pstmt.setString(5,rss.getString("last_update_time"));
                        pstmt.setString(6,rss.getString("title"));
                        pstmt.setString(7,rss.getString("type_id"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 38){
                sql1="SELECT * FROM questions_type order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("question_type 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO question_type (`id`, `icon`, `language`, `title`) VALUES (?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("icon"));
                        pstmt.setString(3,rss.getString("lang"));
                        pstmt.setString(4,rss.getString("title"));

                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 39){
                sql1="SELECT * FROM request_refund order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("refund_request 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO refund_request (`id`, `adyen_reference`, `balance`, `cancellation_reason`, `confirm_time`, `confirmed_by`, `creation_date`, `deposit`, `pay_id`, `psp_reference`, `refund_time`, `status`, `user_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("adyen_reference"));//
                        pstmt.setString(3,rss.getString("balance"));//
                        pstmt.setString(4,rss.getString("cancellation_reason"));//
                        pstmt.setString(5,rss.getString("confirm_time"));//
                        pstmt.setString(6,rss.getString("confirm_manager_id"));//
                        pstmt.setString(7,rss.getString("create_time"));//
                        pstmt.setString(8,rss.getString("deposit"));//
                        pstmt.setString(9,rss.getString("pay_id"));//
                        pstmt.setString(10,rss.getString("psp_reference"));//
                        pstmt.setString(11,rss.getString("tk_time"));//
                        pstmt.setString(12,rss.getString("status"));
                        pstmt.setString(13,rss.getString("user_id"));

                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 40){
                sql1="SELECT * FROM resource order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("security_entries 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO security_entries (`id`, `icon`, `name`, `parent`, `sorting`, `url`) VALUES (?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("icon"));//
                        pstmt.setString(3,rss.getString("name"));//
                        pstmt.setString(4,rss.getString("parent"));//
                        pstmt.setString(5,rss.getString("xx"));//
                        pstmt.setString(6,rss.getString("url"));//

                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 41){
                sql1="SELECT * FROM resource_role order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("permission 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO permission (`id`, `role_id`, `security_entries_id`) VALUES (?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("role_id"));//
                        pstmt.setString(3,rss.getString("resource_id"));//
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 42){
                sql1="SELECT * FROM role order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("role 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO role (`id`, `creation_date`, `name`) VALUES (?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("add_time"));//
                        pstmt.setString(3,rss.getString("name"));//
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize ==43){
                sql1="SELECT * FROM share_reg_log order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("role 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO shared_link_registration_log (`id`, `creation_date`, `registration_user_id`, `sharing_user_id`) VALUES (?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("add_time"));//
                        pstmt.setString(3,rss.getString("reg_user_id"));//
                        pstmt.setString(4,rss.getString("share_user_id"));//
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 44){
                sql1="SELECT * FROM backend_log order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("system_audit 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO system_audit (`id`, `created_by`, `creation_date`, `message`, `status`) VALUES (?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("manager_id"));//
                        pstmt.setString(3,rss.getString("creation_time"));//
                        pstmt.setString(4,rss.getString("message"));//
                        pstmt.setString(5,rss.getString("status"));//
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize ==45 ){
                sql1="SELECT * FROM system_general order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("system_config 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO system_config (`id`, `creation_date`, `description`, `key_str`, `value_str`) VALUES (?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("add_time"));//
                        pstmt.setString(3,rss.getString("description"));//
                        pstmt.setString(4,rss.getString("key_str"));//
                        pstmt.setString(5,rss.getString("value_str"));//
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 46){
                sql1="SELECT * FROM company order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("apiconsumer 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO apiconsumer (`id`, `create_by`, `creation_date`, `is_active`, `link_user_group`, `name`, `notificationurl`, `open_id`, `secret`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("create_by"));//
                        pstmt.setString(3,rss.getString("creation_date"));//
                        pstmt.setString(4,rss.getString("is_active"));//
                        pstmt.setString(5,rss.getString("link_user_group"));//
                        pstmt.setString(6,rss.getString("name"));//
                        pstmt.setString(7,rss.getString("notificationurl"));//
                        pstmt.setString(8,rss.getString("open_id"));//
                        pstmt.setString(9,rss.getString("secret"));//
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 47){
                sql1="SELECT * FROM users_app order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("third_party_login 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO third_party_login (`id`, `creation_date`, `third_party_login_app_name`, `third_party_login_app_token`, `user_id`) VALUES (?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("create_time"));//
                        pstmt.setString(3,rss.getString("app"));//
                        pstmt.setString(4,rss.getString("app_id"));//
                        pstmt.setString(5,rss.getString("user_id"));//
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 48){
                sql1="SELECT * FROM orders_gps_info order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("track 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO track (`id`, `creation_date`, `google_path_planning`, `ride_id`, `track_data`) VALUES (?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("add_time"));//
                        pstmt.setString(3,rss.getString("google_gps_track"));//
                        pstmt.setString(4,rss.getString("orders_id"));//
                        pstmt.setString(5,rss.getString("gps_str"));//
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize ==49){
                sql1="SELECT * FROM user_bill order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("user_bill 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO user_bill (`id`, `amount`, `bill_type`, `creation_date`, `reference_table_id`, `user_id`) VALUES (?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("fee"));//
                        pstmt.setString(3,rss.getString("dict_type"));//
                        pstmt.setString(4,rss.getString("add_time"));//
                        pstmt.setString(5,rss.getString("table_id"));//
                        pstmt.setString(6,rss.getString("user_id"));//
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 50){
                sql1="SELECT * FROM user_pass order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("user_pass 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO user_pass (`id`, `activation_method`, `created_by`, `day_limit`, `description_de`, `description_en`, `description_fr`, `description_nl`, `description_zh`, `duration`, `image`, `message_template_id`, `name`, `order_index`, `price`, `ride_limit`, `show_on_app`, `update_time`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("activation_method"));
                        pstmt.setString(3,rss.getString("manager"));
                        pstmt.setString(4,rss.getString("day_limit"));
                        pstmt.setString(5,rss.getString("description_de"));
                        pstmt.setString(6,rss.getString("description_en"));
                        pstmt.setString(7,rss.getString("description_fr"));
                        pstmt.setString(8,rss.getString("description_nl"));
                        pstmt.setString(9,rss.getString("description_zh"));
                        pstmt.setString(10,rss.getString("duration"));
                        pstmt.setString(11,rss.getString("image"));
                        pstmt.setString(12,rss.getString("message_template_id"));
                        pstmt.setString(13,rss.getString("name"));
                        pstmt.setString(14,rss.getString("order_index"));
                        pstmt.setString(15,rss.getString("price"));
                        pstmt.setString(16,rss.getString("ride_limit"));
                        pstmt.setString(17,rss.getString("show_on_app"));
                        pstmt.setString(18,rss.getString("update_time"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 51){
                sql1="SELECT * FROM user_pass_detail order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("user_pass_detail 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO user_pass_detail (`id`, `end_time`, `purchasing_time`, `used_time`, `user_id`, `user_pass_id`) VALUES (?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("failure_time"));
                        pstmt.setString(3,rss.getString("buy_time"));
                        pstmt.setString(4,rss.getString("use_time"));
                        pstmt.setString(5,rss.getString("user_id"));
                        pstmt.setString(6,rss.getString("user_pass_id"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize ==52){
                sql1="SELECT * FROM user_rating order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("user_rating 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO user_rating (`id`, `created_by`, `discount`, `end_credits`, `last_modified_time`, `name`, `rating`, `start_credits`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("manager_id"));//
                        pstmt.setString(3,rss.getString("discount"));//
                        pstmt.setString(4,rss.getString("end_credits"));//
                        pstmt.setString(5,rss.getString("update_time"));//
                        pstmt.setString(6,rss.getString("name"));//
                        pstmt.setString(7,rss.getString("rating"));//
                        pstmt.setString(8,rss.getString("start_credits"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 53){
                sql1="SELECT * FROM user_share_code order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("user_share_code 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO user_share_code (`id`, `code`, `creation_date`, `user_id`) VALUES (?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("code"));//
                        pstmt.setString(3,rss.getString("add_time"));//
                        pstmt.setString(4,rss.getString("user_id"));//

                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 54){
                sql1="SELECT * FROM users order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("user 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO `user` (`id`, `address`, `api_consumer_id`, `app_version`, `birthday`, `building`, `city`, `coin`, `country`, `creation_date`, `credits`, `email`, `family_name`, `fire_base_token`, `given_name`, `group_ids`, `is_deleted`, `is_disabled`, `is_sub`, `language`, `last_login`, `last_modified_time`, `modify_count`, `name`, `phone_number`, `phone_operation_system`, `photo`, `postal_code`, `sex`, `street`, `sub_market_message`, `total_calories`, `total_carbon`, `total_distance`, `total_duration`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("address"));//
                        pstmt.setString(3,rss.getString("company_id"));//
                        pstmt.setString(4,rss.getString("app_version"));//
                        pstmt.setString(5,rss.getString("birthday"));//
                        pstmt.setString(6,rss.getString("building"));//
                        pstmt.setString(7,rss.getString("city"));//
                        pstmt.setString(8,rss.getString("coin"));//
                        pstmt.setString(9,rss.getString("country"));//
                        pstmt.setString(10,rss.getString("add_time"));//
                        pstmt.setString(11,rss.getString("credits"));//
                        pstmt.setString(12,rss.getString("email"));//
                        pstmt.setString(13,rss.getString("name"));//
                        pstmt.setString(14,rss.getString("fire_base_token"));//
                        pstmt.setString(15,rss.getString("first_name"));//
                        pstmt.setString(16,rss.getString("group_by"));//
                        pstmt.setString(17,rss.getString("is_delete"));//
                        pstmt.setString(18,rss.getString("is_disabled"));//
                        pstmt.setString(19,rss.getString("is_sub"));//
                        pstmt.setString(20,rss.getString("language"));//
                        pstmt.setString(21,rss.getString("last_login"));//
                        pstmt.setString(22,rss.getString("last_update_time"));//
                        pstmt.setString(23,rss.getString("modify_count"));//
                        String gdpr = "GDPR";
                        if (gdpr.equals(rss.getString("name"))){
                            pstmt.setString(24,"GDPR");
                        }else {
                            pstmt.setString(24,rss.getString("first_name")+","+rss.getString("name"));
                        }
                        pstmt.setString(25,rss.getString("phone"));//
                        pstmt.setString(26,rss.getString("phone_os"));//
                        pstmt.setString(27,rss.getString("photo"));//
                        pstmt.setString(28,rss.getString("postal_code"));//
                        pstmt.setString(29,rss.getString("sex"));//
                        pstmt.setString(30,rss.getString("street"));//
                        pstmt.setString(31,rss.getString("sub_market_message"));//
                        pstmt.setString(32,rss.getString("total_calories"));//
                        pstmt.setString(33,rss.getString("total_carbon"));//
                        pstmt.setString(34,rss.getString("total_distance"));//
                        pstmt.setString(35,rss.getString("total_duration"));
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 55){
                sql1="SELECT * FROM wallet order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("wallet 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO wallet (`id`, `balance`, `deposit`, `updated_time`, `user_id`) VALUES (?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("balance"));//
                        pstmt.setString(3,rss.getString("deposit"));//
                        pstmt.setString(4,rss.getString("last_edit_time"));//
                        pstmt.setString(5,rss.getString("user_id"));//

                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 56){
                sql1="SELECT * FROM object_type order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("bptype 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO `bptype` (`id`, `name`) VALUES (?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("name"));//

                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (dateSize == 57){
                sql1="SELECT * FROM dict_info order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("generic_object_type 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO generic_object_type (`id`, `is_default`, `name`, `object_key`, `object_type`, `object_value`) VALUES (?, ?, ?, ?, ?, ?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("id"));
                        pstmt.setString(2,rss.getString("is_default"));//
                        pstmt.setString(3,rss.getString("name"));//
                        pstmt.setString(4,rss.getString("key_str"));//
                        pstmt.setString(5,rss.getString("group_str"));//
                        pstmt.setString(6,rss.getString("value_str"));//

                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            if (dateSize == 58){
                sql1="SELECT * FROM group_account_main order by id limit "+startNum+","+pageSize+";";
                rss=stas.executeQuery(sql1);
                System.out.println("group_account_main 表添加数据");
                while(rss.next()){
                    String sql = "INSERT INTO group_account_main (`dtime`, `manager_id`, `quantity`, `user_id`) VALUES (?,?,?,?)";
                    try {
                        pstmt = (PreparedStatement) con.prepareStatement(sql);
                        pstmt.setString(1,rss.getString("dtime"));
                        pstmt.setString(2,rss.getString("manager_id"));//
                        pstmt.setString(3,rss.getString("quantity"));//
                        pstmt.setString(4,rss.getString("user_id"));//
                        int i =pstmt.executeUpdate();
                        System.out.println(pstmt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }







        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rss.close();
            stas.close();
            sta.close();
         //   con.close();
         //   cons.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void run() {
        try {
            insert(startNum,pageSize,dateSize);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
