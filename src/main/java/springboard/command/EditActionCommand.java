package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

public class EditActionCommand implements BbsCommandImpl{
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		
		//커맨드객체를 통해 모든 폼값을 저장한 DTO를 가져온다.
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		SpringBbsDTO springBbsDTO = 
				(SpringBbsDTO)map.get("springBbsDTO");
		
		JDBCTemplateDAO dao = new JDBCTemplateDAO();
		
		/*
		String idx = req.getParameter("idx");
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		String pass = req.getParameter("pass");
		dao.edit(idx, name, title, contents, pass);
		*/
		
		dao.edit(springBbsDTO);
	}

}
