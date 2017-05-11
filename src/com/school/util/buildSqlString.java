package com.school.util;

import net.sf.json.JSONObject;


/**
 * 数据库语句合成类
 * @author Long
 *
 */
public class buildSqlString {
	
	/**
	 * 生成数据录入的list格式方便拼装sql语言
	 * @param json
	 * @return
	 */
	public String buildCheckLand(JSONObject json) {
		String str = "username=" + "'" + json.getString("username") + "'" + " and " + "password=" + "'" + json.getString("password") + "'";
		//System.out.println(str);
		return str;
	}
}
