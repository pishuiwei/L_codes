package tree;

/**
 * *哈夫曼树
 * ：又称为最优二叉树，它是n个带权的叶子结点构成的所有二叉树中带权路径长度WPL最小的二叉树
 * <br>
 * 
 * 哈夫曼树的构造算法：假设有n个权值，则构造出来的哈夫曼树有n个叶子结点。n个权值分别为w1，w2,...wn，
 * 则哈夫曼树的构造算法为：<br>
 * （1）将w1,w2，...wn看成是有n棵树的森林（每棵树仅有一个结点）<br>
 * （2）在森林中选出两个根结点的权值最小的树合并，作为一棵新树的左、右子树，且新树的根结点权值
 * 为其左、右子树根结点权值之和<br>
 * （3）从森林中删除选取的两棵树，并将新树加入森林<br>
 * （4）重复（2）、（3）步，直到什么了中只剩下一颗树为止，该树即为所求得的哈夫曼树<br>
 *
 * *哈夫曼编码：
 * 
 * 路径：若在树中存在一个结点序列k1，k2，...，kj，使得ki是ki+1的双亲(i<=i<=j)，
 * 则此结点序列称为从k1到kj的路径；
 * <br>
 * 路劲的长度：从k1到kj所经过的分支树称为这两点之间的路劲长度，它等于路径上的结点数减1
 * <br>
 * 结点的权：在许多应用中，常常将树中的某个结点赋上一个具有某种意义的数值，这个和某个结点相关的
 * 数值称为该结点的权或权值<br>
 * <br>
 * 结点的带权路径长度：指从树根到该结点之间的路径长度与结点的权值的乘积
 * <br>
 * 树的带权路径长度：指树中所有叶子结点的带权路径长度之和，通常记作WPL=(1*W1*L1+.. +n*Wn*Ln)
 * 
 * 
 * 
 * 
 * @author PW 2018/03/16
 *
 */
public class HuffmanTree {

}
