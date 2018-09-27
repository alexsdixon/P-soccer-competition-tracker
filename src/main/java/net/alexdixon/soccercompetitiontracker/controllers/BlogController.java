package net.alexdixon.soccercompetitiontracker.controllers;


import net.alexdixon.soccercompetitiontracker.models.data.BlogDao;
import net.alexdixon.soccercompetitiontracker.models.forms.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("blog")
public class BlogController {


    @Autowired
    private BlogDao blogDao;


    @RequestMapping(value = "")
    public String index (Model model) {

        model.addAttribute("blogs", blogDao.findAll());
        model.addAttribute("title", "BLOGS");

        return "blog/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddBlogForm(Model model) {
        model.addAttribute("title", "ADD BLOG");
        model.addAttribute(new Blog());
        return "blog/add";
    }

    @RequestMapping (value = "add", method = RequestMethod.POST)
    public String processAddBlogForm(@ModelAttribute @Valid Blog newBlog, Errors errors,
                                      Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "ADD BLOG");
            return "blog/add";
        }

        blogDao.save(newBlog);
        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveBlogForm(Model model) {

        model.addAttribute("blogs", blogDao.findAll());
        model.addAttribute ("title", "REMOVE BLOG");
        return "blog/remove";
    }


    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveBlogForm(@RequestParam int[] blogIds) {

        for (int blogId : blogIds) {
            blogDao.delete(blogId);
        }

        return "redirect:";
    }


    @RequestMapping(value = "edit/{blogId}", method = RequestMethod.GET)
    public String displayEditBlogForm(Model model, @PathVariable int blogId) {

        model.addAttribute("title", "EDIT BLOG");
        model.addAttribute("blog", blogDao.findOne(blogId));

        return "blog/edit";
    }


    @RequestMapping(value = "edit/{blogId}", method = RequestMethod.POST)
    public String processEditBlogForm(Model model, @PathVariable int blogId,
                                         @ModelAttribute  @Valid Blog newBlog,
                                         Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "EDIT BLOG");
            return "blog/edit";
        }

        Blog editedBlog = blogDao.findOne(blogId);
        editedBlog.setTopic(newBlog.getTopic());
        editedBlog.setDescription(newBlog.getDescription());
        blogDao.save(editedBlog);

        return "redirect:/blog";
    }


}
