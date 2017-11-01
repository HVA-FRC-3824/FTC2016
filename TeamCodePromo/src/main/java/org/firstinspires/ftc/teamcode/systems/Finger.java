public class Finger {

    private HvaHardwarePushbot bot;

    Finger(HvaHardwarePushbot ourBot){
        bot = ourBot;
    }

    setPositionOpen(boolean flag){
        if(flag == true){
            bot.leftFinger.setPosition(HvaHardwarePushbot.LEFT_FINGER_OPEN);
            bot.rightFinger.setPosition(HvaHardwarePushbot.RIGHT_FINGER_OPEN);
        }
        else{
            bot.leftFinger.setPosition(HvaHardwarePushbot.LEFT_FINGER_CLOSE);
            bot.rightFinger.setPosition(HvaHardwarePushbot.RIGHT_FINGER_CLOSE);
        }
    }
}