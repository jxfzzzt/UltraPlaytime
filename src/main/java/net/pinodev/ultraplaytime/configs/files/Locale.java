package net.pinodev.ultraplaytime.configs.files;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.function.Function;

import static net.pinodev.ultraplaytime.UltraPlaytime.langYML;
import static net.pinodev.ultraplaytime.UltraPlaytime.utilsManager;


public enum Locale {
    PREFIX(String.class, "prefix"),
    TIME_YEARS(String.class,"TimeFormat.years"),
    TIME_YEAR(String.class,"TimeFormat.year"),
    TIME_MONTHS(String.class,"TimeFormat.months"),
    TIME_MONTH(String.class,"TimeFormat.month"),
    TIME_DAYS(String.class,"TimeFormat.days"),
    TIME_DAY(String.class,"TimeFormat.day"),
    TIME_HOURS(String.class,"TimeFormat.hours"),
    TIME_HOUR(String.class,"TimeFormat.hour"),
    TIME_MINUTES(String.class,"TimeFormat.minutes"),
    TIME_MINUTE(String.class,"TimeFormat.minute"),
    TIME_SECONDS(String.class,"TimeFormat.seconds"),
    TIME_SECOND(String.class,"TimeFormat.second"),
    PLAYER_PLAYTIME(List.class, "playerMessages.playtime"),
    TOP_PLAYERS(List.class,"playerMessages.topPlayers"),
    TARGET_PLAYTIME(List.class,"playerMessages.targetPlaytime"),
    TARGET_NOT_FOUND(String.class,"playerMessages.targetNotFound"),
    TIME_NEXT_REWARD(List.class,"playerMessages.timeToNextReward"),
    NO_MORE_REWARDS(String.class,"playerMessages.noRewardAvailable"),
    GENERAL_ERROR(String.class,"adminMessages.error"),
    RELOADED_FILE(String.class,"adminMessages.fileReloaded"),
    INVALID_COMMAND(String.class,"playerMessages.invalidCommand"),
    HELP_LIST(List.class, "adminMessages.help"),
    SET_TIME(String.class,"adminMessages.setTime"),
    SET_REWARD(String.class,"adminMessages.setReward"),
    NOT_NUMBER(String.class,"adminMessages.notANumber"),
    NO_PERMISSION(String.class,"playerMessages.noPermission"),
    ADDED_LEADERBOARD_IGNORED(String.class,"adminMessages.leaderboard.addedIgnoredUser"),
    REMOVED_LEADERBOARD_IGNORED(String.class,"adminMessages.leaderboard.removedIgnoredUser");





    public final String key;
    public final Class<?> type;

    Locale(Class<?> type, String key) {
        this.key = key;
        this.type = type;
    }

    public String getString() {
        return langYML.getFileConfiguration().getString(key);
    }

    public List<String> getStringList(){
        return langYML.getFileConfiguration().getStringList(key);
    }

    public String getStripped(){
        String text =  langYML.getFileConfiguration().getString(key);
        text = text.replaceAll("&", "§");
        return ChatColor.stripColor(text);
    }

    public String getColorized(){
        final String message = langYML.getFileConfiguration().getString(key);
        return utilsManager.message.colorized(message);
    }

    public ConfigurationSection getConfigurationSection(){
        return langYML.getFileConfiguration().getConfigurationSection(key);
    }
}
