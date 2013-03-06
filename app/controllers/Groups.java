package controllers;

import models.Group;
import models.Team;
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
    show(group.id, null);
  }

  public static void show(Long id, Long userId) {
    Group group = Group.findById(id);
    User user = Security.getConnectedUser();
    boolean isMember = group.members.contains(user);
    List<Team> table = Team.getTable();
    User selectedUser;
    if (userId == null && !group.members.isEmpty()) {
      selectedUser = group.getMembersSorted().get(0);
    }
    else {
      selectedUser = User.findById(userId);
    }
    render(group, isMember, table, selectedUser);
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
    show(groupId, null);
  }
}
