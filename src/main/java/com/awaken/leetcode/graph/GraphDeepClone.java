package com.awaken.leetcode.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* @Description:    133、图的深度克隆,https://leetcode-cn.com/problems/clone-graph/
* @Author:         kirago
* @CreateDate:     2020/8/12 11:47 下午
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class GraphDeepClone {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 通过构造 HashMap 来记录已经遍历的元素，结合 BFS 的思路实现完全遍历
     */
    private HashMap<Node,Node> visited = new HashMap<>();

    /**
    * @Description: java方法描述
    * @Param: Node
    * @return: Node
    **/
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(visited.containsKey(node)) return visited.get(node);
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);
        for(Node neighbor:node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
