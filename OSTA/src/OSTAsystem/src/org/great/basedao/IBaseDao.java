package org.great.basedao;

import java.util.List;

public interface IBaseDao {
	//查询表的所有数据
		public abstract List<?> selectAll();
		//通过ID删除该ID所对应的元组
		public abstract boolean deleteById(int id);//删除数据
		public abstract boolean insertByBean(Object bean);//插入数据
		public abstract boolean updataByBean(Object bean);//更改数据
}
