package medical.commoninfo.menu.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.commoninfo.menu.service.MenuVO;

@Repository("MenuDAO")
public class MenuDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<MenuVO> selectMenuList(MenuVO menuVO){
		return sqlSession.selectList("Menu.selectMenuList",menuVO);
	}
}
