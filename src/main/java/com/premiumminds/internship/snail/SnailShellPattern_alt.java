package com.premiumminds.internship.snail;

import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern_alt implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {
    return CompletableFuture.completedFuture(computeSnail(matrix));
  };

  /**
   * Function that calculates snailshell for an NxN matrix 
   * using a series of directions. Each time an element is added
   * it is then set to -1 in the original matrix so that we know it's
   * already been visited and the algorithm moves on the next slot.
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values that represent a snail shell pattern
   */
  private int[] computeSnail(int[][] matrix){
    int[] snail = {};
    int size = matrix[0].length;
    if(size != 0){
      snail = new int[size*size];
      int[] pos = {0,0};
      int[] dir = {0,1};

      for(int i = 0; i < size*size; i++){
        if(matrix[pos[0]][pos[1]] == -1){
          //go back and pivot
          pos[0] -= dir[0]; pos[1] -= dir[1];
          dir = nextDir(dir);
          pos[0] += dir[0]; pos[1] += dir[1];

          //add correct element to path
          snail[i] = matrix[pos[0]][pos[1]];
          matrix[pos[0]][pos[1]] = -1;
        }
        else{
          //add element to snail path
          snail[i] = matrix[pos[0]][pos[1]];
          matrix[pos[0]][pos[1]] = -1;

          //check if in corner (only ever happens 3x)
          if((pos[0] == size-1 && pos[1] == 0) ||
            (pos[0] == size-1 && pos[1] == size -1) || 
            (pos[0] == 0 && pos[1] == size-1)){
            dir = nextDir(dir);
          }
        }
        //advance to next slot
        pos[0] += dir[0]; pos[1] += dir[1];
      }
    }
    return snail;
  }

  /**
   * Simple function that indicates the next direction in clockwise motion
   * considering the input direction.
   * 
   * @param dir array that indicates direction in (row,col) format
   * @return array containing new direction to follow in (row,col) format
   */
  private int[] nextDir(int[] dir){
    int[] newDir = {0,0};
    if(dir[0] == 0 && dir[1] == 1){ newDir = new int[]{1,0};  }    //Right -> Down
    if(dir[0] == 1 && dir[1] == 0){ newDir = new int[]{0,-1}; }    //Down -> Left
    if(dir[0] == 0 && dir[1] == -1){ newDir = new int[]{-1,0};; }  //Left -> Up
    if(dir[0] == -1 && dir[1] == 0){ newDir = new int[]{0,1};; }   //Up -> Right
    return newDir;
  }
}