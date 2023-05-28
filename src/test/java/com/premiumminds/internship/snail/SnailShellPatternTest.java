package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  };

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void Test_example1()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3}, { 4, 5, 6 }, { 7, 8, 9 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 6, 9, 8, 7, 4, 5};
    assertArrayEquals(result, expected);
  }

  @Test
  public void Test_example2()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 1}, { 4, 5, 6, 4 }, { 7, 8, 9, 7 }, { 7, 8, 9, 7 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 1, 4, 7, 7, 9, 8, 7, 7, 4, 5, 6, 9, 8};
    assertArrayEquals(result, expected);
  }

  @Test
  public void Test_big()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {  { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1}, 
                        { 2, 2, 3, 4, 5, 6, 7, 8, 9, 2}, 
                        { 3, 2, 3, 4, 5, 6, 7, 8, 9, 3}, 
                        { 4, 2, 3, 4, 5, 6, 7, 8, 9, 4},
                        { 5, 2, 3, 4, 5, 6, 7, 8, 9, 5},
                        { 6, 2, 3, 4, 5, 6, 7, 8, 9, 6},
                        { 7, 2, 3, 4, 5, 6, 7, 8, 9, 7},
                        { 8, 2, 3, 4, 5, 6, 7, 8, 9, 8},
                        { 9, 2, 3, 4, 5, 6, 7, 8, 9, 9},
                        { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1,
                       2, 3, 4, 5, 6, 7, 8, 9, 1,
                       9, 8, 7, 6, 5, 4, 3, 2, 1,
                       9, 8, 7, 6, 5, 4, 3, 2,
                       2, 3, 4, 5, 6, 7, 8, 9,
                       9, 9, 9, 9, 9, 9, 9,
                       8, 7, 6, 5, 4, 3, 2,
                       2, 2, 2, 2, 2, 2,
                       3, 4, 5, 6, 7, 8,
                       8, 8, 8, 8, 8,
                       7, 6, 5, 4, 3,
                       3, 3, 3, 3,
                       4, 5, 6, 7,
                       7, 7, 7,
                       6, 5, 4,
                       4, 4,
                       5, 6,
                       6,
                       5
                      };
    assertArrayEquals(result, expected);
  }

  @Test
  public void Test_small()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2}, { 4, 3}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4};
    assertArrayEquals(result, expected);
  }

  @Test
  public void Test_empty()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { {} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {};
    assertArrayEquals(result, expected);
  }
}