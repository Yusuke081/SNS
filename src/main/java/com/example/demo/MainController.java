package com.example.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class MainController {

	
@Autowired
UserDataRepository repository;
@Autowired
TweetDataRepository tweet_repository;

@RequestMapping(value="/CreateAccount", method = RequestMethod.GET)
public ModelAndView CreateAccountGet(ModelAndView mv) {
	List<UserData> accountData = repository.findAll();
	mv.addObject("accountData", accountData);
	mv.setViewName("CreateAccount");
	return mv;
}

@RequestMapping(value="/CreateAccount", method = RequestMethod.POST)
public ModelAndView CreateAccountPost(@ModelAttribute("formModel") @Validated UserData userData, BindingResult result, ModelAndView mv) {
	ModelAndView res = null;
    if (!result.hasErrors()){
        repository.saveAndFlush(userData);
        res = new ModelAndView("redirect:MyPage/"+ userData.getId());
    } else {
        mv.setViewName("CreateAccount");
        List<String> errorList = new ArrayList<String>();
        for(ObjectError error : result.getAllErrors()) {
        	errorList.add(error.getDefaultMessage());}
        mv.addObject("errorList",errorList);
        System.out.println(errorList);
        res = mv;
    }
    return res;
}

 

@RequestMapping(value="/MyPage/{id}", method = RequestMethod.GET)
public ModelAndView MaypageGet(@ModelAttribute UserData userData, ModelAndView mv, 
@PathVariable long id) {
	Optional<UserData> accountData = repository.findById(id);
	mv.addObject("userData", accountData.get());
	mv.setViewName("MyPage");
	return mv;
}
@RequestMapping(value="MyPage/", method = RequestMethod.POST)
public ModelAndView MyPagePost(@ModelAttribute @Validated UserData userData, BindingResult result, ModelAndView mv) {
	ModelAndView res = null;
    if (!result.hasErrors()){
        repository.saveAndFlush(userData);
        res = new ModelAndView("redirect:/MyPage");
    } else {
        mv.setViewName("MyPage");
        List<String> errorList = new ArrayList<String>();
        for(ObjectError error : result.getAllErrors()) {
        	errorList.add(error.getDefaultMessage());}
        mv.addObject("errorList",errorList);
        System.out.println(errorList);
        res = mv;
    }
    return res;
}



//@RequestMapping(value="/PostTweet/", method = RequestMethod.GET)
//public ModelAndView PostTweetget(ModelAndView mv) {
//	List<TweetData> tweetData = tweet_repository.findAll();
//	mv.addObject("tweetData", tweetData);
//	mv.setViewName("PostTweet");
//	return mv;
//}



@RequestMapping(value="/PostTweet/{id}", method = RequestMethod.GET)
public ModelAndView PostTweetget(@ModelAttribute UserData userData ,ModelAndView mv, @PathVariable long id) {
	Optional<UserData> accountData = repository.findById(id);
//	Optional<TweetData> TweetData = tweet_repository.findById(id);
	mv.addObject("UserData", accountData.get());
	mv.setViewName("PostTweet");
	return mv;

}

//
//@RequestMapping(value="/PostTweet/", method = RequestMethod.POST)
//public ModelAndView PostTweetPost(ModelMap modelMap,  @RequestParam("tweet") String tweet) {
//	long id = 1;
//    Optional<UserData> userData = repository.findById(id);
//    TweetData tweetData = new TweetData();
//    tweetData.setUserData(userData.get());
//    tweetData.setComment(tweet);
//    tweet_repository.save(tweetData);
//    System.out.println(tweet);
//    System.out.println(tweetData);
//    return new ModelAndView("redirect:/Comment/");
//}


@RequestMapping(value="/postTweet", method = RequestMethod.POST)
public ModelAndView PostTweetPost(
		ModelAndView mv
		,  @RequestParam("tweet") String text
		) {
	long id = 1;
    Optional<UserData> userData = repository.findById(id);
    TweetData tweetData = new TweetData();
//    tweetData.setUserData(userData.get());
    tweetData.setComment(text);
    tweet_repository.save(tweetData);
    System.out.println(text);
    System.out.println(tweetData);
    return new ModelAndView("redirect:/Comment");
}
//




//@RequestMapping(value="/postTweet/", method = RequestMethod.POST)
//public ModelAndView PostTweetPost(
//		@ModelAttribute("formModel")TweetData tweetData,
////		ModelMap modelMap
//		ModelAndView mv
////		,  @RequestParam("tweet") String text
//		) {
//	long id = 1;
//    Optional<UserData> userData = repository.findById(id);
////    tweetData.setUserData(userData.get());
////    tweetData.setComment(text);
////    tweet_repository.save(tweetData);
////    System.out.println(text);
////    System.out.println(tweetData);
//    return new ModelAndView("redirect:/Comment/");
//}


@RequestMapping(value="/Comment", method = RequestMethod.GET)
public ModelAndView CommentGet(ModelAndView mv) {
	List<TweetData> tweetData = tweet_repository.findAll();
	List<UserData> userData = repository.findAll();
	mv.addObject("tweetData", tweetData);
	mv.addObject("userData", userData);
	mv.setViewName("Comment");
	return mv;
}

//@RequestMapping(value="/Comment/", method = RequestMethod.POST)
//public ModelAndView CommentPost(@ModelAttribute("formModel") TweetData tweetData,ModelAndView mv) {
//	tweet_repository.saveAndFlush(tweetData);
//	return new ModelAndView("redirect:/Comment/");
//}















}











