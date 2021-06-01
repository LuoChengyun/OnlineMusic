package oms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import oms.db.SongRepository;
import oms.db.SongTypeRepository;
import oms.domain.Song;
import oms.domain.SongType;
import oms.domain.User;


@Controller // 控制定义
@RequestMapping("/typelist") // 相对web路径
public class TypeListController {
	@Autowired
	private SongTypeRepository songtypeRepository;
	@Autowired
	private SongRepository songRepository;
	/*
	 * 推荐分类
	 */
	@RequestMapping(method= RequestMethod.GET)
	public String typelist(@RequestParam(value = "st_id", defaultValue = "")Long st_id,Model model) {
		List<Song> songlist=songRepository.findTypeSong(st_id);
		SongType songtype=songtypeRepository.findOne(st_id);
	    model.addAttribute("songlist",songlist);
	    model.addAttribute("songtype",songtype);
	    return  "typelist";
	}


}
