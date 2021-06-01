package oms.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
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

import oms.db.SongRepository;
import oms.db.SongTypeRepository;
import oms.db.UserRepository;
import oms.db.AlbumRepository;
import oms.db.RecordRepository;
import oms.db.SingerRepository;
import oms.domain.Album;
import oms.domain.Record;
import oms.domain.Singer;
import oms.domain.Song;
import oms.domain.SongType;
import oms.domain.User;

@Controller
@SessionAttributes({ "manager" })
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SongRepository songRepository;
	@Autowired
	private SingerRepository singerRepository;
	@Autowired
	private SongTypeRepository songtypeRepository;
	@Autowired
	private RecordRepository recordRepository;
	@Autowired
	private AlbumRepository albumRepository;
	
/*
 * 管理员信息管理控制方法************************************************
 */
	
	/**
	 * 进入管理员个人中心
	 */
	@RequestMapping(value="/managerCenter",method=RequestMethod.GET)
	public String Center() {
		
		return "managerInformation";
	}
	/**
	 * 进入个人资料编辑页面
	 */
	@RequestMapping(value="/altermanagerpage",method=RequestMethod.GET)
	public String Altermanager(@RequestParam(value = "id", defaultValue = "0") long id, Model model) {
		User user=userRepository.findOne(id);
		model.addAttribute("user", user);
		
		return "alterManagerInformation";
	}
	/**
	 * 提交修改个人信息
	 */
	@RequestMapping(value="/altermanager",method=RequestMethod.GET)
	public String Submitalter(@RequestParam(value = "firstName", defaultValue = "")String firstName ,
			@RequestParam(value = "lastName", defaultValue = "")String lastName ,
			@RequestParam(value = "userName", defaultValue = "")String userName ,
			@RequestParam(value = "password", defaultValue = "")String password ,
			@RequestParam(value = "sex", defaultValue = "")String sex ,
			@RequestParam(value = "introduct", defaultValue = "")String introduct ,HttpSession session) {
		User user= (User)session.getAttribute("user");
		User newuser = new User(user.getId(),firstName,lastName,userName,password,sex,introduct);
//		user=userRepository.findOne(newuser.getId());
		
			user=userRepository.alterManager(newuser);
			session.setAttribute("user", newuser);
//			model.addAttribute("tipMessage", "修改成功");
//			return "tips";
		
		return "managerInformation";
		
	}
	
	
	
	
	
	
/*
 * 歌曲管理控制方法*******************************************************
 */
	
	/**
	 * 获取歌曲列表
	 * @param count
	 * @return
	 */
	@RequestMapping(value="/songlist", method = RequestMethod.GET)
	public String music(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,Model model) {
		
		 model.addAttribute("songpaginationSupport",songRepository.findPage(
		 pageNo, pageSize)); 
		 model.addAttribute("song", new AddSong());
		 return "songList";
		  
		 
	}
	
	/**
	 * 根据歌曲名搜索歌曲列表
	 * 返回歌曲管理页面
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/searchsong", method=RequestMethod.GET)
	public String selectByName(@RequestParam(value="name",defaultValue="")String name,@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,Model model) {
		 model.addAttribute("songpaginationSupport",songRepository.findBySongName(
				 pageNo, pageSize,name)); 
				 model.addAttribute("song", new Song());
		 return "songList";		
	}
	
	/**
	 * 增加歌曲
	 */
	@RequestMapping(value="/addsong",method=RequestMethod.GET)
	public String addSong(@Valid AddSong addsong,Errors errors ,HttpSession session,Model model) {
		if (errors.hasErrors()) {
			return "songList";
		}
		System.out.println(addsong.getName());
		Song song=songRepository.save(new Song(addsong.getName(),new Date(),addsong.getUrl(),addsong.getLyricURL(),singerRepository.findBySingerName(addsong.getSinger()),
				albumRepository.findByAlbumName(addsong.getAlbum()),songtypeRepository.findBySongTypeName(addsong.getType())));
		
		if (song==null) {
			model.addAttribute("tipMessage","添加歌取失败");
		}else {
			model.addAttribute("tipMessage","添加歌取成功");
		}
		return "tips";
	}
	
	/**
	 * 修改一个歌曲
	 */
	@RequestMapping(value="/updateSong",method=RequestMethod.GET)
	public String updateSong(@Valid Song song,
			@RequestParam(value="userId",defaultValue="")
			Integer userId,
			HttpServletRequest request,  Model model, HttpSession session)
			throws Exception {
//		songRepository.alter(song);//依据指定id和给出的歌曲修改歌曲
		return "redirect:/manager";//返回音乐管理页面
	}
	
	/**
	 * 删除一个歌曲
	 */
	@RequestMapping(value="/deleteSong",method = RequestMethod.GET)
	public String deleteSong(@Valid Song song,HttpServletRequest request,Model model,HttpSession session)
			throws Exception{
		songRepository.deleteSong(song.getId());//依据指定id删除对应的歌曲
		return "redirect:/manager";//返回歌曲管理页面
	}
	
