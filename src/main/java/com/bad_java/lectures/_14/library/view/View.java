package com.bad_java.lectures._14.library.view;

import com.bad_java.lectures._14.library.infrastructure.Model;

public interface View {

    String update(Model inModel, Model outModel);
}
