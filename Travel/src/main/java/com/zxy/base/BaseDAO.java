package com.zxy.base;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 在一个系统中通常情况下都是由很多张表组成的，基本每张表我们都有增删改查操作，若对每张表都编写一套增删改查的方法就会有很多重复的代码，不符合编码规范
 这里的编码规范包含了javaee三层架构：表示层（web层）、业务逻辑层（service）、数据访问层（dao层）。这里的数据访问层就是指：与数据库进行交互，实现数据维护的相关代码
 为了优化代码，通常我们会将这些功能所公用的部分封装为一个对象或者类，此类就是所有dao的基类。我们通常会将常用到的增删改查的方法封装到一个基类（BaseDao），这个类是所有Dao的基类
 但是这个类需要接收到不同的操作对象，因此我们需要用到范型
 */
//范型的目的是使得参数可以任意化，它的本质是将参数类型化
public abstract class BaseDAO<T> {
    //    public 修饰的变量可以被任何对象引用    final修饰基本数据类型，该变量就是一个常量，不可被修改
    public final String DRIVER = "com.mysql.cj.jdbc.Driver" ;
    public final String URL = "jdbc:mysql://localhost:3306/travelweb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
    public final String USER = "root";
    public final String PWD = "15205966365" ;

    //  protected 与 private一样，但是protected修饰的成员可以被它的子类访问
    protected Connection conn ;
    protected PreparedStatement psmt ;
    protected ResultSet rs ;

    //    private 关键字除了类型创建者和类型内部的方法，任何人都不可引用
    //T的Class对象
    private Class entityClass ;
    //  无参的构造方法
    public BaseDAO(){
        //getClass() 获取Class对象，当前我们执行的是new FruitDAOImpl() , 创建的是FruitDAOImpl的实例
        //那么子类构造方法内部首先会调用父类（BaseDAO）的无参构造方法
        //因此此处的getClass()会被执行，但是getClass获取的是FruitDAOImpl的Class
        //所以getGenericSuperclass()获取到的是BaseDAO的Class
        Type genericType = getClass().getGenericSuperclass();
        //ParameterizedType 参数化类型
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
        //获取到的<T>中的T的真实的类型
        Type actualType = actualTypeArguments[0];
        try {
            entityClass = Class.forName(actualType.getTypeName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //     抽取连接数据库的方法
    protected Connection getConn(){
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null ;
    }
    //      抽取释放资源的代码
    protected void close(ResultSet rs , PreparedStatement psmt , Connection conn){
        try {
            if (rs != null) {
                rs.close();
            }
            if(psmt!=null){
                psmt.close();
            }
            if(conn!=null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //给预处理命令对象设置参数：Object... params实现动态参数设置
    private void setParams(PreparedStatement psmt , Object... params) throws SQLException {
        if(params!=null && params.length>0){
            for (int i = 0; i < params.length; i++) {
                psmt.setObject(i+1,params[i]);
            }
        }
    }


    //执行更新，返回影响行数
    protected int executeUpdate(String sql , Object... params){
//        判断是否是insert操作
        try {
            conn = getConn();
//                使用原生JDBC进行数据插入，进行数据insert时会预先生成一个id主键再进行插入，并通过Statement.RETURN_GENERATED_KEYS的方式返回主键id
//                参数2：用于获取主键自动增长的值
            psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            setParams(psmt,params);
//            执行更新，返回影响行数
            int count = psmt.executeUpdate() ;
//            获取自动增长的主键值
            rs = psmt.getGeneratedKeys();
            if(rs.next()){
                return ((Long)rs.getLong(1)).intValue();
            }
            return count ;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs,psmt,conn);
        }
        return 0;
    }



    //执行查询，返回单个实体对象
    protected T load(String sql , Object... params){
        try {
            conn = getConn() ;
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs = psmt.executeQuery();

            //通过rs可以获取结果集的元数据
            //元数据：描述结果集数据的数据 , 简单讲，就是这个结果集有哪些列，什么类型等等

            ResultSetMetaData rsmd = rs.getMetaData();
            //获取结果集的列数
            int columnCount = rsmd.getColumnCount();
            //6.解析rs
            if(rs.next()){
                // 创建范型对象
                T entity = (T)entityClass.newInstance();
                // 遍历结果集
                for(int i = 0 ; i<columnCount;i++){
                    // 获取列的名
                    String columnName = rsmd.getColumnName(i+1);            //fid   fname   price
                    // 获取列的值
                    Object columnValue = rs.getObject(i+1);     //33    苹果      5
                    /**
                     将结果映射到对应的实体类上，但是在基类中我们还不知道具体的类是什么，此时就使用到了java的反射机制
                     在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；
                     这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
                     */
                    setValue(entity,columnName,columnValue);
                }
                return entity ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            close(rs,psmt,conn);
        }
        return null ;
    }

    //通过反射技术给obj对象的property属性赋propertyValue值
    private void setValue(Object obj ,  String property , Object propertyValue){
//        获取对象类型
        Class clazz = obj.getClass();
        try {
            //获取property这个字符串对应的属性名 ， 比如 "fid"  去找 obj对象中的 fid 属性
            //获取类中被对应过的属性
            Field field = clazz.getDeclaredField(property);
            if(field!=null){
                // 私有成员对外是不可访问，设置字段的访问权限：为对外可以访问
                field.setAccessible(true);
                // 给字段设置值
                field.set(obj,propertyValue);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //执行复杂查询，返回例如统计结果
    protected Object[] executeComplexQuery(String sql , Object... params){
        try {
            conn = getConn() ;
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs = psmt.executeQuery();

            //通过rs可以获取结果集的元数据
            //元数据：描述结果集数据的数据 , 简单讲，就是这个结果集有哪些列，什么类型等等

            ResultSetMetaData rsmd = rs.getMetaData();
            //获取结果集的列数
            int columnCount = rsmd.getColumnCount();
            Object[] columnValueArr = new Object[columnCount];
            //6.解析rs
            if(rs.next()){
                for(int i = 0 ; i<columnCount;i++){
                    Object columnValue = rs.getObject(i+1);     //33    苹果      5
                    columnValueArr[i]=columnValue;
                }
                return columnValueArr ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs,psmt,conn);
        }
        return null ;
    }




    //执行查询，返回List
    protected List<T> executeQuery(String sql , Object... params){
        List<T> list = new ArrayList<>();
        try {
            conn = getConn() ;
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs = psmt.executeQuery();

            //通过rs可以获取结果集的元数据
            //元数据：描述结果集数据的数据 , 简单讲，就是这个结果集有哪些列，什么类型等等

            ResultSetMetaData rsmd = rs.getMetaData();
            //获取结果集的列数
            int columnCount = rsmd.getColumnCount();
            //6.解析rs
            while(rs.next()){
                T entity = (T)entityClass.newInstance();

                for(int i = 0 ; i<columnCount;i++){
                    String columnName = rsmd.getColumnName(i+1);            //fid   fname   price
                    Object columnValue = rs.getObject(i+1);     //33    苹果      5
                    setValue(entity,columnName,columnValue);
                }
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            close(rs,psmt,conn);
        }
        return list ;
    }
}
