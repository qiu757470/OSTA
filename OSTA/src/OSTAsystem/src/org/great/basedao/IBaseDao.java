package org.great.basedao;

import java.util.List;

public interface IBaseDao {
	//��ѯ�����������
		public abstract List<?> selectAll();
		//ͨ��IDɾ����ID����Ӧ��Ԫ��
		public abstract boolean deleteById(int id);//ɾ������
		public abstract boolean insertByBean(Object bean);//��������
		public abstract boolean updataByBean(Object bean);//��������
}
