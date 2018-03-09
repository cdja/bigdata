package com;

import com.test.clean.GetUTCTimeUtil;
import org.junit.Test;

public class GetUTCTimeUtilTest {
    @Test
    public void testGetUTCTimeStr() {
        GetUTCTimeUtil gc = new GetUTCTimeUtil();
        long mill = gc.getUTCTimeStr(1520490634902L);
        System.out.print(mill);
    }
}