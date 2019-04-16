package cn.sun.controller;

import cn.sun.dto.MoodDTO;
import cn.sun.service.MoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: SXH
 * \* Date: 2019/4/9
 * \
 */
@Controller
@RequestMapping("/mood")
public class MoodController {
    @Resource
    private MoodService moodService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<MoodDTO> moodDTOList = moodService.findAll();
        model.addAttribute("moods",moodDTOList);
        return "mood";
    }


    @GetMapping(value = "/{moodId}/praise")
    public String praise(Model model , @PathVariable(value = "moodId") int moodId , @RequestParam(value = "userId") int userId){
        System.out.println(userId);
        System.out.println(moodId);
        boolean isPraise = moodService.praiseMood(userId,moodId);
        List<MoodDTO> moodDTOList = moodService.findAll();
        model.addAttribute("moods",moodDTOList);
        model.addAttribute("isPraise",isPraise);
        return "mood";
    }

    @GetMapping(value = "/{moodId}/praiseForRedis")
    public String praiseForRedis(Model model , @PathVariable(value = "moodId") int moodId , @RequestParam(value = "userId") int userId){
//        方便使用，随机的生成用户的id
        Random random = new Random();
        userId = random.nextInt(100);

        boolean isPraise = moodService.praiseMoodForRedis(userId,moodId);
//        查询所用说说的数据
        List<MoodDTO> moodDTOList = moodService.findAllForRedis();
        model.addAttribute("moods",moodDTOList);
        model.addAttribute("isPraise",isPraise);
        return "mood";
    }
}
