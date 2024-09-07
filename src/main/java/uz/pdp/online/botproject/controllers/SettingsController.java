package uz.pdp.online.botproject.controllers;

import io.github.reflectframework.reflecttelegrambot.annotations.BotController;
import io.github.reflectframework.reflecttelegrambot.annotations.mappings.CallbackQueryMapping;
import io.github.reflectframework.reflecttelegrambot.annotations.mappings.ContactMapping;
import io.github.reflectframework.reflecttelegrambot.annotations.mappings.TextMapping;
import io.github.reflectframework.reflecttelegrambot.entities.user.HashedUser;
import io.github.reflectframework.reflecttelegrambot.utils.markers.UserState;
import lombok.RequiredArgsConstructor;
import uz.pdp.online.botproject.services.bot.SettingsService;
import uz.pdp.online.botproject.utils.State;

import static uz.pdp.online.botproject.utils.Constant.BACK_TO_SETTINGS;
import static uz.pdp.online.botproject.utils.Locale.*;


@BotController
@RequiredArgsConstructor
public class SettingsController {

    private final SettingsService settingsService;



}
