package com.gongy.dao;


import com.gongy.Item;
import com.gongy.dao.model.TbGysinfo;
import com.gongy.dao.model.TbKhinfo;
import com.gongy.dao.model.TbKucun;
import com.gongy.dao.model.TbSpinfo;
import com.sun.javafx.collections.ListListenerHelper;

import java.awt.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Dao {

    protected static String dbClassName = "com.mysql.jdbc.Driver";  // MySQL 数据库驱动类的名称
    protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/db_database28";    // 访问 MySQL 数据库的路径
    protected static String dbUser = "root";        // 访问数据库用户名
    protected static String dbPwd = "";             // 访问数据库密码
    protected static String dbName = "db_database28";   // 访问数据库中的实例
    protected static String second = null;
    public static Connection conn = null;      // MySQL 数据库的连接对象

    // 在静态代码断种初始化 Dao 类，实现数据库驱动和连接
    static {
        try {
            if (conn == null) {
                Class.forName(dbClassName).newInstance();
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 封闭构造方法，禁止创建 Dao 类的实例对象
    private Dao() {
    }

    // 验证登录
    public static boolean checkLogin(String userStr, String passStr) throws SQLException {
        ResultSet rs = findForResultSet("select * from tb_userlist where name='" + userStr + "' and pass='" + passStr + "'");
        if (rs == null) {
            return false;
        }
        return rs.next();
    }

    // 向数据库发送 SQL 语句
    public static ResultSet findForResultSet(String sql) {
        if (conn == null) {
            return null;
        }
        long time = System.currentTimeMillis();
        ResultSet rs = null;
        try {
            Statement st = null;
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            second = ((System.currentTimeMillis() - time) / 1000d) + "";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // 数据库备份
    public static String backup() throws SQLException {
        LinkedList<String> sqls = new LinkedList<String>();     // 备份文件中所有的 sql
        // 涉及的相关表名数组
        String tables[] = {"tb_gysinfo", "tb_jsr", "tb_khinfo", "tb_kucun",
                "tb_rkth_detail", "tb_rkth_main", "tb_ruku_detail",
                "rb_ruku_main", "tb_sell_datail", "tb_sell_main", "tb_spinfo",
                "tb_userlist", "tb_xsth_detail", "tb_xsth_main"};
        ArrayList<Tables> tableList = new ArrayList<Tables>();        // 创建保存所有表对象的集合
        // 遍历表名称数组
        for (int i = 0; i < tables.length; i++) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("desc" + tables[i]);   // 查询表结构
            ArrayList<Columns> columns = new ArrayList<>();             // 列集合
            while (rs.next()) {
                Columns c = new Columns();                      // 创建列对象
                c.setName(rs.getString("Field"));   // 读取列名
                c.setType(rs.getString("Type"));    // 读取咧类型
                String isnull = rs.getString("null");   // 读取为空类型
                if ("YES".equals(isnull)) {     // 如果列可以为空
                    c.setNull(true);
                }
                String key = rs.getString("key");   // 读取主键类型
                if ("PRI".equals(key)) {        // 如果是主键
                    c.setKey(true);
                    String increment = rs.getString("Extra");   // 读取特殊属性
                    if ("auto_increment".equals(increment)) {               // 表主键是否自增
                        c.setIncerment(true);
                    }
                }
                columns.add(c);     // 列集合添加此列
            }
            Tables table = new Tables(tables[i], columns);      // 创建表示此表名和拥有对应列对象的表对象
            tableList.add(table);       // 表集合保存此表对象
            rs.close();                 // 关闭结果集
            stmt.close();               // 关闭 SQL 语句接口
        }

        // 遍历表对象集合
        for (int i = 0; i < tableList.size(); i++) {
            Tables table = tableList.get(i);        // 获取表格对象

            String dorpsql = "DROP TABLE IF EXISTS" + table.getName() + ";";   // 删除表 SQL 语句
            sqls.add(dorpsql);      // 添加删除表的 SQL

            StringBuilder createsql = new StringBuilder();
            createsql.append("CREATE TABLE " + table.getName() + "(");
            ArrayList<Columns> columns = table.getColumns();
            for (int j = 0; j < columns.size(); j++) {
                Columns c = columns.get(j);
                createsql.append(c.getName() + " " + c.getType());
                if (!c.isNull()) {                          // 是否为空
                    createsql.append(" not null ");
                }
                if (c.isKey()) {                            // 是否为主键
                    createsql.append(" primary key ");
                    if (c.isIncerment()) {                  // 是否自增
                        createsql.append(" AUTO_INCREMENT");
                    }
                }
                if (j < columns.size() - 1) {               // 是否为最后一行
                    createsql.append(",");
                } else {
                    createsql.append(");");                 // 添加结束语句
                }
            }
            sqls.add(columns.toString());

            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM " + table.getName());
            while (rs.next()) {
                StringBuilder instersql = new StringBuilder();
                instersql.append("INSERT INTO " + table.getName() + " VALUES(");

                for (int k = 0; k < columns.size(); k++) {
                    Columns c = columns.get(k);
                    String type = c.getType();
                    if (type.startsWith("varchar") || type.startsWith("char") || type.startsWith("datetime")) {
                        instersql.append("'" + rs.getString(c.getName()) + "'");
                    } else {
                        instersql.append(rs.getString(c.getName()));
                    }
                    if (k < columns.size() - 1) {
                        instersql.append(",");
                    } else {
                        instersql.append(");");
                    }
                }
                sqls.add(instersql.toString());
            }
            rs.close();         // 关闭结果集
            stat.close();       // 关闭 sql 接口
        }
        sqls.add("DROP VIEW IF EXISTS v_rukuView");
        sqls.add("CREATE VIEW v_rukuView AS SELECT tb_ruku_main.rkID, tb_ruku_detail.spid, tb_spinfo.spname, tb_spinfo.gg, tb_ruku_detail.dj, tb_ruku_detail.sl,tb_ruku_detail.dj * tb_ruku_detail.sl AS je, tb_spinfo.gysname, tb_ruku_main.rkdate, tb_ruku_main.czy, tb_ruku_main.jsr,tb_ruku_main.jsfs FROM tb_ruku_detail INNER JOIN tb_ruku_main ON tb_ruku_detail.rkID = tb_ruku_main.rkID INNER JOIN tb_spinfo ON tb_ruku_detail.spid = tb_spinfo.id;");
        sqls.add("DROP VIEW IF EXISTS v_sellView");
        sqls.add("CREATE VIEW v_sellView AS SELECT tb_sell_main.sellID, tb_spinfo.spname, tb_sell_detail.spid, tb_spinfo.gg, tb_sell_detail.dj, tb_sell_detail.sl,tb_sell_detail.sl * tb_sell_detail.dj AS je, tb_sell_main.khname, tb_sell_main.xsdate, tb_sell_main.czy, tb_sell_main.jsr,tb_sell_main.jsfs FROM tb_sell_detail INNER JOIN tb_sell_main ON tb_sell_detail.sellID = tb_sell_main.sellID INNER JOIN tb_spinfo ON tb_sell_detail.spid = tb_spinfo.id;");

        Date date = new Date();     // 通过 date 对象获得当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");     // 设置当前时间输出格式
        String backupTime = sdf.format(date);
        String filePath = "backup\\" + backupTime + ".sql";

        File sqlFile = new File(filePath);
        FileOutputStream fos = null;        // 文件字节输出流
        OutputStreamWriter osw = null;      // 字节转为字符流
        BufferedWriter rw = null;           // 缓冲字符流

        try {
            fos = new FileOutputStream(sqlFile);
            osw = new OutputStreamWriter(fos);
            rw = new BufferedWriter(osw);
            for (String tmp : sqls) {
                rw.write(tmp);
                rw.newLine();
                rw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 依次关闭所有流
            if (rw != null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return filePath;
    }

    // 数据库恢复
    public static void restore(String filePath) {
        File sqlFile = new File(filePath);      // 创建备份文件对象
        Statement stat = null;                  // sql 语句直接接口
        FileInputStream fis = null;             // 文件输入字节流
        InputStreamReader isr = null;           // 字节流转字符流
        BufferedReader br = null;               // 缓存输入字符流

        try {
            fis = new FileInputStream(sqlFile);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String readStr = null;
            while ((readStr = br.readLine()) != null) {
                if (!"".equals(readStr.trim())) {
                    stat = conn.createStatement();
                    int cont = stat.executeUpdate(readStr);
                    stat.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 读取所有客户信息
    public static List getKhInfos() {
        List list = findforList("select id, khname from tb_khinfo");
        return list;
    }

    // 读取所有供应商信息
    public static List getGysInfos() {
        List list = findforList("select id, name from tb_gysinfo");
        return list;
    }

    // 读取客户信息
    public static TbKhinfo getKhyInfo(Item item){
        String where = "khname='" + item.getName() + "'";
        if (item.getId() != null) {
            where = "id='" + item.getId() + "'";
        }
        TbKhinfo info = new TbKhinfo();
        ResultSet set = findForResultSet("select * from tb_khinfo where " + where);
        try {
            if (set.next()) {
                info.setId(set.getString("id").trim());
                info.setKhname(set.getString("kuname").trim());
                info.setJian(set.getString("jian").trim());
                info.setAddress(set.getString("address").trim());
                info.setPostcode(set.getString("postcode").trim());
                info.setPhone(set.getString("phone").trim());
                info.setFax(set.getString("fax").trim());
                info.setLian(set.getString("lian").trim());
                info.setTel(set.getString("tel").trim());
                info.setMail(set.getString("mail").trim());
                info.setBank(set.getString("bank").trim());
                info.setNum(set.getString("num").trim());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }

    // 读取指定供应商信息
    public static TbGysinfo getGysInfo(Item item) {
        String where = "name'" + item.getName() + "'";
        if (item.getId() != null) {
            where = "id='" + item.getId() + "'";
        }
        TbGysinfo info = new TbGysinfo();
        ResultSet set = findForResultSet("select * from tb_gysinfo where " + where);
        try {
            if (set.next()) {
                info.setId(set.getString("id").trim());
                info.setName(set.getString("name").trim());
                info.setJc(set.getString("jc").trim());
                info.setAddress(set.getString("address").trim());
                info.setCode(set.getString("code").trim());
                info.setTel(set.getString("tel").trim());
                info.setFax(set.getString("fax").trim());
                info.setLinkman(set.getString("linkman").trim());
                info.setPhone(set.getString("phone").trim());
                info.setBank(set.getString("bank").trim());
                info.setMail(set.getString("mail").trim());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }

    // 读取经手人

    // 执行指定查询
    public static ResultSet query(String QueryStr) {
        ResultSet set = findForResultSet(QueryStr);
        return set;
    }

    // 执行删除
    public static int delete(String sql) {
        return update(sql);
    }

    // 添加客户信息的方法
    public static boolean addKuhu(TbKhinfo khinfo) {
        if (khinfo != null) {
            return insert("insert tb_khinfo valuse('" + khinfo.getId() + "','"
                            + khinfo.getKhname() + "','" + khinfo.getJian() + "','"
                            + khinfo.getAddress() + "','" + khinfo.getPostcode() + "','"
                            + khinfo.getPhone() + "','" + khinfo.getFax() + "','"
                            + khinfo.getLian() + "','" + khinfo.getTel() + "','"
                            + khinfo.getMail() + "','" + khinfo.getBank() + "','"
                            + khinfo.getNum() + "')");
        }
        return false;
    }

    // 修改客户信息的方法
    public static int uodateKeHu(TbKhinfo khinfo) {
        return update("update tb_khinfo set jian='" + khinfo.getLian()
                        + "',address='" + khinfo.getAddress() + "',postcode='"
                        + khinfo.getPostcode() + "',phone='" + khinfo.getPhone()
                        + "',fax='" + khinfo.getFax() + "',lian='" + khinfo.getLian()
                        + "',tel='" + khinfo.getTel() + "',mail='" + khinfo.getMail()
                        + "',bank='" + khinfo.getBank() + "',num='" + khinfo.getNum()
                        + "' where id='" + khinfo.getId() + "'");
    }

    // 修改库存的方法
    public static int upDateKucunPrice(TbKucun kucun) {
        return update("update tb_kucun price=" + kucun.getPrice()
                        + " where id='" + kucun.getId() + "'");
    }

    // 修改供应商信息的方法
    public static int updateGys(TbGysinfo gysinfo) {
        return update("update tb_gysinfo set jc='" + gysinfo.getJc() + "',address='"
                        + gysinfo.getAddress() + "',code='" + gysinfo.getCode() + "', tel='"
                        + gysinfo.getTel() + "',fax='" + gysinfo.getFax() + "',linkman='"
                        + gysinfo.getLinkman() + "',phone='" + gysinfo.getPhone() + "',bank='"
                        + gysinfo.getBank() + "',mail='" + gysinfo.getMail() + "' where id='"
                        + gysinfo.getId() + "'");
    }

    // 添加供应商信息的方法
    public static boolean addGys(TbGysinfo gysinfo) {
        if (gysinfo != null) {
            return insert("insert tb_Gysinfo values ('" + gysinfo.getId() + "','"
                            + gysinfo.getName() + "','" + gysinfo.getJc() + "','"
                            + gysinfo.getAddress() + "','" + gysinfo.getCode() + "','"
                            + gysinfo.getTel() + "','" + gysinfo.getFax() + "','"
                            + gysinfo.getLinkman() + "','" + gysinfo.getPhone() + "','"
                            + gysinfo.getBank() + "','" + gysinfo.getMail() + "')");
        }
        return false;
    }

    // 添加商品方法
    public static boolean addSp(TbSpinfo spinfo) {
        if (spinfo != null) {
            return insert("insert tb_spinfo valuse ('" + spinfo.getId() + "','"
                            + spinfo.getSpname() + "','" + spinfo.getJc() + "','"
                            + spinfo.getCd() + "','" + spinfo.getDw() + "','"
                            + spinfo.getGg() + "','" + spinfo.getBz() + "','"
                            + spinfo.getPh() + "','" + spinfo.getPzwh() + "','"
                            + spinfo.getMemo() + "','" + spinfo.getGysname() + "')");
        }
        return false;
    }

    // 更新商品方法
    public static int updateSp(TbSpinfo spinfo) {
        return update("update tb_Spinfo set jc='" + spinfo.getJc() + "',cd='"
                        + spinfo.getCd() + "',dw='" + spinfo.getDw() + "',gg='"
                        + spinfo.getGg() + "',bz='" + spinfo.getBz() + "',ph='"
                        + spinfo.getPh() + "',pzwh='" + spinfo.getPzwh() + "',memo='"
                        + spinfo.getMemo() + "',gysname='" + spinfo.getGysname() + "' where id='"
                        + spinfo.getId() + "'");
    }

    // 读取商品信息
    public static TbSpinfo getSpInfo(Item item) {
        String where = "spname='" + item.getName() + "'";
        if (item.getId() != null) {
            where = "id='" + item.getId() + "'";
        }
        ResultSet rs = findForResultSet("select * from tb_Spinfo where" + where);
        TbSpinfo spinfo = new TbSpinfo();
        try {
            if (rs.next()) {
                spinfo.setId(rs.getString("id").trim());
                spinfo.setSpname(rs.getString("spname").trim());
                spinfo.setJc(rs.getString("jc").trim());
                spinfo.setCd(rs.getString("cd").trim());
                spinfo.setDw(rs.getString("dw").trim());
                spinfo.setGg(rs.getString("gg").trim());
                spinfo.setBz(rs.getString("bz").trim());
                spinfo.setPh(rs.getString("ph").trim());
                spinfo.setPzwh(rs.getString("pzwh").trim());
                spinfo.setMemo(rs.getString("memo").trim());
                spinfo.setGysname(rs.getString("gysname").trim());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spinfo;
    }

    // 获取所有商品信息
    public static List getSpInfos() {
        List list = findforList("select * from tb_spinfo");
        return list;
    }

    // 获取库存商品信息




    // 数据更新
    public static int update(String sql) {
        int result = 0;
        try {
            Statement stat = conn.createStatement();
            result = stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 添加数据
    public static boolean insert(String sql) {
        boolean result = false;
        try {
            Statement stat = conn.createStatement();
            result = stat.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static List findforList(String sql) {
        List<List> list = new ArrayList<List>();
        ResultSet rs = findForResultSet(sql);
        try {
            ResultSetMetaData mataData = rs.getMetaData();
            int colCount = mataData.getColumnCount();
            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i < colCount; i++) {
                    String str = rs.getString(i);
                    if (str != null && !str.isEmpty()) {
                        str = str.trim();
                    }
                    row.add(str);
                }
                list.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
