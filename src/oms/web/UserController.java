package oms.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import oms.db.RecentListRepository;
import oms.db.SongListRepository;
import oms.db.UserRepository;
import oms.domain.RecentList;
import oms.domain.SongList;
import oms.domain.User;



@Controller
@SessionAttributes({ "user" })
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RecentListRepository recentlistRepository;
	@Autowired
	private SongListRepository songListRepository;
	
	/*
	 * 注册页面
	 */
	@RequestMapping(value = "/registerpage", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute(new User());
		return "register";
	}
	
	/**
	 * 注册请求
	 * @param user
	 * @param errors
	 * @param session 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String Registration(			
			@Valid User user, Errors errors,
			HttpSession session,Model model) {
		if(errors.hasErrors()) {
			return "register";
		}
//		if(userRepository.findByUserName(user.getUserName())) {//不存在同名用户
			session.setAttribute("user", userRepository.save(user));//保存用户到数据库
			model.addAttribute("logined", "注册成功，请登录");
//		}else {
//			model.addAttribute("logined", "注册失败,用户名已存在");
//		}
//		model.addAttribute("logined", "注册失败,用户名已存在");
		return "login";//返回登录页面
	}
	//@RequestMapping(value="/register",method= POST)
	
	
	/**
	 * 进入个人资料编辑页面
	 */
	@RequestMapping(value="/alter",method=RequestMethod.POST)
	public String alter() {
		
		return "alterinformation";
	}
	/**
	 * 提交修改个人信息
	 */
	@RequestMapping(value="/alter",method=RequestMethod.GET)
	public String altersubmit(@Valid User user,Errors errors ,HttpSession session,Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("tipMessage", "修改失败");
			return "tips";
		}
		user=userRepository.alterUser(user);
		return "alterinformation";
		
	}
//	@RequestMapping(value="/saverecentlist",method=RequestMethod.GET)
//	public void saveHistory(@RequestParam(value="songId",defaultValue="")long songId ,Model model,HttpSession session) {
//		User user = (User) session.getAttribute("user");
//	}
	/**
	 * 显示最近播放列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/recentlist",method=RequestMethod.GET)
	public String getHistory(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model,HttpSession session) {
		User user =  (User)session.getAttribute("user");
		long userId = user.getId();
		System.out.println(userId);
		
		model.addAttribute("paginationSupport",recentlistRepository.findPage(pageNo, pageSize,userId));
		model.addAttribute("recentlist",new RecentList());
		return "recentlist";
	}
	
	/**
	 * 依据用户id和歌曲名查询最近播放
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @param session
	 * @param songName
	 * @return
	 */
	@RequestMapping(value="/recentlist/searchbyname",method=RequestMethod.GET)
	public String getHistoryByName(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model,HttpSession session,@RequestParam(value="songName",defaultValue="")String songName) {
		System.out.println(songName);
		User user =  (User)session.getAttribute("user");
		long userId = user.getId();
		System.out.println(userId);
		model.addAttribute("paginationSupport",recentlistRepository.findPageByName(pageNo, pageSize, userId, songName));
		model.addAttribute("recentlist",new RecentList());
		return "recentlist";
	}
	
	/**
	 * 依据用户id查询歌单
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @param session
	 * @param songName
	 * @return
	 */
	@RequestMapping(value="/mysonglist",method=RequestMethod.GET)
	public String getSongList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model,HttpSession session) {
		User user =  (User)session.getAttribute("user");
		long userId = user.getId();
		model.addAttribute("songlistpaginationSupport",songListRepository.findPage(pageNo, pageSize, userId));
		model.addAttribute("songlist",new SongList());
		return "mysonglist";
	}
	


}
