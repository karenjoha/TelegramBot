package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "loki_vargas_bot";
    public static final String TOKEN = "6606485191:AAGtIQAb9cuy4gTH7nUiCU-yiKNXcpsRPW0";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        // si escriben "hola" contesta ->
        if(getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Hackear la nevera", "step_1_btn"));

        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of( "Tomar una salchicha! +20 de fama", "step_2_btn",
                            "Tomas un percado! + 20 de fama", "step_2_btn",
                            "tirar la lata de pepinillos! + 20 de fama", "step_2_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of( "Hackear al boton aspirador", "step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of( "Enviar al robot aspirador a por comida! +30 de fama", "step_4_btn",
                            "Dar un paseo en el robot aspirador! + 30 de fama", "step_4_btn",
                            "Huir del robot aspirador! + 30 de fama", "step_4_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Ponerse la GoPro", "step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Lata de atun", "step_6_btn",
                            "Dormir una siesta" , "step_6_btn",
                            "Saltar por los tejados", "step_6_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_6_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackear la contraseña de la computadora", "step_7_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("siguiente", "step_8_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")){
            sendTextMessageAsync(FINAL_TEXT,
                    Map.of());
        }



    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}