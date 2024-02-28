package futureCode.pract3_5;

import javax.swing.SwingUtilities;

import futureCode.pract3_3.clicer;//👨‍💻🔧

public class clikkerRANGEclick extends clicer{//🛠️👩‍💻
    // public int ClicCount1=ClicCount;
    public void updateTEXTerr() {
        panel.setText("ОЧЕНЬ много кликов: " + ClicCount);
        clicButton.setText("🛠️");      
    }
    // public void updateClicCount(){
    //     int ClicCount1=ClicCount;
    // }
    // public void upp(){
    //     SwingUtilities.invokeLater(() -> {//🔄👀
    //         updateClicCount();
    //     });
    // }
    
    public void checkClickCount() {
        //int errCount = 7;🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍
            try {
                
                throw new ClikcException("Слишком много кликов");
             }catch (ClikcException e) {
                SwingUtilities.invokeLater(() -> {//🔄👀
                updateTEXTerr();
            });
            }
    }
    public static void main(String[] args) {   
        clikkerRANGEclick clikker = new clikkerRANGEclick();
        
        while (true) {
            // все я сдаюсь почему ты не работаешь бляяяя
            if (clikker.ClicCount>=7) {
                clikker.checkClickCount();
            }
        }   
    }
}