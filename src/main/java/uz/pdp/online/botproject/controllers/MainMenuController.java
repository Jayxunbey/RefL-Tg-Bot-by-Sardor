package uz.pdp.online.botproject.controllers;

import io.github.reflectframework.reflecttelegrambot.annotations.BotController;
import io.github.reflectframework.reflecttelegrambot.annotations.mappings.CallbackQueryMapping;
import io.github.reflectframework.reflecttelegrambot.annotations.mappings.ContactMapping;
import io.github.reflectframework.reflecttelegrambot.annotations.mappings.TextMapping;
import io.github.reflectframework.reflecttelegrambot.entities.user.HashedUser;
import io.github.reflectframework.reflecttelegrambot.utils.markers.UserState;
import lombok.RequiredArgsConstructor;
import uz.pdp.online.botproject.services.bot.MainMenuService;
import uz.pdp.online.botproject.utils.Constant;
import uz.pdp.online.botproject.utils.State;

import static uz.pdp.online.botproject.utils.Locale.*;

@BotController
@RequiredArgsConstructor
public class MainMenuController {

    private final MainMenuService mainMenuService;
    @TextMapping(regexp = "/start", states = {State.Fields.INIT})
    public UserState showFirstStartMenu(HashedUser user) {
        return mainMenuService.showChangeLanguageMenu(user);
    }

    @TextMapping(regexp = "/start")
    public UserState savePhoneAndShowMainMenu(HashedUser user) {
        return mainMenuService.showChangeLanguageMenu(user);
    }

    @CallbackQueryMapping(dataRegexp = "(" + LANGUAGE_EN + "|" + LANGUAGE_RU + "+)", target = CallbackQueryMapping.CallbackQueryMappingTarget.QUERY_DATA)
    public UserState changeLanguage(HashedUser user, String data) {
        return mainMenuService.changeLanguage(user, data);
    }

    @ContactMapping(states = {State.Fields.SEND_PHONE}, target = ContactMapping.ContactMappingTarget.PHONE_NUMBER)
    public UserState savePhoneAndShowMainMenu(HashedUser user, String phoneNumber) {
        return mainMenuService.savePhoneAndShowMainMenu(user, phoneNumber);
    }
    @CallbackQueryMapping(dataRegexp = MY_PHONE_NUMBER)
    public UserState showChangePhoneMenu(HashedUser user) {
        return mainMenuService.showChangePhoneMenu(user);
    }

    @CallbackQueryMapping(dataRegexp = Constant.BACK_TO_MAIN_MENU, states = {State.Fields.PHONE_NUMBER_MENU})
    public UserState showMainMenu(HashedUser user) {
        return mainMenuService.showEditMainMenu(user);
    }

}
