package springboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.JdbcTemplateConst;
import springboard.command.BbsCommandImpl;
import springboard.command.ListCommand;

/*
기본패키지로 설정한 곳에 컨트롤러를 선언하면 요청이
들어왔을때 Auto Scan된다.
 */
@Controller
public class BbsController {
	
	
	/*
	@Autowired
		: 스프링 설정파일에서 이미 생성된 빈을 자동으로 주입받고
		싶을때 사용한다. 타입을 기반으로 자동주입되며, 만약 해당 타입의
		빈이 존재하지 않으면 에러가 발생되어 서버를 시작할 수 없다.
		- 생성자, 멤버변수, 메소드(setter)에 적용가능
		- 타입을 이용해 자동으로 프로퍼티 값을 설정
		- 해당 어노테이션은 멤버변수에만 적용 가능. 함수 내 지역변수에서는 사용불가
		- 타입을 통해 자동으로 설정되므로 같은타입이 2개이상 존재하면 예외발생
	 */
	private JdbcTemplate template; 
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		System.out.println("@Autowired -> JDBCTemplate 연결성공");
		//JdbcTemplate을 해당 프로그램 전체에서 사용하기 위한 설정 (static타입)
		JdbcTemplateConst.template = this.template;
	}
	
	/*
	멤버변수로 선언하여 클래스에서 전역적으로 사용할 수 있다. 해당
	클래스의 모든 command객체는 해당 인터페이스를 구현하여 정의한다.
	 */
	BbsCommandImpl command = null;
	
	//게시판 리스트
	@RequestMapping("/board/list.do")
	public String list(Model model, HttpServletRequest req) {
		
		/*
		사용자로부터 받은 모든 요청은 request객체에 저장되고, 이를
		ListCommand객체로 전달하기 위해 model에 저장한 후 매개변수로
		전달한다.
		 */
		model.addAttribute("req",req);   
	    command = new ListCommand();
	    command.execute(model);  
	      
		return "07Board/list";
	}
	
}
