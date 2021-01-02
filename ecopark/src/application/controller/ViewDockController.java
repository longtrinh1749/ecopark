package application.controller;


import application.model.entity.Dock;
import application.model.services.DockService;
import application.model.services.DockServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class ViewDockController {
  private DockServiceInterface dockServiceHandler;
  
  public ViewDockController() {
    this.dockServiceHandler = new DockService();
  }
  
  public List<Dock> searchDock(String address) {
    List<Dock> listDock = dockServiceHandler.getDockList();
    List<Dock> matched = new ArrayList<Dock>();
    for (int i = 0; i < listDock.size(); i++) {
      if (listDock.get(i).getAddress().contains(address)) {
        matched.add(listDock.get(i));
      }
    }
    return matched;
  }
  
  public List<Dock> getAllDock() {
    return dockServiceHandler.getDockList();
  }
}
