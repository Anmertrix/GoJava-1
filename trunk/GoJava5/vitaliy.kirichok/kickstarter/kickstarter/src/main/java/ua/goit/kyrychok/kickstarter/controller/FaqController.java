package ua.goit.kyrychok.kickstarter.controller;

import org.apache.commons.lang3.StringUtils;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.view.FaqView;

public class FaqController extends AbstractController {
    public static final int MAX_QUESTION_LENGTH = 150;

    private FaqView view;
    private int projectId;

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setView(FaqView view) {
        this.view = view;
    }

    public void addFaq(String question) {
        Faq faq = new Faq(question);
        dataProvider.addFaq(projectId, faq);
    }

    @Override
    protected boolean isValid(String input) {
        return !(StringUtils.isBlank(input) || input.length() > MAX_QUESTION_LENGTH);
    }

    @Override
    protected void updateModel() {
    }

    @Override
    protected void renderModel() {
        view.render();
    }

    @Override
    protected void doValidControl(String input) {
        addFaq(input);
        setNextController(getParentController());
    }
}