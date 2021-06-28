package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

public class ReplyActionCommand implements BbsCommandImpl{

	@Override
	public void execute(Model model) { 
		
		//요청 일괄적으로 받아오기
		Map<String, Object> paramMap = model.asMap();
		HttpServletRequest req = (HttpServletRequest)paramMap.get("req");
		
		SpringBbsDTO dto = (SpringBbsDTO)paramMap.get("springBbsDTO");
		
		JDBCTemplateDAO dao = new JDBCTemplateDAO();
		
		dao.reply(dto); 
		//dao.close();
	}
	
}
