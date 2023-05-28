package com.premiumminds.internship.snail;

import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

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
   * Function that calculates a snailshell path for an NxN matrix.
   * Using a barrier approach each time an outer row/col is fully 
   * added to the snail the corresponding barrier is updated until
   * at least two barriers meet, meaning the snail is complete.
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values that represent a snail shell pattern
   */
  private int[] computeSnail(int[][] matrix){
    int[] snail = {};
    int size = matrix[0].length;
    if(size != 0){
      snail = new int[size*size];
      int left = 0; int right = size;
      int top = 0; int bottom = size;
      int counter = 0;

      while(left < right && top < bottom){
        //get the whole top row
        for(int i = left; i < right; i++){
          snail[counter] = matrix[top][i];
          counter++;
        }
        top++;

        //get the whole right col
        for(int i = top; i < bottom; i++){
          snail[counter] = matrix[i][right-1];
          counter++;
        }
        right--;

        //get the whole bottom row
        for(int i = right-1; i > left-1; i--){
          snail[counter] = matrix[bottom-1][i];
          counter++;
        }
        bottom--;

        //get the whole left col
        for(int i = bottom-1; i > top-1; i--){
          snail[counter] = matrix[i][left];
          counter++;
        }
        left++;;
      }
    }
    return snail;
  }
}