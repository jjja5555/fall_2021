package edu.northeastern.martin;

public class Main {


    public static void main(String[] args) {
	// write your code here
        System.out.println(isRobotBounded("GL"));
    }


    public static boolean isRobotBounded(String instructions) {
        int[]position = new int[2];
        char direction = 'n';
        for (char c : instructions.toCharArray()) {
            if(c == 'G'){
                switch (direction){
                    case'n':position[1]++;
                        break;
                    case's':position[1]--;
                        break;
                    case'e':position[0]++;
                        break;
                    case'w':position[0]--;
                        break;
                }

            }
            if(c == 'L'){
                switch (direction){
                    case'n':direction = 'w';
                        break;
                    case's':direction = 'e';
                        break;
                    case'e':direction = 'n';
                        break;
                    case'w':direction = 's';
                }
            }
            if(c == 'R'){
                switch (direction){
                    case'n':direction = 'e';
                        break;
                    case's':direction = 'w';
                        break;
                    case'e':direction = 's';
                        break;
                    case'w':direction = 'n';
                }
            }
        }

        //1.方向和原来一样
        //2.位置不在原点
        if(direction == 'n'&& (position[0] != 0 || position[1] !=0)){
            return false;
        }

        return true;


    }
}
