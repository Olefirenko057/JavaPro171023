package org.example.lesson6_homework.task2;

public interface VolumeCounter <H extends Number,L extends Number,W extends Number>{
      private Number countVolumeHelper(Number height, Number length,Number width) {
            if(height instanceof Double || length instanceof Double || width instanceof Double) {
                  return height.doubleValue() * length.doubleValue() * width.doubleValue();
            } else if(height instanceof Float || length instanceof Float || width instanceof Float) {
                  return height.floatValue() * length.floatValue() * width.floatValue();
            } else if(height instanceof Long || length instanceof Long || width instanceof Long) {
                  return height.longValue() * length.longValue() * width.longValue();
            } else {
                  return height.intValue() * length.intValue() * width.intValue();
            }
      }
      default Number countVolume(H height, L length, W width) {
        return countVolumeHelper(height,length,width);
    }


}
