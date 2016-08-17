package de.heisemedia.gateway.controller;


import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import de.heisemedia.gateway.api.User;


public class UserControllerTest {

    private UserController userController = new UserController();

    @Test
    public void whenRequestAvailableUserMustBeNotNull() throws Exception {
        User user = userController.getUserById( 1L ).getBody();
        assertThat( user, CoreMatchers.notNullValue() );
    }

    @Test
    public void whenRequestAvailableUserMustHaveId() throws Exception {
        User user = userController.getUserById( 1L ).getBody();
        assertThat( user.getId(), CoreMatchers.is( 1L ) );
    }

    @Test
    public void whenRequestAvailableUserMustHaveName() throws Exception {
        User user = userController.getUserById( 1L ).getBody();
        assertThat( user.getName(), CoreMatchers.is( "User 1" ) );
    }

    @Test( expected = UserNotFoundException.class )
    public void whenUserNotFoundMustThrow() throws Exception {
        userController.getUserById( 10L );
    }
}
