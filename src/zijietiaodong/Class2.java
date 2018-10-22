package zijietiaodong;


import java.util.Scanner;
import java.util.Stack;

public class Class2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(output(input));

    }
    public static String output(String input){
        char[] inChars = input.toCharArray();
        Stack<Character> currentStack = new Stack<>();
        Stack<LastStep> lastSteps = new Stack<>();
        for (int i = 0; i < inChars.length; i++) {
            if (inChars[i] == 'i'){
                if (currentStack.size() > 0) {
                    lastSteps.push(new LastStep(1, currentStack.pop()));
                }
            }else if (inChars[i] == 'o'){
                if (lastSteps.size()>0) {
                    LastStep lastStep = lastSteps.pop();
                    if (lastStep.lastStepType == 0) {
                        currentStack.pop();
                    } else {
                        currentStack.push(lastStep.lastStepChar);
                    }
                }

            }else {
                currentStack.push(inChars[i]);
                lastSteps.push(new LastStep(0,inChars[i]));
            }
        }
        char[] resArr = new char[currentStack.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[resArr.length-1-i] = currentStack.pop();
        }
        return new String(resArr);
    }
}
class LastStep{

    /**
     * 0 输入
     * 1 输出
     */
    int lastStepType;
    char lastStepChar;
    LastStep(int lastStepType,char lastStepChar){
        this.lastStepType = lastStepType;
        this.lastStepChar = lastStepChar;
    }
}
