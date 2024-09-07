package uz.pdp.online.botproject.utils;

import io.github.reflectframework.reflecttelegrambot.utils.markers.UserState;
import lombok.experimental.FieldNameConstants;

@FieldNameConstants(onlyExplicitlyIncluded = true)
public enum State implements UserState {
    @FieldNameConstants.Include INIT,
    @FieldNameConstants.Include SEND_PHONE,
    @FieldNameConstants.Include MAIN_MENU,
    @FieldNameConstants.Include PHONE_NUMBER_MENU,
    @FieldNameConstants.Include CHANGE_PHONE,
    @FieldNameConstants.Include CHANGE_LANGUAGE,
}
