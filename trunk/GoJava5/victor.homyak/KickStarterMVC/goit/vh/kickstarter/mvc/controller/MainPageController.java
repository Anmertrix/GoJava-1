package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.InputListener;
import goit.vh.kickstarter.mvc.model.MainPageModel;
import goit.vh.kickstarter.mvc.view.MainPageView;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageController implements InputListener {

    private MainPageView view;
    private MainPageModel model;



    public MainPageController(MainPageView view, MainPageModel model) {
        this.view = view;
        this.model = model;
    }

    public void onApplicationStart() {
        view.render(model);
    }

    @Override
    public void onInput(String input) {

    }
}
