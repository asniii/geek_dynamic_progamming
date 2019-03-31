package dynamic_programming.q22;

import java.util.Arrays;

/***
 * Box Stacking Problem | DP-22
 * You are given a set of n types of rectangular 3-D boxes, where the i^th box has height h(i), width w(i) and
 * depth d(i) (all real numbers). You want to create a stack of boxes which is as tall as possible, but you can
 * only stack a box on top of another box if the dimensions of the 2-D base of the lower box are each strictly
 * larger than those of the 2-D base of the higher box. Of course, you can rotate a box so that any side functions
 * as its base. It is also allowable to use multiple instances of the same type of box.
 */
public class GFG {

    static class Box implements Comparable<Box> {

        int h,w,d,area;


        public Box(int h,int w,int d){
            this.h = h;
            this.w = w;
            this.d = d;
        }


        @Override
        public int compareTo(Box o) {
            return o.area - this.area;
        }
    }

    static int maxStackHeight(Box arr[], int n){
        Box[] rot = new Box[n*3];


        for(int i = 0;i<n;i++){
            Box box = arr[i];

            rot[3*i] = new Box(box.h,Math.max(box.w,box.d),Math.min(box.w,box.d));

            rot[3*i + 1] = new Box(box.w,Math.max(box.h,box.d),Math.min(box.h,box.d));

            rot[3*i + 2] = new Box(box.d,Math.max(box.w,box.h),Math.min(box.w,box.h));
        }

        for(int i = 0;i<rot.length;i++){
            rot[i].area = rot[i].w * rot[i].d;
        }

        Arrays.sort(rot);

        int count = 3*n;

        int msh[] = new int[count];

        for(int i = 0;i<count;i++){
            msh[i] = rot[i].h;
        }

        for(int i =0;i<count;i++){
            msh[i] = 0;
            Box box = rot[i];
            int val = 0;

            for(int j = 0;j<i;j++){
                Box prevBox = rot[j];
                if(box.w < prevBox.w && box.d <prevBox.d){
                    val = Math.max(val,msh[j]);
                }
            }
            msh[i] = val + box.h;
        }

        int max = -1;

        for(int i = 0;i<count;i++){
            max = Math.max(max,msh[i]);
        }
        return max;
    }


    public static void main(String args[]){
        Box[] arr = new Box[4];
        arr[0] = new Box(4,6,7);
        arr[1] = new Box(1,2,3);
        arr[2] = new Box(4,5,6);
        arr[3] = new Box(10,12,32);

        System.out.println("The maximum possible height of stack is : " + maxStackHeight(arr,4));
    }


}
