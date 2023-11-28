package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;
@Autowired
ImageRepository imageRepository;
    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
Blog b = new Blog();
b.setTitle(title);
b.setContent(content);
User user=userRepository1.findByuserId(userId);
b.setUser(user);
return b;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
List<Image> images = blogRepository1.findById(blogId).get().getImage();
for(int i =0; i<images.size(); i++){
    Image image=images.get(i);
    int id =image.getImageId();
    imageRepository.deleteById(id);
}
blogRepository1.deleteById(blogId);

    }
}
