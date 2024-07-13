package kr.co.sist.aak.module.instructor.notice.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.aak.domain.instructor.NoticeDomain;
import kr.co.sist.aak.domain.instructor.vo.NoticeVO;
import kr.co.sist.aak.module.instructor.notice.service.NoticeService;

@Controller
@RequestMapping("/instructor")
public class NoticeController {
	
	@Autowired(required = false)
	private NoticeService ns;
	
	@GetMapping("/notice.do")
	public String notice(Model model) {
		
		
		
		List<NoticeDomain> list=ns.searchList();
		model.addAttribute("noticelist",list);
				
		return "/instructor/notice/notice";
		
	}
	
	@GetMapping("/notice_detail.do")
    public String searchDetailNotice(Model model, @RequestParam("noti_no") String noti_No) {
        NoticeDomain nDomain = ns.searchdetail(noti_No);
        model.addAttribute("nDomain", nDomain);
        return "/instructor/notice/notice_detail";
    }
	
	@GetMapping("/notice_write.do")
    public String notice_WriteFrm(String noti_no,Model model) {
		noti_no = ns.searchMaxNoticeVal();
		model.addAttribute("noti_no",noti_no);
        return "/instructor/notice/notice_write";
    }

	@PostMapping("/notice_write_pr.do")
	public String notice_Write(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		String noti_no = request.getParameter("noti_no");
		String SUB_CODE = request.getParameter("SUB_CODE");
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    String INST_ID = request.getParameter("INST_ID");
	    
	    System.out.println("Received Parameters:"); 
	    System.out.println("noti_no: " + noti_no);
	    System.out.println("SUB_CODE: " + SUB_CODE);
	    System.out.println("title: " + title);
	    System.out.println("content: " + content);
	    System.out.println("inst_id: " + INST_ID);


	    NoticeVO nVO = new NoticeVO();
	    nVO.setNOTI_NO(noti_no);
	    nVO.setTitle(title);
	    nVO.setContent(content);
	    nVO.setStatus("Y");
	    nVO.setSUB_CODE(SUB_CODE);
	    nVO.setINST_ID(INST_ID);
	    

	    try {
	        int cnt = ns.insertNotice(nVO);
	        if (cnt == 1) {
	            model.addAttribute("cnt", cnt);
	            
	        } else {
	          
	        }
	    } catch (Exception e) {
	        model.addAttribute("error", "An error occurred: " + e.getMessage());
	    }

	    return "/instructor/notice/notice_write_result";
	}
	
	@RequestMapping(value = "/notice_update.do", method = RequestMethod.POST)
    public String noticeUpdate(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");

        String noti_no = request.getParameter("noti_no");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        NoticeVO nVO = new NoticeVO();
        nVO.setNOTI_NO(noti_no);
        nVO.setTitle(title);
        nVO.setContent(content);

        int cnt = ns.modifyNotice(nVO);
        model.addAttribute("cnt", cnt);
        model.addAttribute("noti_no", noti_no);

        return "/instructor/notice/notice_update_result";
    }
	
}