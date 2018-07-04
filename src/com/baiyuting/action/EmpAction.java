package com.baiyuting.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.baiyuting.vo.Emp;

@Controller
@RequestMapping("/pages/back/emp") // 此处定义的是父路径
public class EmpAction {// 完全是一个独立的类

	@Resource
	private MessageSource messageSource;

	@RequestMapping("/test")
	public ModelAndView test() {
		System.out.println(messageSource.getMessage("welcom.url", null, Locale.getDefault()));
		System.out.println(messageSource.getMessage("emp.add.page", null, Locale.getDefault()));
		System.out.println(messageSource.getMessage("emp.add.rules", null, Locale.getDefault()));
		return null;
	}

	@RequestMapping("/add")
	public ModelAndView add(Emp emp) {// 此处表示接受的参数为 emp 类型
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/forward.jsp");
		mav.addObject("msg", "天要下雨了");
		mav.addObject("myemp", emp);
		return mav;
	}

	@RequestMapping("/upload")
	public ModelAndView addUpload(Emp emp, MultipartFile photo, HttpServletRequest request) {
		System.out.println(emp);
		String fileExt = null;
		if ("image/jpeg".equals(photo.getContentType())) {
			fileExt = "jpg";
		}
		String outFilePath = request.getServletContext().getRealPath("/upload/") + UUID.randomUUID() + "." + fileExt;
		try {
			photo.transferTo(new File(outFilePath));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@ExceptionHandler
	public ModelAndView exceptionHandle(Exception e) {// 专门处理异常
		ModelAndView modelAndView = new ModelAndView("/errors.jsp");
		if (e instanceof MaxUploadSizeExceededException) {
			modelAndView.addObject("error", "文件太大了");
		}
		return modelAndView;
	}

	/**
	 * 为 int 型数字必须传参数，不传包错
	 * 
	 * HTTP Status 500 - Request processing failed; nested exception is
	 * java.lang.IllegalStateException: Optional int parameter 'empno' is
	 * present but cannot be translated into a null value due to being declared
	 * as a primitive type. Consider declaring it as object wrapper for the
	 * corresponding primitive type.
	 * 
	 * @param empno
	 * @return
	 */
	@RequestMapping("/empEdit")
	public ModelAndView edit(int empno) {
		System.out.println("empno=" + empno);
		return null;
	}

	/**
	 * 为引用类型的时候 empno 可以不传，此时默认为 null
	 * 
	 * @param empno
	 * @return
	 */
	@RequestMapping("/empEdit2")
	public ModelAndView edit2(Integer empno) {
		System.out.println("empno=" + empno);
		return null;
	}

	@RequestMapping("/empEdit3")
	public ModelAndView edit3(String empno) {
		System.out.println("empno=" + empno);
		return null;
	}

	/**
	 * 加上 @RequestParam 注解，默认必须要带上 empno 参数，不带返回 400
	 * 
	 * HTTP Status 400 - Required String parameter 'empno' is not present
	 * 
	 * @param empno
	 * @return
	 */
	@RequestMapping("/empEdit4")
	public ModelAndView edit4(@RequestParam String empno) {
		System.out.println("empno=" + empno);
		return null;
	}

	/**
	 * 加上 @CookieValue 注解，不带 empno 参数，返回 400
	 * 
	 * HTTP Status 400 -
	 * 
	 * @param empno
	 * @return
	 */
	@RequestMapping("/empEdit5")
	public ModelAndView edit5(@CookieValue String empno) {
		System.out.println("empno=" + empno);
		return null;
	}

	/**
	 * 添加 内置对象
	 * 
	 * @param empno
	 * @param request
	 * @return
	 */
	@RequestMapping("/empEdit6")
	public ModelAndView edit6(@RequestParam String empno, HttpServletRequest request) {
		System.out.println("empno=" + empno);
		System.out.println(request.getContextPath());
		return null;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {// 转换器
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 将自定义的转换编辑器进行配置，如果以后发现有Date类型，使用 sdf 转换并允许数据为null
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
	}

}
