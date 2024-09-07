package uz.pdp.online.botproject.controllers;

import io.github.reflectframework.reflecttelegrambot.annotations.BotController;
import io.github.reflectframework.reflecttelegrambot.annotations.mappings.TextMapping;
import io.github.reflectframework.reflecttelegrambot.components.sender.Sender;
import io.github.reflectframework.reflecttelegrambot.entities.user.HashedUser;
import io.github.reflectframework.reflecttelegrambot.utils.markers.UserState;
import lombok.RequiredArgsConstructor;

import static uz.pdp.online.botproject.utils.Locale.UNKNOWN_OPTION;

@BotController
@RequiredArgsConstructor
public class ExceptionController {

    private final Sender sender;

    @TextMapping(regexp = "[\\w.-]*")
    public UserState exceptionHandler(HashedUser user) {
        sender.sendMessage(user, UNKNOWN_OPTION);
        return user.getState();
    }

}
