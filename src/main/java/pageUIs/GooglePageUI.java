package pageUIs;

public class GooglePageUI {
    public static final String GOOGLE_SEARCH_TEXTBOX = "//input[@maxlength='2048']";
    public static final String GOOGLE_SEARCH_BTN = "//input[@type='submit' and contains(@value, 'Search')]";

    //Search result
    public static final String GOOGLE_SEARCH_RESULTS = "//div[@class='g']/div[@class='rc' and contains(@data-hveid, 'AA')]//h3";
    public static final String GOOGLE_HOW_PEOPLE_ASK_RESULTS = "//h2[text()='People also ask']/parent::div//div[@role='button']/div";
    public static final String GOOGLE_TOP_STORIES_RESULTS = "//h3[text()='Top stories']/parent::div/following-sibling::div//a//div[@aria-level='3']";
    public static final String GOOGLE_VIDEOS_RESULTS = "//h3[text()='Videos']/parent::div/following-sibling::div//a//div[@aria-level='3']";
}
