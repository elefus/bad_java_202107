package com.bad_java.lectures._12.library.controller;

import com.bad_java.lectures._12.library.infrastructure.Model;

public interface Controller {

    String handle(Model inModel, Model outModel);
}
