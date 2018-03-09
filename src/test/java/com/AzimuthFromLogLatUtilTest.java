package com;

import com.test.clean.AzimuthFromLogLatUtil;
import org.junit.Test;

public class AzimuthFromLogLatUtilTest {

    @Test
    public void testGetAzimuth() {
        AzimuthFromLogLatUtil A = new AzimuthFromLogLatUtil(116.496167, 39.917066);
        AzimuthFromLogLatUtil B = new AzimuthFromLogLatUtil(116.496149, 39.917205);
        AzimuthFromLogLatUtil test = new AzimuthFromLogLatUtil();
        double result = test.getAzimuth(A, B);
        System.out.println(result);
    }
}