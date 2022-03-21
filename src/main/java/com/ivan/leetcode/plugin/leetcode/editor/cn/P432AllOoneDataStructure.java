package com.ivan.leetcode.plugin.leetcode.editor.cn;
//请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。 
//
// 实现 AllOne 类： 
//
// 
// AllOne() 初始化数据结构的对象。 
// inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。 
// dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例
//保证：在减少计数前，key 存在于数据结构中。 
// getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", 
//"getMinKey"]
//[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
//输出
//[null, null, null, "hello", "hello", null, "hello", "leet"]
//
//解释
//AllOne allOne = new AllOne();
//allOne.inc("hello");
//allOne.inc("hello");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "hello"
//allOne.inc("leet");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "leet"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length <= 10 
// key 由小写英文字母组成 
// 测试用例保证：在每次调用 dec 时，数据结构中总存在 key 
// 最多调用 inc、dec、getMaxKey 和 getMinKey 方法 5 * 10⁴ 次 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 160 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P432AllOoneDataStructure{

    @Test
    public void test(){
        AllOne obj = new AllOne();
        obj.inc("hello");
        obj.inc("world");
        obj.inc("leet");
        obj.inc("code");
        obj.inc("ds");
        obj.inc("leet");
        System.out.println(obj.getMaxKey());
        obj.inc("ds");
        obj.dec("leet");
        System.out.println(obj.getMaxKey());
        obj.dec("ds");
        obj.inc("hello");
        System.out.println(obj.getMaxKey());
        obj.inc("hello");
        obj.inc("hello");
        obj.dec("world");
        obj.dec("leet");
        obj.dec("code");
        obj.dec("ds");
        System.out.println(obj.getMaxKey());
        obj.inc("new");
        obj.inc("new");
        obj.inc("new");
        obj.inc("new");
        obj.inc("new");
        obj.inc("new");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());

    }

    //leetcode submit region begin(Prohibit modification and deletion)
class AllOne {

    public AllOne() {

    }

    class Tuple{
        String key;
        Integer cnt;

        public Tuple(String key,Integer cnt){
            this.key=key;
            this.cnt=cnt;
        }

    }

    List<Tuple> list=new ArrayList<>();
    Map<String,Integer> map=new HashMap<>();

    public void inc(String key) {
        if(map.containsKey(key)){
            int index=map.get(key);
            Tuple tuple=list.get(index);
            tuple.cnt++;
            while (index>=1 && list.get(index).cnt>list.get(index-1).cnt){
                Tuple pre=list.get(index-1);
                //变更index索引
                map.put(tuple.key,map.get(tuple.key)-1);
                map.put(pre.key,map.get(pre.key)+1);
                //list交换
                list.set(index,pre);
                list.set(index-1,tuple);
                index=index-1;
                pre=tuple;
            }
        }else{
            Tuple tuple=new Tuple(key,1);
            list.add(tuple);
            map.put(key,list.size()-1);
        }
    }
    
    public void dec(String key) {
        int index=map.get(key);
        Tuple tuple=null;
        try {
            tuple=list.get(index);
        }catch (Exception e){
            e.printStackTrace();
        }
        tuple.cnt--;
        if(tuple.cnt!=0){
            while (index<list.size()-1 && list.get(index).cnt<list.get(index+1).cnt){
                Tuple next=list.get(index+1);
                //变更index索引
                map.put(tuple.key,map.get(tuple.key)+1);
                map.put(next.key,map.get(next.key)-1);
                //list交换
                list.set(index,next);
                list.set(index+1,tuple);
                index=index+1;
                next=tuple;
            }
        }else{
            map.remove(key);
            list.remove(index);
            //调整index
            for(int i=index;i<list.size();i++){
                map.put(list.get(i).key,i);
            }
        }
    }
    
    public String getMaxKey() {
        if(list.size()==0){
            return "";
        }
        return list.get(0).key;
    }
    
    public String getMinKey() {
        if(list.size()==0){
            return "";
        }
        return list.get(list.size()-1).key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)

}