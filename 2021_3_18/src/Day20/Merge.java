package Day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
     int start;
     int end;
     Interval() {
         start = 0;
         end = 0;
     }
    Interval(int s, int e) {
         start = s;
         end = e;
     }

}

/**
 * 合并重叠得数组区间
 * 给出一组区间，请合并所有重叠的区间。
 * 请保证合并后的区间按区间起点升序排列
 */
public class Merge {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size()<=2){
            return intervals;
        }
        //首先将数组元素进行排序，按照升序排
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start){
                    return o1.end<o2.end?-1:1;
                }
                return o1.start<o2.start?-1:1;
            }
        });

        ArrayList<Interval> list=new ArrayList<>();

        //采用滑动窗口机制来进行插入元素
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            if(end<intervals.get(i).start){
                list.add(new Interval(start,end));
                start=intervals.get(i).start;

            }
            end=Math.max(end,intervals.get(i).end);
        }
        list.add(new Interval(start,end));
        return list;


    }

    public static void main(String[] args) {


    }



}
