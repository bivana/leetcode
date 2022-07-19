package com.ivan.leetcode.plugin.leetcode.editor.cn;
//535 TinyURL 的加密与解密
//TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-
//tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。 
//
// 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本
//的 URL 。 
//
// 实现 Solution 类： 
//
// 
// 
// 
// Solution() 初始化 TinyURL 系统对象。 
// String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。 
// String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系
//统对象加密的。 
// 
//
// 
//
// 示例： 
//
// 
//输入：url = "https://leetcode.com/problems/design-tinyurl"
//输出："https://leetcode.com/problems/design-tinyurl"
//
//解释：
//Solution obj = new Solution();
//string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
//string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= url.length <= 10⁴ 
// 题目数据保证 url 是一个有效的 URL 
// 
// 
// 
// Related Topics 设计 哈希表 字符串 哈希函数 👍 180 👎 0

import org.junit.Test;

import java.util.HashMap;

public class P535EncodeAndDecodeTinyurl{

    public Codec solution=new Codec();

    @Test
    public void test(){
        String s=solution.encode("https://leetcode.com/problems/design-tinyur");
        System.out.println(s);
        System.out.println(solution.decode(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
public class Codec {

    public HashMap<Integer,String> map=new HashMap<>();

    public int id=0;

    public String baseUrl="http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(++id,longUrl);
        return baseUrl+id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int l=Integer.parseInt(shortUrl.substring(19,shortUrl.length()));
        return map.get(l);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
//leetcode submit region end(Prohibit modification and deletion)

}