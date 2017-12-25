package org.great.daofactory;

import java.lang.reflect.InvocationTargetException;

import org.great.basedao.IBaseDao;

public class DaoFactory {
	public static IBaseDao getInstance(String ClassName){
		IBaseDao ibasedao=null;
		Class clazz;
		try {
			clazz = Class.forName(ClassName);
			try {
				ibasedao =(IBaseDao) clazz.getMethod("getInstance").invoke(null);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return ibasedao;
		
	}
}
