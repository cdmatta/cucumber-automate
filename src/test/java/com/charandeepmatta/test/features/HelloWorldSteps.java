package com.charandeepmatta.test.features;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;
import cuke4duke.spring.StepDefinitions;

@StepDefinitions
public class HelloWorldSteps {
    private Support support;

    @Given("^user opens new browser session$")
    public void newBrowserSessions() {
        support = new Support();
    }

    @When("^user opens \"(.*)\"")
    public void openHomePage(final String url) {
        support.open(url);
    }

    @Then("^the page title is \"(.*)\"")
    public void thePageTitleShouldBe(final String expectedTitle) {
        //        assertEquals(expectedTitle, webDriver.getTitle());
    }
}
