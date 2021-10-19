package com.bad_java.lectures._12.library.view.swing;

import com.bad_java.lectures._12.library.infrastructure.Dispatcher;
import com.bad_java.lectures._12.library.view.View;
import lombok.RequiredArgsConstructor;

import javax.swing.*;

@RequiredArgsConstructor
public abstract class AbstractSwingView implements View {

    protected final JFrame frame;

    protected final Dispatcher dispatcher;
}
