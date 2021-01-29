package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class MainController {

	
@Autowired
UserDataRepository repository;

@RequestMapping(value="/CreateAccount", method = RequestMethod.GET)
public ModelAndView CreateAccountGet(ModelAndView mv) {
	List<UserData> accountData = repository.findAll();
	mv.addObject("accountData", accountData);
	mv.setViewName("CreateAccount");
	return mv;
}

@RequestMapping(value="/CreateAccount", method = RequestMethod.POST)
public ModelAndView CreateAccountPost(@ModelAttribute("formModel") UserData userData,ModelAndView mv) {
	repository.saveAndFlush(userData);
	return new ModelAndView("redirect:/MyPage/");
}

 

@RequestMapping(value="/MyPage/{id}", method = RequestMethod.GET)
public ModelAndView MaypageGet(@ModelAttribute UserData userData, ModelAndView mv, 
@PathVariable long id) {
	Optional<UserData> accountData = repository.findById(id);
	mv.addObject("accountData", accountData.get());
	mv.setViewName("MyPage");
	return mv;
}
@RequestMapping(value="/MyPage/", method = RequestMethod.POST)
public ModelAndView MyPage(@ModelAttribute UserData userData, ModelAndView mv) {
	repository.saveAndFlush(userData);
	return new ModelAndView("redirect:/MyPage/");
}

@RequestMapping(value="/PostTweet/{id}", method = RequestMethod.GET)
public ModelAndView PostTweetget(@ModelAttribute UserData userData ,ModelAndView mv,
	@PathVariable long id) {
	List<UserData> TweetData = repository.findAll();
	mv.addObject("TweetData", TweetData);
	mv.setViewName("PostTweet");
	return mv;

}

@RequestMapping(value="/PostTweet/", method = RequestMethod.POST)
public ModelAndView PostTweetPost(@ModelAttribute("formModel") TweetData tweetData,ModelAndView mv) {
	repository.saveAndFlush(tweetData);
	return new ModelAndView("redirect:/Postweet/");
}




@RequestMapping("/test")
public ModelAndView test(ModelAndView mv) {
	mv.addObject("name","名前");
	mv.setViewName("test");
	return mv;
}

}











