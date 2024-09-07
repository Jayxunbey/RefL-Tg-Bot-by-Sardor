package uz.pdp.online.botproject.services.bot;

import io.github.reflectframework.reflecttelegrambot.components.sender.Sender;
import io.github.reflectframework.reflecttelegrambot.entities.user.HashedUser;
import io.github.reflectframework.reflecttelegrambot.utils.enums.KeyboardType;
import io.github.reflectframework.reflecttelegrambot.utils.markers.UserState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.online.botproject.services.UserService;
import uz.pdp.online.botproject.utils.Language;
import uz.pdp.online.botproject.utils.State;

import java.util.List;

import static uz.pdp.online.botproject.utils.Constant.BACK_TO_MAIN_MENU;
import static uz.pdp.online.botproject.utils.Constant.BACK_TO_SETTINGS;
import static uz.pdp.online.botproject.utils.Locale.*;


@Service
@RequiredArgsConstructor
public class MainMenuService {

    private final Sender sender;

    private final UserService userService;


    public UserState savePhoneAndShowMainMenu(HashedUser user, String phoneNumber) {
        userService.updatePhone(user, phoneNumber);
        sender.sendMessage(user, READY, KeyboardType.REMOVE);
        return State.MAIN_MENU;
    }



    public UserState showChangeLanguageMenu(HashedUser user) {
        sender.sendMessage(user, CHOOSE_ONE, List.of(List.of(LANGUAGE_EN), List.of(LANGUAGE_RU)));
        return State.CHANGE_LANGUAGE;
    }

    public UserState changeLanguage(HashedUser user, String data) {
        switch (data) {
            case LANGUAGE_EN -> userService.updateLanguage(user, Language.EN);
            case LANGUAGE_RU -> userService.updateLanguage(user, Language.RU);
        }

        return showContactMenu(user);
    }

    public UserState showContactMenu(HashedUser user) {
        sender.editMessageText(user, CHOOSE_ONE, List.of(List.of(MY_PHONE_NUMBER),
                List.of(BACK_TO_MAIN_MENU)));
        return State.PHONE_NUMBER_MENU;
    }

    public UserState showChangePhoneMenu(HashedUser user) {
        sender.deleteMessage(user);
        sender.sendMessage(user, CHANGE_PHONE_TITLE, KeyboardType.CONTACT_WITH_BACK);
        return State.CHANGE_PHONE;
    }



    public UserState showEditMainMenu(HashedUser user) {
        sender.editMessageText(user, CHOOSE_ONE, List.of(List.of(SEARCH_MODE,SETTINGS)));
        return State.MAIN_MENU;
    }
}
