package de.heisemedia.gateway.controller;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class PostControllerTest {
    
    private PostController postController = new PostController();
    
    @Test
    public void whenNotPostFoundReturnEmptyList() throws Exception {
        List<Post> userPosts = postController.getUserById( 0L ).getBody();
        assertThat( userPosts.isEmpty(), CoreMatchers.is( Boolean.TRUE ) );
    }
    
    @Test
    public void whenUserHasPostsReturnThem() throws Exception {
        List<Post> userPosts = postController.getUserById( 1L ).getBody();
        assertThat( userPosts.size(), CoreMatchers.is( 2 ) );
        assertThat( userPosts.get(0).getText(), CoreMatchers.is( "User 1 post1" ) );
        assertThat( userPosts.get(1).getText(), CoreMatchers.is( "User 1 post2" ) );
    }
    @Test
    public void whenUserIdIsNullReturnAllPosts() throws Exception {
        List<Post> userPosts = postController.getUserById( null ).getBody();
        assertThat( userPosts.size(), CoreMatchers.is( 3 ) );
    }

}
