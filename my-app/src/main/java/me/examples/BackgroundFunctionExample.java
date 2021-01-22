package me.examples;

import java.util.logging.Logger;

import com.google.cloud.functions.BackgroundFunction;
import com.google.cloud.functions.Context;

public class BackgroundFunctionExample implements BackgroundFunction<Message> {

    private static final Logger logger = Logger.getLogger(BackgroundFunction.class.getName());

    @Override
    public void accept(Message message, Context context) throws Exception {
        logger.info(message.getMessageId());
    }
}
