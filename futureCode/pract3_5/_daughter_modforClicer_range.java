package futureCode.pract3_5;

//import javax.swing.SwingUtilities;
import futureCode.pract3_3.clicer;//👨‍💻🔧
public class _daughter_modforClicer_range extends clicer{//🛠️👩‍💻
    // // public int ClicCount1=ClicCount;
    // public void updateTEXTerr() {
    //     panel.setText("ОЧЕНЬ много кликов: " + ClicCount);
    //     clicButton.setText("🛠️");      
    // }
    // // public void updateClicCount(){
    // //     int ClicCount1=ClicCount;
    // // }
    // // public void upp(){
    // //     SwingUtilities.invokeLater(() -> {//🔄👀
    // //         updateClicCount();
    // //     });
    // // }
    
    // public void checkClickCount() {
    //     //int errCount = 7;🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍🕵️‍♂️🔍
    //         try {
                
    //             throw new ClikcException("Слишком много кликов");
    //          }catch (ClikcException e) {
    //             SwingUtilities.invokeLater(() -> {//🔄👀
    //             updateTEXTerr();
    //         });
    //         }
    // }
        public int maxClic = 7;
    public void updateTEXT() {
        try{
            if (ClicCount>=maxClic) {
                throw new ClikcException("Слишком много кликов");
            }
        panel.setText("результат : " + ClicCount);
        clicButton.setText("" + ClicCount);
        }catch(ClikcException a){
            panel.setText("ОЧЕНЬ много кликов: " + ClicCount);
            clicButton.setText("🛠️");
            clicButton.removeMouseListener(adapter);
        }
    }
    public static void main(String[] args) {   
        _daughter_modforClicer_range clikker = new _daughter_modforClicer_range();
        
        // while (true) {
        //     // все я сдаюсь почему ты не работаешь
        //     if (clikker.ClicCount>=7) {
        //         clikker.checkClickCount();
        //     }
        // }   
    }
}