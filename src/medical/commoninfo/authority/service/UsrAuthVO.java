package medical.commoninfo.authority.service;

import java.util.ArrayList;
import java.util.List;

import medical.framework.vo.KoriginCommonVO;

public class UsrAuthVO extends KoriginCommonVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1756239511165005595L;
	private String menuId;
	private String menuNm;
	private String userId;
	private String insertYn;
	private String selectYn;
	private String modifyYn;
	private String deleteYn;
	private String uploadYn;
	private String downYn;
	private List<UsrAuthVO> usrAuthList = new ArrayList<UsrAuthVO>();
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInsertYn() {
		return insertYn;
	}
	public void setInsertYn(String insertYn) {
		this.insertYn = insertYn;
	}
	public String getSelectYn() {
		return selectYn;
	}
	public void setSelectYn(String selectYn) {
		this.selectYn = selectYn;
	}
	public String getModifyYn() {
		return modifyYn;
	}
	public void setModifyYn(String modifyYn) {
		this.modifyYn = modifyYn;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	public String getUploadYn() {
		return uploadYn;
	}
	public void setUploadYn(String uploadYn) {
		this.uploadYn = uploadYn;
	}
	public String getDownYn() {
		return downYn;
	}
	public void setDownYn(String downYn) {
		this.downYn = downYn;
	}
	public List<UsrAuthVO> getUsrAuthList() {
		return usrAuthList;
	}
	public void setUsrAuthList(List<UsrAuthVO> usrAuthList) {
		this.usrAuthList = usrAuthList;
	} 
	
	
	
	
}
