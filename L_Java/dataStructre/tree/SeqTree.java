package tree;

/**
 * *树
 * 概念：树是零个或多个结点的有限集合。结点树为0的树称为空树，结点树大于0的树称为非空树。
 * 在一个非空树种：（1）有且仅有一个特定的称为根的结点（2）当结点树大于1时，除根结点外，其他
 * 结点被分成n个互不相交的子集 
 * 
 * 基本术语
 * 结点的度：指结点拥有子树的数目。
 * 终端结点（叶子结点）：指度为0的结点。
 * 树的度：指数内个结点的度的最大值。
 * 孩子和双亲：某个结点的子树的根称为该结点的孩子，相应的，该结点称为其孩子的双亲。
 * 兄弟：同一个双亲的孩子结点互为兄弟。
 * 结点的层次：规定根所在的层次为第一层，根的孩子在第二层，依次类推。
 * 树的高度（深度）：树中结点最大的层数。
 * 有序树：指数中结点的各子树从左直右是有次序的，否则称为无序树。
 * 森林：指n棵互不相交的树的集合。
 * 
 * 由上可知：树中任一个结点都可以有零个或多个后续结点（孩子），但最多只能有一个前趋结点（双亲），
 * 根结点无双亲，叶子结点无孩子；祖先与子孙的关系是父子关系的拓展；有序树中兄弟结点之间从左至右
 * 有次序之分。
 * 
 * 树的逻辑表示方法
 * 1、树形图法
 * 2、嵌套结合法
 * 3、广义表法
 * 4、凹入表示法
 * 
 * 树的存储结构
 * 1、双亲表示法
 * 2、孩子表示法
 * 3、双亲孩子表示法
 * 4、孩子兄弟表示法
 * 
 * @author PW 2018/03/15
 *
 */
public class SeqTree {

}
