package com.bad_java.lectures._12.library.infrastructure;

import com.bad_java.lectures._12.library.controller.Controller;
import com.bad_java.lectures._12.library.view.View;

import java.util.HashMap;
import java.util.Map;

public class Dispatcher {

    private final Map<String, Controller> controllersMapping = new HashMap<>();
    private final Map<String, View> viewsMapping = new HashMap<>();

    public void addController(String controllerName, Controller controller) {
        controllersMapping.put(controllerName, controller);
    }

    public void addView(String viewName, View view) {
        viewsMapping.put(viewName, view);
    }

    public ModelAndTarget dispatchRequest(String controller, Model inModel) {
        Model outModel = new Model();
        inModel.tryGet("user").ifPresent(user -> outModel.put("user", user));
        String viewName = controllersMapping.get(controller).handle(inModel, outModel);
        return new ModelAndTarget(outModel, viewName);
    }

    public ModelAndTarget dispatchResponse(String view, Model inModel) {
        Model outModel = new Model();
        inModel.tryGet("user").ifPresent(user -> outModel.put("user", user));
        String viewName = viewsMapping.get(view).update(inModel, outModel);
        return new ModelAndTarget(outModel, viewName);
    }
}
