package com.book.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class JDBCutil {
	
	private Connection conn=null;
	private PreparedStatement psmt=null;
	private ResultSet rs=null;
	private String url="jdbc:oracle:thin:@localhost:1521/orcl";
	private String username="scott";
	private String password="admin";
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConn(){
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//澧炲垹鏀�   ? ?  '7396' 'zhangsan'
	
	public void updatePreparedStatement(String sql,List params){
		getConn();
		
		try {
			psmt = conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.size();i++){
					psmt.setObject(i+1, params.get(i));
				}
			}
			
			psmt.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//鏌ヨ
	public List queryPreparedStatement(String sql,List params,Class clazz){
		
		getConn();
		
		try {
			psmt = conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.size();i++){
					psmt.setObject(i+1, params.get(i));
				}
			}
			
			rs = psmt.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			//鑾峰彇鍒楃殑鏁伴噺
			int count = rsmd.getColumnCount();
			//鑾峰彇姣忓垪鐨勫悕瀛�
			List<String> cnames = new ArrayList();//empno  ename  job
			for(int i=0;i<count;i++){
				if(rsmd.getColumnName(i+1).equals("NUM")){
					count=count-1;
				}else{
					cnames.add(rsmd.getColumnName(i+1));	
				}
				
				
			}
			
			// empno  ename  job
			List result = new ArrayList();	
			while(rs.next()){
				//鍒涘缓瀵硅薄
				Object obj = clazz.newInstance();
				
				for(int i=0;i<count;i++){
					//鑾峰彇缁撴灉闆嗕腑姣忎竴鍒楃殑鍚嶅瓧
					String name = cnames.get(i).toLowerCase();
					//鍒癱lazz涓壘鍒颁笌璇ame鍖归厤鐨勫睘鎬�
					Field f = null;
					try{
						f = clazz.getDeclaredField(name);
					}catch(Exception e){
						e.printStackTrace();
					}
					
					if(f!=null){
						f.setAccessible(true);
	
						//鍒ゆ柇璇ュ睘鎬х殑绫诲瀷
						String type = f.getType().getName();
						if(type.equals("int") || type.equals("java.lang.Integer")){
							int value = rs.getInt(name);
							//缁檕bj瀵硅薄鐨勫睘鎬ц祴鍊�
							f.set(obj, value);
						}else if(type.equals("double") || type.equals("java.lang.Double")){
							double value = rs.getDouble(name);
							f.set(obj, value);
						}else if(type.equals("java.lang.String")){
							String value = rs.getString(name);
							f.set(obj, value);
						}else if(type.equals("java.sql.Date")){
							java.sql.Date value = rs.getDate(name);
							f.set(obj, value);
						}else if(type.equals("java.util.Date")){
							java.util.Date value = rs.getDate(name);
							f.set(obj, value);
						}else if(type.equals("java.sql.Timestamp")){
							java.sql.Timestamp value = rs.getTimestamp(name);
							f.set(obj, value);
						}else if(type.equals("long") || type.equals("java.lang.Long")){
							long value = rs.getLong(name);
							f.set(obj, value);
						}
					
					}
					
				}
				
				result.add(obj);
				
			}
			
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	//鍏抽棴
	public void close(){
		
		try {
			if(psmt!=null){
				psmt.close();
			}
			if(conn!=null){
				conn.close();
			}
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}






