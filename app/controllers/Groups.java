package controllers;

import models.Group;
import models.User;
import play.mvc.Controller;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
public class Groups extends Controller {

  public static void create() {
    render();
  }

  public static void save(String name) {
    Group group = new Group(name);
    group.members.add(Security.getConnectedUser());
    group.save();
    Application.showGroup(group.id, null);
  }

  public static void list() {
    List<Group> groups = Group.findAll();
    render(groups);
  }

  public static void join(Long groupId) {
    Group group = Group.findById(groupId);
    User user = Security.getConnectedUser();
    if (!group.members.contains(user)) {
      group.members.add(user);
      group.save();
    }
    Application.showGroup(groupId, null);
  }
}
