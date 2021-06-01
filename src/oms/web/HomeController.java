/**
 * 
 */
package oms.web;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import oms.db.AlbumRepository;
import oms.db.SingerRepository;
import oms.db.SongRepository;
import oms.db.SongTypeRepository;
import oms.db.UserRepository;
import oms.domain.Album;
import oms.domain.Singer;
import oms.domain.Song;
import oms.domain.SongType;
import oms.domain.User;

/**
 * 系统的主页控制类
 * 
 * @author nwx
 *
 */
@Controller // 控制定义
@RequestMapping("/") // 相对web路径
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SongTypeRepository songtypeRepository;
	@Autowired
	private SongRepository songRepository;
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private SingerRepository singerRepository;


    /**
     * 主页面
     * @param model
     * @return
     */
	@RequestMapping(method= RequestMethod.GET)
	public String homePage(Model model) {
		List<SongType> songtypes=songtypeRepository.findAll();
		model.addAttribute("songtypes",songtypes);
		List<Album> albums=albumRepository.findLastFive();
		model.addAttribute("newalbums",albums);
		List<Song> songs=songRepository.findFirstTen();
		model.addAttribute("songs",songs);
		List<Singer> singers=singerRepository.findFirstFive();
		model.addAttribute("singers",singers);
		return "home";
	}

//	/*
//	 * 搜索职业
//	 */
//	@RequestMapping(value = "/homePage", method = RequestMethod.POST)
//	public String searchJob(@RequestParam(value = "query", defaultValue = "") String query, RedirectAttributes attr) {
//		// System.out.println(query);
//		attr.addAttribute("type", "工作类型");
//		attr.addAttribute("pro", "省份");
//		attr.addAttribute("city", "城市");
//		attr.addAttribute("query", query);
//		return "redirect:/employmentPage";
//	}
	

	/*
	 * 登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	/*
	 * 登录请求
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(
			@RequestParam(value = "userName", defaultValue = "") 
			String userName,
			@RequestParam(value = "password", defaultValue = "") 
			String password, 
			HttpSession session,Model model) {
//		System.out.println(userName+password);
		User user=userRepository.findByUserName(userName, password);
//		System.out.println("111");
//		System.out.println(user.getUserName());
		//如果登录输入的用户存在
		if (user != null) {
				if(user.getStatus()==0) {//账号可用
				// 向session添加属性
				session.setAttribute("user", user);	
				if(user.getIdentity()==0) {
					System.out.println("普通用户登录");
					model.addAttribute("logined", "登陆成功");
					return "home";// 登录成功返回用户首页
				}else {
					System.out.println("管理员登录");
					return "userlist";//登录成功返回管理员首页
				}
				}else {
				model.addAttribute("logined","登陆失败，账号已被禁用");
				return "login";// 登录失败返回登录失败提醒页面
			}
			
		} else {
			model.addAttribute("logined", "登录失败，用户名不存在或密码错误");
			return "login";// 登录失败返回登录失败提醒页面
		}

	}
	
	/*
	 * 退出登录
	 */
	@RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 删除整个会话
		session.invalidate();
		return "home";// 返回首页
	}

}
