package webank;

import java.util.Scanner;

public class Class2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int box1 = in.nextInt();
        int box2 = in.nextInt();
        int box3 = in.nextInt();
        int box4 = in.nextInt();
        int box5 = in.nextInt();
        int box6 = in.nextInt();
        int times = 0;
        if (box6 > 0){
            times += box6;
        }
        if (box5 > 0){
            times += box5;
            if (box1 <= box5 * 11){
                box1 = 0;
            }else {
                box1 = box1 - box5 * 11;
            }
        }
        if (box4 > 0){
            times += box4;
            if (box2 <= box4 * 5){
                if ((box4 * 5 - box2 ) * 4 >= box1){
                    box1 = 0;
                }else {
                    box1 = box1 - (box4 * 5 - box2 ) * 4;
                }
                box2 = 0;
            }else {
                box2 = box2 - box4*5;
            }
        }
        if (box3 > 0){
            if (box3 % 4 == 0){
                times += box3 / 4;
            }else {
                times += (box3 / 4 + 1);
                int left = box3 % 4;
                if (left == 1){
                    if (box2 >= 5){
                        box2 -= 5;
                        if (box1 >= 7){
                            box1 -= 7;
                        }else {
                            box1 = 0;
                        }
                    }else {
                        if (box2 == 4){
                            box2 = 0;
                            if (box1 <= 11){
                                box1 = 0;
                            }else {
                                box1 -= 11;
                            }
                        }else if (box2 == 3){
                            box2 = 0;
                            if (box1 <= 15){
                                box1 = 0;
                            }else {
                                box1 -= 15;
                            }
                        }else if (box2 == 2){
                            box2 = 0;
                            if (box1 <= 19){
                                box1 = 0;
                            }else {
                                box1 -= 19;
                            }
                        }else if (box2 == 1){
                            box2 = 0;
                            if (box1 <= 23){
                                box1 = 0;
                            }else {
                                box1 -= 23;
                            }
                        }else if (box2 == 0){
                            if (box1 <= 27){
                                box1 = 0;
                            }else {
                                box1 -= 27;
                            }
                        }
                    }
                }else if (left == 2){
                    if (box2 >= 3){
                        box2 = box2 - 3;
                        if (box1 <= 6){
                            box1 = 0;
                        }else {
                            box1 = box1 - 6;
                        }
                    }else if (box2 ==2){
                        box2 = 0;
                        if (box1 <= 10){
                            box1 = 0;
                        }else {
                            box1 = box1 - 10;
                        }
                    }
                }else if (left == 3){
                    if (box2 > 0){
                        box2--;
                        if (box1 <= 5){
                            box1 =0;
                        }else {
                            box1 = box1 -5;
                        }
                    }else {
                        if (box1 <= 9){
                            box1 = 0;
                        }else {
                            box1 = box1 -9;
                        }
                    }
                }
            }
        }
        if (box2 > 0){
            if (box2 % 9 == 0){
                times += box2 /9;
            }else {
                times += box2/9 + 1;
                int left = box2 % 9;
                if (left == 1){
                    if (box1 <= 32){
                        box1 = 0;
                    }else {
                        box1 = box1 -32;
                    }
                }else if (left == 2){
                    if (box1 <= 28){
                        box1 = 0;
                    }else {
                        box1 = box1 -28;
                    }
                }else if (left == 3){
                    if (box1 <= 24){
                        box1 = 0;
                    }else {
                        box1 = box1 -24;
                    }
                }else if (left == 4){
                    if (box1 <= 20){
                        box1 = 0;
                    }else {
                        box1 = box1 -20;
                    }
                }else if (left == 5){
                    if (box1 <= 16){
                        box1 = 0;
                    }else {
                        box1 = box1 -16;
                    }
                }else if (left == 6){
                    if (box1 <= 12){
                        box1 = 0;
                    }else {
                        box1 = box1 -12;
                    }
                }else if (left == 7){
                    if (box1 <= 8){
                        box1 = 0;
                    }else {
                        box1 = box1 -8;
                    }
                }else if (left == 8){
                    if (box1 <= 4){
                        box1 = 0;
                    }else {
                        box1 = box1 -4;
                    }
                }
            }
        }
        if (box1 > 0){
            if (box1 % 36 ==0){
                times += box1 / 36;
            }else {
                times += box1 / 36 +1;
            }
        }
        System.out.println(times);
    }
}
