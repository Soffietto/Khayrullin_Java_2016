package com.jetbrains.vector2d;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector2DTest {

    private static Vector2D vector1;
    private static Vector2D vector2;
    private static final double VECTOR_1_X = 10.0;
    private static final double VECTOR_1_Y = 5.0;
    private static final double VECTOR_2_X = 3.0;
    private static final double VECTOR_2_Y = 7.0;
    private static Vector2D vectorSum;
    private static Vector2D vectorMult1;
    private static Vector2D vectorMult2;
    private static final double K = 7.2;
    private static final double DELTA = 10e-2;

    @BeforeClass
    public static void setUp() {
        vector1 = new Vector2D(VECTOR_1_X, VECTOR_1_Y);
        vector2 = new Vector2D(VECTOR_2_X, VECTOR_2_Y);
        vectorSum = new Vector2D(VECTOR_1_X + VECTOR_2_X, VECTOR_1_Y + VECTOR_2_Y);
        vectorMult1 = new Vector2D(VECTOR_1_X * K, VECTOR_1_Y * K);
        vectorMult2 = new Vector2D(VECTOR_2_X * K, VECTOR_2_Y * K);
    }

    @Test
    public void shouldReturnProperX() {
        Assert.assertEquals(vector1.getX(), VECTOR_1_X, DELTA);
        Assert.assertEquals(vector2.getX(), VECTOR_2_X, DELTA);
    }

    @Test
    public void shouldReturnProperY() {
        Assert.assertEquals(vector1.getY(), VECTOR_1_Y, DELTA);
        Assert.assertEquals(vector2.getY(), VECTOR_2_Y, DELTA);
    }

    @Test
    public void shouldReturnProperVectorLength() {
        Assert.assertEquals(vector1.length(), Math.sqrt(VECTOR_1_X * VECTOR_1_X + VECTOR_1_Y * VECTOR_1_Y), DELTA);
        Assert.assertEquals(vector2.length(), Math.sqrt(VECTOR_2_X * VECTOR_2_X + VECTOR_2_Y * VECTOR_2_Y), DELTA);
    }

    @Test
    public void shouldReturnProperVectorSum() {
        Assert.assertTrue(vector1.vectorSum(vector2).equals(vectorSum));
    }

    @Test
    public void shouldReturnProperVectorMult() {
        Assert.assertTrue(vector1.vectorMult(K).equals(vectorMult1));
        Assert.assertTrue(vector2.vectorMult(K).equals(vectorMult2));
    }

    @Test
    public void shouldReturnProperScalarMult() {
        Assert.assertEquals(vector1.scalarMult(vector2), VECTOR_1_X * VECTOR_2_X + VECTOR_1_Y * VECTOR_2_Y, DELTA);
    }

    @Test
    public void shouldReturnProperEqualization() {
        Assert.assertEquals(vector1.equals(vector2), VECTOR_1_X == VECTOR_2_X && VECTOR_1_Y == VECTOR_2_Y);
    }
}
