package com.dmitrii.pairofpoints;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClosestPointTest {

    @Test
    void closest() {
        ClosestPoint service = new ClosestPoint();
        Point[] points = new Point[]{
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };
        System.out.println(service.closest(points, points.length));

        Assertions.assertEquals(service.closest(points, points.length), 1.4142135381698608);
    }
}