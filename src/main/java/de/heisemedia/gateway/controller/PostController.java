package de.heisemedia.gateway.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostController {

    private static final List<Post> posts = new ArrayList<>();

    static {
        posts.add( new Post( 1L, 1L, "User 1 post1" ) );
        posts.add( new Post( 2L, 1L, "User 1 post2" ) );
        posts.add( new Post( 3L, 2L, "User 2 post1" ) );
    }

    @RequestMapping( value = "/posts", method = RequestMethod.GET )
    public HttpEntity<List<Post>> getUserById( @RequestParam( "userid" ) final Long userid ) {
        if( userIdNotNull( userid ) ) {
            return ResponseEntity.ok( filterPostsByUserId( userid ) );
        }
        else {
            return ResponseEntity.ok( posts );
        }
    }

    private List<Post> filterPostsByUserId( Long userid ) {
        return posts.stream().filter( post -> post.getUserId().equals( userid ) ).collect( Collectors.toList() );
    }

    private boolean userIdNotNull( final Long userid ) {
        return userid != null;
    }

}
