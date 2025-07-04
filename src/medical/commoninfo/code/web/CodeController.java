package medical.commoninfo.code.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import medical.commoninfo.code.service.CodeService;
import medical.commoninfo.code.service.CodeVO;
import medical.commoninfo.member.service.MemberVO;
import medical.framework.util.Constant;
import medical.framework.util.JsonUtils;

@Controller
public class CodeController {
	@Resource(name = "CodeService")
	private CodeService codeService;
	
	@RequestMapping("/medical/commoninfo/code/selectCodeDetailSearchCondition.do")
	public ModelAndView selectCodeDetailSearchCondition(HttpSession session, @ModelAttribute("codeVO") CodeVO codeVO ,ModelMap model) throws Exception {
		MemberVO memberVo = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		codeVO.setDefaultLanguage(memberVo.getDefaultLanguage());
		List<CodeVO> result = codeService.selectCodeDetailSearchCondition(codeVO);
		model.put("success", true);
		model.put("result", result);
		return JsonUtils.describe(model);
	} 
}
