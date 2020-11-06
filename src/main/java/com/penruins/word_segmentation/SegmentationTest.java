package com.penruins.word_segmentation;

import org.ictclas4j.bean.SegResult;
import org.ictclas4j.segment.SegTag;
import org.junit.Test;

public class SegmentationTest {
  @Test
  public void test() {
    SegTag tag = new SegTag(1);
    SegResult result = tag.split("我有印象无不来自于感觉之中");
    System.out.println(result.getFinalResult());
  }


}
