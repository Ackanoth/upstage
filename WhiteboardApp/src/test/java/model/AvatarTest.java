/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.sample.whiteboardapp.Avatar;
import org.sample.whiteboardapp.Stage;
import org.sample.whiteboardapp.User;

/**
 *
 * @author zhf3041
 */
public class AvatarTest {
    
    public AvatarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of moveAvatar method, of class Avatar.
     */
    @Test
    public void testMoveAvatarFast() {
        System.out.println("moveAvatar");
        int x = 10;
        int y = 10;
        User user = new User();
        user.fast = true;
        Avatar instance = new Avatar(0, 0, "Test");
        instance.moveAvatar(x, y, user);
        assertEquals(10, instance.positionX, 1);
        assertEquals(10, instance.positionY, 1);
    }
    @Test
    public void testMoveAvatarNormal() {
        System.out.println("moveAvatar");
        int x = 10;
        int y = 10;
        User user = new User();
        user.fast = false;
        Avatar instance = new Avatar(0, 0, "Test");
        instance.moveAvatar(x, y, user);
        assertEquals(10, instance.positionX, 1);
        assertEquals(10, instance.positionY, 1);
    }
    
    @Test
    public void testMoveAvatarXNoChange() {
        System.out.println("moveAvatar");
        int x = 0;
        int y = 10;
        User user = new User();
        user.fast = false;
        Avatar instance = new Avatar(0, 0, "Test");
        instance.moveAvatar(x, y, user);
        assertEquals(0, instance.positionX, 1);
        assertEquals(10, instance.positionY, 1);
    }

    @Test
    public void testMoveAvatarYNoChange() {
        System.out.println("moveAvatar");
        int x = 10;
        int y = 0;
        User user = new User();
        user.fast = false;
        Avatar instance = new Avatar(0, 0, "Test");
        instance.moveAvatar(x, y, user);
        assertEquals(10, instance.positionX, 1);
        assertEquals(0, instance.positionY, 1);
    }
    /**
     * Test of setAvatarID method, of class Avatar.
     */
    @Test
    public void testSetAvatarID() {
        System.out.println("setAvatarID");
        String id = "Test";
        Avatar instance = new Avatar(0, 0, "Test");
        instance.setAvatarID(id);
        assertEquals(id, instance.UserID);
    }

    /**
     * Test of placeAvatar method, of class Avatar.
     */
    @Test
    public void testPlaceAvatar() {
        System.out.println("placeAvatar");
        int x = 58;
        int y = 42;
        String id = "Test";
        Avatar instance = new Avatar(0, 0, "Test");
        instance.placeAvatar(x, y, id);
        assertEquals(id, instance.UserID);
        assertEquals(58, instance.positionX, 1);
        assertEquals(42, instance.positionY, 1);
    }

    /**
     * Test of dropAvatar method, of class Avatar.
     */
    @Test
    public void testDropAvatar() {
        System.out.println("dropAvatar");
        int x = 58;
        int y = 42;
        String id = "Test";
        Avatar instance = new Avatar(0, 0, "Test");
        instance.placeAvatar(x, y, id);
        instance.dropAvatar();
        assertEquals(null, instance.UserID);
    }

    /**
     * Test of clearAvatars method, of class Avatar.
     */
   // @Test
    //public void testClearAvatars() {
      //  System.out.println("clearAvatars");
      //  Stage stage = null;
     //   Avatar instance = null;
      //  instance.clearAvatars(stage);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
   // }

    /**
     * Test of stopAvatar method, of class Avatar.
     */
   // @Test
   // public void testStopAvatar() {
    //    System.out.println("stopAvatar");
    //    Avatar instance = null;
     //   instance.stopAvatar();
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
  //  }

    /**
     * Test of setProp method, of class Avatar.
     */
   // @Test
  //  public void testSetProp() {
  //      System.out.println("setProp");
   //     Avatar avatar = null;
  //      Prop prop = null;
  //      Avatar instance = null;
  //      instance.setProp(avatar, prop);
  //      // TODO review the generated test code and remove the default call to fail.
  //      fail("The test case is a prototype.");
  //  }
    
}
