package Array;

/**
 * 先找到山顶元素 一分为二 先查找左边是否存在target 再查找右边是否存在target
 */
public class lc1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size=mountainArr.length();
        int topIndex=findMountainTop(mountainArr, 0, size-1);
        if (mountainArr.get(topIndex)<target)return -1;
        if (mountainArr.get(topIndex)==target)return topIndex;
        int leftIndex=findLeft(mountainArr, 0, topIndex, target);
        int rightIndex=findRight(mountainArr, topIndex, size-1,target);
        if (leftIndex!=-1)return leftIndex;
        else if (rightIndex!=-1)return rightIndex;
        else return -1;
    }
    public int findMountainTop(MountainArray mountainArray,int s,int e){

        while (s<e){
            int mid=(s+e-1)/2;//保证右侧+1不会越界
            int num=mountainArray.get(mid);
            int next=mountainArray.get(mid+1);
            if (num<next)s=mid+1;
            else e=mid;
        }
        return s;
    }
    //可以等区间收缩为一个数的时候再进行判断
    public int findLeft(MountainArray mountainArray,int s, int e,int target){
        while (s<e){
            int mid=(s+e-1)/2;
            int num=mountainArray.get(mid);
//            int next=mountainArray.get(mid+1);
            if (num<target)s=mid+1;
            else e=mid;
            if (num==target)return mid;
//            if (next==target)return mid+1;
        }
        if (mountainArray.get(s)==target)return s;
        return -1;
    }
    //上方的写法要高效一些
    public int findRight(MountainArray mountainArray,int s,int e,int target){
        while (s<e){
            int mid=(s+e-1)/2;
            int num=mountainArray.get(mid);
            int next=mountainArray.get(mid+1);
            if (num>target)s=mid+1;
            else e=mid;
            if (num==target)return mid;
            if (next==target)return mid+1;
        }
        return -1;
    }
}

interface MountainArray {
    public int get(int index);
    public int length();
}
