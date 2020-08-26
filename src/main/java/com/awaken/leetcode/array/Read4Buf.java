package com.awaken.leetcode.array;

/**
 * @author Kirago
 * @date 2020/8/26 11:36
 * @description https://leetcode-cn.com/problems/read-n-characters-given-read4/
 * @version version-1.0
 */
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Read4Buf {
    
    // 此函数忽略 只是为了保证工程项目编译无问题， read4为题目中的API接口 不需要实现
    protected int read4(char[] buf){
        return 0;
    }
    
    public int read(char[] buf, int n){
        // 用于存放 read4 读取到的 char 数组的有效长度
        int tmp;
        // 有效计数位
        int length = 0;
        // 初始化 bufinfo 供 read4使用
        char[] bufTmp = new char[4];
        while( (tmp=read4(bufTmp)) != 0){
            for(int i=0;i<tmp && length < n; i++){
                buf[length] = bufTmp[i];
                length++;
            }
        }
        return length;
    }
}
