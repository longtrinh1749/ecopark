package application.controller;

import application.model.entity.Dock;
import application.model.services.DockService;

public class DockDetailedController {
  private DockService dockServiceHandler;
  
  public DockDetailedController() {
    this.dockServiceHandler = new DockService();
  }
  
  public Dock getDockInfo(int dockId) {
    return dockServiceHandler.getDockInfo(dockId);
  }
}
