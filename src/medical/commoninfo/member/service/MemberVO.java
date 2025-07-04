package medical.commoninfo.member.service;

import java.util.List;

import medical.framework.vo.KoriginCommonVO;

public class MemberVO extends KoriginCommonVO {
	private static final long serialVersionUID = 1L;
	private String idx;
	private String rndId;
	private String userId;
	private String userPwd;
	private String userNm;
	private String userAuth;
	private String userAuthNm;
	private String userInstCd;
	private String userInstCdNm;
	private String deptNm;
	private String grdNm;
	private String phoneNum;
	private String email;
	private String useYn;
	private String remarks;
	private String rndNm;
	private String instTargetCd;
	private String createDate;
	private String updateDate;
	private String menuId;
	private String menuNm;
	private String insertYn;
	private String selectYn;
	private String modifyYn;
	private String deleteYn;
	private String uploadYn;
	private String downYn;
	private List<String> userAuthList;
	
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getRndId() {
		return rndId;
	}
	public void setRndId(String rndId) {
		this.rndId = rndId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}
	public String getUserAuthNm() {
		return userAuthNm;
	}
	public void setUserAuthNm(String userAuthNm) {
		this.userAuthNm = userAuthNm;
	}
	public String getUserInstCd() {
		return userInstCd;
	}
	public void setUserInstCd(String userInstCd) {
		this.userInstCd = userInstCd;
	}
	public String getUserInstCdNm() {
		return userInstCdNm;
	}
	public void setUserInstCdNm(String userInstCdNm) {
		this.userInstCdNm = userInstCdNm;
	}
	public String getDeptNm() {
		return deptNm;
	}
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	public String getGrdNm() {
		return grdNm;
	}
	public void setGrdNm(String grdNm) {
		this.grdNm = grdNm;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRndNm() {
		return rndNm;
	}
	public void setRndNm(String rndNm) {
		this.rndNm = rndNm;
	}
	public String getInstTargetCd() {
		return instTargetCd;
	}
	public void setInstTargetCd(String instTargetCd) {
		this.instTargetCd = instTargetCd;
	}
	public List<String> getUserAuthList() {
		return userAuthList;
	}
	public void setUserAuthList(List<String> userAuthList) {
		this.userAuthList = userAuthList;
	}
	
}