/*
 * 用户管理控制方法********************************************************
 */

	
	/**
	 * 获取用户列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userlist",method=RequestMethod.GET)
	public String UserList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("userpaginationSupport",userRepository.findPage(pageNo, pageSize));
		model.addAttribute("user",new User());
		return "userlist" ;
	}
	
	/**
	 * 查询单个用户
	 */
	@RequestMapping(value="/searchuser",method=RequestMethod.GET)
	public String SelectUserList(@RequestParam(value="userName",defaultValue="")String userName,@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("userpaginationSupport",userRepository.findPageByUserName(pageNo, pageSize, userName));
		model.addAttribute("user",new User());
		return "userlist" ;
	}

	/**
	 * 增加用户
	 */
	@RequestMapping(value="/adduser",method=RequestMethod.GET)
	public String addUser(@Valid User user,Errors errors ,HttpSession session,Model model) {
		if (errors.hasErrors()) {
			return "userlist";
		}
		User newuser=userRepository.save(user);
//		System.out.println(newuser.getFirstName());
		String string="";
		if (newuser==null) {
			string="添加用户失败";
		}else {
			string="添加用户成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	/**
	 * 删除用户
	 */
	@RequestMapping(value="/deleteuser")
	public String deleteUser(@RequestParam(value="id",defaultValue="0") long id,Model model){
		int row=userRepository.deleteByUserId(id);
		String string="";
		if (row==0) {
			string="删除用户失败";
		}else {
			string="删除用户成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	/**
	 * 禁用用户
	 */
	@RequestMapping(value="/checkuser")
	public String checkUser(@RequestParam(value="id",defaultValue="0") long id,Model model) {
		int rows=userRepository.checkUser(id);
		if (rows==0) {
			model.addAttribute("tipMessage","禁用失败");
		}else {
			model.addAttribute("tipMessage","禁用成功");
		}
		return "tips";
	}

	
	
	
/*
 * 歌手管理控制方法******************************************************
 */
	
	
	/**
	 * 增加歌手
	 */
	@RequestMapping(value="/addsinger",method=RequestMethod.GET)
	public String addSinger(@Valid Singer singer,Errors errors ,HttpSession session,Model model) {
		if (errors.hasErrors()) {
			return "singerList";
		}
		Singer newsinger=singerRepository.save(singer);
		if (newsinger==null) {
			model.addAttribute("tipMessage","添加歌手失败");
		}else {
			model.addAttribute("tipMessage","添加歌手成功");
		}
		return "tips";
	}
	
	/**
	 * 获取歌手列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/singerlist",method=RequestMethod.GET)
	public String SingerList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("singerpaginationSupport",singerRepository.findPage(pageNo, pageSize));
		model.addAttribute("newsinger",new Singer());
		return "singerList" ;
	}
	
	/**
	 * 删除歌手
	 */
	@RequestMapping(value="/deletesinger")
	public String deleteSinger(@RequestParam(value="id",defaultValue="0") long id,Model model){
		int row=singerRepository.deleteBySingerId(id);
		String string="";
		if (row==0) {
			string="删除歌手失败";
		}else {
			string="删除歌手成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	/**
	 * 查询单个用户
	 */
	@RequestMapping(value="/searchsinger",method=RequestMethod.GET)
	public String SelectSingerList(@RequestParam(value="name",defaultValue="")String name,@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("singerpaginationSupport",singerRepository.findPageBySingerName(pageNo, pageSize, name));
		model.addAttribute("newsinger",new Singer());
		return "singerList" ;
	}
	
	/**
	 * 进入歌手编辑页面
	 */
	@RequestMapping(value="/altersingerpage",method=RequestMethod.GET)
	public String Altersinger(@RequestParam(value = "id", defaultValue = "0") long id,HttpSession session, Model model) {
		Singer singer=singerRepository.findOne(id);
		model.addAttribute("singer", singer);
		session.setAttribute("singer", singer);
		return "alterSinger";
	}
	
	/**
	 * 提交修改歌手信息
	 */
	@RequestMapping(value="/altersinger",method=RequestMethod.GET)
	public String Submitaltersinger(@RequestParam(value = "name", defaultValue = "")String name ,
			@RequestParam(value = "sex", defaultValue = "")String sex ,
			@RequestParam(value = "introduct", defaultValue = "")String introduct ,
			@RequestParam(value = "pictureURL", defaultValue = "")String pictureURL ,
			HttpSession session) {
		Singer singer= (Singer)session.getAttribute("singer");
		Singer newsinger = new Singer(singer.getId(),name,sex,introduct,pictureURL);
			singer=singerRepository.alterSinger(newsinger);
			session.setAttribute("singer", singer);
		
		return "redirect:/manager/userlist";
	}
	
	
	/*
	 * 歌曲分类管理控制方法****************************************************
	 */
	
	
	/**
	 * 增加分类
	 */
	@RequestMapping(value="/addsongtype",method=RequestMethod.GET)
	public String addSongType(@Valid SongType songtype,Errors errors ,HttpSession session,Model model) {
		if (errors.hasErrors()) {
			return "songTypeList";
		}
		SongType newsongtype=songtypeRepository.save(songtype);
		if (newsongtype==null) {
			model.addAttribute("tipMessage","添加分类失败");
		}else {
			model.addAttribute("tipMessage","添加分类成功");
		}
		return "tips";
	}
	
	/**
	 * 获取分类列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/songtypelist",method=RequestMethod.GET)
	public String SongTypeList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("songtypepaginationSupport",songtypeRepository.findPage(pageNo, pageSize));
		model.addAttribute("newsongtype",new SongType());
		return "songTypeList" ;
	}
	/**
	 * 删除分类
	 */
	@RequestMapping(value="/deletesongtype")
	public String deleteSongType(@RequestParam(value="id",defaultValue="0") long id,Model model){
		int row=songtypeRepository.deleteSongType(id);
		String string="";
		if (row==0) {
			string="删除分类失败";
		}else {
			string="删除分类成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	/**
	 * 进入分类编辑页面
	 */
	@RequestMapping(value="/altersongtypepage",method=RequestMethod.GET)
	public String Altersongtype(@RequestParam(value = "id", defaultValue = "0") long id, HttpSession session,Model model) {
		SongType songtype=songtypeRepository.findOne(id);
//		System.out.println(songtype.getName());
		model.addAttribute("songtype", songtype);
		session.setAttribute("songtype", songtype);
		return "alterSongType";
	}

	/**
	 * 提交修改分类
	 */
	@RequestMapping(value="/altersongtype",method=RequestMethod.GET)
	public String SubmitAlterSongType(@RequestParam(value = "name", defaultValue = "")String name ,
			@RequestParam(value = "picture", defaultValue = "")String picture ,HttpSession session,Model model) {
		SongType songtype= (SongType)session.getAttribute("songtype");
		
		SongType newsongtype = new SongType(songtype.getId(),name,picture);

		
			  songtype=songtypeRepository.altersongType(newsongtype);
			session.setAttribute("songtype", songtype);
				

		return "redirect:/manager/userlist";
		
		
		
	}
	
/*
 * 专辑管理控制方法******************************************************
 */
	
	/**
	 * 增加专辑
	 */
	@RequestMapping(value="/addalbum",method=RequestMethod.GET)
	public String addAlbum(@Valid AddAlbum addalbum,Errors errors ,HttpSession session,Model model) {
		if (errors.hasErrors()) {
			return "albumList";
		}
		Album  album = new Album(addalbum.getAlbumName(),singerRepository.findBySingerName(addalbum.getAlbumSingerName()),addalbum.getPicture());
		Album newalbum=albumRepository.save(album);
		if (newalbum==null) {
			model.addAttribute("tipMessage","添加专辑失败");
		}else {
			model.addAttribute("tipMessage","添加专辑成功");
		}
		return "tips";
	}
	/**
	 * 获取专辑列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/albumlist",method=RequestMethod.GET)
	public String AlbumList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("albumpaginationSupport",albumRepository.findPage(pageNo, pageSize));
		model.addAttribute("addalbum",new AddAlbum());
		return "albumList" ;
	}
	
	
	
	/**
	 * 删除专辑
	 */
	@RequestMapping(value="/deletealbum")
	public String deleteAlbum(@RequestParam(value="id",defaultValue="0") long id,Model model){
		int row=albumRepository.deleteAlbum(id);
		String string="";
		if (row==0) {
			string="删除专辑失败";
		}else {
			string="删除专辑成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	/**
	 * 进入专辑编辑页面
	 */
	@RequestMapping(value="/alteralbumpage",method=RequestMethod.GET)
	public String AlterAlbum(@RequestParam(value = "id", defaultValue = "0") long id, HttpSession session,Model model) {
		Album album=albumRepository.findOne(id);
		System.out.println(album.getName());
		model.addAttribute("album", album);
		session.setAttribute("album", album);
		return "alterAlbum";
	}
	
	/**
	 * 提交修改专辑
	 */
	@RequestMapping(value="/alteralbum",method=RequestMethod.GET)
	public String SubmitAlterAlbum(@RequestParam(value = "name", defaultValue = "")String name ,
			HttpSession session,Model model) {
		
		Album album= (Album)session.getAttribute("album");
		System.out.println(album.getName());
		Album newalbum = new Album(album.getId(),name);

		
			  album=albumRepository.alterAlbum(newalbum);
			session.setAttribute("album", album);
				

		return "redirect:/manager/userlist";
		
		
		
	}

	
	/**
	 * 查询单个专辑
	 */
	@RequestMapping(value="/searchalbum",method=RequestMethod.GET)
	public String SelectAlbumList(@RequestParam(value="name",defaultValue="")String name,@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("albumpaginationSupport",albumRepository.findPageByAlbumName(pageNo, pageSize, name));
		model.addAttribute("addalbum",new AddAlbum());
		return "albumList" ;
	}
	
	

/*
 * 登录记录控制方法********************************************************
 */

	/**
	 * 展示登录信息列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/recordlist",method = RequestMethod.GET)
	public String recordlist(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("recordpaginationSupport",recordRepository.findPage(pageNo, pageSize));
		return "recordlist";
	}
	/**
	 * 依据给定的用户名查询登录信息列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @param userName
	 * @return
	 */
	@RequestMapping(value="/searchrecord",method = RequestMethod.GET)
	public String recordlist(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model,String userName) {
		System.out.println(userName);
		model.addAttribute("recordpaginationSupport",recordRepository.findPageByName(pageNo, pageSize,userName));
		model.addAttribute("record", new Record());
		return "recordlist";
	}

}
