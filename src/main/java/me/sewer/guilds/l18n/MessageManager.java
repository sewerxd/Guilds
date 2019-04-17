package me.sewer.guilds.l18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class MessageManager {

    private final Map<Locale, MessageMap> localeMap = new HashMap<>();
    private final Locale ballback;

    public MessageManager(Locale ballback) {
        this.ballback = ballback;
    }

    public void registerLocale(MessageMap messageMap) {
        this.localeMap.put(messageMap.getLocale(), messageMap);
    }

    public void unregisterLocale(MessageMap messageMap) {
        this.localeMap.remove(messageMap.getLocale());
    }

    public Optional<MessageMap> getMessage(Locale locale) {
        return Optional.ofNullable(this.localeMap.get(locale));
    }

    public Map<Locale, MessageMap> getLocaleMap() {
        return this.localeMap;
    }

    public Locale getBallback() {
        return this.ballback;
    }
}