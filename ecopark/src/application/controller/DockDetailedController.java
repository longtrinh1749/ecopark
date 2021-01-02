package application.controller;

import application.model.entity.Dock;
import application.model.services.DockService;
import application.model.services.DockServiceInterface;

public class DockDetailedController {
  private DockServiceInterface dockServiceHandler;
  
  public DockDetailedController() {
	  this.dockServiceHandler = new DockService();
  }
  
  public Dock getDockInfo(int dockId) {
    return dockServiceHandler.getDockInfo(dockId);
  }
}
