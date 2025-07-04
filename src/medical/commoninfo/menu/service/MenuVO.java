package medical.commoninfo.menu.service;

import java.util.List;

import medical.framework.vo.KoriginCommonVO;

public class MenuVO extends KoriginCommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6250086192223097203L;
	private String menuId;
	private String parentMenuId;
	private String menuNm;
	private String menuDesc;
	private String disClassDtl;
	private String imageUrl;
	private String linkUrl;
	private int menuLevel;
	private int sortNo;
	private String usingYn;
	private String tableNm;
	private String mainFields;
	private List<MenuVO> menuList;
	
	
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	public String getDisClassDtl() {
		return disClassDtl;
	}
	public void setDisClassDtl(String disClassDtl) {
		this.disClassDtl = disClassDtl;
	}
	public String getMenuDesc() {
		return menuDesc;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public int getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}
	public int getSortNo() {
		return sortNo;
	}
	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}
	public String getUsingYn() {
		return usingYn;
	}
	public void setUsingYn(String usingYn) {
		this.usingYn = usingYn;
	}
	public String getTableNm() {
		return tableNm;
	}
	public void setTableNm(String tableNm) {
		this.tableNm = tableNm;
	}
	public String getMainFields() {
		return mainFields;
	}
	public void setMainFields(String mainFields) {
		this.mainFields = mainFields;
	}
	public List<MenuVO> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<MenuVO> menuList) {
		this.menuList = menuList;
	}
	
	
}