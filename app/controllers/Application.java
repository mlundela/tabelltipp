package controllers;

import models.Group;
import models.Team;
import models.User;
import play.data.validation.Valid;
import play.mvc.Controller;

import java.util.List;


public class Application extends Controller {

  public static void register() {
    User user = Security.getConnectedUser();
    if (user != null) {
      Users.profile();
    } else {
      user = new User();
      render(user);
    }
  }

  public static void createProfile(@Valid User user) {
    if (validation.hasErrors()) {
      params.flash(); // add http parameters to the flash scope
      validation.keep(); // keep the errors for the next request
      register();
    }
    user.save();
    session.put("username", user.email);
    Users.profile();
  }


  public static void showGroup(Long id, Long userId) {
    Group group = Group.findById(id);
    boolean isMember = false;
    if (Security.isConnected()) {
      User user = Security.getConnectedUser();
      isMember = group.members.contains(user);
    }
    List<Team> table = Team.getTable();
    User selectedUser;
    if (userId == null && !group.members.isEmpty()) {
      selectedUser = group.getMembersSorted().get(0);
    } else {
      selectedUser = User.findById(userId);
    }
    boolean canJoin = !isMember && Security.isConnected();
    render(group, canJoin, table, selectedUser);
  }

}