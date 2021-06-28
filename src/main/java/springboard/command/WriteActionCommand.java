package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

public class WriteActionCommand implements BbsCommandImpl{
	
	@Override
	public void execute(Model model) {
		
		//model에 저장된 값을 Map컬렉션으로 변환한다.
		Map<String, Object> paramMap = model.asMap();
		//request객체와 DTO객체를 가져온다.
		HttpServletRequest req =
				(HttpServletRequest)paramMap.get("req");
		SpringBbsDTO springBbsDTO = 
				(SpringBbsDTO)paramMap.get("springBbsDTO");
		
		//폼값 확인용
		System.out.println("springBbsDTO.title="+springBbsDTO.getTitle());
		
		//DAO객체 생성 후 쓰기 처리
		JDBCTemplateDAO dao = new JDBCTemplateDAO();
		dao.write(springBbsDTO);
		//dao.close();
	}

}
