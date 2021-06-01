package oms.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
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
import oms.domain.Song;
@Controller
@SessionAttributes({ "song" })
@RequestMapping("/SongPlay")
public class SongController {
	@Autowired
	private SongRepository songRepository;
	
	@RequestMapping(method = GET)
	public String playSong(@RequestParam(value = "song_id", defaultValue = "")Long song_id,Model model) {
		Song song=songRepository.findOne(song_id);
		 model.addAttribute("song",song);
		return "songplaydetail";
	}

}
