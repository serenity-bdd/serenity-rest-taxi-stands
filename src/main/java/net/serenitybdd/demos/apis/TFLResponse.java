package net.serenitybdd.demos.apis;

public class TFLResponse {
    private String content;

    public TFLResponse(String content) {
        this.content = content;
    }

    public static TFLResponse withContent(String content) {
        return new TFLResponse(content);
    }

    public void shouldBeValid() {
        if (content.contains("Your authentication credentials were missing or incorrect")) {
            throw new IncorrectApiCredentials();
        }
    }
}
