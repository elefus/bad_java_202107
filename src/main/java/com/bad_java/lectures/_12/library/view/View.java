package com.bad_java.lectures._12.library.view;

import com.bad_java.lectures._12.library.infrastructure.Model;

public interface View {

    String update(Model inModel, Model outModel);
}
