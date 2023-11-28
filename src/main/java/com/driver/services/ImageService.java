package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
Image image = new Image();
image.setDimension(dimensions);
image.setDiscription(description);
Blog b= blogRepository2.findById(blogId).orElse(null);
image.setBlog(b);
return image;
    }

    public void deleteImage(Integer id){
imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
Image image= imageRepository2.findById(id).orElse(null);
String[] screendimension=screenDimensions.split("x");
String [] imagedimension=image.getDimension().split("x");
int imagearea=Integer.parseInt(imagedimension[0])*Integer.parseInt(imagedimension[1]);
int screenarea=Integer.parseInt(screendimension[0])*Integer.parseInt(screendimension[1]);
return screenarea/imagearea;
    }
}
