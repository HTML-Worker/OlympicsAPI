package com.school.util;

import net.sf.json.JSONObject;


/**
 * ���ݿ����ϳ���
 * @author Long
 *
 */
public class buildSqlString {
	
	/**
	 * ��������¼���list��ʽ����ƴװsql����
	 * @param json
	 * @return
	 */
	public String buildCheckLand(JSONObject json) {
		String str = "username=" + "'" + json.getString("username") + "'" + " and " + "password=" + "'" + json.getString("password") + "'";
		//System.out.println(str);
		return str;
	}
}
