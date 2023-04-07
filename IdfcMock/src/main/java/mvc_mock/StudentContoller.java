package mvc_mock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mvc_mock.StudentDto;
import mvc_mock.StudentDao;


@Controller
public class StudentContoller {
@Autowired
StudentDto studto;
@Autowired
StudentDao studao;
@RequestMapping("/signup")
public ModelAndView create(){
	ModelAndView andView=new ModelAndView("insert.jsp");
	andView.addObject("studetails", studto);
	return andView;
}
@ResponseBody
@RequestMapping("/save")
public String saveData(StudentDto stu){
	studao.insert(stu);
	return "saved data successfully";
}

@ResponseBody
@RequestMapping("/fetchjs")
public ModelAndView fetch2(String id){ 
	StudentDto dto=studao.fetch(id);
	ModelAndView m2=new ModelAndView("display.jsp");
	m2.addObject("key", dto);
	System.out.println(dto);
	return m2;
}
@RequestMapping("/all")
public ModelAndView fetchall(){
	List<StudentDto> details=studao.fetchAll();
	ModelAndView MV3=new ModelAndView("fetchall.jsp");
	MV3.addObject("key",details);
	 return MV3;
	}
}
