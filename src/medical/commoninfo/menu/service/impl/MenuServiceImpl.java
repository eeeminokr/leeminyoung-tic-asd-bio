package medical.commoninfo.menu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import medical.common.service.AbstractService;
import medical.commoninfo.menu.service.MenuService;
import medical.commoninfo.menu.service.MenuVO;

@Service("MenuService")
public class MenuServiceImpl extends AbstractService implements MenuService {

	@Resource(name = "MenuDAO")
	private MenuDAO MenuDAO;

	public List<MenuVO> selectMenuList(MenuVO menuVO){
		menuVO.setMenuLevel(0);
		List<MenuVO> menuList = MenuDAO.selectMenuList(menuVO);
		return menuList;
	}
	
}
