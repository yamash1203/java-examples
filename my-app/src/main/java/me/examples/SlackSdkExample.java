package me.examples;

import java.util.concurrent.ExecutionException;

import com.slack.api.Slack;

public class SlackSdkExample {

    public static void main(String[] args) {
        var token = System.getenv("SLACK_TOKEN");
        var channel = System.getenv("SLACK_CHANNEL_ID");

        var slack = Slack.getInstance();
        // var methods = slack.methods(token);
        var methods = slack.methodsAsync(token);
        var response = methods.chatPostMessage(req -> req.channel(channel).text("Hello, World!"));
        try {
            System.out.println(response.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}