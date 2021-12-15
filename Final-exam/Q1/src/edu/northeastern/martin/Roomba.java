package edu.northeastern.martin;

public class Roomba implements iRobot{
    private int [][]room;
    private Direction direction;
    private int x;
    private int y;

    public Roomba(int [][] room) {
        this.room = room;
        this.direction = Direction.DOWN;
        this.x = 0;
        this.y = 0;
    }

    @Override
    public final boolean move() {
        if(this.direction.equals(Direction.UP)){
            if(this.x == 0){
                return false;
            }else if(room[x-1][y] == -1){
                return false;
            }else{
                this.x--;
                return true;
            }
        }

        if(this.direction.equals(Direction.LEFT)){
            if(this.y == 0){
                return false;
            }else if(room[x][y-1] == -1){
                return false;
            }else{
                this.y--;
                return true;
            }
        }

        if(this.direction.equals(Direction.DOWN)){
            if(this.x == this.room.length-1){
                return false;
            }else if(room[x+1][y] == -1){
                return false;
            }else{
                this.x++;
                return true;
            }
        }

        if(this.direction.equals(Direction.RIGHT)){
            if(this.y == this.room[0].length-1){
                return false;
            }else if(room[x][y+1] == -1){
                return false;
            }else{
                this.y++;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void turnLeft() {
        if(this.direction.equals(Direction.UP)){
            this.direction = Direction.LEFT;
        }
        if(this.direction.equals(Direction.LEFT)){
            this.direction = Direction.DOWN;
        }if(this.direction.equals(Direction.DOWN)){
            this.direction = Direction.RIGHT;
        }if(this.direction.equals(Direction.RIGHT)){
            this.direction = Direction.UP;
        }
    }

    @Override
    public final void turnRight() {
        if(this.direction.equals(Direction.UP)){
            this.direction = Direction.RIGHT;
        }
        if(this.direction.equals(Direction.RIGHT)){
            this.direction = Direction.DOWN;
        }if(this.direction.equals(Direction.DOWN)){
            this.direction = Direction.LEFT;
        }if(this.direction.equals(Direction.LEFT)){
            this.direction = Direction.UP;
        }
    }

    @Override
    public final void clean() {
        this.room[x][y] = 1;
    }

    public void print(){

        for (int[] ints : room) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
