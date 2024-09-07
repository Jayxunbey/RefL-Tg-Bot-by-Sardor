package uz.pdp.online.botproject.services.bot;

import io.github.reflectframework.reflecttelegrambot.components.sender.Sender;
import io.github.reflectframework.reflecttelegrambot.entities.user.HashedUser;
import io.github.reflectframework.reflecttelegrambot.utils.enums.KeyboardType;
import io.github.reflectframework.reflecttelegrambot.utils.extensions.Extension;
import io.github.reflectframework.reflecttelegrambot.utils.markers.UserState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
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
public class SettingsService {
    private final UserService userService;

    private final Sender sender;

    private final MessageSource messageSource;

    @Value("${bot.i18.key.back-button}")
    private String backButton;


}
