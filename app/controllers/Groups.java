package controllers;

import models.Group;
import play.mvc.Controller;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
public class Groups extends Controller {

  public static void create(String name) {
    Group group = new Group(name);
    group.save();
    show(group.id);
  }

  public static void show(Long id) {
    Group group = Group.findById(id);
    render(group);
  }

  public static void list() {
    List<Group> groups = Group.findAll();
    render(groups);
  }
}
