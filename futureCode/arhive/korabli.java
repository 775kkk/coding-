package futureCode.arhive;
import java.util.Random;
import java.util.Scanner;
public class korabli {
    //инициализ поля
    public static void InitializationField(char[][] field){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j]='0';
            }
        }
    }
    //вывод поля
    public static void printField(char[][] field){
            for (int i = 0; i <10; i++) {
                for (int j = 0; j <10; j++) {
                    System.out.print(field[i][j]+" ");
                }
                System.out.println();
            }
        }
    /*//проверка занятости
    public static boolean isCellEmpty(int row, int col, char[][] field){
        return field[row][col]=='0';}
        */
        
        //размещение кор
        public static void SpawnShip(int longShip, char[][] field){
            Random random = new Random();
            int randomROWpozSHIP = random.nextInt(10);
            int randomCOLpozSHIP = random.nextInt(10);
            int randomBountDVA = random.nextInt(2);// сделал эту и переменные ниже когда понял что просто random.nextInt(3)==0 и random.nextInt(3)==1 могут быть выполнены вместе...
            int randomBountTRI = random.nextInt(3);//понял что зря сделал randomBountDVA...
            int randomBountCHETblRE = random.nextInt(3);
            if (longShip==1) {
                if (field[randomROWpozSHIP][randomCOLpozSHIP]=='0') {
                    field[randomROWpozSHIP][randomCOLpozSHIP]=1;
                }
                else{SpawnShip(longShip, field);}
            }
            if (longShip==2) {
                if (field[randomROWpozSHIP][randomCOLpozSHIP]=='0') {
                    if (randomROWpozSHIP == 9) {
                        if (randomCOLpozSHIP ==9) {
                            if (randomBountDVA==0) {
                                if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                    field[randomROWpozSHIP-1][randomCOLpozSHIP]=2;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-1]=2;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }
                        if (randomCOLpozSHIP==0) {
                            if (random.nextInt(2)==0) {// не буду здесь ставить randomBountDVA тк вродебы и так норм...
                                if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                    field[randomROWpozSHIP-1][randomCOLpozSHIP]=2;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }//ой не запутаться быы
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+1]=2;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }
                        else if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP][randomCOLpozSHIP-1]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==1) {//додумался до else if
                            if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP][randomCOLpozSHIP+1]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                    }
                    if (randomROWpozSHIP == 0) {
                        if (randomCOLpozSHIP ==9) {
                            if (random.nextInt(2)==0) {
                                if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                    field[randomROWpozSHIP+1][randomCOLpozSHIP]=2;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-1]=2;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }
                        if (randomCOLpozSHIP==0) {
                            if (random.nextInt(2)==0) {
                                if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                    field[randomROWpozSHIP+1][randomCOLpozSHIP]=2;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }//ой не запутаться быы
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+1]=2;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }
                        else if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP][randomCOLpozSHIP+1]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==1) {
                            if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP][randomCOLpozSHIP-1]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                    }
                    else if (randomCOLpozSHIP==9) {
                        if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP-1][randomCOLpozSHIP]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==1) {
                            if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP][randomCOLpozSHIP-1]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                    }}
                    else if (randomCOLpozSHIP==0){
                        if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP][randomCOLpozSHIP+1]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==1) {
                            if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP-1][randomCOLpozSHIP]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=2;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                    }
                    else if (randomBountCHETblRE==0){
                        if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                            field[randomROWpozSHIP+1][randomCOLpozSHIP]=2;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                    else if (randomBountCHETblRE==1){
                        if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                            field[randomROWpozSHIP-1][randomCOLpozSHIP]=2;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                    else if (randomBountCHETblRE==2){
                        if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                            field[randomROWpozSHIP][randomCOLpozSHIP+1]=2;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                    else if (randomBountCHETblRE==3){
                        if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=2;
                            field[randomROWpozSHIP][randomCOLpozSHIP-1]=2;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                }
                else{SpawnShip(longShip, field);}
            }
            if (longShip==3) {
                if (field[randomROWpozSHIP][randomCOLpozSHIP]=='0') {
                    if (randomROWpozSHIP == 9 || randomROWpozSHIP==8) {
                        if (randomCOLpozSHIP ==9 || randomCOLpozSHIP ==8) {
                            if (randomBountDVA==0) {
                                if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-2][randomCOLpozSHIP]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP-1][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP-2][randomCOLpozSHIP]=3;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-1]=3;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-2]=3;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }
                        if (randomCOLpozSHIP==0 || randomCOLpozSHIP ==1) {
                            if (random.nextInt(2)==0) {// не буду здесь ставить randomBountDVA тк вродебы и так норм...
                                if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-2][randomCOLpozSHIP]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP-1][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP-2][randomCOLpozSHIP]=3;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }//ой не запутаться быы
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+1]=3;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+2]=3;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }                       
                        else if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0' ) {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP][randomCOLpozSHIP-1]=3;//удобнее было бы если бы вместо 3 просто longShip поставил...
                                field[randomROWpozSHIP][randomCOLpozSHIP-2]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==1) {//додумался до else if
                            if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP][randomCOLpozSHIP+1]=3;
                                field[randomROWpozSHIP][randomCOLpozSHIP+2]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0'  && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP+2][randomCOLpozSHIP]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                    }
                    if (randomROWpozSHIP == 0 || randomROWpozSHIP==1) {
                        if (randomCOLpozSHIP ==9 || randomCOLpozSHIP==8) {
                            if (random.nextInt(2)==0) {
                                if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0' ) {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP+1][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP+2][randomCOLpozSHIP]=3;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-1]=3;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-2]=3;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }
                        if (randomCOLpozSHIP==0 || randomCOLpozSHIP==1) {
                            if (random.nextInt(2)==0) {
                                if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP+1][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP+2][randomCOLpozSHIP]=3;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }//ой не запутаться быы
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+1]=3;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+2]=3;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }
                        else if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP][randomCOLpozSHIP+1]=3;
                                field[randomROWpozSHIP][randomCOLpozSHIP+2]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==1) {
                            if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP][randomCOLpozSHIP-1]=3;
                                field[randomROWpozSHIP][randomCOLpozSHIP-2]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP+2][randomCOLpozSHIP]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                    }
                    else if (randomCOLpozSHIP==9 || randomCOLpozSHIP ==8) {
                        if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-2][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP-1][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP-2][randomCOLpozSHIP]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==1) {
                            if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP][randomCOLpozSHIP-1]=3;
                                field[randomROWpozSHIP][randomCOLpozSHIP-2]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP+2][randomCOLpozSHIP]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                    }}
                    else if (randomCOLpozSHIP==0 || randomCOLpozSHIP == 1){
                        if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP][randomCOLpozSHIP+1]=3;
                                field[randomROWpozSHIP][randomCOLpozSHIP+2]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==1) {
                            if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-2][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP-1][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP-2][randomCOLpozSHIP]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=3;
                                field[randomROWpozSHIP+2][randomCOLpozSHIP]=3;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                    }
                    else if (randomBountCHETblRE==0){
                        if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                            field[randomROWpozSHIP+1][randomCOLpozSHIP]=3;
                            field[randomROWpozSHIP+2][randomCOLpozSHIP]=3;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                    else if (randomBountCHETblRE==1){
                        if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-2][randomCOLpozSHIP]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                            field[randomROWpozSHIP-1][randomCOLpozSHIP]=3;
                            field[randomROWpozSHIP-2][randomCOLpozSHIP]=3;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                    else if (randomBountCHETblRE==2){
                        if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                            field[randomROWpozSHIP][randomCOLpozSHIP+1]=3;
                            field[randomROWpozSHIP][randomCOLpozSHIP+2]=3;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                    else if (randomBountCHETblRE==3){
                        if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=3;
                            field[randomROWpozSHIP][randomCOLpozSHIP-1]=3;
                            field[randomROWpozSHIP][randomCOLpozSHIP-2]=3;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                }
                else{SpawnShip(longShip, field);}
            }
            if (longShip==4) {
                if (field[randomROWpozSHIP][randomCOLpozSHIP]=='0') {
                    if (randomROWpozSHIP == 9 || randomROWpozSHIP==8 || randomROWpozSHIP==7) {
                        if (randomCOLpozSHIP ==9 || randomCOLpozSHIP ==8 || randomCOLpozSHIP ==7) {
                            if (randomBountDVA==0) {
                                if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-3][randomCOLpozSHIP]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP-1][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP-2][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP-3][randomCOLpozSHIP]=4;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-3]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-1]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-2]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-3]=4;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }
                        if (randomCOLpozSHIP==0 || randomCOLpozSHIP ==1 || randomCOLpozSHIP==2) {
                            if (random.nextInt(2)==0) {//я пришел к выводу что что в кол0 что в кол2 корабль будет вести себя как в углу... ну пришел к выводу давно, так действую с самого начала почти
                                if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-3][randomCOLpozSHIP]=='0'){
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP-1][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP-2][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP-3][randomCOLpozSHIP]=4;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }//ой не запутаться быы          спокойно уже привык
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+3]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+1]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+2]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+3]=4;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }                       
                        else if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-3]=='0' ) {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP-1]=4;//удобнее было бы если бы вместо 3 просто longShip поставил...
                                field[randomROWpozSHIP][randomCOLpozSHIP-2]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP-4]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==1) {
                            if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+3]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP+1]=4;//задумался что я типу char присваиваю число...
                                field[randomROWpozSHIP][randomCOLpozSHIP+2]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP+3]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0'  && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+3][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+2][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+3][randomCOLpozSHIP]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                    }
                    if (randomROWpozSHIP == 0 || randomROWpozSHIP==1 || randomROWpozSHIP==3) {
                        if (randomCOLpozSHIP ==9 || randomCOLpozSHIP==8 || randomCOLpozSHIP==7) {
                            if (random.nextInt(2)==0) {
                                if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+3][randomCOLpozSHIP]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP+1][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP+2][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP+3][randomCOLpozSHIP]=4;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-3]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-1]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-2]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP-3]=4;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }
                        if (randomCOLpozSHIP==0 || randomCOLpozSHIP==1 || randomCOLpozSHIP==3) {
                            if (random.nextInt(2)==0) {
                                if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+3][randomCOLpozSHIP]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP+1][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP+2][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP+3][randomCOLpozSHIP]=4;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                            else {
                                if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+3]=='0') {
                                    field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+1]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+2]=4;
                                    field[randomROWpozSHIP][randomCOLpozSHIP+3]=4;
                                }
                                else{
                                    SpawnShip(longShip, field);
                                }
                            }
                        }
                        else if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+3]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP+1]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP+2]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP+3]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==1) {
                            if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-3]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP-1]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP-2]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP-3]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        else if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+3][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+2][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+3][randomCOLpozSHIP]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                    }
                    else if (randomCOLpozSHIP==9 || randomCOLpozSHIP ==8 || randomCOLpozSHIP==7) {
                        if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-3][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP-1][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP-2][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP-3][randomCOLpozSHIP]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==1) {
                            if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-3]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP-1]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP-2]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP-3]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+3][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+2][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+3][randomCOLpozSHIP]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                    }}
                    else if (randomCOLpozSHIP==0 || randomCOLpozSHIP == 1 || randomCOLpozSHIP == 2){
                        if (randomBountTRI==0){// это и подобные рандомы - рандомы вариаций размещения кораблей...
                            if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+3]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP+1]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP+2]=4;
                                field[randomROWpozSHIP][randomCOLpozSHIP+3]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==1) {
                            if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-3][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP-1][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP-2][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP-3][randomCOLpozSHIP]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                        if (randomBountTRI==2) {
                            if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+3][randomCOLpozSHIP]=='0') {
                                field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+1][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+2][randomCOLpozSHIP]=4;
                                field[randomROWpozSHIP+3][randomCOLpozSHIP]=4;
                            }
                            else{
                                SpawnShip(longShip, field);
                            }
                        }
                    }
                    else if (randomBountCHETblRE==0){
                        if (field[randomROWpozSHIP+1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP+3][randomCOLpozSHIP]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                            field[randomROWpozSHIP+1][randomCOLpozSHIP]=4;
                            field[randomROWpozSHIP+2][randomCOLpozSHIP]=4;
                            field[randomROWpozSHIP+3][randomCOLpozSHIP]=4;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                    else if (randomBountCHETblRE==1){
                        if (field[randomROWpozSHIP-1][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-2][randomCOLpozSHIP]=='0' && field[randomROWpozSHIP-3][randomCOLpozSHIP]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                            field[randomROWpozSHIP-1][randomCOLpozSHIP]=4;
                            field[randomROWpozSHIP-2][randomCOLpozSHIP]=4;
                            field[randomROWpozSHIP-3][randomCOLpozSHIP]=4;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                    else if (randomBountCHETblRE==2){
                        if (field[randomROWpozSHIP][randomCOLpozSHIP+1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP+3]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                            field[randomROWpozSHIP][randomCOLpozSHIP+1]=4;
                            field[randomROWpozSHIP][randomCOLpozSHIP+2]=4;
                            field[randomROWpozSHIP][randomCOLpozSHIP+3]=4;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                    else if (randomBountCHETblRE==3){
                        if (field[randomROWpozSHIP][randomCOLpozSHIP-1]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-2]=='0' && field[randomROWpozSHIP][randomCOLpozSHIP-3]=='0') {
                            field[randomROWpozSHIP][randomCOLpozSHIP]=4;
                            field[randomROWpozSHIP][randomCOLpozSHIP-1]=4;
                            field[randomROWpozSHIP][randomCOLpozSHIP-2]=4;
                            field[randomROWpozSHIP][randomCOLpozSHIP-3]=4;
                        }
                        else{
                            SpawnShip(longShip, field);
                        }
                    }
                }
                else{SpawnShip(longShip, field);}
            }   
        // ee доделал, впервые работаю с такими массивными условиями.
        // в углах и при стенках корабли можно было поставить только двуми и тремя способами соответственно, а вдали от стенок на опр расстоянии у них было 4 вариации... сейчас я понимаю что с увелиением палуб коробля расширяются сами стенки и углы для них , а так все одно и то же
        }
    //инициализация кораблей да можно было просто код из этой функции запихать в инициализацию поля... 
    public static void ShipInitialization(char[][] field){
        SpawnShip(1, field);
        SpawnShip(2, field);
        SpawnShip(3, field);
        SpawnShip(4, field);
    }
    public static void TrueCompShot(int ROWmoveComp,int COLmoveComp,char[][] field,int CountMediumShip,int CountBigShip,int CountBiggestShip, int CountMiniShip){
/* Структура этой функции :
 * Это вспомогательная рекурсивная функция, которая будет вносить втрую и поледующие изменения на поле, опираясь на уже сделанный ход.
 * Здесь я опять рассмотрю углы и стены для каждого хода, чтобы компьютер ходил в пределах поля
 * а также опишу одз для следующего изменения на поле(выстрела), чтобы компьютер ходил случайно в определенном радиусе
 */
        Random random = new Random();
        //int randomShotCOMP = random.nextInt(8);
        if (ROWmoveComp == 9) {
            if (COLmoveComp==9) {
                if (random.nextInt(3)==0) {// 0:0
                    if (field[ROWmoveComp-1][COLmoveComp-1]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp-1][COLmoveComp-1]='*';
                    }
                    if (field[ROWmoveComp-1][COLmoveComp-1]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp-1][COLmoveComp-1]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp-1][COLmoveComp-1]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp-1][COLmoveComp-1]='X';
                        if (CountMediumShip==2) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field,CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp-1]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp-1][COLmoveComp-1]='X';
                        if (CountBigShip==3) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip,CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp-1]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp-1][COLmoveComp-1]='X';
                        if (CountBiggestShip==4) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp-1]=='*'|| field[ROWmoveComp-1][COLmoveComp-1]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                else if(random.nextInt(3)==1){//0:1
                    if (field[ROWmoveComp-1][COLmoveComp]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp-1][COLmoveComp]='*';
                    }
                    if (field[ROWmoveComp-1][COLmoveComp]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp-1][COLmoveComp]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp-1][COLmoveComp]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp-1][COLmoveComp]='X';
                        if(CountMediumShip==2){
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp-1][COLmoveComp]='X';
                        if(CountBigShip==3){
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp-1][COLmoveComp]='X';
                        if(CountBiggestShip==4){
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else {
                            TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp]=='*'|| field[ROWmoveComp-1][COLmoveComp]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                else if(random.nextInt(3)==2){//1:0
                    if (field[ROWmoveComp][COLmoveComp-1]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp][COLmoveComp-1]='*';
                    }
                    if (field[ROWmoveComp][COLmoveComp-1]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp][COLmoveComp-1]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp][COLmoveComp-1]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp][COLmoveComp-1]='X';
                        if (CountMediumShip==2) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp-1]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp][COLmoveComp-1]='X';
                        if (CountBigShip==3) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp-1]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp][COLmoveComp-1]='X';
                        if (CountBiggestShip==4) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp-1]=='*'|| field[ROWmoveComp][COLmoveComp-1]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
            }
            if (COLmoveComp==0) {
                if (random.nextInt(3)==0) {//0:1
                    if (field[ROWmoveComp-1][COLmoveComp]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp-1][COLmoveComp]='*';
                    }
                    if (field[ROWmoveComp-1][COLmoveComp]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp-1][COLmoveComp]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp-1][COLmoveComp]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp-1][COLmoveComp]='X';
                        if(CountMediumShip==2){
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp-1][COLmoveComp]='X';
                        if(CountBigShip==3){
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp-1][COLmoveComp]='X';
                        if(CountBiggestShip==4){
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else {
                            TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp]=='*'|| field[ROWmoveComp-1][COLmoveComp]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                else if(random.nextInt(3)==1){//0:2
                    if (field[ROWmoveComp-1][COLmoveComp+1]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp-1][COLmoveComp+1]='*';
                    }
                    if (field[ROWmoveComp-1][COLmoveComp+1]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp-1][COLmoveComp+1]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp-1][COLmoveComp+1]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp-1][COLmoveComp+1]='X';
                        if(CountMediumShip==2){
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp+1]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp-1][COLmoveComp]='X';
                        if(CountBigShip==3){
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp+1]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp-1][COLmoveComp]='X';
                        if(CountBiggestShip==4){
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp-1][COLmoveComp+1]=='*' || field[ROWmoveComp-1][COLmoveComp+1]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                else if(random.nextInt(3)==2){//1:2
                    if (field[ROWmoveComp][COLmoveComp+1]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp][COLmoveComp+1]='*';
                    }
                    if (field[ROWmoveComp][COLmoveComp+1]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp][COLmoveComp+1]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp][COLmoveComp+1]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp][COLmoveComp+1]='X';
                        if (CountMediumShip==2) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                        TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp+1]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp][COLmoveComp+1]='X';
                        if (CountBigShip==3) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp+1]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp][COLmoveComp+1]='X';
                        if (CountBiggestShip==4) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp+1]=='*' || field[ROWmoveComp][COLmoveComp+1]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
            }
            else if (random.nextInt(5)==0) {//1:0
                if (field[ROWmoveComp][COLmoveComp-1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp][COLmoveComp-1]='*';
                }
                if (field[ROWmoveComp][COLmoveComp-1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp][COLmoveComp-1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp-1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp-1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp-1]=='*'|| field[ROWmoveComp][COLmoveComp-1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==1) {//0:0
                if (field[ROWmoveComp-1][COLmoveComp-1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp-1][COLmoveComp-1]='*';
                }
                if (field[ROWmoveComp-1][COLmoveComp-1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp-1][COLmoveComp-1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp-1][COLmoveComp-1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp-1][COLmoveComp-1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp-1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp-1][COLmoveComp-1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp-1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp-1][COLmoveComp-1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp-1]=='*'|| field[ROWmoveComp-1][COLmoveComp-1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==2) {//0:1
                if (field[ROWmoveComp-1][COLmoveComp]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp-1][COLmoveComp]='*';
                }
                if (field[ROWmoveComp-1][COLmoveComp]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp-1][COLmoveComp]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountMediumShip==2){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountBigShip==3){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountBiggestShip==4){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else {
                        TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp]=='*'|| field[ROWmoveComp-1][COLmoveComp]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==3) {//0:2
                if (field[ROWmoveComp-1][COLmoveComp+1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp-1][COLmoveComp+1]='*';
                }
                if (field[ROWmoveComp-1][COLmoveComp+1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp-1][COLmoveComp+1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp-1][COLmoveComp+1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp-1][COLmoveComp+1]='X';
                    if(CountMediumShip==2){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp+1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountBigShip==3){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp+1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountBiggestShip==4){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp+1]=='*'|| field[ROWmoveComp-1][COLmoveComp+1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==4) {//1:2
                if (field[ROWmoveComp][COLmoveComp+1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp][COLmoveComp+1]='*';
                }
                if (field[ROWmoveComp][COLmoveComp+1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp][COLmoveComp+1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                    TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp+1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp+1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp+1]=='*'|| field[ROWmoveComp][COLmoveComp+1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
        }
        if (ROWmoveComp == 0) {
            if (COLmoveComp==9) {
                if (random.nextInt(3)==0) {//1:0
                    if (field[ROWmoveComp][COLmoveComp-1]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp][COLmoveComp-1]='*';
                    }
                    if (field[ROWmoveComp][COLmoveComp-1]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp][COLmoveComp-1]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp][COLmoveComp-1]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp][COLmoveComp-1]='X';
                        if (CountMediumShip==2) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp-1]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp][COLmoveComp-1]='X';
                        if (CountBigShip==3) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp-1]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp][COLmoveComp-1]='X';
                        if (CountBiggestShip==4) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp-1]=='*'|| field[ROWmoveComp][COLmoveComp-1]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                else if(random.nextInt(3)==1){//2:0
                    if (field[ROWmoveComp+1][COLmoveComp-1]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp+1][COLmoveComp-1]='*';
                    }
                    if (field[ROWmoveComp+1][COLmoveComp-1]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp+1][COLmoveComp-1]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp+1][COLmoveComp-1]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp+1][COLmoveComp-1]='X';
                        if (CountMediumShip==2) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp-1]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp+1][COLmoveComp-1]='X';
                        if (CountBigShip==3) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp-1]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp+1][COLmoveComp-1]='X';
                        if (CountBiggestShip==4) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp-1]=='*'|| field[ROWmoveComp+1][COLmoveComp-1]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                else if(random.nextInt(3)==2){//2:1
                    if (field[ROWmoveComp+1][COLmoveComp]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp+1][COLmoveComp]='*';
                    }
                    if (field[ROWmoveComp+1][COLmoveComp]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp+1][COLmoveComp]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp+1][COLmoveComp]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp+1][COLmoveComp]='X';
                        if (CountMediumShip==2) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp+1][COLmoveComp]='X';
                        if (CountBigShip==3) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp+1][COLmoveComp]='X';
                        if (CountBiggestShip==4) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp]=='*' || field[ROWmoveComp+1][COLmoveComp]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
            }
            if (COLmoveComp==0) {
                if (random.nextInt(3)==0) {//1:2
                    if (field[ROWmoveComp][COLmoveComp+1]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp][COLmoveComp+1]='*';
                    }
                    if (field[ROWmoveComp][COLmoveComp+1]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp][COLmoveComp+1]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp][COLmoveComp+1]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp][COLmoveComp+1]='X';
                        if (CountMediumShip==2) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                        TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp+1]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp][COLmoveComp+1]='X';
                        if (CountBigShip==3) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp+1]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp][COLmoveComp+1]='X';
                        if (CountBiggestShip==4) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp][COLmoveComp+1]=='*' || field[ROWmoveComp][COLmoveComp+1]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                else if(random.nextInt(3)==1){//2:2
                    if (field[ROWmoveComp+1][COLmoveComp+1]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp+1][COLmoveComp+1]='*';
                    }
                    if (field[ROWmoveComp+1][COLmoveComp+1]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp+1][COLmoveComp+1]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp+1][COLmoveComp+1]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp+1][COLmoveComp+1]='X';
                        if (CountMediumShip==2) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp+1]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp+1][COLmoveComp+1]='X';
                        if (CountBigShip==3) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp+1]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp+1][COLmoveComp+1]='X';
                        if (CountBiggestShip==4) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp+1]=='*'|| field[ROWmoveComp+1][COLmoveComp+1]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                else if(random.nextInt(3)==2){//2:1
                    if (field[ROWmoveComp+1][COLmoveComp]=='0') {
                        System.out.println("Компьютер промахнулся после попадания");
                        field[ROWmoveComp+1][COLmoveComp]='*';
                    }
                    if (field[ROWmoveComp+1][COLmoveComp]==1) {
                        System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                        field[ROWmoveComp+1][COLmoveComp]='X';
                        CountMiniShip++;
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    if (field[ROWmoveComp+1][COLmoveComp]==2) {
                        System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                        CountMediumShip++;
                        field[ROWmoveComp+1][COLmoveComp]='X';
                        if (CountMediumShip==2) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp]==3) {
                        System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                        CountBigShip++;
                        field[ROWmoveComp+1][COLmoveComp]='X';
                        if (CountBigShip==3) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp]==4) {
                        System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                        CountBiggestShip++;
                        field[ROWmoveComp+1][COLmoveComp]='X';
                        if (CountBiggestShip==4) {
                            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                        }
                        else{
                            TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                        }
                    }
                    if (field[ROWmoveComp+1][COLmoveComp]=='*'|| field[ROWmoveComp+1][COLmoveComp]=='X') {
                        TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
            }
            else if (random.nextInt(5)==0) {//1:0
                if (field[ROWmoveComp][COLmoveComp-1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp][COLmoveComp-1]='*';
                }
                if (field[ROWmoveComp][COLmoveComp-1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp][COLmoveComp-1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp-1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp-1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp-1]=='*' || field[ROWmoveComp][COLmoveComp-1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==1) {//2:0
                if (field[ROWmoveComp+1][COLmoveComp-1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp+1][COLmoveComp-1]='*';
                }
                if (field[ROWmoveComp+1][COLmoveComp-1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp+1][COLmoveComp-1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp+1][COLmoveComp-1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp+1][COLmoveComp-1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp-1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp+1][COLmoveComp-1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp-1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp+1][COLmoveComp-1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp-1]=='*'|| field[ROWmoveComp+1][COLmoveComp-1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==2) {//2:1
                if (field[ROWmoveComp+1][COLmoveComp]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp+1][COLmoveComp]='*';
                }
                if (field[ROWmoveComp+1][COLmoveComp]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp+1][COLmoveComp]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp]=='*'|| field[ROWmoveComp+1][COLmoveComp]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==3) {//2:2
                if (field[ROWmoveComp+1][COLmoveComp+1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp+1][COLmoveComp+1]='*';
                }
                if (field[ROWmoveComp+1][COLmoveComp+1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp+1][COLmoveComp+1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp+1][COLmoveComp+1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp+1][COLmoveComp+1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp+1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp+1][COLmoveComp+1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp+1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp+1][COLmoveComp+1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp+1]=='*' || field[ROWmoveComp+1][COLmoveComp+1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==4) {//1:2
                if (field[ROWmoveComp][COLmoveComp+1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp][COLmoveComp+1]='*';
                }
                if (field[ROWmoveComp][COLmoveComp+1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field,CountMiniShip);
                }
                if (field[ROWmoveComp][COLmoveComp+1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field,CountMiniShip);
                    }
                    else{
                    TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip,CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp+1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field,CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip,CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp+1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field,CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip,CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp+1]=='*'|| field[ROWmoveComp][COLmoveComp+1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip,CountMiniShip);
                }
            }
        }
        else if (COLmoveComp==9) {
            if (random.nextInt(5)==0) {//0:1
                if (field[ROWmoveComp-1][COLmoveComp]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp-1][COLmoveComp]='*';
                }
                if (field[ROWmoveComp-1][COLmoveComp]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp-1][COLmoveComp]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountMediumShip==2){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountBigShip==3){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountBiggestShip==4){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else {
                        TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp]=='*'|| field[ROWmoveComp-1][COLmoveComp]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==1) {//0:0
                if (field[ROWmoveComp-1][COLmoveComp-1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp-1][COLmoveComp-1]='*';
                }
                if (field[ROWmoveComp-1][COLmoveComp-1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp-1][COLmoveComp-1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field,CountMiniShip);
                }
                if (field[ROWmoveComp-1][COLmoveComp-1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp-1][COLmoveComp-1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field,CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip,CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp-1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp-1][COLmoveComp-1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field,CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip,CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp-1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp-1][COLmoveComp-1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field,CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip,CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp-1]=='*'|| field[ROWmoveComp-1][COLmoveComp-1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==2) {//1:0
                if (field[ROWmoveComp][COLmoveComp-1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp][COLmoveComp-1]='*';
                }
                if (field[ROWmoveComp][COLmoveComp-1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp][COLmoveComp-1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp-1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp-1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp][COLmoveComp-1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp-1]=='*'|| field[ROWmoveComp][COLmoveComp-1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==3) {//2:0
                if (field[ROWmoveComp+1][COLmoveComp-1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp+1][COLmoveComp-1]='*';
                }
                if (field[ROWmoveComp+1][COLmoveComp-1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp+1][COLmoveComp-1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp+1][COLmoveComp-1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp+1][COLmoveComp-1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp-1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp+1][COLmoveComp-1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp-1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp+1][COLmoveComp-1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp-1]=='*' || field[ROWmoveComp+1][COLmoveComp-1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==4) {//2:1
                if (field[ROWmoveComp+1][COLmoveComp]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp+1][COLmoveComp]='*';
                }
                if (field[ROWmoveComp+1][COLmoveComp]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp+1][COLmoveComp]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp]=='*' || field[ROWmoveComp+1][COLmoveComp]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
        }
        else if (COLmoveComp==0) {
            if (random.nextInt(5)==0) {//0:1
                if (field[ROWmoveComp-1][COLmoveComp]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp-1][COLmoveComp]='*';
                }
                if (field[ROWmoveComp-1][COLmoveComp]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp-1][COLmoveComp]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountMediumShip==2){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountBigShip==3){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountBiggestShip==4){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else {
                        TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp]=='*'|| field[ROWmoveComp-1][COLmoveComp]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==1) {//0:2
                if (field[ROWmoveComp-1][COLmoveComp+1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp-1][COLmoveComp+1]='*';
                }
                if (field[ROWmoveComp-1][COLmoveComp+1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp-1][COLmoveComp+1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp-1][COLmoveComp+1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp-1][COLmoveComp+1]='X';
                    if(CountMediumShip==2){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp+1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountBigShip==3){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp+1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp-1][COLmoveComp]='X';
                    if(CountBiggestShip==4){
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp-1][COLmoveComp+1]=='*'|| field[ROWmoveComp-1][COLmoveComp+1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==2) {//1:2
                if (field[ROWmoveComp][COLmoveComp+1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp][COLmoveComp+1]='*';
                }
                if (field[ROWmoveComp][COLmoveComp+1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp][COLmoveComp+1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                    TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp+1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp+1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp][COLmoveComp+1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp][COLmoveComp+1]=='*'|| field[ROWmoveComp][COLmoveComp+1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==3) {//2:2
                if (field[ROWmoveComp+1][COLmoveComp+1]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp+1][COLmoveComp+1]='*';
                }
                if (field[ROWmoveComp+1][COLmoveComp+1]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp+1][COLmoveComp+1]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp+1][COLmoveComp+1]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp+1][COLmoveComp+1]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp+1]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp+1][COLmoveComp+1]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp+1]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp+1][COLmoveComp+1]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp+1]=='*'|| field[ROWmoveComp+1][COLmoveComp+1]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            else if (random.nextInt(5)==4) {//2:1
                if (field[ROWmoveComp+1][COLmoveComp]=='0') {
                    System.out.println("Компьютер промахнулся после попадания");
                    field[ROWmoveComp+1][COLmoveComp]='*';
                }
                if (field[ROWmoveComp+1][COLmoveComp]==1) {
                    System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    CountMiniShip++;
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if (field[ROWmoveComp+1][COLmoveComp]==2) {
                    System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                    CountMediumShip++;
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    if (CountMediumShip==2) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp]==3) {
                    System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                    CountBigShip++;
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    if (CountBigShip==3) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp]==4) {
                    System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                    CountBiggestShip++;
                    field[ROWmoveComp+1][COLmoveComp]='X';
                    if (CountBiggestShip==4) {
                        ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                    }
                    else{
                        TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                    }
                }
                if (field[ROWmoveComp+1][COLmoveComp]=='*'|| field[ROWmoveComp+1][COLmoveComp]=='X') {
                    TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
        }
        //                                  ROW:COL
        else if (random.nextInt(8)==0){// позиция 0:0 (field[ROWmoveComp-1][COLmoveComp-1]) в квадрате 3х3 где 1х1 - центр : field[ROWmoveComp][COLmoveComp]
            if (field[ROWmoveComp-1][COLmoveComp-1]=='0') {
                System.out.println("Компьютер промахнулся после попадания");
                field[ROWmoveComp-1][COLmoveComp-1]='*';
            }
            if (field[ROWmoveComp-1][COLmoveComp-1]==1) {
                System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                field[ROWmoveComp-1][COLmoveComp-1]='X';
                CountMiniShip++;
                ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
            }
            if (field[ROWmoveComp-1][COLmoveComp-1]==2) {
                System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                CountMediumShip++;
                field[ROWmoveComp-1][COLmoveComp-1]='X';
                if (CountMediumShip==2) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if(CountMediumShip<2){
                    TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp-1][COLmoveComp-1]==3) {
                System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                CountBigShip++;
                field[ROWmoveComp-1][COLmoveComp-1]='X';
                if (CountBigShip==3) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                if(CountBigShip<3){//я когда исправлял часть кода про оповещение для хода компа если он потопил корабль, начал с 0:0, на 0:1 я задумался про else привально ли оно там, потом уже сейчас вот когда полез 0:0 исправлять смекнул что тру комп шот мне нужен даже есл иф не выполняется поэтому елсе норм
                    TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp-1][COLmoveComp-1]==4) {
                System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                CountBiggestShip++;
                field[ROWmoveComp-1][COLmoveComp-1]='X';
                if (CountBiggestShip==4) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp-1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp-1][COLmoveComp-1]=='*'|| field[ROWmoveComp-1][COLmoveComp-1]=='X') {
                TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
            }

        }
        else if (random.nextInt(8)==1){// позиция 0:1 (field[ROWmoveComp-1][COLmoveComp]  ) в квадрате 3х3 где 1х1 - центр : field[ROWmoveComp][COLmoveComp]
            if (field[ROWmoveComp-1][COLmoveComp]=='0') {
                System.out.println("Компьютер промахнулся после попадания");
                field[ROWmoveComp-1][COLmoveComp]='*';
            }
            if (field[ROWmoveComp-1][COLmoveComp]==1) {
                System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                field[ROWmoveComp-1][COLmoveComp]='X';
                CountMiniShip++;
                ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
            }
            if (field[ROWmoveComp-1][COLmoveComp]==2) {
                System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                CountMediumShip++;
                field[ROWmoveComp-1][COLmoveComp]='X';
                if(CountMediumShip==2){
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp-1][COLmoveComp]==3) {
                System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                CountBigShip++;
                field[ROWmoveComp-1][COLmoveComp]='X';
                if(CountBigShip==3){
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp-1][COLmoveComp]==4) {
                System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                CountBiggestShip++;
                field[ROWmoveComp-1][COLmoveComp]='X';
                if(CountBiggestShip==4){
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else {
                    TrueCompShot(ROWmoveComp-1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp-1][COLmoveComp]=='*'|| field[ROWmoveComp-1][COLmoveComp]=='X') {
                TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
            }
        }
        else if (random.nextInt(8)==2){// позиция 0:2 (field[ROWmoveComp-1][COLmoveComp+1]) в квадрате 3х3 где 1х1 - центр : field[ROWmoveComp][COLmoveComp]
            if (field[ROWmoveComp-1][COLmoveComp+1]=='0') {
                System.out.println("Компьютер промахнулся после попадания");
                field[ROWmoveComp-1][COLmoveComp+1]='*';
            }
            if (field[ROWmoveComp-1][COLmoveComp+1]==1) {
                System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                field[ROWmoveComp-1][COLmoveComp+1]='X';
                CountMiniShip++;
                ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
            }
            if (field[ROWmoveComp-1][COLmoveComp+1]==2) {
                System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                CountMediumShip++;
                field[ROWmoveComp-1][COLmoveComp+1]='X';
                if(CountMediumShip==2){
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp-1][COLmoveComp+1]==3) {
                System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                CountBigShip++;
                field[ROWmoveComp-1][COLmoveComp]='X';
                if(CountBigShip==3){
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp-1][COLmoveComp+1]==4) {
                System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                CountBiggestShip++;
                field[ROWmoveComp-1][COLmoveComp]='X';
                if(CountBiggestShip==4){
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp-1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp-1][COLmoveComp+1]=='*'|| field[ROWmoveComp-1][COLmoveComp+1]=='X') {
                TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
            }
        }
        else if (random.nextInt(8)==3){// позиция 1:2 (field[ROWmoveComp][COLmoveComp+1]  ) в квадрате 3х3 где 1х1 - центр : field[ROWmoveComp][COLmoveComp]
            if (field[ROWmoveComp][COLmoveComp+1]=='0') {
                System.out.println("Компьютер промахнулся после попадания");
                field[ROWmoveComp][COLmoveComp+1]='*';
            }
            if (field[ROWmoveComp][COLmoveComp+1]==1) {
                System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                field[ROWmoveComp][COLmoveComp+1]='X';
                CountMiniShip++;
                ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
            }
            if (field[ROWmoveComp][COLmoveComp+1]==2) {
                System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                CountMediumShip++;
                field[ROWmoveComp][COLmoveComp+1]='X';
                if (CountMediumShip==2) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp][COLmoveComp+1]==3) {
                System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                CountBigShip++;
                field[ROWmoveComp][COLmoveComp+1]='X';
                if (CountBigShip==3) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp][COLmoveComp+1]==4) {
                System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                CountBiggestShip++;
                field[ROWmoveComp][COLmoveComp+1]='X';
                if (CountBiggestShip==4) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp][COLmoveComp+1]=='*'|| field[ROWmoveComp][COLmoveComp+1]=='X') {
                TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
            } 
        }
        else if (random.nextInt(8)==4){// позиция 2:2 (field[ROWmoveComp+1][COLmoveComp+1]) в квадрате 3х3 где 1х1 - центр : field[ROWmoveComp][COLmoveComp]
            if (field[ROWmoveComp+1][COLmoveComp+1]=='0') {
                System.out.println("Компьютер промахнулся после попадания");
                field[ROWmoveComp+1][COLmoveComp+1]='*';
            }
            if (field[ROWmoveComp+1][COLmoveComp+1]==1) {
                System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                field[ROWmoveComp+1][COLmoveComp+1]='X';
                CountMiniShip++;
                ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
            }
            if (field[ROWmoveComp+1][COLmoveComp+1]==2) {
                System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                CountMediumShip++;
                field[ROWmoveComp+1][COLmoveComp+1]='X';
                if (CountMediumShip==2) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp+1][COLmoveComp+1]==3) {
                System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                CountBigShip++;
                field[ROWmoveComp+1][COLmoveComp+1]='X';
                if (CountBigShip==3) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp+1][COLmoveComp+1]==4) {
                System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                CountBiggestShip++;
                field[ROWmoveComp+1][COLmoveComp+1]='X';
                if (CountBiggestShip==4) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp+1, COLmoveComp+1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp+1][COLmoveComp+1]=='*'|| field[ROWmoveComp+1][COLmoveComp+1]=='X') {
                TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
            } 
        }
        else if (random.nextInt(8)==5){// позиция 2:1 (field[ROWmoveComp+1][COLmoveComp]  ) в квадрате 3х3 где 1х1 - центр : field[ROWmoveComp][COLmoveComp]
            if (field[ROWmoveComp+1][COLmoveComp]=='0') {
                System.out.println("Компьютер промахнулся после попадания");
                field[ROWmoveComp+1][COLmoveComp]='*';
            }
            if (field[ROWmoveComp+1][COLmoveComp]==1) {
                System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                field[ROWmoveComp+1][COLmoveComp]='X';
                CountMiniShip++;
                ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
            }
            if (field[ROWmoveComp+1][COLmoveComp]==2) {
                System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                CountMediumShip++;
                field[ROWmoveComp+1][COLmoveComp]='X';
                if (CountMediumShip==2) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp+1][COLmoveComp]==3) {
                System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                CountBigShip++;
                field[ROWmoveComp+1][COLmoveComp]='X';
                if (CountBigShip==3) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp+1][COLmoveComp]==4) {
                System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                CountBiggestShip++;
                field[ROWmoveComp+1][COLmoveComp]='X';
                if (CountBiggestShip==4) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp+1, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp+1][COLmoveComp]=='*'|| field[ROWmoveComp+1][COLmoveComp]=='X') {
                TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
            }
        }
        else if (random.nextInt(8)==6){// позиция 2:0 (field[ROWmoveComp+1][COLmoveComp-1]) в квадрате 3х3 где 1х1 - центр : field[ROWmoveComp][COLmoveComp]
            if (field[ROWmoveComp+1][COLmoveComp-1]=='0') {
                System.out.println("Компьютер промахнулся после попадания");
                field[ROWmoveComp+1][COLmoveComp-1]='*';
            }
            if (field[ROWmoveComp+1][COLmoveComp-1]==1) {
                System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                field[ROWmoveComp+1][COLmoveComp-1]='X';
                CountMiniShip++;
                ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
            }
            if (field[ROWmoveComp+1][COLmoveComp-1]==2) {
                System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                CountMediumShip++;
                field[ROWmoveComp+1][COLmoveComp-1]='X';
                if (CountMediumShip==2) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp+1][COLmoveComp-1]==3) {
                System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                CountBigShip++;
                field[ROWmoveComp+1][COLmoveComp-1]='X';
                if (CountBigShip==3) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp+1][COLmoveComp-1]==4) {
                System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                CountBiggestShip++;
                field[ROWmoveComp+1][COLmoveComp-1]='X';
                if (CountBiggestShip==4) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp+1, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp+1][COLmoveComp-1]=='*'|| field[ROWmoveComp+1][COLmoveComp-1]=='X') {
                TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
            }
        }
        else if (random.nextInt(8)==7){// позиция 1:0 (field[ROWmoveComp][COLmoveComp-1]  ) в квадрате 3х3 где 1х1 - центр : field[ROWmoveComp][COLmoveComp]
            if (field[ROWmoveComp][COLmoveComp-1]=='0') {
                System.out.println("Компьютер промахнулся после попадания");
                field[ROWmoveComp][COLmoveComp-1]='*';
            }
            if (field[ROWmoveComp][COLmoveComp-1]==1) {
                System.out.println("Компьютер уничтожил твой катер! (однопалубный корабль)");
                field[ROWmoveComp][COLmoveComp-1]='X';
                CountMiniShip++;
                ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
            }
            if (field[ROWmoveComp][COLmoveComp-1]==2) {
                System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
                CountMediumShip++;
                field[ROWmoveComp][COLmoveComp-1]='X';
                if (CountMediumShip==2) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp][COLmoveComp-1]==3) {
                System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
                CountBigShip++;
                field[ROWmoveComp][COLmoveComp-1]='X';
                if (CountBigShip==3) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp][COLmoveComp-1]==4) {
                System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
                CountBiggestShip++;
                field[ROWmoveComp][COLmoveComp-1]='X';
                if (CountBiggestShip==4) {
                    ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
                }
                else{
                    TrueCompShot(ROWmoveComp, COLmoveComp-1, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
                }
            }
            if (field[ROWmoveComp][COLmoveComp-1]=='*' || field[ROWmoveComp][COLmoveComp-1]=='X') {
                TrueCompShot(ROWmoveComp, COLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
            } 
        }
        
    }
    public static void ComputersMove(int CountMediumShip,int CountBigShip,int CountBiggestShip,char[][] field,int CountMiniShip){
        System.out.println("Компьютер делает свой ход...");
        Random random = new Random();
        int randomROWmoveComp = random.nextInt(10);//тк после попадания в корабль игроку дается еще один ход
        int randomCOLmoveComp = random.nextInt(10);//и в этот ход он будет бить рядом с местом куда попал я делаю еще одну функцию
        if (field[randomROWmoveComp][randomCOLmoveComp]==1) {
            System.out.println("Компьютер уничтожил твой легкий катер! (однопалубный корабль)");
            field[randomROWmoveComp][randomCOLmoveComp]='X';
            CountMiniShip++;
            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
        }
        if (field[randomROWmoveComp][randomCOLmoveComp]==2) {
            System.out.println("Компьютер подбил твой средний корабль! (двхпалубный корабль)");
            CountMediumShip++;
            field[randomROWmoveComp][randomCOLmoveComp]='X';
            TrueCompShot(randomROWmoveComp, randomCOLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
        }
        if (field[randomROWmoveComp][randomCOLmoveComp]==3) {
            System.out.println("Компьютер подбил твой большой корабль! (трехпалубный корабль)");
            CountBigShip++;
            field[randomROWmoveComp][randomCOLmoveComp]='X';
            TrueCompShot(randomROWmoveComp, randomCOLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
        }
        if (field[randomROWmoveComp][randomCOLmoveComp]==4) {
            System.out.println("Компьютер подбил твой огромный корабль! (четырехпалубный корабль)");
            CountBiggestShip++;
            field[randomROWmoveComp][randomCOLmoveComp]='X';
            TrueCompShot(randomROWmoveComp, randomCOLmoveComp, field, CountMediumShip, CountBigShip, CountBiggestShip, CountMiniShip);
        }
        if (field[randomROWmoveComp][randomCOLmoveComp]=='0') {
            System.out.println("Компьютер промазал");
            field[randomROWmoveComp][randomCOLmoveComp]='*';
        }
        else{
            ComputersMove(CountMediumShip, CountBigShip, CountBiggestShip, field, CountMiniShip);
        }
    }
    public static void PlayerMove(char[][] fieldPUB,char[][] fieldCOMP, int COMPCountMiniShip,int COMPCountMediumShip, int COMPCountBigShip,int COMPCountBiggestShip){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ваш ход!");
        System.out.println("Укажите координату по вертикали (отсчет сверху вниз, от 1 до 10)");
        int RowPl = scanner.nextInt()-1;
        System.out.println("Укажите координату пгоризонтали (от 1 до 10)");
        int ColPl = scanner.nextInt()-1;
        if (fieldPUB[RowPl][ColPl]=='X'||fieldPUB[RowPl][ColPl]=='*') {
            System.out.println("Клетка уже занята!");
            PlayerMove(fieldPUB, fieldCOMP, COMPCountMiniShip, COMPCountMediumShip, COMPCountBigShip, COMPCountBiggestShip);
        }
         else if (fieldCOMP[RowPl][ColPl]==1) {
            fieldPUB[RowPl][ColPl]='X';
            System.out.println("Вы уничтожили катер проитвника! (однопалубный корабль)");
            COMPCountMiniShip++;
        }
        else if(fieldCOMP[RowPl][ColPl]==2){
            fieldPUB[RowPl][ColPl]='X';
            COMPCountMediumShip++;
            System.out.println("Вы попали!");
            PlayerMove(fieldPUB, fieldCOMP, COMPCountMiniShip, COMPCountMediumShip, COMPCountBigShip, COMPCountBiggestShip);
        }
        else if(fieldCOMP[RowPl][ColPl]==3){
            fieldPUB[RowPl][ColPl]='X';
            COMPCountBigShip++;
            System.out.println("Вы попали!");
            PlayerMove(fieldPUB, fieldCOMP, COMPCountMiniShip, COMPCountMediumShip, COMPCountBigShip, COMPCountBiggestShip);
        }
        else if(fieldCOMP[RowPl][ColPl]==4){
            fieldPUB[RowPl][ColPl]='X';
            COMPCountBiggestShip++;
            System.out.println("Вы попали!");
            PlayerMove(fieldPUB, fieldCOMP, COMPCountMiniShip, COMPCountMediumShip, COMPCountBigShip, COMPCountBiggestShip);
        }
        else if (fieldCOMP[RowPl][ColPl]=='0'){
            fieldPUB[RowPl][ColPl]='*';
            System.out.println("Вы промазали");
        }
    }
    public static boolean checkWin(int MiniShip,int MediumShip, int BigShip, int BiggestShip){
        return (MiniShip>=1) && (MediumShip>=2) && (BigShip>=3) && (BiggestShip>=4);
    }
    /* 
    public static boolean gameover(){//нафик не сдалось
        return checkWin()||checkWin();
    }*/
    public static void main(String[] args) {
        char[][] fieldPL = new char[10][10];
        char[][] fieldComp = new char[10][10];
        char[][] fieldPublic = new char[10][10];
        int PLminiShip = 0;
        int PLmediumShip = 0;
        int PLbigShip = 0;
        int PLbiggestShip = 0;
        int COMPminiShip = 0;
        int COMPmediumShip = 0;
        int COMPbigShip = 0;
        int COMPbiggestShip = 0;
        InitializationField(fieldPL);
        InitializationField(fieldComp);
        InitializationField(fieldPublic);
        SpawnShip(1, fieldPL);
        SpawnShip(2, fieldPL);
        SpawnShip(3, fieldPL);
        SpawnShip(4, fieldPL);
        SpawnShip(1, fieldComp);
        SpawnShip(2, fieldComp);
        SpawnShip(3, fieldComp);
        SpawnShip(4, fieldComp);
        System.out.println("Приветствуем в игре 'Морской бой'!");
        System.out.println("Примичание : корабли могут распологаться друг к другу в плотную \n Расположение ваших кораблей и компьютера всегда случайно.");
        while (!(checkWin(COMPminiShip, COMPmediumShip, COMPbigShip, COMPbiggestShip)||checkWin(PLminiShip, PLmediumShip, PLbigShip, PLbiggestShip))) {
            System.out.println("Ваше поле :");
            printField(fieldPL);
            System.out.println("\n Поле противника :");
            printField(fieldPublic);
            PlayerMove(fieldPublic, fieldComp, COMPminiShip, COMPmediumShip, COMPbigShip, COMPbiggestShip);
            ComputersMove(PLmediumShip, PLbigShip, PLbiggestShip, fieldPL, PLminiShip);
            System.out.println("Сводка:");
            if (PLminiShip==1) {
                System.out.println("Противник уничтожил ваш катер (однопалубный корабль)");
            }
            if (PLmediumShip==2) {
                System.out.println("Противник уничтожил ваш средний корабль (двухпалубный корабль)");
            }
            if (PLbigShip==3) {
                System.out.println("Противник уничтожил ваш большой корабль (трехпалубный корабль)");
            }
            if (PLbiggestShip==4) {
                System.out.println("Противник уничтожил ваш гигантский корабль (четырехпалубный корабль)");
            }
            else{System.out.println("Ничего примечательного...");}
        }

    }



}